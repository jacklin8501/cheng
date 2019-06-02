/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.cheng.beetl.config.BeetlSqlConfig;
import com.cheng.beetl.config.BeetlWebConfig;
import com.cheng.btlusermrg.config.BtlUserMrgConfig;
import com.cheng.security.core.config.WebSecurityBeanConfig;
import com.cheng.security.core.config.WebSinglePageSecurityConfig;

/**
 * @author jack.lin
 *
 */
@Import({
	WebSinglePageSecurityConfig.class, 
	WebSecurityBeanConfig.class, 
	BeetlWebConfig.class,
	BeetlSqlConfig.class,
	BtlUserMrgConfig.class
})
@Configuration
public class DemoConfig {

	@Bean
	public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource() {
		return new DemoFilterInvocationSecurityMetadataSource();
	}
}
