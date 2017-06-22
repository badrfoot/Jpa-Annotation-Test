/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.polymorphism;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;

/**
 *
 * @author OBD
 */
@Entity
@AttributeOverride(name = "screenType", column = @Column(name = "tvScreenType"))
@NoArgsConstructor
public class TvScreen extends Screen{

	public TvScreen(String screenType) {
		super(screenType);
	}
	
}
