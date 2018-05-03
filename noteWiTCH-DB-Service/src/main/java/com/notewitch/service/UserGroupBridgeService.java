package com.notewitch.service;

import java.util.stream.Stream;

import com.notewitch.entity.Group;
import com.notewitch.entity.UserGroupBridge;

public interface UserGroupBridgeService {

	public Stream<UserGroupBridge> findByGroup(Group group);
	
	public UserGroupBridge save(UserGroupBridge bridge);
}
