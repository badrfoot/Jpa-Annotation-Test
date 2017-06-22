/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.enumerated;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.AttributeConverter;

/**
 *
 * @author OBD
 */
public class NumberConverter implements AttributeConverter<CharSequence, Integer>{

	@Override
	public Integer convertToDatabaseColumn(CharSequence attribute) {
		return Integer.parseInt(attribute.toString());
	}

	@Override
	public CharSequence convertToEntityAttribute(Integer dbData) {
		return dbData.toString();
	}
	
	
}
