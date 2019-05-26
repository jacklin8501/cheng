/**
 * 
 */
package com.cheng.beetl.gen;

import org.junit.Test;

import com.cheng.AbstractMvcTest;
import com.cheng.beetl.manager.BeetlSqlGenderManager;

/**
 * @author jack.lin
 *
 */
public class Gender extends AbstractMvcTest {

	@Test
	public void whenGenAllSuccess() throws Exception {
		whenGenUserSuccess();
		whenGenRoleSuccess();
		whenGenUserRoleSuccess();
	}
	
	@Test
	public void whenGenUserSuccess() throws Exception {
		BeetlSqlGenderManager
			.create()
			.table("iden_user")
			.daoPackage("com.cheng.beetl.spring.dao")
			.pojoPackage("com.cheng.beetl.spring.pojo")
			.genPojoCode();
	}
	
	@Test
	public void whenGenRoleSuccess() throws Exception {
		BeetlSqlGenderManager
		.create()
		.table("iden_role")
		.daoPackage("com.cheng.beetl.spring.dao")
		.pojoPackage("com.cheng.beetl.spring.pojo")
		.genPojoCode();
	}
	
	@Test
	public void whenGenUserRoleSuccess() throws Exception {
		BeetlSqlGenderManager
		.create()
		.table("iden_user_role")
		.daoPackage("com.cheng.beetl.spring.dao")
		.pojoPackage("com.cheng.beetl.spring.pojo")
		.genPojoCode();
	}
}
