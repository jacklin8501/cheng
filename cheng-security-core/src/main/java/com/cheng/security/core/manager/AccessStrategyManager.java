/**
 * 
 */
package com.cheng.security.core.manager;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;
import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.cheng.core.properties.ChengProperties;
import com.cheng.security.core.config.Strategy.AccessStrategy;
import com.cheng.security.core.config.Strategy.impl.AnyRequestAuthenticatedAccessStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.DefaultPermitAllRequestAccessStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.PermitAllRequestAccessStrategyImpl;

/**
 * @author jack.lin
 *
 */
@Component
public class AccessStrategyManager {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ChengProperties cheng;
	
	private AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
	
	private AccessStrategy defaultPermitAllRequestAccessStrategy;
	
	private AccessStrategy permitAllRequestAccessStrategy;
	
	private AccessStrategy anyRequestAuthenticatedAccessStrategy;
	
	public AccessStrategy getDefaultPermitAllRequestAccessStrategy() {
		if (null == defaultPermitAllRequestAccessStrategy) {
			defaultPermitAllRequestAccessStrategy = new DefaultPermitAllRequestAccessStrategyImpl();
		}
		return defaultPermitAllRequestAccessStrategy;
	}
	
	public AccessStrategy getPermitAllRequestAccessStrategy() {
		if (null == permitAllRequestAccessStrategy) {
			permitAllRequestAccessStrategy = new PermitAllRequestAccessStrategyImpl();
		}
		return permitAllRequestAccessStrategy;
	}
	
	public AccessStrategy getAnyRequestAuthenticatedAccessStrategy() {
		if (null == anyRequestAuthenticatedAccessStrategy) {
			anyRequestAuthenticatedAccessStrategy = new AnyRequestAuthenticatedAccessStrategyImpl();
		}
		return anyRequestAuthenticatedAccessStrategy;
	}
	
	public void executeDecide(Authentication authentication, HttpServletRequest request, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException  {
		String uri = calculateUri(request);
		logger.info(":: Pre-access uri {}", uri);
		
		/*if (cheng.getSecurity().getEnabledDefaultPermitAll() 
				&& getDefaultPermitAllRequestAccessStrategy().canAccess(request)) {
			return;
		}
		
		if (getPermitAllRequestAccessStrategy().canAccess(request)) {
			return;
		}
		
		if (trustResolver.isAnonymous(authentication)) {
			logger.info(":: AnonymousUser: can not understander the user!");
			logger.info(":: Refuse access uri {}", uri);
			throw new InsufficientAuthenticationException("AnonymousUser: can not understander the user!");
		}
		
		if (trustResolver.isRememberMe(authentication)) {
			logger.info(":: RememberMe user");
		}
		
		if (getAnyRequestAuthenticatedAccessStrategy().canAccess(request)) {
			return;
		}*/
		
		if (isNotEmpty(configAttributes)) {
			Iterator<ConfigAttribute> iterator = configAttributes.iterator();
			while (iterator.hasNext()) {
				ConfigAttribute cfa = iterator.next();
				//authenticated
				if (StringUtils.equals("authenticated", cfa.toString())) {
					logger.info(":: No ConfigAttributes! can access uri {}", uri);
					return;
				}
				if (StringUtils.equals("PERMIT_ALL", cfa.getAttribute())) {
					logger.info(":: PERMIT_ALL! can access uri {}", uri);
					return;
				}
				String perm = cfa.getAttribute();
				logger.info(":: need permission {}", perm);
				for (GrantedAuthority ga : authentication.getAuthorities()) {
					String pattern = ga.getAuthority();
					logger.info(":: user owns permission {}", pattern);
					if (StringUtils.equals(pattern, perm)) {
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
}
