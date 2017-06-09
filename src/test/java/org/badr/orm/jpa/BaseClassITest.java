/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OBD
 */
public class BaseClassITest {
	protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	protected EntityManager entityManager;
	protected EntityTransaction transaction;

	public BaseClassITest() {
		entityManager = Persistence.createEntityManagerFactory("JPA_Annotation").createEntityManager();
		transaction = entityManager.getTransaction();
	}
	
	@Test @Ignore
	public void shouldLoadContext(){
		
	}
}
