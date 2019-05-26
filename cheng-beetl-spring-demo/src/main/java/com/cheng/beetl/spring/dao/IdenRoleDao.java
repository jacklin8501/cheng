package com.cheng.beetl.spring.dao;
import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.cheng.beetl.spring.pojo.IdenRole;

/*
* 
* gen by beetlsql mapper 2019-05-12
*/
public interface IdenRoleDao extends BaseMapper<IdenRole> {
	
	List<IdenRole> findByUserIdIn(@Param("userIds") List<Long> userIds);
}
