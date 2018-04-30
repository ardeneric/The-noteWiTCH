package com.notewitch.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.Group;
import com.notewitch.entity.UserGroupBridge;

public interface UserGroupBridgeRepository extends JpaRepository<UserGroupBridge, String> {
	public Stream<UserGroupBridge> findByGroupId(Group group);

}
