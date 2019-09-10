package com.cheng.as.demo.config;

import java.util.List;

import com.cheng.as.demo.config.view.BeetlHandlerMethodReturnValueHandler;
import com.cheng.as.demo.config.view.BeetlViewResolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * BeetlConfig
 */
@Configuration
public class BeetlConfig implements WebMvcConfigurer {

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(new BeetlHandlerMethodReturnValueHandler());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new BeetlViewResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/index").setViewName("/index");
    }

}