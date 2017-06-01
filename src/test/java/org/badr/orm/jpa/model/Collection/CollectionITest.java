/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityTransaction;
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
public class CollectionITest extends BaseClassITest {

	private Image image1;	

	public CollectionITest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		image1 = new Image();
		List<String> locations = Arrays.asList("HardDisk", "USB");
		image1.setName("MINE");
		image1.setLoations(locations);

		transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(image1);
		transaction.commit();
	}

	@After
	public void tearDown() {
		if (entityManager.createQuery("SELECT i FROM Image i WHERE i.id=:id").setParameter("id", image1.getId()).getResultList().size() == 1){
			transaction.begin();
			entityManager.remove(image1);
			transaction.commit();
		}
	}

	@Test //@Ignore
	public void shouldDeleteAllImageLocations() {

		transaction.begin();
		entityManager.remove(image1);
		transaction.commit();
		
		assertEquals(0, entityManager.createQuery("SELECT i FROM Image i WHERE i.id=:id").setParameter("id", image1.getId()).getResultList().size() +
						entityManager.createNativeQuery("SELECT * FROM IMAGES_LOCATIONS").getResultList().size());
	}

	@Test //@Ignore
	public void shouldGetOneRecord(){
		assertEquals(image1.getLoations().size(),entityManager.createNativeQuery("SELECT * FROM IMAGES_LOCATIONS").getResultList().size());
	}

	@Test //@Ignore
	public void shouldGetLocationsImageElement(){
		assertEquals(1, entityManager.createQuery("SELECT i FROM Image i WHERE i.id=:id").setParameter("id", image1.getId()).getResultList().size());
	}	
}
