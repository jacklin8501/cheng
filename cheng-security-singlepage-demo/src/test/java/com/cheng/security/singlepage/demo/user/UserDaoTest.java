/**
 * 
 */
package com.cheng.security.singlepage.demo.user;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;

import com.cheng.AbstractSecurityMvcTest;
import com.cheng.btlusermrg.dao.AuthUserDao;
import com.cheng.btlusermrg.pojo.AuthUser;

/**
 * @author jack.lin
 *
 */
@WithUserDetails(value="maxadmin", userDetailsServiceBeanName="userDetailsServiceImpl")
public class UserDaoTest extends AbstractSecurityMvcTest {

	@Autowired
	private AuthUserDao authUserDao;
	
	@Test
	public void whenFindAllSuccess() {
		List<AuthUser> users = authUserDao.all();
		showMessages(users);
	}
	
	@Test
	public void whenInsertSuccess() {
		AuthUser user = new AuthUser();
		user.setUsername("HelloXiao2Hui3");
		user.setPassword("000000");
		authUserDao.insert(user);
	}
}
