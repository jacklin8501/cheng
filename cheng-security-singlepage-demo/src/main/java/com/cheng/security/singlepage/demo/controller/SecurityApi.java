/**
 * 
 */
package com.cheng.security.singlepage.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack.lin
 *
 */
@RestController
@RequestMapping("/sec")
public class SecurityApi {

	@GetMapping("/me")
	public UserDetails me(@AuthenticationPrincipal UserDetails user) {
		return user;
	}
}
