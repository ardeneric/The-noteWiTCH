package com.notewitch.auth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class UserGroupBridge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5042192023403199262L;

	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id")
	private String id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role roleId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "group_id")
	private Group groupId;
	
}
