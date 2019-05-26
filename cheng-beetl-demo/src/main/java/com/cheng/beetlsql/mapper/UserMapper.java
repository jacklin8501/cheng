/**
 * 
 */
package com.cheng.beetlsql.mapper;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.cheng.beetlsql.entity.User;

/**
 * @author jack.lin
 *
 */
public interface UserMapper extends BaseMapper<User> {

	List<User> select(@Param("name") String name);
	
	List<User> select(User query);
	
	User simpleRelRole(@Param("id") int id);
	
	List<User> simpleTimeStamp(@Param("name") String name);
	
	List<User> simpleIn(@Param("ids") List<Integer> ids);
}
