package com.notewitch.resource;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.notewitch.DTO.UserDTO;
import com.notewitch.service.LocationService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/user")
public class Resource {

	private final LocationService locationService;
	
	@Autowired
    @LoadBalanced
    private RestTemplate loadBalanced;
	
	@GetMapping("/allUsers")
	public UserDTO[] getUsers(){
		ResponseEntity<UserDTO[]> response = loadBalanced.getForEntity("http://db-service/rest/db/allUsers", UserDTO[].class);
		return response.getBody();
	}
	
	
	@GetMapping("/{username}")
	public UserDTO getUser(@PathVariable("username") String username) {
		ResponseEntity<UserDTO> response = loadBalanced.getForEntity("http://db-service/rest/db/user/" + username,
				UserDTO.class);
		return response.getBody();
	}
		
	
	@GetMapping("/location")
	public String getLocation() throws URISyntaxException, UnsupportedEncodingException {
		return locationService.getLocation("5.614423" , "-0.198318");
	}
}
