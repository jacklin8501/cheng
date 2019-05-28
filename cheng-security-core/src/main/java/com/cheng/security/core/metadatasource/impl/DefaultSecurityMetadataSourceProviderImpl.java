/**
 * 
 */
package com.cheng.security.core.metadatasource.impl;

import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.FilterInvocation;

import com.cheng.core.properties.ChengProperties;
import com.cheng.security.core.manager.AccessStrategyManager;
import com.cheng.security.core.metadatasource.CustomerSecurityMetadataSourceProvider;
import com.cheng.security.core.pojo.PermissionSec;
import com.cheng.security.core.pojo.RoleSec;

/**
 * @author jack.lin
 *
 */
public class DefaultSecurityMetadataSourceProviderImpl implements CustomerSecurityMetadataSourceProvider {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static Map<PermissionSec, RoleSec> resource;
	
	private ChengProperties cheng;
	private AccessStrategyManager accessStrategyManager;
	private SessionRegistry sessionRegistry;
	
	@PostConstruct
	@Override
	public void reflushMetaDataSource() {
		resource = new HashMap<>();
		List<Object> principals = sessionRegistry.getAllPrincipals();
		for (Object object : principals) {
			logger.info(":: Principal {}", object.getClass().getName());
		}
	}
	
	@Override
	public void setSessionRegistry(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		
		FilterInvocation fi = (FilterInvocation) arg0;
		HttpServletRequest request = fi.getRequest();
		
		String uri = calculateUri(request);
		String method = request.getMethod().toUpperCase();
		logger.info(":: set ConfigAttribute {}:{} ", method, uri);
		
		Collection<ConfigAttribute> cfas = new ArrayList<>();
		
		if (cheng.getSecurity().getEnabledDefaultPermitAll()) {
			boolean isDefaultPermitAll = accessStrategyManager.getDefaultPermitAllRequestAccessStrategy().canAccess(request);
			if (isDefaultPermitAll) {
				logger.info(":: Access PermitAll");
				cfas.add(new SecurityConfig("PERMIT_ALL"));
			}
		}
		
		boolean isPermitAll = accessStrategyManager.getDefaultPermitAllRequestAccessStrategy().canAccess(request);
		if (isPermitAll) {
			logger.info(":: Access PermitAll");
			cfas.add(new SecurityConfig("PERMIT_ALL"));
		}
		
		String attr = method.toUpperCase() + ":" + uri;
		cfas.add(new SecurityConfig(attr));
		
		return cfas;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return FilterInvocation.class.isAssignableFrom(arg0);
	}

	public void setAccessStrategyManager(AccessStrategyManager accessStrategyManager) {
		this.accessStrategyManager = accessStrategyManager;
	}

	public void setChengProperties(ChengProperties cheng) {
		this.cheng = cheng;
	}
	
}
