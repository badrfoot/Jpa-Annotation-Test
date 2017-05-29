/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.CompositeId.Association;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeIdEmbedded implements Serializable {

	private int idEmployee;
	private String branchName;

	public EmployeeIdEmbedded() {

	}

	public EmployeeIdEmbedded(String branchName, int idEmployee) {
		this.branchName = branchName;
		this.idEmployee = idEmployee;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public String getBranchName() {
		return branchName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + idEmployee;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeIdEmbedded other = (EmployeeIdEmbedded) obj;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		return true;
	}

	
	
}