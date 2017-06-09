/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import javax.persistence.Entity;
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
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Room extends BaseClass{
	
	private String  name;
	
}
