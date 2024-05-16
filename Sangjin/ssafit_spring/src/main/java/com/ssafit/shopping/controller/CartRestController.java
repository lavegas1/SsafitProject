package com.ssafit.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ssafit.shopping.model.dao.CartDao;
import com.ssafit.shopping.model.dao.ProductDao;
import com.ssafit.shopping.model.dto.Cart;
import com.ssafit.shopping.model.dto.Product;
import com.ssafit.shopping.model.service.JwtService;
import com.ssafit.shopping.model.service.JwtServiceImpl;


@RestController
@RequestMapping("/api-cart")
public class CartRestController {
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	
	@GetMapping("/product")
	public ResponseEntity<?> getCartProducts(@CookieValue(value="token",required = false) String token){
		JwtService jwtService = new JwtServiceImpl();
		if(jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		String userId = jwtService.getId(token);
		List<Cart> cart = cartDao.findByUserId(userId);
		List<Integer> productIds = cart.stream().map(Cart::getCartProductId).toList();
		List<Product> pro = productDao.findByIdIn(productIds);
		
		return new ResponseEntity<>(pro,HttpStatus.OK);

	}
	
	

	@PostMapping("/product/{productId}")
	public ResponseEntity<?> pushCartItem(@PathVariable("productId") int productId, @CookieValue(value="token",required = false) String token) {
		JwtService jwtService = new JwtServiceImpl();
		if(jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		String userId = jwtService.getId(token);
		Cart cart = cartDao.findByUserIdAndProductId(userId, productId);
		
		if(cart==null) {
			Cart newCart = new Cart();
			newCart.setCartUserId(userId);
			newCart.setCartProductId(productId);
			cartDao.insertCart(newCart);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
