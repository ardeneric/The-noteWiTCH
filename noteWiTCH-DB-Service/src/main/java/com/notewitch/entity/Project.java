package com.notewitch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1852830099598055050L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "project_id")
	private String id;
	
	@NotNull
	private String projectName;
	
	@NotNull
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	@NotNull
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "group_id", referencedColumnName = "group_id")
	private Group group;
	
	@OneToMany(mappedBy = "project" ,cascade = CascadeType.ALL)
	private List<Multimedia> multimedia;
}
