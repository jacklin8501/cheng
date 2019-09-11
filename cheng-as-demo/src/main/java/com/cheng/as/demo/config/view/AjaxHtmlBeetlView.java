package com.cheng.as.demo.config.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import lombok.Builder;

/**
 * AjaxHtmlView
 */
@Builder
public class AjaxHtmlBeetlView extends AbstractBeetlView {

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        super.renderString(model, request, response);
    }

    @Override
    public String getContentType() {
        return MediaType.APPLICATION_JSON_UTF8_VALUE;
    }
    
}