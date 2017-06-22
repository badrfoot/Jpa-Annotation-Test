/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.associations.onetoone;

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
public class OneToOneTest extends BaseClassITest{

	public OneToOneTest() {
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
	public void shouldAddMouseWithConstrained() {

		UsbCable usbCable1 = new UsbCable(10L);
		UsbCable usbCable3 = new UsbCable(30L);
		UsbCable usbCable2 = new UsbCable(20L);
		
		
		
		Mouse mouse = new Mouse("HP", usbCable3);
		
		transaction.begin();
		entityManager.persist(usbCable2);
		// Todo we have a problem here >> we should persist the UsbCable object before Mouse or we will get NullPointerException 
//		entityManager.persist(usbCable3);
		entityManager.persist(mouse);
		transaction.commit();
		
	}
}
