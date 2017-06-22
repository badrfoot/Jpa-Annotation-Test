/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.polymorphism;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class House extends BaseClass{
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "house", targetEntity = ComputerScreen.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Screen> screens = new ArrayList<>();

	public House(String name) {
		this.name = name;
	}
	
}
