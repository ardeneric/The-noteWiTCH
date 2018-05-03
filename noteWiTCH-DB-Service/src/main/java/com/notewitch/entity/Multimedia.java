package com.notewitch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Multimedia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5782171387562347247L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	@Lob
	private Byte[] image;
	
	private String text;
	
	private String location;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;
}
