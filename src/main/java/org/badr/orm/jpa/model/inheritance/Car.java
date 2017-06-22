/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;

@Entity
@ToString
@Getter @Setter
public class Car extends BaseClass {

	private int noOfDoors;

	@OneToMany(fetch = FetchType.LAZY,  targetEntity = MyEmployee.class)
	@JoinColumn(name = "ID_CAREmployee")
	private List<MyEmployeeSuperClass > driversMyEmployeeSuperClasses;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Owner.class)
	@JoinColumn(name = "ID_CAR")
	private List<OwnerSuperClass > driversOwnerSuperClasses;
	
	

}