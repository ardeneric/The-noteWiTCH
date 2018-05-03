/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.controller.rest;

import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.notewitch.dto.GroupDto;
import com.notewitch.dto.ProjectDto;
import com.notewitch.dto.RoleDto;
import com.notewitch.dto.UserGroupBridgeDto;

/**
 * @author EricAr
 *
 */
@RestController
public class Resource {
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/addProject")
	public ProjectDto save(@RequestBody ProjectDto projectDto,HttpServletRequest session) {
		projectDto.setCreatedDate(LocalDateTime.now());
		projectDto.setModifiedDate(LocalDateTime.now());
		HttpHeaders requestHeaders = new HttpHeaders();
		Cookie[] cookies = session.getCookies();
		for (Cookie cookie : cookies) {
			requestHeaders.add(HttpHeaders.COOKIE, cookie.getName() + "=" + cookie.getValue());
		}
		
		HttpEntity<?> requestEntity = new HttpEntity<>(projectDto, requestHeaders);
		String url = "http://localhost:8761/api/db-service/rest/project/save";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		ResponseEntity<ProjectDto> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, ProjectDto.class);
		return response.getBody();
	}
	
	@PostMapping("/addGroup")
	public GroupDto saveGroup(@RequestBody GroupDto groupDto,HttpServletRequest session, Model model) {
	
		HttpHeaders requestHeaders = new HttpHeaders();
		Cookie[] cookies = session.getCookies();
		for (Cookie cookie : cookies) {
			requestHeaders.add(HttpHeaders.COOKIE, cookie.getName() + "=" + cookie.getValue());
		}
		
		groupDto.setCreatedDate(LocalDateTime.now());
		groupDto.setModifiedDate(LocalDateTime.now());
		HttpEntity<?> requestEntityOne = new HttpEntity<>(groupDto, requestHeaders);
		String groupUrl = "http://localhost:8761/api/db-service/rest/group/save";
		UriComponentsBuilder builderOne = UriComponentsBuilder.fromHttpUrl(groupUrl);
		ResponseEntity<GroupDto> responseOne = restTemplate.exchange(builderOne.toUriString(), HttpMethod.POST, requestEntityOne, GroupDto.class);
		
		UserGroupBridgeDto bridgeDto = new UserGroupBridgeDto();
		RoleDto roleDto = new RoleDto();
				roleDto.setId(1);
		bridgeDto.setGroupId(responseOne.getBody());
		bridgeDto.setRoleId(roleDto);
		bridgeDto.setUserId(groupDto.getUser());
		HttpEntity<?> requestEntityTwo = new HttpEntity<>(bridgeDto, requestHeaders);
		String bridgeUrl = "http://localhost:8761/api/db-service/rest/bridge/save";
		UriComponentsBuilder builderTwo = UriComponentsBuilder.fromHttpUrl(bridgeUrl);
		ResponseEntity<UserGroupBridgeDto> responseTwo = restTemplate.exchange(builderTwo.toUriString(), HttpMethod.POST, requestEntityTwo, UserGroupBridgeDto.class);
		return responseOne.getBody();
	}
}
