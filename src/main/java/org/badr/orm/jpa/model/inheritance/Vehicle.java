/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import lombok.Getter;
import org.badr.orm.jpa.model.BaseClass;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
public abstract class Vehicle extends BaseClass{ //extends Engine{

	@Column
	private String manufacturer;

	@ElementCollection
	@CollectionTable(name = "CountryManufacturers_For_Vehicule", joinColumns = @JoinColumn(name = "Id_Vehicle"))
	private List<String> CountryManufacturers;
	
}