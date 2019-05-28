/**
 * 
 */
package com.cheng.security.core.config.Strategy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.AntPathMatcher;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public interface AccessStrategy {

	boolean canAccess(HttpServletRequest request);
	
	default ChengProperties getChengProperties() {
		return SpringContextHolder.getBean(ChengProperties.class);
	}
	
	default AntPathMatcher getAntPathMatcher() {
		return new AntPathMatcher();
	}
}
