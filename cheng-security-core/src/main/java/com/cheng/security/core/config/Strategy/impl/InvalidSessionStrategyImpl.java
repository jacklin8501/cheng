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
import org.springframework.security.web.session.InvalidSessionStrategy;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 * 有bug, 如果logout之后， 发现session 一直处于过期状态， 访问登录页面时， 一直触发InvalidSessionStrategy
 */
public class InvalidSessionStrategyImpl implements InvalidSessionStrategy {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	ChengProperties cheng = SpringContextHolder.getBean(ChengProperties.class);
	
	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (isAjaxRequest(request)) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			try(PrintWriter writer = response.getWriter();) {
				writer.write("Session 无效!");
			}
		} else {
			redirectStrategy.sendRedirect(request, response, cheng.getSecurity().getForm().getLoginPage());
		}
	}

}
