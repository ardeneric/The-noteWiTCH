package com.notewitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.notewitch.dto.GroupDto;


@Controller
public class HomeController {
	
	@Autowired
	RestTemplate restTemplate; 
	
	@GetMapping({"/","index"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/groups")
	public String groups() {
		return "groups";
	}
	
	@GetMapping("/projects")
	public String projects() {
		return "projects";
	}
	
	@GetMapping("/group/{id}")
	public String projectCards(Model model, @PathVariable("id") String id) {
		ResponseEntity<GroupDto> response = restTemplate.getForEntity("http://localhost:8761/api/db-service/rest/group/" + id, GroupDto.class);
		model.addAttribute("group", response);
		return "projectCards";
	}
}
