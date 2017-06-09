/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics.Collection;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@Table(name = "Non_GENERICS_STAFF")
@Access(AccessType.PROPERTY)
public class SomeClass extends BaseClass{
	
//	
////	@Id
////	@GeneratedValue(strategy = GenerationType.AUTO)	
////	private Long id;

	
	private SortedMap<EmbeddableDate, EmbeddableDouble> mySortedMap = new TreeMap<>();
	
//	public Long getId() {
//		return id;
//	}	
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "MyNonGenericTable_EmbeddableDouble_Double" , joinColumns = @JoinColumn(name = "ID_SomeClass"))	
	@Column(nullable = false, name = "MyValue")
	@AttributeOverrides({
		@AttributeOverride(name = "key.start", column = @Column(name = "START")),
		@AttributeOverride(name = "key.end", column = @Column(name = "END"))
	})
	@OrderBy	
	public SortedMap<EmbeddableDate, EmbeddableDouble> getMySortedMap() {
		return mySortedMap;
	}
	
	public void setMySortedMap(SortedMap<EmbeddableDate, EmbeddableDouble> mySortedMap) {
		this.mySortedMap = mySortedMap;
	}

	public SomeClass() {
	}	
}
