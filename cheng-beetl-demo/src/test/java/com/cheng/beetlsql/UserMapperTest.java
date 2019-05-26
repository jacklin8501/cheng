/**
 * 
 */
package com.cheng.beetlsql;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.ext.gen.GenConfig;
import org.junit.Test;

import com.cheng.AbstractMvcTest;
import com.cheng.beetlsql.entity.User;
import com.cheng.beetlsql.enums.Gender;

/**
 * @author jack.lin
 *
 */
public class UserMapperTest extends AbstractMvcTest {

	@Test
	public void whenInsertSuccess() {
		logger.info(":: start");
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setAge(i);
			user.setName("xiaoj8hui" + i);
			user.setUserName("xiaoj8hui" + i);
			user.setRoleId(1 + i);
			user.setCreateDate(new Date());
			sql.insert(user);
		}
		logger.info(":: end");
	}
	
	@Test
	public void whenQuerySuccess() {
		int id = 1;
		User user = sql.unique(User.class, id);
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void whenUpdateSuccess() {
		User user = new User();
		user.setId(1);
		user.setAge(31);
		user.setName("xiaoj8hui");
		sql.updateTemplateById(user);
	}
	
	@Test
	public void whenQueryTemplateSuccess() {
		User query = new User();
		query.setName("xiaoj8hui");
		List<User> users = sql.template(query);
		users.forEach(u -> logger.info(":: {}", ReflectionToStringBuilder.toString(u, ToStringStyle.MULTI_LINE_STYLE)));
	}
	
	@Test
	public void whenQueryByMdSuccess() {
		User query = new User();
		query.setName("xiaoj8hui");
		List<User> users = sql.select("user.sample", User.class, query);
		users.forEach(u -> logger.info(":: {}", ReflectionToStringBuilder.toString(u, ToStringStyle.MULTI_LINE_STYLE)));
	}
	
	@Test
	public void whenGenSuccess() throws Exception {
		//sql.genPojoCodeToConsole("user");
		sql.genSQLTemplateToConsole("user");
	}
	
	@Test
	public void whenSampleQuerySuccess() {
		List<User> users = sql.lambdaQuery(User.class).andEq(User::getName, "xiaoj8hui").orderBy(User::getCreateDate).select();
		users.forEach(u -> logger.info(":: {}", ReflectionToStringBuilder.toString(u, ToStringStyle.MULTI_LINE_STYLE)));
	}
	
	@Test
	public void whenPageQuerySuccess() {
		PageQuery<User> query = new PageQuery<>();
		query.setPageNumber(1L);
		query.setPageSize(10L);
		query.setPara("name", "xiaoj8hui");
		//query.setOrderBy("user.create_date desc");
		sql.pageQuery("user.queryPageUser", User.class, query);
		logger.info(":: total page = {}", query.getTotalPage());
		logger.info(":: total row = {}", query.getTotalRow());
		//List<User> users = query.getList();
		//users.forEach(u -> logger.info(":: {}", ReflectionToStringBuilder.toString(u, ToStringStyle.MULTI_LINE_STYLE)));
	}
	
	@Test
	public void whenGenPojoSuccess() throws Exception {
		sql.genPojoCode("role", "com.cheng.beetlsql.entity");
	}
	
	@Test
	public void whenGenSqlFileSuccess() throws Exception {
		sql.genSQLFile("role", new GenConfig());
	}
	
	@Test
	public void whenMapperSuccess() {
		User user = userMapper.single(1);
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		
		user.setUserName("huihuigou");
		
		int num = userMapper.updateById(user);
		logger.info(":: execute number = {}", num);
		
		user = userMapper.single(1);
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void whenMapperInsertSuccess() {
		User user = new User();
		user.setName("JACK.LIN");
		user.setUserName("JACK.LIN");
		user.setAge(11);
		user.setGender(Gender.MALE);
		userMapper.insert(user);
	}
	
	@Test
	public void whenMapperSingleSuccess() {
		User query = new User();
		query.setGender(Gender.MALE);
		List<User> user = userMapper.select(query);
		logger.info(":: {}", ReflectionToStringBuilder.toString(user.get(0), ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void whenMapperUpdateSuccess() {
		//sql.executeUpdate(new SQLReady("delete from user"));
		int id = 206;
		User user = userMapper.single(id);
		logger.info(":: 第1次查询");
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		user.setUserName(user.getName());
		userMapper.updateById(user);
		logger.info(":: 第2次查询,更新后");
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		user = userMapper.single(id);
		logger.info(":: 第3次查询");
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void whenQuerySimpleRole() {
		int id = 306;
		User user = userMapper.simpleRelRole(id);
		logger.info(":: {}", ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@Test
	public void whenMapperSimpleTimeStamp() {
		userMapper.simpleTimeStamp("xiaohuihui");
	}
	
	@Test
	public void whenMapperSimpleIn() {
		List<Integer> ids = Arrays.asList(306, 307, 308);
		List<User> users = userMapper.simpleIn(ids);
		logger.info(":: {}", ReflectionToStringBuilder.toString(users.get(0), ToStringStyle.MULTI_LINE_STYLE));
	}
}
