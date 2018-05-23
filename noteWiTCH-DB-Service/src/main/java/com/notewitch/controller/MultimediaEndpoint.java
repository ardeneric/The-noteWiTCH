/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notewitch.entity.Multimedia;
import com.notewitch.service.MultimediaService;

/**
 * @author EricAr
 *
 */
@RestController
@RequestMapping(path = "/rest/multimedia", produces = MediaType.APPLICATION_JSON_VALUE)
public class MultimediaEndpoint {
	@Autowired
	MultimediaService multimediaService;
	
	@PostMapping("/save")
	public Multimedia saveProject(@RequestBody Multimedia media) {
		return multimediaService.save(media);
	}

}
