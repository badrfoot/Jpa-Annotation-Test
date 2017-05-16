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
import static org.junit.Assert.*;

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

	/**
	 * Method should pass but we have errors see hibernate Bug for Hibernate 5.0_
	 * <a href=https://hibernate.atlassian.net/browse/HHH-10623>https://hibernate.atlassian.net/browse/HHH-10623</a>
	 */
	@Test //@Ignore
	public void ShouldPersistEntitiesForCompositeKeyWithAssociation() {

		Department department1 = new Department("IT", "Seatle");
		Employee employee1 = new Employee("Bill", department1, "Gate");

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(department1);				
		transaction.commit();

		// If we comment below line ==> the test pass
		entityManager.detach(department1);
		
		transaction.begin();
		entityManager.persist(employee1);
		transaction.commit();
		
		transaction.begin();
		Employee employee2 = entityManager.find(Employee.class, new EmployeeId("Bill", department1.getId()));
		transaction.commit();
		
		assertEquals(employee1, employee2);
	 }
}
