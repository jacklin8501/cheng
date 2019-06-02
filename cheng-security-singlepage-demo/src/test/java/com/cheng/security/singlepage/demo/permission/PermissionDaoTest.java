/**
 * 
 */
package com.cheng.security.singlepage.demo.permission;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractMvcTest;
import com.cheng.btlusermrg.dao.AuthPermissionDao;
import com.cheng.btlusermrg.pojo.AuthPermission;

/**
 * @author jack.lin
 *
 */
public class PermissionDaoTest extends AbstractMvcTest {

	@Autowired
	private AuthPermissionDao authPermissionDao;
	
	@Test
	public void whenFindAllSuccess() {
		List<AuthPermission> perms = authPermissionDao.all();
		showMessages(perms);
	}
}
