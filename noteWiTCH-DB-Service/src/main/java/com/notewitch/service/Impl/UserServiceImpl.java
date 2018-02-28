package com.notewitch.service.Impl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notewitch.entity.User;
import com.notewitch.repository.UserRepository;
import com.notewitch.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Stream<User> findAll() {
		return userRepository.findAll().stream();
	}

	@Override
	public Stream<User> findByGroup(String id) {
		return userRepository.findByUserGroupBridgeGroupId(id);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(String username) {
		userRepository.delete(userRepository.findOne(username));
	}

	@Override
	public Stream<User> findByProject(String id) {
		return userRepository.findByProjectId(id);
	}

}
