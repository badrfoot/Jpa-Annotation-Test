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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OBD
 */
public class CompositePKManyToOneITest extends BaseClassITest {

	Logger LOGGER = LoggerFactory.getLogger(CompositePKManyToOneITest.class);

	public CompositePKManyToOneITest() {
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
	@Test  @Ignore
	public void ShouldPersistEntitiesForCompositeKeyWithAssociation_NotOk() {

		Department department1 = new Department("IT", "Seatle");
		Employee employee1 = new Employee("Bill", department1, "Gate");

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(department1);				
		transaction.commit();

		// If we comment below line ==> the test pass whithout
		entityManager.detach(department1);
		
		LOGGER.debug( "Outside Transaction - Before Persist IsNull(department1) = {} - IsNull(employee1.getDepartment()) = {}",
					(department1 == null), (employee1.getDepartment() == null));
		LOGGER.debug( "Outside Transaction - employee1.toString() = {}", employee1.toString());

		transaction.begin();
		LOGGER.debug( "Inside  Transaction - Before Persist employee1.toString() = {}", employee1.toString());
		LOGGER.debug( "Inside Transaction - Before Persist IsNull(department1) = {} - IsNull(employee1.getDepartment()) = {}",
					(department1 == null), (employee1.getDepartment() == null));
		LOGGER.debug( "Insisde Transaction - Before Persist employee1.toString() = {}", employee1.toString());		
		entityManager.persist(employee1);
		LOGGER.debug( "Inside Transaction - After Persist IsNull(department1) = {} - IsNull(employee1.getDepartment()) = {}",
					(department1 == null), (employee1.getDepartment() == null));
		LOGGER.debug( "Insisde Transaction - After Persist employee1.toString() = {}", employee1.toString());
		
		transaction.commit();
		
		transaction.begin();
		Employee employee2 = entityManager.find(Employee.class, new EmployeeId("Bill", department1.getId()));
		transaction.commit();
		
		assertEquals(employee1, employee2);
	 }

	
	@Test //@Ignore
	public void ShouldPersistEntitiesForCompositeKeyWithAssociation_OK() {

		Department department1 = new Department("IT", "Seatle");
		Employee employee1 = new Employee("Bill", department1, "Gate");

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(department1);

		// Either persist or flush as you like...
		LOGGER.debug("Persist Department...");
		//entityManager.flush();
		transaction.commit();
		LOGGER.debug("Persist Department...OK");

		// If we comment below line ==> the test pass whithout
		entityManager.detach(department1);

		LOGGER.debug( "Outside Transaction - Before Persist IsNull(department1) = {} - IsNull(employee1.getDepartment()) = {}",
					(department1 == null), (employee1.getDepartment() == null));
		LOGGER.debug( "Outside Transaction - employee1.toString() = {}", employee1.toString());

		// You should comment below line If you 've used flush for previous perist
		transaction.begin();
		
		LOGGER.debug( "Inside  Transaction - Before Persist employee1.toString() = {}", employee1.toString());
		LOGGER.debug( "Inside Transaction - Before Persist IsNull(department1) = {} - IsNull(employee1.getDepartment()) = {}",
					(department1 == null), (employee1.getDepartment() == null));
		LOGGER.debug( "Insisde Transaction - Before Persist employee1.toString() = {}", employee1.toString());

		employee1.setDepartment(entityManager.find(Department.class, department1.getId()));
		entityManager.persist(employee1);

		LOGGER.debug( "Inside Transaction - After Persist IsNull(department1) = {} - IsNull(employee1.getDepartment()) = {}",
					(department1 == null), (employee1.getDepartment() == null));
		LOGGER.debug( "Insisde Transaction - After Persist employee1.toString() = {}", employee1.toString());

		transaction.commit();

		transaction.begin();
		Employee employee2 = entityManager.find(Employee.class, new EmployeeId("Bill", department1.getId()));
		transaction.commit();

		assertEquals(employee1, employee2);
	 }
}
