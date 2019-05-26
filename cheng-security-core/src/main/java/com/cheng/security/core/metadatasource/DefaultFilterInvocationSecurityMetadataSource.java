/**
 * 
 */
package com.cheng.security.core.metadatasource;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * @author jack.lin
 * 安全认证资源加载
 */
public class DefaultFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	private CustomerSecurityMetadataSourceProvider securityMetadataSourceProvider;
	
	/**
	 * 根据请求，加载资源一般是角色
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg) throws IllegalArgumentException {
		return securityMetadataSourceProvider.getAttributes(arg);
	}

	/**
	 * 加载所有
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return securityMetadataSourceProvider.getAllConfigAttributes();
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return securityMetadataSourceProvider.supports(clazz);
	}

	public void setSecurityMetadataSourceProvider(CustomerSecurityMetadataSourceProvider securityMetadataSourceProvider) {
		this.securityMetadataSourceProvider = securityMetadataSourceProvider;
	}

}
