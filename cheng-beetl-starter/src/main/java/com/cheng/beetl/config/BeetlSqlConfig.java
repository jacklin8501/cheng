/**
 * 
 */
package com.cheng.beetl.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author jack.lin
 *
 */
public class BeetlSqlConfig {

	@Bean(name="datasource")
	public DataSource dataSource(Environment env) {
		
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
	    ds.setUsername(env.getProperty("spring.datasource.username"));
	    ds.setPassword(env.getProperty("spring.datasource.data-password"));
	    ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		return ds;
	}
}
