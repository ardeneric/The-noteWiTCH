package com.notewitch.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notewitch.auth.entity.CustomUserDetails;
import com.notewitch.auth.entity.User;
import com.notewitch.auth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	 @Autowired
	 private UserRepository usersRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        log.info("user :: " +  username + " logging in");
	    	Optional<User> usersOptional = usersRepository.findByUsername(username);
	        usersOptional
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
	        return usersOptional
	                .map(CustomUserDetails::new)
	                .get();
	    }

}
