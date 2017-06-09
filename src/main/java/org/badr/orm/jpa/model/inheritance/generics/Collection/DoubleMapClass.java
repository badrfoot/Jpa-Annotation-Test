/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics.Collection;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
//@Table(value = "My_DoubleMapClass")
@DiscriminatorValue(value = "My_DoubleMapClass")
@Access(AccessType.PROPERTY)
public class DoubleMapClass extends SecondLevelBaseClass<EmbeddableDate, Long, SortedMap<EmbeddableDate, Long>>{
	
	//private SortedMap<EmbeddableDate, Double> value = new TreeMap<>();
	
	@Override
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name ="My_DoubleMapClass_Collection", joinColumns = @JoinColumn(name = "ID_GENERIC"))	
	@Column(nullable = false, name = "MyValue")
	@AttributeOverrides({
		@AttributeOverride(name = "keysdfdsd.sdtart", column = @Column(name = "START")),
		@AttributeOverride(name = "keyfsfss.end", column = @Column(name = "END"))
	})
	@OrderBy	
	public SortedMap<EmbeddableDate, Long> getValue() {
		return super.getValue();
	}

	@Override
	public void setValue(SortedMap<EmbeddableDate, Long> value) {
		super.setValue(value);
	}
}
