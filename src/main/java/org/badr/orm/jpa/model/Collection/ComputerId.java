/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author OBD
 */
@NoArgsConstructor
@Getter @Setter
public class ComputerId implements Serializable{
	
	private Long image;
	private Long room;

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + Objects.hashCode(this.image);
		hash = 89 * hash + Objects.hashCode(this.room);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)  return true;		
		if ((obj == null) || !(obj instanceof ComputerId)) return false;		
		
		final ComputerId other = (ComputerId) obj;
		
		if (this.image == null || this.room == null) return false;
		
		return this.image.equals(other.image) && this.room.equals(other.room);
	}
	
}
