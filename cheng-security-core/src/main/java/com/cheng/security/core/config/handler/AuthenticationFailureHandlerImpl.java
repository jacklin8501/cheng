/**
 * 
 */
package com.cheng.security.core.config.handler;

import static com.cheng.security.core.utils.RequestUtils.getIp;
import static com.cheng.security.core.utils.RequestUtils.isAjaxRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	final Logger logger = LoggerFactory.getLogger(getClass());
	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	ChengProperties cheng = SpringContextHolder.getBean(ChengProperties.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		
		logger.info(":: login failure.");
		
		logger.info(":: ip = {}", getIp(request));
		
		logger.info(":: error message = {}", ex.getMessage());
		if (isAjaxRequest(request)) {
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.setCharacterEncoding("UTF-8");
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			
			try ( PrintWriter writer = response.getWriter(); ) {
				
				writer.write(ex.getMessage());
			}
			
		} else {
			String redirectUrl = 
					cheng.getSecurity().getForm().getLoginPage() + 
					"?error=" + 
					URLEncoder.encode(ex.getMessage(), "UTF-8") +
					"&username=" +
					URLEncoder.encode(request.getParameter("username"), "UTF-8");
			redirectStrategy.sendRedirect(request, response, redirectUrl);
		}
	}

}
