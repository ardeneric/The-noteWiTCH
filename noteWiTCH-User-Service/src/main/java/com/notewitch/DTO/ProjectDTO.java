package com.notewitch.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ProjectDTO {
	private String id;
	
	private String projectName;
	
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
	
	private List<MultimediaDTO> multimedia;
}
