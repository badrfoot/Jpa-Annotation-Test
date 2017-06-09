/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "TWO_WHEELER")
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {

	@Column(name = "STEERING_TYPE")
	private String steeringTwoWheeler;

	public String getSteeringTwoWheeler() {
		return steeringTwoWheeler;
	}

	public void setSteeringTwoWheeler(String steeringTwoWheeler) {
		this.steeringTwoWheeler = steeringTwoWheeler;
	}
}
