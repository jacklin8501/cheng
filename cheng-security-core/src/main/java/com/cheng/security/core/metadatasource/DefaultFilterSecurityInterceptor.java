/**
 * 
 */
package com.cheng.security.core.metadatasource;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author jack.lin
 *
 */
public class DefaultFilterSecurityInterceptor extends FilterSecurityInterceptor {

	FilterInvocationSecurityMetadataSource newSource;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		this.invoke(fi);
	}

	@Override
	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
	}

	@Override
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
		this.newSource = newSource;
	}

	@Override
	public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
		super.setAccessDecisionManager(accessDecisionManager);
	}

	@Override
	public void setAlwaysReauthenticate(boolean alwaysReauthenticate) {
		super.setAlwaysReauthenticate(alwaysReauthenticate);
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return newSource;
	}
}
