/**
 * 
 */
package com.cheng.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.DefaultWebInvocationPrivilegeEvaluator;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.cheng.core.properties.ChengProperties;
import com.cheng.security.core.config.Strategy.impl.InvalidSessionStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.SessionInformationExpiredStrategyImpl;
import com.cheng.security.core.config.handler.AuthenticationFailureHandlerImpl;
import com.cheng.security.core.config.handler.AuthenticationSuccessHandlerImpl;
import com.cheng.security.core.config.handler.LogoutSuccessHandlerImpl;
import com.cheng.security.core.config.manager.DefaultAccessDecisionManager;
import com.cheng.security.core.holder.PermitAllHolder;
import com.cheng.security.core.metadatasource.impl.DefaultFilterInvocationSecurityMetadataSourceImpl;

/**
 * @author jack.lin
 *
 */
public class WebSinglePageSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DefaultAccessDecisionManager defaultAccessDecisionManagerImpl;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private ChengProperties cheng;

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@ConditionalOnMissingBean(FilterInvocationSecurityMetadataSource.class)
	@Bean
	public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource() {
		DefaultFilterInvocationSecurityMetadataSourceImpl fss = new DefaultFilterInvocationSecurityMetadataSourceImpl();
		return fss;
	}
	
	@Bean
	public FilterSecurityInterceptor filterSecurityInterceptor() throws Exception {
		FilterSecurityInterceptor fs = new FilterSecurityInterceptor();
		fs.setAccessDecisionManager(defaultAccessDecisionManagerImpl);
		fs.setSecurityMetadataSource(filterInvocationSecurityMetadataSource());
		return fs;
	}
	
	@Bean(name="defaultWebInvocationPrivilegeEvaluator")
	public WebInvocationPrivilegeEvaluator webInvocationPrivilegeEvaluator() throws Exception {
		return new DefaultWebInvocationPrivilegeEvaluator(filterSecurityInterceptor());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.securityInterceptor(filterSecurityInterceptor());
		web.privilegeEvaluator(webInvocationPrivilegeEvaluator());
		//web.ignoring().antMatchers("/**/*.js", "/**/*.html", "/**/*.css");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
			//.addFilterAfter(new SessionFilter(sessionRegistry()), ConcurrentSessionFilter.class);
		
		http
			.authorizeRequests()
			.filterSecurityInterceptorOncePerRequest(true)
			.antMatchers(PermitAllHolder.getPermitAllExpression()).permitAll()
			.anyRequest().authenticated()
			.and()
			.rememberMe().disable()
			.sessionManagement()
			//.invalidSessionUrl(cheng.getSecurity().getSession().getInvalidSessionUrl())
			.invalidSessionStrategy(new InvalidSessionStrategyImpl())
			.maximumSessions(cheng.getSecurity().getSession().getMaximumSessions())
			.maxSessionsPreventsLogin(cheng.getSecurity().getSession().getMaxSessionsPreventsLogin())
			//.expiredUrl(cheng.getSecurity().getSession().getExpiredUrl())
			.expiredSessionStrategy(new SessionInformationExpiredStrategyImpl())
			.sessionRegistry(sessionRegistry())
			.and()
			
			.and()
			.formLogin()
			.loginPage(cheng.getSecurity().getForm().getLoginPage())
			.loginProcessingUrl(cheng.getSecurity().getForm().getLoginProcessingUrl())
			.successHandler(new AuthenticationSuccessHandlerImpl())
			.failureHandler(new AuthenticationFailureHandlerImpl())
			.permitAll()
			.and()
			
			.logout()
			.logoutSuccessHandler(new LogoutSuccessHandlerImpl())
			.permitAll()
			;
		
		//http.addFilterBefore(filterSecurityInterceptor(), FilterSecurityInterceptor.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	
}
