package com.notewitch.service.Impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notewitch.entity.User;
import com.notewitch.repository.UserRepository;
import com.notewitch.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Transactional(readOnly = true)
	@Override
	public Stream<User> findAll() {
		log.debug("Request to retrieve all users");
		return userRepository.findAll().stream();
	}

	@Override
	public Stream<User> findByGroup(String id) {
		log.debug("Request user by group");
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
		log.debug("Request user by project");
		return userRepository.findByProjectId(id);
	}

	@Override
	public List<User> findByUsernameContaining(String username) {
		return userRepository.findByUsernameContaining(username);
	}

}
