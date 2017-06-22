/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.embedded.override;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@Getter @Setter 
public class Country extends BaseClass{
	
	@Embedded
//	@AttributeOverride(name = "language.language", column = @Column(name = "Value_Country"))
	private Language language;
}
