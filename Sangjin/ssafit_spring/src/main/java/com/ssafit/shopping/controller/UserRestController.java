package com.ssafit.shopping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.shopping.model.dto.User;
import com.ssafit.shopping.model.service.JwtService;
import com.ssafit.shopping.model.service.JwtServiceImpl;
import com.ssafit.shopping.model.service.UserService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api-user")
@CrossOrigin(origins = "*")
public class UserRestController {

	private final UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> selectAll() {
		try {
			List<User> users = userService.selectAll();
			if (users != null && users.size() > 0) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	//회원가입
	@PostMapping("/user")
	public ResponseEntity<?> signup(@RequestBody User user){
		userService.signup(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//로그인
	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody Map<String,String> params,HttpServletResponse res) throws InterruptedException{
		User user = userService.login(params.get("id"), params.get("password"));
		System.out.println(user);
		if(user != null) {
			JwtService jwtService = new JwtServiceImpl();
			String id = user.getId();
			String token = jwtService.getToken("id", id);
			Cookie cookie = new Cookie("token",token);
//			cookie.setHttpOnly(true);
			cookie.setPath("/");
			res.addCookie(cookie);
			
			System.out.println(cookie.getValue());
			System.out.println(token);
			
			
			
			
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/user/account/check")
	public ResponseEntity<?> check(@CookieValue(value="token",required = false) String token){
		JwtService jwtService = new JwtServiceImpl();
		Claims claims = jwtService.getClaims(token);
		
		if(claims !=null) {
			String id = claims.get("id").toString();
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
}
