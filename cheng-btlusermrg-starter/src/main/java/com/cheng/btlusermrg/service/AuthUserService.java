/**
 * 
 */
package com.cheng.btlusermrg.service;

import org.beetl.sql.core.engine.PageQuery;

import com.cheng.btlusermrg.pojo.AuthUser;

/**
 * @author jack.lin
 *
 */
public interface AuthUserService {

	PageQuery<AuthUser> pageQuery(PageQuery<AuthUser> query);
}
