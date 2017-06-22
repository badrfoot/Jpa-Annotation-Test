/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.embedded.override;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@NoArgsConstructor @RequiredArgsConstructor
@Access(AccessType.PROPERTY)
@ToString
//@Getter @Setter 
public class Nationality extends BaseClass{
	
	@NonNull
	private Dialect language;

	@Embedded
	public Language getLanguage() {
		return (Language) language;
	}

	public void setLanguage(Dialect  language) {
		this.language = language;
	}
	
	

}
