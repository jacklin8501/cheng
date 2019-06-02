/**
 * 
 */
package com.cheng.security.singlepage.demo.userdao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractMvcTest;
import com.cheng.btlusermrg.dao.AuthUserDao;
import com.cheng.btlusermrg.pojo.AuthUser;

/**
 * @author jack.lin
 *
 */
public class UserDaoTest extends AbstractMvcTest {

	@Autowired
	private AuthUserDao authUserDao;
	
	@Test
	public void whenFindAllSuccess() {
		List<AuthUser> users = authUserDao.all();
		showMessages(users);
	}
}
