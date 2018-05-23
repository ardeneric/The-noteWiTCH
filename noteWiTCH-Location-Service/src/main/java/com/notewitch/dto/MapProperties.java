package com.notewitch.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(ignoreUnknownFields = false, prefix = "request")
@Data
public class MapProperties {
	private String url;
	private String API_KEY;

}
