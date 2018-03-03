package com.notewitch.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
	public Stream<Project> findByUserId(String id);
	public Stream<Project> findByGroupId(String id);

}
