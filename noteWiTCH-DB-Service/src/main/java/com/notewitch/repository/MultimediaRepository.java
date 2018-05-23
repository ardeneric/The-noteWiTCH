/*******************************************************************************
 * CONFIDENTIAL
 *******************************************************************************/
package com.notewitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notewitch.entity.Multimedia;

/**
 * @author EricAr
 *
 */
public interface MultimediaRepository extends JpaRepository<Multimedia, String> {
	
}
