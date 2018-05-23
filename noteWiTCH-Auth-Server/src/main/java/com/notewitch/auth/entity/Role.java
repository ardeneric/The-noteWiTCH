/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.auth.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author EricAr
 *
 */
@Data
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "roleId" ,cascade = CascadeType.ALL)
	private List<User> user;

}
