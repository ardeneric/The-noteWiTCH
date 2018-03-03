package com.notewitch.service;

import java.util.stream.Stream;

import com.notewitch.entity.Group;

public interface GroupService {
	public Group findById(String id);
	public Group findByProjectId(String id);
	public Stream<Group> findByUserId(String id);
	public Stream<Group> findAll();
	public Group save(Group group);
	public void delete(String id);
}
