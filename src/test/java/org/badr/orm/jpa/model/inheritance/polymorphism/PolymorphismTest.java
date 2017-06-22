/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.badr.orm.jpa.BaseClassITest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OBD
 */
public class PolymorphismTest extends BaseClassITest{

	public PolymorphismTest() {
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

	@Test
	public void shouldAddHouseWithScreen() {
		
		List<Screen> screens = new ArrayList<>();
		
		
		House house1 = new House("MyHouse", screens);
		screens.add(new ComputerScreen("Dell", house1));
		screens.add(new ComputerScreen("HP", house1));
		
		transaction.begin();
		entityManager.persist(house1);
		transaction.commit();
		
		entityManager.detach(house1);
		
		transaction.begin();
		House house2 = entityManager.find(House.class, house1.getId());
		transaction.commit();
		
		System.out.println("********************** ==> house2.toString() ==> " +  house2.toString());
		System.out.println("********************** ==> house2.getScreens().size() ==> " +  house2.getScreens().size());
		house2.getScreens().stream().map(s->s.getScreenType()).forEach(System.out::println);
		
	}
}
