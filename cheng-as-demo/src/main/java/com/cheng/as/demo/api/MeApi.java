package com.cheng.as.demo.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * MeApi
 */
@Controller
@RequestMapping("/me")
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
    @GetMapping("/a")
    public String a() {
        return "a";
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
}