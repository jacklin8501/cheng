/**
 * 
 */
package com.cheng.security.core.metadatasource.impl;

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
 * 安全认证资源加载
 */
public class DefaultFilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 根据请求，加载资源一般是角色
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) arg;
		HttpServletRequest request = fi.getRequest();
		
		String uri = calculateUri(request);
		String method = request.getMethod().toUpperCase();
		logger.info(":: getAttributes by {}:{} ", method, uri);
		
		Collection<ConfigAttribute> cfas = new ArrayList<>();
		String attr = method.toUpperCase() + ":" + uri;
		cfas.add(new SecurityConfig(attr));
		return cfas;
	}

	/**
	 * 加载所有
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
}
