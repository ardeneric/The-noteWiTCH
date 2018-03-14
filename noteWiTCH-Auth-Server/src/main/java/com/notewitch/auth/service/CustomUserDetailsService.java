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


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	 @Autowired
	 private UserRepository usersRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> usersOptional = usersRepository.findByUsername(username);

	        usersOptional
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
	        System.err.println(usersOptional
	                .map(CustomUserDetails::new)
	                .get());
	        return usersOptional
	                .map(CustomUserDetails::new)
	                .get();
	    }

}
