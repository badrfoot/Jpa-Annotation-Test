/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.CompositeId.Association;

import javax.persistence.EntityTransaction;
import org.badr.orm.jpa.BaseClassITest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author OBD
 */
public class JpaITest extends BaseClassITest {

	public JpaITest() {
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

	@Test @Ignore("You can activate to isolate you generated schema test")
	public void ShouldLoadContext() { }

	@Test
	public void ShouldPersistEntities() {

		Department department1 = new Department("IT", "Seatle");
		Employee employee1 = new Employee("Bill", "Gate", department1);

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(department1);
		entityManager.persist(employee1);		
		transaction.commit();
	 }
}
