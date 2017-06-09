/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.inheritance.generics.Collection;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 *
 * @author OBD
 * @param <K>
 * @param <V>
 * @param <M>
 */

@MappedSuperclass
public class SecondLevelBaseClass <K extends Serializable, V, M extends Map<K, V>> extends FirstLevelBaseClass{
	@Transient
    private M value;

	public M getValue() {
		return value;
	}

	public void setValue(M value) {
		this.value = value;
	}
    
}
