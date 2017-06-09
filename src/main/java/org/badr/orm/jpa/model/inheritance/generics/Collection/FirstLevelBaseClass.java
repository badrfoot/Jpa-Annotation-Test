/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author OBD
 */
@Entity
@Table(name = "GENERICS_STAFF")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TYPE_PARAM", discriminatorType = DiscriminatorType.STRING, length = 255)
public class FirstLevelBaseClass {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	public Long getId() {
		return id;
	}	
}
