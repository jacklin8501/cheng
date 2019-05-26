/**
 * 
 */
package com.cheng.security.core.config.manager.impl;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;
import static com.cheng.security.core.utils.AuthenticationUtils.isAnonymousUser;
import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.cheng.security.core.config.Strategy.AccessStrategy;
import com.cheng.security.core.config.Strategy.impl.AnyRequestAuthenticatedAccessStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.DefaultPermitAllRequestAccessStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.PermitAllRequestAccessStrategyImpl;
import com.cheng.security.core.config.manager.DefaultAccessDecisionManager;

/**
 * @author jack.lin
 *
 */
@Component
public class DefaultAccessDecisionManagerImpl implements DefaultAccessDecisionManager {

	final Logger logger = LoggerFactory.getLogger(getClass());
	final AntPathMatcher pathMatcher = new AntPathMatcher();
	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		FilterInvocation fi = (FilterInvocation) object;
		HttpServletRequest request = fi.getHttpRequest();
		
		String uri = calculateUri(request);
		logger.info(":: Pre-access uri {}", uri);
		
		AccessStrategy publishRequestAccessStrategy = new DefaultPermitAllRequestAccessStrategyImpl();
		boolean isPublish = publishRequestAccessStrategy.canAccess(request);
		if (isPublish) {
			return;
		}
		
		AccessStrategy permitAllRequestAccessStrategy = new PermitAllRequestAccessStrategyImpl();
		boolean isPermitAll = permitAllRequestAccessStrategy.canAccess(request);
		if (isPermitAll) {
			return;
		}
		
		if (isAnonymousUser(authentication)) {
			logger.info(":: AnonymousUser: can not understander the user!");
			logger.info(":: Refuse access uri {}", uri);
			throw new InsufficientAuthenticationException("AnonymousUser: can not understander the user!");
		}
		
		AccessStrategy anyRequestAuthenticatedAccessStrategy = new AnyRequestAuthenticatedAccessStrategyImpl();
		boolean isAnyRequestAuthenticated = anyRequestAuthenticatedAccessStrategy.canAccess(request);
		if (isAnyRequestAuthenticated) {
			return;
		}
		
		if (isNotEmpty(configAttributes)) {
			Iterator<ConfigAttribute> iterator = configAttributes.iterator();
			while (iterator.hasNext()) {
				ConfigAttribute cfa = iterator.next();
				String perm = cfa.getAttribute();
				logger.info(":: need permission {}", perm);
				for (GrantedAuthority ga : authentication.getAuthorities()) {
					String au = ga.getAuthority();
					logger.info(":: user owns permission {}", au);
					if (StringUtils.equals(au, perm)) {
						logger.info(":: can access uri {}", uri);
						return ;
					}
				}
			}
		}
		
		logger.info(":: Refuse access uri {}", uri);
		logger.info(":: Permission is not enougth!");
		throw new AccessDeniedException("Refuse access: permission is not enougth!");
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
