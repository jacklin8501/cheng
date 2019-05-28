/**
 * 
 */
package com.cheng.security.core.config.Strategy.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author jack.lin
 *
 */
public class SessionInformationExpiredStrategyImpl implements SessionInformationExpiredStrategy {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		HttpServletResponse response = event.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		try ( PrintWriter writer = response.getWriter(); ) {
			writer.write("Session过期!");
		}
	}

}
