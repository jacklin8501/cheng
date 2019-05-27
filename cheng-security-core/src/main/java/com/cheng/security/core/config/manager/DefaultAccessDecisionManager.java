/**
 * 
 */
package com.cheng.security.core.config.manager;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.core.Authentication;

/**
 * @author jack.lin
 * 单服务访问管理器
 */
public interface DefaultAccessDecisionManager extends AccessDecisionManager {
	
	default String message(Object obj) {
		return ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	default boolean isLogin(Authentication authentication) {
		if (isEmpty(authentication)) {
			return false;
		}
		if (isEmpty(authentication.getPrincipal())) {
			return false;
		}
		if (String.class == authentication.getPrincipal().getClass()) {
			return false;
		}
		if (StringUtils.equalsIgnoreCase("AnonymousUser", authentication.getPrincipal().toString())) {
			return false;
		}
		return true;
	}
	
	default String username(Authentication authentication) {
		return authentication.getPrincipal().toString();
	}
}
