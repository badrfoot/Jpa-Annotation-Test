/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author OBD
 */
@MappedSuperclass
public abstract class BaseClass{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;

	public Long getId() {
		return id;
	}

}
