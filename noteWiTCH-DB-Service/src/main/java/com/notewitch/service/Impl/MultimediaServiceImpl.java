/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notewitch.entity.Multimedia;
import com.notewitch.repository.MultimediaRepository;
import com.notewitch.service.MultimediaService;

/**
 * @author EricAr
 *
 */
@Service
public class MultimediaServiceImpl implements MultimediaService {

	@Autowired
	MultimediaRepository multimediaRepository;
	
	@Override
	public Multimedia save(Multimedia multimedia) {
		return multimediaRepository.save(multimedia);
	}

	@Override
	public void delete(String id) {
		multimediaRepository.delete(id);
		
	}


}
