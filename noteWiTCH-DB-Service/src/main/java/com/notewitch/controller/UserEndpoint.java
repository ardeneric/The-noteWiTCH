package com.notewitch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notewitch.entity.User;
import com.notewitch.service.UserService;


@RestController
@RequestMapping("/rest/user")
public class UserEndpoint {
	
	@Autowired
	UserService userService; 
	
	/*
	 * User Enpoints for Discovery
	 * 
	 * */
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userService
				.findAll()
				.collect(Collectors.toList());
	}
	
	@GetMapping("/group/{id}")
	public List<User> getUsersByGroup(@PathVariable("id") String id){
		return userService
				.findByGroup(id)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/project/{id}")
	public List<User> getUsersByProject(@PathVariable("id") String id){
		return userService
				.findByProject(id)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PostMapping("/delete/{username}")
	public void delete(@PathVariable("username") String username) {
		userService.delete(username);
	}
}
