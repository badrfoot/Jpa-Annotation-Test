/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.embedded.override;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author OBD
 */
@Embeddable
@Getter @Setter 
@ToString
public class Dialect {
	
	@Column
	private String dialectName;
	
	@Column
	private String dialectLocation;
	
	@Transient
	private String dialectOrigin;
}
