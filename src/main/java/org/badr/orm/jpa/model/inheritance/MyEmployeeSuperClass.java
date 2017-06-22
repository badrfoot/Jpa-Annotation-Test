package org.badr.orm.jpa.model.inheritance;

import javax.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
public class MyEmployeeSuperClass extends Person {

	public MyEmployeeSuperClass(String firstname, String lastname) {
		super(firstname, lastname);
	}
	
}
