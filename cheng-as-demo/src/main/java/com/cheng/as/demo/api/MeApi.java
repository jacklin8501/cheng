package com.cheng.as.demo.api;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MeApi
 */
@Controller
@RequestMapping("/me")
public class MeApi {

    @GetMapping
    public String me(Model model) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("me", subject.getPrincipal());
        return "/me.tpl";
    }
}