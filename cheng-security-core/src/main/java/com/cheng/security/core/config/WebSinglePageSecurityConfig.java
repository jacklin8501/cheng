/**
 * 
 */
package com.cheng.security.core.config;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
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
import com.cheng.security.core.holder.PermitAllHolder;

/**
 * @author jack.lin
 *
 */
public class WebSinglePageSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private ChengProperties cheng;
	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	@Autowired
	private AccessDecisionManager accessDecisionManager;
	
	@Autowired
	private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
	
	/**
	 * 定义FilterSecurityInterceptor
	 * @return
	 * @throws Exception
	 */
	private FilterSecurityInterceptor fs;
	private FilterSecurityInterceptor getFilterSecurityInterceptor() throws Exception {
		if (isEmpty(fs)) {
			fs = new FilterSecurityInterceptor();
		}
		fs.setAccessDecisionManager(accessDecisionManager);
		fs.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
		return fs;
	}
	
	@Bean(name="defaultWebInvocationPrivilegeEvaluator")
	public WebInvocationPrivilegeEvaluator webInvocationPrivilegeEvaluator() throws Exception {
		return new DefaultWebInvocationPrivilegeEvaluator(getFilterSecurityInterceptor());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//设置filterSecurityInterceptor
		web.securityInterceptor(getFilterSecurityInterceptor());
		
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
			.anyRequest().authenticated();
		
		http
			.rememberMe().disable();
		
		http
			.sessionManagement()
			.invalidSessionStrategy(new InvalidSessionStrategyImpl())
			.maximumSessions(cheng.getSecurity().getSession().getMaximumSessions())
			.maxSessionsPreventsLogin(cheng.getSecurity().getSession().getMaxSessionsPreventsLogin())
			.expiredSessionStrategy(new SessionInformationExpiredStrategyImpl())
			.sessionRegistry(sessionRegistry);
		
		http
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
