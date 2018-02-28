package com.notewitch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "user_id")
	private String id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	private String otherNames;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String username;
	
	private String address;
	
	private String password;
	
	private String lat;
	
	private String lng; 
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
	private List<Project> project;

	@OneToMany(mappedBy = "userId" ,cascade = CascadeType.ALL)
	private List<UserGroupBridge> userGroupBridge;

	

}
