/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.cheng.security.core.metadatasource.CustomerSecurityMetadataSourceProvider;

/**
 * @author jack.lin
 *
 */
@Component
public class CustomerSecurityMetadataSourceProviderImpl implements CustomerSecurityMetadataSourceProvider {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		
		FilterInvocation fi = (FilterInvocation) arg0;
		HttpServletRequest request = fi.getRequest();
		
		String uri = calculateUri(request);
		String method = request.getMethod().toUpperCase();
		logger.info(":: set ConfigAttribute {}:{} ", method, uri);
		
		Collection<ConfigAttribute> cfas = new ArrayList<>();
		
		AntPathMatcher matcher = getPathMatcher();
		if (matcher.match("/index/**", uri)) {
			logger.info(":: index module");
			cfas.add(new SecurityConfig("GET:INDEX"));
		}
		if (matcher.match("/user/**", uri)) {
			logger.info(":: user module");
			cfas.add(new SecurityConfig("GET:USER"));
		}
		if (matcher.match("/me/**", uri)) {
			logger.info(":: me module");
			cfas.add(new SecurityConfig("GET:ME"));
		}
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

}
