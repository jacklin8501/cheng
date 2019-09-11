package com.cheng.as.demo.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cheng.as.demo.enums.WebConst;
import com.cheng.as.demo.enums.WebConst.WebContextEnum;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


/**
 * MeApi
 */
@Controller
@RequestMapping(WebConst.MDL_ME)
@Slf4j
public class MeApi {
    final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @RequiresAuthentication
    @GetMapping
    public String me(Model model) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("me", subject.getPrincipal());
        return "/me.tpl";
    }

    @RequiresPermissions("MAXADMIN:EDIT")
    @ResponseBody
    @GetMapping(value = WebConst.URI_A)
    public String a(HttpServletRequest request) {
        request.setAttribute("page", "a");
        return WebContextEnum.convert(WebConst.MDL_ME + WebConst.URI_A).getHtml();
    }

    @RequiresPermissions("USER:EDIT")
    @ResponseBody
    @GetMapping("/b")
    public String b() {
        new Thread(() -> {
            log.info(":: A start");
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
                log.info(":: A = {}", threadLocal.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            log.info(":: B start");
            threadLocal.set("B");
            try {
                Thread.sleep(1000);
                log.info(":: B = {}", threadLocal.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        return "b";
    }

    @PostMapping(value="/c")
    @ResponseBody
    public String c(@RequestBody Map<String, Object> content) {
        return (String) content.get("page");
    }
    
}