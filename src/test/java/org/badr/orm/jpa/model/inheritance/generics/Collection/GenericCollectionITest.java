/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics.Collection;

import java.util.SortedMap;
import java.util.TreeMap;
import org.badr.orm.jpa.BaseClassITest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author OBD
 */
public class GenericCollectionITest extends BaseClassITest{

	public GenericCollectionITest() {
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
		
		DoubleMapClass doubleMapClass = new DoubleMapClass();
		
		SortedMap<EmbeddableDate, Long> doubleSortedMap = new TreeMap();
		
		doubleSortedMap.put(new EmbeddableDate("11/10/2011 - 11/10/2011"), 10l);
		
		doubleMapClass.setValue(doubleSortedMap);
		
		transaction.begin();
		entityManager.persist(doubleMapClass);
		transaction.commit();
		
	}
	
	@Test @Ignore
	public void shouldInsertIntegerMapClass() {
		
//		IntegerMapClass integerMapClass = new IntegerMapClass();
//		
//		SortedMap<EmbeddableDate, Integer> doubleSortedMap = new TreeMap();
//		
//		doubleSortedMap.put(new EmbeddableDate("11/10/2011 - 11/10/2011"), 10);
//		
//		integerMapClass.setValue(doubleSortedMap);
//		
//		transaction.begin();
//		entityManager.persist(integerMapClass);
//		transaction.commit();		
	}
	
//	@Test @Ignore
//	public void shouldInsertIntegerMapClass1111111() {
//		
//		IntegerMapClass1 integerMapClass1 = new IntegerMapClass1();
//		
//		SortedMap<Integer, Integer> doubleSortedMap = new TreeMap();
//		
//		doubleSortedMap.put(10*2, 3*6);
//		
//		integerMapClass1.setValeurs(doubleSortedMap);
//		
//		transaction.begin();
//		entityManager.persist(integerMapClass1);
//		transaction.commit();		
//	}
	
	@Test @Ignore
	public void shouldLoadContext(){
		
	}
	
	@Test //@Ignore
	public void shouldInsertNonGenericClass() {
		
		SomeClass nonGenericClass = new SomeClass();
		
		SortedMap<EmbeddableDate, EmbeddableDouble> doubleSortedMap = new TreeMap();
		
		doubleSortedMap.put(new EmbeddableDate("11/10/2011 - 11/10/2011"), new EmbeddableDouble(10d));
		
		nonGenericClass.setMySortedMap(doubleSortedMap);
		
		transaction.begin();
		entityManager.persist(nonGenericClass);
		transaction.commit();		
	}
	
}
