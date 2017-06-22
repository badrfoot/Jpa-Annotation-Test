/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.enumerated;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import javax.persistence.AttributeConverter;

/**
 *
 * @author OBD
 */
public class localDateConverter implements AttributeConverter<Temporal, Long>{

	@Override
	public Long convertToDatabaseColumn(Temporal attribute) {		
		return ChronoUnit.MONTHS.between(LocalDate.now(), attribute);
	}

	@Override
	public Temporal convertToEntityAttribute(Long dbData) {
		return LocalDate.now().plus(dbData, ChronoUnit.MONTHS);
	}
	
}
