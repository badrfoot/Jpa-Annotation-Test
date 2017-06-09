package org.badr.orm.jpa.model.inheritance.generics.Collection;

import javax.persistence.AccessType;
import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class EmbeddableDouble  {
	
	public EmbeddableDouble() {}
	
	public EmbeddableDouble(Double value) {
		super();
		this.value = value;
	}
	
	@Column
	private Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		EmbeddableDouble other = (EmbeddableDouble) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	
}
