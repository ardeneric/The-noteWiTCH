package com.notewitch.service.Impl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notewitch.entity.Project;
import com.notewitch.repository.ProjectRepository;
import com.notewitch.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Stream<Project> findByUser(String id) {
		return projectRepository.findByUserId(id);
	}

	@Override
	public Stream<Project> findByGroup(String id) {
		return projectRepository.findByGroupId(id);
	}

	@Override
	public Stream<Project> findAll() {
		return projectRepository.findAll().stream();
	}

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void delete(String id) {
		projectRepository.delete(id);		
	}

	@Override
	public Project findById(String id) {
		return projectRepository.findOne(id);
	}
	
	

}
