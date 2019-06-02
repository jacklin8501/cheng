/**
 * 
 */
package com.cheng.btlusermrg.config;

import static com.cheng.beetl.consts.DataSourceConsts.DRIVER_CLASS_NAME;
import static com.cheng.beetl.consts.DataSourceConsts.PASSWORD;
import static com.cheng.beetl.consts.DataSourceConsts.URL;
import static com.cheng.beetl.consts.DataSourceConsts.USERNAME;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author jack.lin
 *
 */
public class BtlUserMrgConfig {

	final String PREFIX = "cheng.btlusermrg.datasource.";
	
	@Bean(name="usermrg")
	public DataSource userMrgDataSource(Environment env) {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(env.getProperty(PREFIX + DRIVER_CLASS_NAME));
		ds.setJdbcUrl(env.getProperty(PREFIX + URL));
		ds.setUsername(env.getProperty(PREFIX + USERNAME));
		ds.setPassword(env.getProperty(PREFIX + PASSWORD));
		return ds;
	}
}
