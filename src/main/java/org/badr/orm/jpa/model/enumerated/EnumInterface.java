/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.enumerated;

/**
 *
 * @author OBD
 */
public interface EnumInterface{

	public Number getCode();

	public static <EE extends Enum<EE> & EnumInterface> Enum findByCode(Number code, Class<EE> enumType){
		
		for (EE c : enumType.getEnumConstants()){
			if (c.getCode().equals(code)){
				return Enum.valueOf(enumType, c.toString());
			}
		}		
		return null;
	}
			
}
