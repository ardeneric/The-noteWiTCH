package com.notewitch.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Result {
	
	@JsonProperty("address_components")
	List<AddressComponents> addressComponent = new ArrayList<>();
	
	@JsonProperty("formatted_address")
	private String formattedAddress;
}
