package com.notewitch.DTO;

import java.util.List;


import lombok.Data;

@Data
public class UserDTO {
	
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String otherNames;
	
	private String email;
	
	private String address;
	
	private String password;
	
	private List<ProjectDTO> project;
	
	
}
