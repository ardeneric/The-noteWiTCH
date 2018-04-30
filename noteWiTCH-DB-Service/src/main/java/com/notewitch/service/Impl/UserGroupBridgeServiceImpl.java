package com.notewitch.service.Impl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notewitch.entity.Group;
import com.notewitch.entity.UserGroupBridge;
import com.notewitch.repository.UserGroupBridgeRepository;
import com.notewitch.service.UserGroupBridgeService;

@Service
public class UserGroupBridgeServiceImpl implements UserGroupBridgeService {
	@Autowired
	UserGroupBridgeRepository bridgeRepository;

	@Override
	public Stream<UserGroupBridge> findByGroup(Group group) {
		return bridgeRepository.findByGroupId(group);
	}
}
