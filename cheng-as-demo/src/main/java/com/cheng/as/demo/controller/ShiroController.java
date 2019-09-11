package com.cheng.as.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheng.as.demo.utils.HttpWebUtils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ShiroWebHandler
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @PostMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        response.sendRedirect(request.getContextPath() + "/index");
    }

    @RequestMapping("/unlogin")
    public String unlogin(HttpServletRequest request, HttpServletResponse response) {
        if (HttpWebUtils.isAsynRequest(request)) {
            return "/403.tpl";
        } else {
            return "redirect:/login";
        }
    }
    
    @RequestMapping("/handler/{code}")
    public String handlerX(@PathVariable("code") String code, HttpServletRequest request) {
        if (HttpWebUtils.isAsynRequest(request)) {
            return "/" + code + ".tpl";
        } else {
            return "/" + code;
        }
    }

}