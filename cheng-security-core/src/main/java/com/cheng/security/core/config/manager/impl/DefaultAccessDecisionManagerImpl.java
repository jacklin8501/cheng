/**
 * 
 */
package com.cheng.security.core.config.manager.impl;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.cheng.security.core.config.manager.DefaultAccessDecisionManager;
import com.cheng.security.core.manager.AccessStrategyManager;

/**
 * @author jack.lin
 *
 */
@Component
public class DefaultAccessDecisionManagerImpl implements DefaultAccessDecisionManager {

	final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccessStrategyManager accessStrategyManager;
	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		FilterInvocation fi = (FilterInvocation) object;
		HttpServletRequest request = fi.getHttpRequest();
		
		accessStrategyManager.executeDecide(authentication, request, configAttributes);
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
