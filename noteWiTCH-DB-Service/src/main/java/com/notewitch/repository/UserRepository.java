package com.notewitch.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByUsername(String username);
	public Stream<User> findByProjectId(String id);
	public Stream<User> findByUserGroupBridgeGroupId(String id);
}
