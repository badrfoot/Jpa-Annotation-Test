package org.badr.orm.jpa.model.inheritance;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.ToString;

@Entity
@DiscriminatorValue(value = "ME") 
@AttributeOverrides({
    @AttributeOverride(name="firstname", column=@Column(name="FIRSTNAME")),
    @AttributeOverride(name="lastname", column=@Column(name="LASTNAME"))
})
@ToString
public class MyEmployee extends MyEmployeeSuperClass {

	@Temporal(TemporalType.DATE)
	@Column(name="joining_date")	
	private Date joiningDate;
	
	@Column(name="department_name")
	private String departmentName;

	public MyEmployee() {
	}
	
	public MyEmployee(String firstname, String lastname, String departmentName, Date joiningDate) {
		
		super(firstname, lastname);
		
		this.departmentName = departmentName;
		this.joiningDate = joiningDate;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
