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
public class PermitAllRequestAccessStrategyImpl implements AccessStrategy {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean canAccess(HttpServletRequest request) {
		List<String> permitAll = getChengProperties().getSecurity().getPermitAll();
		if (isNotEmpty(permitAll)) {
			AntPathMatcher pathMatcher = getAntPathMatcher();
			for (String permituri : permitAll) {
				String uri = calculateUri(request);
				if (pathMatcher.match(permituri, uri)) {
					logger.info(":: can access uri {}", uri);
					return true;
				}
			}
		}
		return false;
	}
}
