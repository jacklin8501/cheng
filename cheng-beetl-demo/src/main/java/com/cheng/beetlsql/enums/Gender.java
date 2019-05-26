/**
 * 
 */
package com.cheng.beetlsql.enums;

import org.beetl.sql.core.annotatoin.EnumMapping;

/**
 * @author jack.lin
 * 性别
 */
@EnumMapping("value")
public enum Gender {
	
	/**
	 * 雄性
	 */
	MALE(1, "MALE"),
	
	/**
	 * 雌性
	 */
	FEMALE(2, "FEMALE");
	
	private int value;
	private String code;
	
	private Gender(int value, String code) {
		this.value = value;
		this.code = code;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
