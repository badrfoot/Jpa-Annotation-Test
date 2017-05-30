/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import org.badr.orm.jpa.model.CompositeId.Association.Employee;

/**
 *
 * @author OBD
 */
@MappedSuperclass
public abstract class BaseClass{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "YesIamID")
	private Long id;

	public Long getId() {
		return id;
	}

	private final String JustFinalField = "ttttttttFinal" ;

}
