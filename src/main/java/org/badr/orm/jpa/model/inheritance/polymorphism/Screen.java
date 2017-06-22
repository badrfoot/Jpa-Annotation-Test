/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.polymorphism;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@MappedSuperclass  
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Screen extends BaseClass{
	
	private String screenType;
	
	@ManyToOne
	@JoinColumn(name = "id_house")
	private House house;

	public Screen(String screenType) {
		this.screenType = screenType;		
	}
	
	
	
}
