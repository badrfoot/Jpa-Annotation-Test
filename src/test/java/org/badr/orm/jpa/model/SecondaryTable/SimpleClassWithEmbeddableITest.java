/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.SecondaryTable;

import org.badr.orm.jpa.BaseClassITest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author OBD
 */
public class SimpleClassWithEmbeddableITest  extends BaseClassITest{
	
	public SimpleClassWithEmbeddableITest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test @Ignore
	public void shouldInsertDoubleMapClass() {
		
//		SimpleClassWithEmbeddable simpleClassEmbeddable = new SimpleClassWithEmbeddable("MyName", new EmbeddableDate("11/10/2011 - 11/10/2011"));
//		
//		transaction.begin();
//		entityManager.persist(simpleClassEmbeddable);
//		transaction.commit();
//		
	}
	
	@Test //@Ignore
	public void shouldGetMySecondaryTable() {
		
		SimpleClassWithEmbeddable simpleClassEmbeddable = new SimpleClassWithEmbeddable("MyName");
		
		transaction.begin();
		entityManager.persist(simpleClassEmbeddable);
		transaction.commit();
		
		entityManager.detach(simpleClassEmbeddable);		
		
		entityManager.find(SimpleClassWithEmbeddable.class,simpleClassEmbeddable.getId());	
		entityManager.createQuery("SELECT e FROM " + SimpleClassWithEmbeddable.class.getSimpleName() + "  e").getResultList();//   SimpleClassWithEmbeddable.class,simpleClassEmbeddable.getId());	
	}
}
