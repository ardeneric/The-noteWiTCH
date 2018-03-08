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

import com.notewitch.entity.Group;
import com.notewitch.service.GroupService;

@RestController
@RequestMapping("/rest/group")
public class GroupEndpoint {

	@Autowired
	GroupService groupService;
	
	/*
	 * Group Enpoints for Discovery
	 * 
	 * */
	
	@GetMapping("/{id}")
	public Group getGroup(@PathVariable("id") String id) {
		return groupService.findById(id);
	}
	
	@GetMapping("/allGroups")
	public List<Group> getAllGroups(){
		return groupService
				.findAll()
				.collect(Collectors.toList());
	}
	
	@GetMapping("/project/{id}")
	public Group getGroupByProject(@PathVariable("id") String id){
		return groupService.findByProjectId(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Group> getGroupByUser(@PathVariable("id") String id){
		return groupService
				.findByUserId(id)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/save")
	public Group saveProject(@RequestBody Group group) {
		return groupService.save(group);
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		groupService.delete(id);
	}
}
