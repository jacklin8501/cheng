/**
 * 
 */
package com.cheng.security.core.config.Strategy.impl;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;
import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import com.cheng.security.core.config.Strategy.AccessStrategy;

/**
 * @author jack.lin
 *
 */
public class AnyRequestAuthenticatedAccessStrategyImpl implements AccessStrategy {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean canAccess(HttpServletRequest request) {
		List<String> anyRequestAuthenticated = getChengProperties().getSecurity().getAnyRequestAuthenticated();
		if (isNotEmpty(anyRequestAuthenticated)) {
			AntPathMatcher pathMatcher = getAntPathMatcher();
			String uri = calculateUri(request);
			for (String pattern : anyRequestAuthenticated) {
				if (pathMatcher.match(pattern, uri)) {
					logger.info(":: can access uri {}", uri);
					return true;
				}
			}
		}
		return false;
	}

}
