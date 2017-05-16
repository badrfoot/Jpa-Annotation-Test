/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author OBD
 */
public abstract class BaseClassITest {
	
	protected EntityManager entityManager;

	public BaseClassITest() {
		entityManager = Persistence.createEntityManagerFactory("JPA_Annotation").createEntityManager();
	}
}
