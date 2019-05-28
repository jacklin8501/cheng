/**
 * 
 */
package com.cheng.security.core.config.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author jack.lin
 *
 */
public class SessionFilter extends OncePerRequestFilter {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	private SessionRegistry sessionRegistry;
	
	private LogoutHandler handlers = new CompositeLogoutHandler(new SecurityContextLogoutHandler());

	public SessionFilter(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (null != auth) {
			logger.info(":: Authentication is present.");
			logger.info(":: user info is = {}", auth.getPrincipal().toString());
			if (!StringUtils.equalsIgnoreCase("", auth.getPrincipal().toString())) {
				List<SessionInformation> sessions = sessionRegistry.getAllSessions(auth.getPrincipal(), false);
				logger.info(":: session info size is {}", sessions.size());
				
				if (sessions.size() - 0 < 1) {
					logger.info(":: logout");
					handlers.logout(request, response, auth);
				}
			}
		}
		chain.doFilter(request, response);
	}

}
