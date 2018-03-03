package com.notewitch.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.Group;

public interface GroupRepository extends JpaRepository<Group, String> {
	public Group findByProjectId(String id);
	public Stream<Group> findByUserGroupBridgeUserId(String id);
}
