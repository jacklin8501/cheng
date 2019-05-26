/**
 * 
 */
package com.cheng.beetl.spring.demo.dao;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractMvcTest;
import com.cheng.beetl.spring.dao.IdenRoleDao;
import com.cheng.beetl.spring.dao.IdenUserDao;
import com.cheng.beetl.spring.pojo.IdenRole;
import com.cheng.beetl.spring.pojo.IdenUser;

/**
 * @author jack.lin
 *
 */
public class UserDaoTest extends AbstractMvcTest {

	@Autowired
	private IdenUserDao userDao;
	@Autowired
	private IdenRoleDao roleDao;
	
	@Test
	public void whenInsertSuccess() {
		IdenUser user = new IdenUser();
		user.setUsername("alison.lin");
		user.setPassword("000000");
		user.setCreateBy("alison.lin");
		user.setLastModifiedBy("alison.lin");
		
		userDao.insert(user);
	}
	
	@Test
	public void whenUpdateSuccess() {
		
	}
	
	@Test
	public void whenQuerySuccess() {
		IdenUser user = userDao.sample(6L);
		List<IdenRole> roles = (List<IdenRole>) user.get("idenRole");
		roles.forEach(r -> logger.info(":: {}", ReflectionToStringBuilder.toString(r, ToStringStyle.MULTI_LINE_STYLE)));
	}
	
	@Test
	public void whenQueryRole() {
		IdenUser query = new IdenUser();
		query.setUserId(6L);
		List<IdenRole> roles = userDao.getSQLManager().select("idenUser.selectRole", IdenRole.class, query);
	}
}
