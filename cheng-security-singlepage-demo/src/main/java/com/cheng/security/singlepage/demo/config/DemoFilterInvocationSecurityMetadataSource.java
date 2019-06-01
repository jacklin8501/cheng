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
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * @author jack.lin
 *
 */
public class DemoFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		logger.info(":: 自定义生效了");
		FilterInvocation fi = (FilterInvocation) arg0;
		HttpServletRequest request = fi.getRequest();
		
		String uri = calculateUri(request);
		String method = request.getMethod().toUpperCase();
		logger.info(":: demo getAttributes by {}:{} ", method, uri);
		
		Collection<ConfigAttribute> cfas = new ArrayList<>();
		String attr = method.toUpperCase() + ":" + uri;
		cfas.add(new SecurityConfig(attr));
		return cfas;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
