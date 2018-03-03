package com.notewitch.service.Impl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notewitch.entity.Group;
import com.notewitch.repository.GroupRepository;
import com.notewitch.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	@Override
	public Group findByProjectId(String id) {
		return groupRepository.findByProjectId(id);
	}

	@Override
	public Stream<Group> findByUserId(String id) {
		return groupRepository.findByUserGroupBridgeUserId(id);
	}

	@Override
	public Stream<Group> findAll() {
		return groupRepository.findAll().stream();
	}

	@Override
	public Group save(Group group) {
		return groupRepository.save(group);
	}

	@Override
	public void delete(String id) {
		groupRepository.delete(id);
	}

	@Override
	public Group findById(String id) {
		return groupRepository.findOne(id);
	}

}
