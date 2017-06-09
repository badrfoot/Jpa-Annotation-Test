/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

//	@Before
	public void setUp() {
		image1 = new Image();
		List<String> locations = Arrays.asList("HardDisk", "USB");
		image1.setName("MINE");
		image1.setLocations(locations);
		
		transaction.begin();
		entityManager.persist(image1);
		transaction.commit();
	}

//	@After
	public void tearDown() {
		if (entityManager.createQuery("SELECT i FROM Image i WHERE i.id=:id").setParameter("id", image1.getId()).getResultList().size() == 1){
			transaction.begin();
			entityManager.remove(image1);
			transaction.commit();
		}
	}

	@Test @Ignore
	public void shouldDeleteAllImageLocations() {

		transaction.begin();
		entityManager.remove(image1);
		transaction.commit();
		
		assertEquals(0, entityManager.createQuery("SELECT i FROM Image i WHERE i.id=:id").setParameter("id", image1.getId()).getResultList().size() +
						entityManager.createNativeQuery("SELECT * FROM IMAGES_LOCATIONS").getResultList().size());
	}

	@Test @Ignore
	public void shouldGetOneRecord(){
		assertEquals(image1.getLocations().size(),entityManager.createNativeQuery("SELECT * FROM IMAGES_LOCATIONS").getResultList().size());
	}

	@Test @Ignore
	public void shouldGetLocationsImageElement(){
		assertEquals(1, entityManager.createQuery("SELECT i FROM Image i WHERE i.id=:id").setParameter("id", image1.getId()).getResultList().size());
	}	
	
	@Test @Ignore
	public void shouldInsertImageWithComputers(){
		
		Image image2 = new Image();
		Computer computer1 = new Computer();
		Computer computer2 = new Computer();
		
		image2.setName("MINE");
		computer1.setIpAddress("10.10.10.10");
		computer2.setIpAddress("20.20.20.20");
		
		List<String> locations = Arrays.asList("HardDisk", "USB");
		image2.setLocations(locations);
		
		Map<Room, Computer> computerLocations = new HashMap<>();
		Room room1 = new Room("Room 1");
		Room room2 = new Room("Room 2");
		computerLocations.put(room1, computer1);
		computerLocations.put(room2, computer2);
		image2.setComputerLocation(computerLocations);
		
		List<Computer> computers = new ArrayList<>();
		computers.add(computer1);
		computers.add(computer2);
		image2.setComputers(computers);
		
		transaction.begin();
		entityManager.persist(room1);
		entityManager.persist(room2);		
		entityManager.persist(image2);
		transaction.commit();
		
		entityManager.clear();
		
		transaction.begin();
		Image imageDB = entityManager.find(Image.class, image2.getId());
		transaction.commit();
		System.out.println("***************** imageDB.getComputerLocation() ==> " + Objects.toString(imageDB.getComputerLocation(), "000000000"));
		System.out.println("***************** imageDB.getComputers() ==> " + Objects.toString(imageDB.getComputers(), "000000000"));
		
//		assertTrue(imageDB.getComputerLocation().entrySet().stream().allMatch( cl -> cl.getValue().getImage().getId().equals(imageDB.getId())) );
//		assertTrue( imageDB.getComputerLocation().entrySet().stream().allMatch(cl-> cl.getValue().getIdImage().equals(image2.getId())) && 
//				   (imageDB.getComputerLocation().size()>0) );
	}
	
	
	@Test //@Ignore
	public void shouldInsertImageAndComputers(){
		
		Image image2 = new Image();
		
		
		image2.setName("MINE");
		
		
		Map<Room, Computer> computerLocations = new HashMap<>();
		// Room
		Room room1 = new Room("Room 1");
		Room room2 = new Room("Room 2");
		
		// Computer
		Computer computer1 = new Computer();
		Computer computer2 = new Computer();
		
		computer1.setIpAddress("10.10.10.10");
		computer1.setImage(image2);
		computer1.setRoom(room1);
		
		computer2.setIpAddress("20.20.20.20");
		computer2.setImage(image2);
		computer2.setRoom(room2);
		
		// ComputerLocations
		computerLocations.put(room1, computer1);
		computerLocations.put(room2, computer2);
		image2.setComputerLocation(computerLocations);
		
		transaction.begin();
		entityManager.persist(room1);
		entityManager.persist(room2);
		entityManager.persist(image2);
		transaction.commit();
		
		
		
		transaction.begin();
		Image imageDB = entityManager.find(Image.class, image2.getId());
		transaction.commit();
		
		
		System.out.println("***************** imageDB.getComputerLocation() ==> " + Objects.toString(imageDB.getComputerLocation(), "000000000"));
//		System.out.println("***************** imageDB.getComputers() ==> " + Objects.toString(imageDB.getComputers(), "000000000"));
		

		assertEquals(2, imageDB.getComputerLocation().size());
		
//		assertTrue(imageDB.getComputerLocation().entrySet().stream().allMatch( cl -> cl.getValue().getImage().getId().equals(imageDB.getId())) );
//		assertTrue( imageDB.getComputerLocation().entrySet().stream().allMatch(cl-> cl.getValue().getIdImage().equals(image2.getId())) && 
//				   (imageDB.getComputerLocation().size()>0) );
	}
}
