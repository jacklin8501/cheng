/**
 * 
 */
package com.cheng.beetl.security.function;

import java.util.Collections;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;

import com.cheng.core.holder.SpringContextHolder;

/**
 * @author jack.lin
 *
 */
public class AccessUrlIf implements Function {

	@Override
	public Boolean call(Object[] paras, Context context) {
		ServletContext servletContext = SpringContextHolder.getBean(ServletContext.class);
		WebInvocationPrivilegeEvaluator privilegeEvaluator = SpringContextHolder.getBean("defaultWebInvocationPrivilegeEvaluator");
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return Boolean.valueOf(true);
		}

		Authentication authentication = getAuthentication(securityContext);

		if ((paras.length == 0) || (paras[0] == null) || (!(paras[0] instanceof String))) {
			return Boolean.valueOf(true);
		}
		String url = (String) paras[0];

		String method = "GET";
		if ((paras.length > 1) && (paras[1] != null) && (paras[1] instanceof String)) {
			method = (String) paras[1];
		}
		return Boolean.valueOf(
				privilegeEvaluator.isAllowed(servletContext.getContextPath(), url, method, authentication));
	}

	/*private ServletContext servletContext;

	private WebInvocationPrivilegeEvaluator privilegeEvaluator;

	public AccessUrlIf() {
		this.servletContext = SpringContextHolder.getBean(ServletContext.class);
		FilterSecurityInterceptor filterSecurityInterceptor = SpringContextHolder.getBean(DefaultFilterSecurityInterceptor.class);
		this.privilegeEvaluator = new DefaultWebInvocationPrivilegeEvaluator(filterSecurityInterceptor);
	}

	public Boolean call(Object[] paras, Context ctx) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return Boolean.valueOf(true);
		}

		Authentication authentication = getAuthentication(securityContext);

		if ((paras.length == 0) || (paras[0] == null) || (!(paras[0] instanceof String))) {
			return Boolean.valueOf(true);
		}
		String url = (String) paras[0];

		String method = "GET";
		if ((paras.length > 1) && (paras[1] != null) && (paras[1] instanceof String)) {
			method = (String) paras[1];
		}
		return Boolean.valueOf(
				this.privilegeEvaluator.isAllowed(this.servletContext.getContextPath(), url, method, authentication));
	}*/

	private Authentication getAuthentication(SecurityContext securityContext) {
		Authentication authentication = securityContext.getAuthentication();
		if (authentication == null) {
			authentication = new AnonymousAuthenticationToken(UUID.randomUUID().toString(), "anonymous",
					Collections.singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
		}

		return authentication;
	}
}
