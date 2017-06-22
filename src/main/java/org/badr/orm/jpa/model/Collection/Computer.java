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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;
import org.hibernate.annotations.Parent;

/**
 *
 * @author OBD
 */
//@Entity
//@Table(name = "IMAGES_COMPUTER")
//@IdClass(ComputerId.class)
@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString //(exclude = {"image"})
public class Computer implements Comparable<Computer>{
	
//	@Id
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "ID_IMAGE")
//	private Image image;
//	
//	@Id
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "COMPUTER_ROOM")
//	private Room room;
	
	@Column
	private String ipAddress;
	
	@Column
	private String pcModel;

	@Override
	public int compareTo(Computer o) {
		return getIpAddress().compareTo(o.getIpAddress());
	}
	
}
