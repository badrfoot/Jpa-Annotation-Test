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
@Getter
public class EmployeeId implements Serializable{

	private String firstName;
	private Long department;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)  return false;
		if (!(obj instanceof EmployeeId ))  return false;

		if (department == null)  return false;

		EmployeeId otherEmployeeId = (EmployeeId) obj;
		return department.equals(otherEmployeeId.getDepartment());
	}

	@Override
	public int hashCode() {
		return department == null ? super.hashCode():department.hashCode();
	}


}
