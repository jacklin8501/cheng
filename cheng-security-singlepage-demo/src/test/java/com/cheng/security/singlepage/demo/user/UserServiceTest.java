/**
 * 
 */
package com.cheng.security.singlepage.demo.user;

import org.beetl.sql.core.engine.PageQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.AbstractSecurityMvcTest;
import com.cheng.btlusermrg.pojo.AuthUser;
import com.cheng.btlusermrg.service.AuthUserService;

/**
 * @author jack.lin
 *
 */
public class UserServiceTest extends AbstractSecurityMvcTest {

	@Autowired
	private AuthUserService authUserService;
	
	@Test
	public void whenPageQuerySuccess() {
		PageQuery<AuthUser> page = authUserService.pageQuery(new PageQuery<>());
		long total = page.getTotalRow();
		logger.info(":: total" + total);
	}
}
