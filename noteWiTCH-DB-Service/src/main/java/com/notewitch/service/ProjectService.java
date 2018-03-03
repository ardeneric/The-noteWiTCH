package com.notewitch.service;

import java.util.stream.Stream;

import com.notewitch.entity.Project;

public interface ProjectService {
	public Project findById(String id);
	public Stream<Project> findByUser(String id);
	public Stream<Project> findByGroup(String id);
	public Stream<Project> findAll();
	public Project save(Project project);
	public void delete(String id);
}
