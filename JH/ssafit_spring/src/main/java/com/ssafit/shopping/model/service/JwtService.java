package com.ssafit.shopping.model.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
	
	public String getToken(String key, Object value) throws InterruptedException;
	
	Claims getClaims(String token);
	
	boolean isValid(String token);
	
	String getId(String token);

}
