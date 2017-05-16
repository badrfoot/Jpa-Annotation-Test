/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.CompositeId.Association;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author OBD
 */
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
@Getter
public class EmployeeId implements Serializable{

	private String firstName;
	private Long department;

}
