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
//@DiscriminatorValue(value = "PRDS_NBS_ENTIERS2222222222")
//@Access(AccessType.PROPERTY)
//public class IntegerMapClass1 extends SecondLevelBaseClass<Integer, Integer, Map<Integer, Integer>>{
//
////	@Override
////	@ElementCollection(fetch = FetchType.LAZY)
////	@CollectionTable(name = "VL_PRM_ANNL_PRD_NB_ENTIER2222222", joinColumns = @JoinColumn(name = "ID_VL_PRM_ANNL"))
////	@AttributeOverrides({
////		@AttributeOverride(name = "key.debut", column = @Column(name = "DEBUT_PRD")),
////		@AttributeOverride(name = "key.fin", column = @Column(name = "FIN_PRD"))
////	})
////	@Column(nullable = false, name = "VALEUR")
////	@OrderBy	
////	public Map<Integer, Integer> getValeurs() {
////		return super.getValeurs();
////	}
//	
//}
