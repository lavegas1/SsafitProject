package com.ssafit.shopping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.shopping.model.dto.User;
import com.ssafit.shopping.model.service.UserService;


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
	public ResponseEntity<?> login(@RequestBody Map<String,String> params){
		User user = userService.login(params.get("id"), params.get("password"));
		System.out.println(user);
		if(user != null)
			return new ResponseEntity<>(user.getId(),HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
}
