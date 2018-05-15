package com.notewitch.service;

import java.util.List;
import java.util.stream.Stream;

import com.notewitch.entity.User;

public interface UserService {
	
	public User findByUsername(String username);
	public List<User> findByUsernameContaining(String username);
	public Stream<User> findAll();
	public Stream<User> findByGroup(String id);
	public Stream<User> findByProject(String id);
	public User save(User user);
	public void delete(String username);
}
