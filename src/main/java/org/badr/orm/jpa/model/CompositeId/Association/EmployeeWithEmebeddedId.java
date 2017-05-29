/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.CompositeId.Association;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import org.badr.orm.jpa.model.BaseClass;

@Entity
public class EmployeeWithEmebeddedId extends BaseClass{

	
	private int salary;

	


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}