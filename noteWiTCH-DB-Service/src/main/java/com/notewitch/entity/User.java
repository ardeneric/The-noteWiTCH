package com.notewitch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
	private List<Project> project;
	

	//@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "userId" ,cascade = CascadeType.ALL)
	private List<UserGroupBridge> userGroupBridge;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role roleId;

	

}
