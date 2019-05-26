/**
 * 
 */
package com.cheng.beetlsql;

import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MapperCodeGen;
import org.junit.Test;

import com.cheng.AbstractMvcTest;
import com.cheng.beetlsql.entity.Role;

/**
 * @author jack.lin
 *
 */
public class RoleMapperTest extends AbstractMvcTest {

	@Test
	public void whenInsertSuccess() {
		for (int i = 0; i < 100; i++) {
			Role role = new Role();
			role.setRoleCode("HUII_" + i);
			role.setRoleName("HUIHUIGOU" + i);
			roleMapper.insert(role);
		}
	}
	
	@Test
	public void whenGenSuccess() throws Exception {
		MapperCodeGen mapper = new MapperCodeGen("com.cheng.beetlsql.mapper");
		GenConfig config = new GenConfig();
		config.codeGens.add(mapper);
		sql.genPojoCodeToConsole("role", config);
	}
}
