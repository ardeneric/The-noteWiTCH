package com.notewitch.auth.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Entity
@Data
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
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

	@OneToMany(mappedBy = "userId" ,cascade = CascadeType.ALL)
	private List<UserGroupBridge> userGroupBridge;

	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.otherNames = user.otherNames;
		this.email = user.email;
		this.username = user.username;
		this.address = user.address;
		this.password = user.password;
		this.userGroupBridge = user.userGroupBridge;
	}

	public User() {
	}
}
