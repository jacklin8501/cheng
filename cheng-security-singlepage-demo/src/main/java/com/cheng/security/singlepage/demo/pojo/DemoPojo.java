/**
 * 
 */
package com.cheng.security.singlepage.demo.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author jack.lin
 *
 */
public class DemoPojo {

	@NotEmpty(message="{name.required}")
	@Length(min=3, max=10, message="{name.length}")
	private String name;
	@NotNull(message="{age.required}")
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
