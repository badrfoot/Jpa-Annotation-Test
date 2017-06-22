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
public enum MyEnum implements EnumInterface{
	
	SOCCER(10), BASKETBALL(30), TENNIS(120);
	
	
	private final Integer code;

	private MyEnum(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
	
//	 public static MyEnum getType(Integer id) {
//       
//        if (id == null) {
//            return null;
//        }
// 
//        for (MyEnum myEnum : MyEnum.values()) {
//            if (id.equals(myEnum.getCode())) {
//                return myEnum;
//            }
//        }
//        throw new IllegalArgumentException("No matching type for id " + id);
//    }
	
}
