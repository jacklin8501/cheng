/**
 * 
 */
package com.cheng.beetl.spring.demo.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractMvcTest;
import com.cheng.beetl.spring.dao.IdenUserRoleDao;
import com.cheng.beetl.spring.pojo.IdenUserRole;

/**
 * @author jack.lin
 *
 */
public class UserRoleDaoTest extends AbstractMvcTest {

	@Autowired
	private IdenUserRoleDao userRoleDao;
	
	@Test
	public void whenInsertSuccess() {
		IdenUserRole userRole = new IdenUserRole();
		userRole.setUserId(6L);
		userRole.setRoleId(1L);
		userRole.setCreateBy("jack.lin");
		userRole.setLastModifiedBy("jack.lin");
		
		userRoleDao.insert(userRole);
		
		userRole.setRoleId(2L);
		userRoleDao.insert(userRole);
	}
}
