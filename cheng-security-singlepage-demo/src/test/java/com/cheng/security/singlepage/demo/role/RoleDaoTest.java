/**
 * 
 */
package com.cheng.security.singlepage.demo.role;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractMvcTest;
import com.cheng.btlusermrg.dao.AuthRoleDao;
import com.cheng.btlusermrg.pojo.AuthRole;

/**
 * @author jack.lin
 *
 */
public class RoleDaoTest extends AbstractMvcTest {

	@Autowired
	private AuthRoleDao authRoleDao;
	
	@Test
	public void whenFindAllSuccess() {
		List<AuthRole> roles = authRoleDao.all();
		showMessages(roles);
	}
}
