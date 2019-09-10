package com.cheng.as.demo.config.view;

import java.util.Locale;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * BeetlViewResolver
 */
public class BeetlViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        AbstractBeetlView view = null;
        if (StringUtils.endsWithIgnoreCase(viewName, ".tpl")) {
            view = new AjaxHtmlBeetlView();
        } else {
            view = new TextHtmlBeetlView();
        }
        view.setViewName(viewName + ".html");
        view.setWebroot("./resources/");
        return view;
    }
}