/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance;

import javax.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;

/**
 *
 * @author OBD
 */
@MappedSuperclass
@NoArgsConstructor
public class OwnerSuperClass extends Person{
	
	public OwnerSuperClass(String firstname, String lastname) {
		super(firstname, lastname);
	}	
	
}
