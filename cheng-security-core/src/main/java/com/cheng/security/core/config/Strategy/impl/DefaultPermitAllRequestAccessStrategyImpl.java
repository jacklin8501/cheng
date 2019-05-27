/**
 * 
 */
package com.cheng.security.core.config.Strategy.impl;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;
import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import com.cheng.core.properties.ChengProperties;
import com.cheng.security.core.config.Strategy.AccessStrategy;

/**
 * @author jack.lin
 *
 */
public class DefaultPermitAllRequestAccessStrategyImpl implements AccessStrategy {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean canAccess(HttpServletRequest request) {
		ChengProperties cheng = getChengProperties();
		String loginPage = cheng.getSecurity().getForm().getLoginPage();
		String loginProcessingUrl = cheng.getSecurity().getForm().getLoginProcessingUrl();
		String logoutProcessingUrl = cheng.getSecurity().getForm().getLogoutProccessUrl();
		String invalidSessionUrl = cheng.getSecurity().getSession().getInvalidSessionUrl();
		String expiredUrl = cheng.getSecurity().getSession().getExpiredUrl();
		
		String uri = calculateUri(request);
		AntPathMatcher pathMatcher = getAntPathMatcher();
		if (pathMatcher.match("/error/**", uri)) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		if (isNotEmpty(expiredUrl) && pathMatcher.match(expiredUrl, uri)) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (isNotEmpty(invalidSessionUrl) && pathMatcher.match(invalidSessionUrl, uri)) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (isNotEmpty(loginPage) && pathMatcher.match(loginPage, uri)) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (isNotEmpty(loginProcessingUrl) && pathMatcher.match(loginProcessingUrl, uri)) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (isNotEmpty(logoutProcessingUrl) && pathMatcher.match(logoutProcessingUrl, uri)) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (StringUtils.endsWithIgnoreCase(uri, ".js")) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (StringUtils.endsWithIgnoreCase(uri, ".css")) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (StringUtils.endsWithIgnoreCase(uri, ".html")) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (StringUtils.endsWithIgnoreCase(uri, ".jpg")) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (StringUtils.endsWithIgnoreCase(uri, ".png")) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		
		if (StringUtils.endsWithIgnoreCase(uri, ".ico")) {
			logger.info(":: can access uri {}", uri);
			return true;
		}
		return false;
	}

}
