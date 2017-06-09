/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Parent;

/**
 *
 * @author OBD
 */
@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString(exclude = {"image"})
public class Computer {
	
	@Column
	private String ipAddress;
	
//	@Column(name = "ID_IMAGE", insertable = false, updatable = false)
//	private Long idImage;
	
	@Parent 
	private Image image;
	
}
