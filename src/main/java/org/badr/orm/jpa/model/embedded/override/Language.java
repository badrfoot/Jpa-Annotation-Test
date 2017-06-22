/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.embedded.override;

import java.util.Collection;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author OBD
 */
@Embeddable
@NoArgsConstructor //@RequiredArgsConstructor
@Getter @Setter 
public class Language extends Dialect{

	@Override	
	@Column
	public String getDialectName() {
		return super.getDialectName();
	}
	
	@Override
	@Column
	public String getDialectOrigin() {
		return super.getDialectOrigin();
	}
	
//	@NonNull
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(joinColumns = @JoinColumn(name = "Id"))
//	@MapKeyColumn(name = "MyKey")
//	@Column(name = "MyValue")
//	private Map<String, String> language;
	
//	@NonNull
//	@Column
//	private String name;

	
	
	
}
