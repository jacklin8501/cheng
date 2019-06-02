/**
 * 
 */
package com.cheng.beetl.gen;

import org.beetl.sql.core.db.MySqlStyle;
import org.junit.Before;
import org.junit.Test;

import com.cheng.AbstractMvcTest;
import com.cheng.beetl.manager.BeetlSqlPojoGenderBuilder;
import com.cheng.beetl.manager.BeetlSqlPojoGenderBuilder.BeetlSqlPojoGender;

/**
 * @author jack.lin
 *
 */
public class GenCodeTest extends AbstractMvcTest {

	private BeetlSqlPojoGender gender;

	@Before
	public void genSetup() {
		gender = BeetlSqlPojoGenderBuilder.create()
				.dataSource("com.mysql.jdbc.Driver",
						"jdbc:mysql://127.0.0.1:3306/beetlsql?useUnicode=yes&characterEncoding=UTF-8", 
						"root", 
						"root",
						MySqlStyle::new)
				.pojoPath("com.cheng.security.singlepage.demo.pojo")
				.daoPath("com.cheng.security.singlepage.demo.dao")
				.build();
	}

	@Test
	public void whenGenSuccess() throws Exception {
		gender.gen("auth_user");
	}
}
