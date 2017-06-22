/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class EnumeratedTest extends BaseClassITest{
	
	public EnumeratedTest() {
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
	
	@Test //@Ignore
	public void shouldInsertTvProgram() {
	
		TvProgram tvProgram = new TvProgram();
		
		System.out.println("************** Before" + tvProgram.toString());
		
		transaction.begin();
		entityManager.persist(tvProgram);		
		transaction.commit();
		
		entityManager.detach(tvProgram);
		
//		System.out.println("**************" + entityManager.find(TvProgram.class, tvProgram.getId()).toString());
	}
	
	@Test //@Ignore
	public void shouldJustPass(){
		
//		System.out.println(EnumInterface.findByCode(MyEnum.SOCCER.getCode(), MyEnum.class));
//		
//		assertEquals(MyEnum.SOCCER, EnumInterface.findByCode(MyEnum.SOCCER.getCode(), MyEnum.class));
	}
	
	
}
