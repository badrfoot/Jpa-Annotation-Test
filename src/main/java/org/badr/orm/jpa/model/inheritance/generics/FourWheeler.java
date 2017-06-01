/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FOUR_WHEELER")
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {

	@Column(name = "STEERING_TYPE")
	private String steeringFourWheeler;

	public String getSteeringFourWheeler() {
		return steeringFourWheeler;
	}

	public void setSteeringFourWheeler(String steeringFourWheeler) {
		this.steeringFourWheeler = steeringFourWheeler;
	}
}
