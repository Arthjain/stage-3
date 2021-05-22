package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("START");
		LOGGER.debug(authHeader);
		
		String user = getUser(authHeader);
		String token = generateJwt(user);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("token", token);
		
		LOGGER.debug("User : " + user);
		LOGGER.debug("Generated Token : " + token);
		LOGGER.info("END");
		return map;
	}
	
	// Read Authorization header and decode the username and password
	
	// Steps to read and decode header
	private String getUser(String authHeader) {
		// getting Base64 encoded text after "Basic"
		String encodedCredentials = Base64.getEncoder().withoutPadding().encodeToString("basic".getBytes());
		LOGGER.debug(encodedCredentials); //YmFzaWM
		byte[] bytes = Base64.getDecoder().decode(encodedCredentials);
		
		String user = new String(bytes);
		LOGGER.debug("User details: " + user);
		
		return user;
	}
	
	// generating token
	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		
		// set token issue time as current time
		builder.setIssuedAt(new Date());
		
		//set token expiry date as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretUser");
		
		String token = builder.compact();
		return token;
	}
	
}
