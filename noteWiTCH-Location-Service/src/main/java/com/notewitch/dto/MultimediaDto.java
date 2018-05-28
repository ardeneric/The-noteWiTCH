package com.notewitch.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MultimediaDto {
	
	private String id;

	private Byte[] image;
	
	private String text;
	
	private String location;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
}
