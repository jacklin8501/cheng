package com.cheng.as.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheng.as.demo.utils.HttpWebUtils;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionHandler
 */
@ControllerAdvice
public class GlExceptionHandler {

    @ExceptionHandler({UnauthorizedException.class})
    public String unauthorizedHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (HttpWebUtils.isAsynRequest(request)) {
            return "/403.tpl";
        }
        return "/403";
    }
    
}