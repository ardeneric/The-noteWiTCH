package com.notewitch.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.notewitch.DTO.UserDTO;

@RestController
@RequestMapping("/rest/user")
public class Resource {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/allUsers")
	public UserDTO[] getUsers(){
		ResponseEntity<UserDTO[]> response = restTemplate.getForEntity("http://db-service/rest/db/allUsers", UserDTO[].class);
		return response.getBody();
	}
	
	@GetMapping("/{username}")
	public UserDTO getUser(@PathVariable("username") String username) {
		ResponseEntity<UserDTO> response = restTemplate.getForEntity("http://db-service/rest/db/user/" + username,
				UserDTO.class);
		return response.getBody();
	}
		
}
