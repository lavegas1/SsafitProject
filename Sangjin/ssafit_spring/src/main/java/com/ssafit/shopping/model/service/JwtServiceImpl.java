package com.ssafit.shopping.model.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class JwtServiceImpl implements JwtService {

	private String secretKey = "ssafydaejeon3banumjunsick1a2a3a4a5a6assafydaejeon3banumjunsick1a2a3a4a5a6a";

	@Override
	public String getToken(String key, Object value) {
		Date expTime = new Date();
		expTime.setTime(expTime.getTime()+ 1000 * 60 *5);
		byte[] secretByteKey = Decoders.BASE64.decode(secretKey);
		Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
		
		
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("typ", "JWT");
		headerMap.put("alg", "HS256");
		
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		
		JwtBuilder builder = Jwts.builder().setHeader(headerMap)
				.setClaims(map)
				.setExpiration(expTime)
				.signWith(signKey,SignatureAlgorithm.HS256);
		return builder.compact();
	}
}
