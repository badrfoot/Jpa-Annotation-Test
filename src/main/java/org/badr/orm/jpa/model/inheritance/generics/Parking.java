/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics;

import java.util.SortedMap;
import java.util.TreeMap;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@Getter @Setter @ToString
public class Parking extends BaseClass{
	
	@OneToMany
	@OrderBy
	private SortedMap<Long, Vehicle> vehicles = new TreeMap<>();
}
