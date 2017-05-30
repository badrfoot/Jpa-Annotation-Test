/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.CompositeId.Association;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity(name =  "DePET199999")
//@Table(name="DEPARTEEEEMENT")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Department extends BaseClass{
	
	private String name;
	private String Location;

}
