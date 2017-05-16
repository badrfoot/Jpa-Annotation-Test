/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.CompositeId.Association;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee extends BaseClass{

	private String firstName;

	private String lastName;

	@ManyToOne
	@JoinColumn(name = "Id_Department")
	private Department department;

}
