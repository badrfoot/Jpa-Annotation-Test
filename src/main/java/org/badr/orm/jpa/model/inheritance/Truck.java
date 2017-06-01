/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.ToString;

@Entity
@ToString
@AttributeOverride(name = "manufacturer", column = @Column(name = "manufacturerOfTruck"))
public class Truck extends Vehicle {

	@Column
	private int noOfContainers;

	public int getNoOfContainers() {
		return noOfContainers;
	}

	public void setNoOfContainers(int noOfContainers) {
		this.noOfContainers = noOfContainers;
	}

}
