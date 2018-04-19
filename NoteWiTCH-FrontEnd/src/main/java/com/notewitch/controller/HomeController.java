package com.notewitch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
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
}
