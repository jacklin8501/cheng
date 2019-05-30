/**
 * 
 */
package com.cheng.security.core.config.Strategy.impl;

import static com.cheng.security.core.utils.RequestUtils.isAjaxRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public class SessionInformationExpiredStrategyImpl implements SessionInformationExpiredStrategy {

	final Logger logger = LoggerFactory.getLogger(getClass());
	ChengProperties cheng = SpringContextHolder.getBean(ChengProperties.class);
	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		HttpServletRequest request = event.getRequest();
		HttpServletResponse response = event.getResponse();
		request.getSession();
		if (isAjaxRequest(request)) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			try ( PrintWriter writer = response.getWriter(); ) {
				writer.write("Session过期!");
			}
		} else {
			redirectStrategy.sendRedirect(request, response, cheng.getSecurity().getForm().getLoginPage());
		}
	}

}
