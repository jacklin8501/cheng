/**
 * 
 */
package com.cheng;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cheng.beetlsql.mapper.RoleMapper;
import com.cheng.beetlsql.mapper.UserMapper;

/**
 * @author jack.lin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractMvcTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected SQLManager sql;
	protected UserMapper userMapper;
	protected RoleMapper roleMapper;
	
	@Autowired
	protected WebApplicationContext context;
	
	protected MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		
		final String driver = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://127.0.0.1:3306/beetlsql?useUnicode=yes&characterEncoding=UTF-8";
		final String userName = "root";
		final String password = "root";
		ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
		DBStyle mysql = new MySqlStyle();
		// sql语句放在classpagth的/sql 目录下
		SQLLoader loader = new ClasspathLoader("/sql");
		// 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
		UnderlinedNameConversion nc = new  UnderlinedNameConversion();
		// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
		sql = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
		userMapper = sql.getMapper(UserMapper.class);
		roleMapper = sql.getMapper(RoleMapper.class);
	}
}
