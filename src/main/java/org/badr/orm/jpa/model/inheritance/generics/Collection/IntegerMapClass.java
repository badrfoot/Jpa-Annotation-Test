///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.badr.orm.jpa.model.inheritance.generics.Collection;
//
//import java.util.Map;
//import javax.persistence.Access;
//import javax.persistence.AccessType;
//import javax.persistence.AttributeOverride;
//import javax.persistence.AttributeOverrides;
//import javax.persistence.CollectionTable;
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OrderBy;
//
///**
// *
// * @author OBD
// */
//@Entity
//@DiscriminatorValue(value = "PRDS_NBS_INTEGER")
//@Access(AccessType.PROPERTY)
//public class IntegerMapClass extends SecondLevelBaseClass<EmbeddableDate, Integer, Map<EmbeddableDate, Integer>>{
//
//	@Override
//	@ElementCollection
//	@CollectionTable(joinColumns = @JoinColumn(name = "ID_GENERIC"))
//	@AttributeOverrides({
//		@AttributeOverride(name = "key.start", column = @Column(name = "START")),
//		@AttributeOverride(name = "key.end", column = @Column(name = "END"))
//	})
//	@Column(nullable = false, name = "MyValue")
//	@OrderBy	
//	public Map<EmbeddableDate, Integer> getValue() {
//		return super.getValue();
//	}
//	
//	
//	
//	
//}
