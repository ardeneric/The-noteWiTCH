package com.notewitch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notewitch.entity.Project;
import com.notewitch.service.ProjectService;

@RestController
@RequestMapping("/rest/project")
public class ProjectEndpoint {

	@Autowired
	ProjectService projectService;
	
	/*
	 * Project Enpoints for Discovery
	 * 
	 * */
	
	@GetMapping("/{id}")
	public Project getUser(@PathVariable("id") String id) {
		return projectService.findById(id);
	}
	
	@GetMapping("/allProjects")
	public List<Project> getAllProjects(){
		return projectService
				.findAll()
				.collect(Collectors.toList());
	}
	
	@GetMapping("/group/{id}")
	public List<Project> getProjectByGroup(@PathVariable("id") String id){
		return projectService
				.findByGroup(id)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/user/{id}")
	public List<Project> getProjecByUser(@PathVariable("id") String id){
		return projectService
				.findByUser(id)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/save")
	public Project saveProject(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		projectService.delete(id);
	}
}
