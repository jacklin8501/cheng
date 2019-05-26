/**
 * 
 */
package com.cheng.security.singlepage.demo.controller;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jack.lin
 *
 */
@Controller
public class PageController {

	@GetMapping("/sign-in")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String error = request.getParameter("error");
		if (isEmpty(error)) {
			error = "";
		}
		String username = request.getParameter("username");
		if (isEmpty(username)) {
			username = "";
		}
		Resource resource = new ClassPathResource("resources/login.html");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String page = "";
		while (reader.ready()) {
			page += reader.readLine();
		}
		
		page = page.replaceAll("\\$\\{error\\}", error);
		page = page.replaceAll("\\$\\{username\\}", username);
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter writer = response.getWriter()) {
			writer.write(page);
		}
	}
	
	@GetMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/resources");
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.add("/beetl.properties");
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("/index.html");
		String str = t.render();
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter writer = response.getWriter()) {
			writer.write(str);
		}*/
		return "index.html";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user.html";
	}
	
	@GetMapping("/me")
	public String me() {
		return "me.html";
	}
}
