package com.notewitch.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GeocodingResult implements Serializable {


	private static final long serialVersionUID = 7242485641017896823L;
	
	@JsonProperty("results")
	List<Result> results = new ArrayList<>();
	

	
}
