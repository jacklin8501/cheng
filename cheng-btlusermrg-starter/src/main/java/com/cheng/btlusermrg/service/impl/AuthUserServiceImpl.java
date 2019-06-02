/**
 * 
 */
package com.cheng.btlusermrg.service.impl;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheng.btlusermrg.dao.AuthUserDao;
import com.cheng.btlusermrg.pojo.AuthUser;
import com.cheng.btlusermrg.service.AuthUserService;

/**
 * @author jack.lin
 *
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private AuthUserDao authUserDao;
	
	@Override
	public PageQuery<AuthUser> pageQuery(PageQuery<AuthUser> query) {
		authUserDao.templatePage(query);
		return query;
	}

}
