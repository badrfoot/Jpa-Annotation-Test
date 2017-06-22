/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.badr.orm.jpa.BaseClassITest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author OBD
 */
public class InheritancePerClassITest extends BaseClassITest{

	@Rule
	public ExpectedException exception = ExpectedException.none();

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
	public void shouldAddCarAndTruck(){		

//		Car car = new Car();
//		car.setManufacturer("Mercedes");
//		car.setNoOfDoors(60);
//
//		Truck truck = new Truck();
//		truck.setManufacturer("SCANIA");
//		truck.setNoOfContainers(1);
//
//		transaction = entityManager.getTransaction();
//		transaction.begin();
//
//		entityManager.persist(car);
//		entityManager.persist(truck);
//
//		entityManager.persist(new JustSimpleClass());
//
//		transaction.commit();
//		System.out.println("Car ==>" + car.toString());
//		System.out.println("Truck ==>" + truck.toString());
	}
	
	@Test //@Ignore
	public void shouldWorkWithPersonSuperClassPolymorphisme(){
		Person person = new Person("Hey", "AndMe");
		
		Owner owner =  new Owner("Heyowner", "AndMeowner", 10L, 10L);
		MyEmployee myEmployee = new MyEmployee("HeyMyemployee", "AndMeMyemployee", "IT", Calendar.getInstance().getTime());
		
		transaction.begin();
		entityManager.persist(person);
		entityManager.persist(owner);
		entityManager.persist(myEmployee);
		
		Car car = new Car();
		List<OwnerSuperClass > driversOwnerSuperClasses = Arrays.asList(owner);
		List<MyEmployeeSuperClass > driversMyEmployeeSuperClasses = Arrays.asList(myEmployee);
				
		car.setDriversMyEmployeeSuperClasses(driversMyEmployeeSuperClasses);
		car.setDriversOwnerSuperClasses(driversOwnerSuperClasses);
		
		entityManager.persist(car);		
		transaction.commit();
		
		entityManager.clear();
		
		transaction.begin();
		Car carDB = entityManager.find(Car.class, car.getId());		
		System.out.println("***********After Search" + carDB.toString());		
		transaction.commit();
		
	}

}
