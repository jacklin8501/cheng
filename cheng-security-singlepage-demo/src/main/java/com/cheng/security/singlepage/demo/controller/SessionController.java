/**
 * 
 */
package com.cheng.security.singlepage.demo.controller;

import static com.cheng.security.core.utils.RequestUtils.isAjaxRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
@Controller
@RequestMapping("/session")
public class SessionController {

	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	ChengProperties cheng;
	
	@RequestMapping("/invalid")
	public void invalidSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		if (isAjaxRequest(request)) {
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			try(PrintWriter writer = response.getWriter();) {
				writer.write("Session 无效!");
			}
		} else {
			redirectStrategy.sendRedirect(request, response, cheng.getSecurity().getForm().getLoginPage());
		}
	}
	
	@RequestMapping("/expired")
	public void expiredSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		if (isAjaxRequest(request)) {
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			try(PrintWriter writer = response.getWriter();) {
				writer.write("Session 过期!");
			}
		} else {
			redirectStrategy.sendRedirect(request, response, cheng.getSecurity().getForm().getLoginPage());
		}
	}
}
