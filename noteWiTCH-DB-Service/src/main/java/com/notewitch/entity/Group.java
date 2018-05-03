package com.notewitch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@Table(name = "Group_Table")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Group implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4583308295640633843L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "group_id")
	private String id;
	
	private String name;
	
	@NotNull
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	@NotNull
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
	
	
	@OneToMany(mappedBy = "group" , cascade = CascadeType.ALL)
	private List<Project> project;
	
	@JsonIgnore
	@OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL)
	private List<UserGroupBridge> userGroupBridge;
}
