/**
 * 
 */
package com.cheng.security.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.cheng.security.core.config.manager.impl.DefaultAccessDecisionManagerImpl;
import com.cheng.security.core.metadatasource.impl.DefaultFilterInvocationSecurityMetadataSourceImpl;

/**
 * @author jack.lin
 *
 */
public class WebSecurityBeanConfig {

	@ConditionalOnMissingBean(AccessDecisionManager.class)
	@Bean
	public AccessDecisionManager accessDecisionManager() {
		return new DefaultAccessDecisionManagerImpl();
	}
	
	@ConditionalOnMissingBean(FilterInvocationSecurityMetadataSource.class)
	@Bean
	public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource() {
		return new DefaultFilterInvocationSecurityMetadataSourceImpl();
	}
	
	@ConditionalOnMissingBean(SessionRegistry.class)
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	@ConditionalOnMissingBean(PasswordEncoder.class)
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
