package com.notewitch.service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.notewitch.dto.GeocodingResult;
import com.notewitch.dto.MapProperties;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {
	private final MapProperties mapProperties;

	@Autowired
	private RestTemplate restTemplate;

	public String getLocation(String lat, String lng) throws URISyntaxException, UnsupportedEncodingException {

		String url = mapProperties.getUrl();
		String api_KEY = mapProperties.getAPI_KEY();

		URIBuilder locationUrl = new URIBuilder(url);
		locationUrl.addParameter("latlng", new StringBuilder().append(lat).append(",").append(lng).toString());
		locationUrl.addParameter("key", api_KEY);
		locationUrl.build();
		String decodedUrl = URLDecoder.decode(locationUrl.toString(), "UTF-8");

		ResponseEntity<GeocodingResult> entity = restTemplate.getForEntity(decodedUrl.toString(),
				GeocodingResult.class);

		return entity.getBody().getResults().get(0).getFormattedAddress();
	}

}
