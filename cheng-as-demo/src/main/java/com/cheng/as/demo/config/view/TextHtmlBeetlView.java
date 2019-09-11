package com.cheng.as.demo.config.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import lombok.Builder;

/**
 * TextBeetlView
 */
@Builder
public class TextHtmlBeetlView extends AbstractBeetlView {

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        super.renderHtml(model, request, response);
    }

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

}