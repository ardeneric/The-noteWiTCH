/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.service;

import com.notewitch.entity.Multimedia;

/**
 * @author EricAr
 *
 */
public interface MultimediaService {
	public Multimedia save(Multimedia multimedia);
	public void delete(String id);

}
