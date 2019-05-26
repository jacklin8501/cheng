/**
 * 
 */
package com.cheng.security.core.config.handler;

import static com.cheng.security.core.utils.RequestUtils.getIp;
import static com.cheng.security.core.utils.RequestUtils.isAjaxRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSONObject;
import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	final Logger logger = LoggerFactory.getLogger(getClass());
	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	ChengProperties cheng = SpringContextHolder.getBean(ChengProperties.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		logger.info(":: login success.");
		
		logger.info(":: user {}", authentication.getName());
		
		logger.info(":: ip = {}", getIp(request));
		
		if (isAjaxRequest(request)) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			
			try ( PrintWriter writer = response.getWriter(); ) {
				String json = JSONObject.toJSONString(authentication.getPrincipal());
				logger.info(":: JSON info = {}", json);
				writer.write(json);
			}
		} else {
			redirectStrategy.sendRedirect(request, response, cheng.getSecurity().getForm().getIndexPage());
		}
	}

}
