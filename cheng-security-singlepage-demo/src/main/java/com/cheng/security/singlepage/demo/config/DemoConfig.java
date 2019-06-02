/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class DemoConfig implements WebMvcConfigurer {

	@Autowired
	Environment env;
	
	@Bean
	public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource() {
		return new DemoFilterInvocationSecurityMetadataSource();
	}
	
	public ResourceBundleMessageSource resourceBundleMessageSource () {
		ResourceBundleMessageSource rms = new ResourceBundleMessageSource();
		rms.setDefaultEncoding(env.getProperty("spring.messages.encoding"));
		rms.setBasename(env.getProperty("spring.messages.basename"));
		rms.setCacheSeconds(10);
		return rms;
	}

	@Bean
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(resourceBundleMessageSource());
		return bean;
	}
	
	
}
