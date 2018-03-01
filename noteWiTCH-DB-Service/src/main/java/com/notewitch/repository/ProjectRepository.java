package com.notewitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
	public Project findByUserId(String id);
	public Project findByGroupId(String id);

}
