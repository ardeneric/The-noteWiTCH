package com.notewitch.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName(value = "address_components")
@Data
public class AddressComponents {
	
	@JsonProperty("long_name")
	private String longName;
	
	@JsonProperty("short_name")
	private String shortName;
	
	@JsonProperty("types")
	private List<String> types;
	
}
