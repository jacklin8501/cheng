package com.cheng.as.demo.config.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.ext.web.SessionWrapper;
import org.beetl.ext.web.WebVariable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import lombok.Cleanup;
import lombok.Data;

/**
 * AbstractBeetlView
 */
@Data
public abstract class AbstractBeetlView implements View {

    private final String REDIRCT_KEY = "REDIRECT:";
    private String webroot;
    private String viewName;

    private void parseWebInfo() {
        this.webroot = StringUtils.trimToEmpty(this.webroot);
        if (StringUtils.endsWith(this.webroot, "/")) {
            this.webroot = StringUtils.substringBeforeLast(this.webroot, "/");
        }
        this.viewName = StringUtils.trimToEmpty(this.viewName);
        if (StringUtils.startsWith(this.viewName, "/")) {
            this.viewName = StringUtils.substringAfter(this.viewName, "/");
        }
    }

    private String renderText(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.parseWebInfo();
        Resource resource = new ClassPathResource(this.webroot + File.separator + this.viewName);
        @Cleanup
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        String html = "";
        while (br.ready()) {
            html += br.readLine() + "\n";
        }
        
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate(html);

        WebVariable webVariable = new WebVariable();
        webVariable.setRequest(request);
        webVariable.setResponse(response);
        webVariable.setSession(request.getSession());

        t.binding(model);
        t.binding("session", new SessionWrapper(request, webVariable.getSession()));
        t.binding("servlet", webVariable);
        t.binding("request", request);
        t.binding("ctxPath", request.getContextPath());
        String str = t.render();
        return str;
    }

    protected void renderHtml(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String html = renderText(model, request, response);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        @Cleanup
        PrintWriter writer = response.getWriter();
        writer.write(html);
    }

    protected void renderString(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setCharacterEncoding("UTF-8");
        String html = renderText(model, request, response);
        @Cleanup
        PrintWriter writer = response.getWriter();
        writer.write(html);
    }

    // protected void redirectIfNeed(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //     log.info(":: view name = {}", this.viewName);
    //     this.parseWebInfo();
    //     String requestType = request.getHeader("X-Requested-With");
    //     if (!StringUtils.equals("XMLHttpRequest", requestType) && StringUtils.startsWithIgnoreCase(this.REDIRCT_KEY, this.viewName)) {
    //         String cxtPath = request.getContextPath();
    //         this.viewName = StringUtils.substring(this.viewName, 0, this.REDIRCT_KEY.length());
    //         response.sendRedirect(cxtPath + File.separator + this.viewName);
    //     }
    // }
}