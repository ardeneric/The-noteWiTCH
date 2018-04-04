package com.notewitch.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MultimediaDTO {
	
	private String id;

	private Byte[] image;
	
	private String text;
	
	private String location;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
}
