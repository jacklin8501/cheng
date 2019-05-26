package com.cheng.beetl.spring.dao;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.cheng.beetl.spring.pojo.IdenUser;

/*
* 
* gen by beetlsql mapper 2019-05-12
*/
public interface IdenUserDao extends BaseMapper<IdenUser> {
	
	IdenUser sample(@Param("userId") long userId);
}
