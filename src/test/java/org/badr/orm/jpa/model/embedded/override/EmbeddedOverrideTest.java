/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.embedded.override;

import java.util.Arrays;
import java.util.List;
import org.badr.orm.jpa.BaseClassITest;
import org.badr.orm.jpa.model.Collection.Image;
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
public class EmbeddedOverrideTest extends BaseClassITest{

	public EmbeddedOverrideTest() {
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
	public void justATest(){
		Language language = new Language();
		
		language.setDialectName("Darija");
		language.setDialectOrigin("Chiblaça");
		Nationality nationality = new Nationality(language);

		transaction.begin();
		entityManager.persist(nationality);
		transaction.commit();
		
		System.out.println("***********After save " + nationality.toString());
		
		entityManager.detach(nationality);
		
		Nationality nationality222 = entityManager.find(Nationality.class, nationality.getId());
		
		System.out.println("***********After find " + nationality222.toString());
	}
	
}
