/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.controller.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.notewitch.dto.ProjectDto;

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
		System.err.println(projectDto);
		return projectDto;
	}
}
