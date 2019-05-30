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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jack.lin
 *
 */
@Controller
public class PageController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/sign-in")
	public String login(@RequestParam(defaultValue="", required=false) String username, @RequestParam(defaultValue="", required=false) String error, Model model) throws IOException {
		model.addAttribute("username", username);
		model.addAttribute("error", error);
		return "login.html";
	}
	
	@GetMapping("/index")
	public String index() throws IOException {
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
	
	@GetMapping("/pre_login")
	public String prelogin() {
		return "prelogin.html";
	}
}
