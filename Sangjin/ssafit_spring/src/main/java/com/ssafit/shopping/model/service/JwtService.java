package com.ssafit.shopping.model.service;

public interface JwtService {
	
	public String getToken(String key, Object value) throws InterruptedException;

}
