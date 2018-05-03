package com.notewitch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notewitch.entity.Group;
import com.notewitch.entity.UserGroupBridge;
import com.notewitch.service.UserGroupBridgeService;

@RestController
@RequestMapping(path = "/rest/bridge", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserGroupBridgeEndpoint {

	@Autowired
	UserGroupBridgeService bridgeService;
	
	/*
	 * Group Enpoints for Discovery
	 * 
	 * 
	 */
	@GetMapping("/users")
	public List<UserGroupBridge> getGroup(@RequestBody Group group) {
		return bridgeService.findByGroup(group).collect(Collectors.toList());
	}
	
	@PostMapping("/save")
	public UserGroupBridge save(@RequestBody UserGroupBridge bridge) {
		return bridgeService.save(bridge);
	}
	

}
