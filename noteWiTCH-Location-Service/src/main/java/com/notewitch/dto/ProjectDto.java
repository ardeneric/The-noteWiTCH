package com.notewitch.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ProjectDto {
	private String id;
	
	private String projectName;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
	
	private List<MultimediaDto> multimedia;
}
