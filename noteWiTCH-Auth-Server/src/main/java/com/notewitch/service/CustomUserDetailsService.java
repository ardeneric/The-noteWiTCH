package com.notewitch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		ResponseEntity<String> response = restTemplate.getForEntity("http://db-service/rest/db/allUsers", String.class);
		return null;
	}

}
