/**
 * 
 */
package com.cheng.beetl.spring.demo.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractMvcTest;
import com.cheng.beetl.spring.dao.IdenRoleDao;
import com.cheng.beetl.spring.pojo.IdenRole;

/**
 * @author jack.lin
 *
 */
public class RoleDaoTest extends AbstractMvcTest {

	@Autowired
	private IdenRoleDao roleDao;
	
	@Test
	public void whenInsertSuccess() {
		IdenRole role = new IdenRole();
		role.setCreateBy("jack.lin");
		role.setLastModifiedBy("jack.lin");
		role.setRoleCode("role_dailao1");
		role.setRoleName("大佬1");
		role.setRoleDescription("大佬1");
		
		roleDao.insert(role);
	}
}
