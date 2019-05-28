/**
 * 
 */
package com.cheng.security.singlepage.demo.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cheng.security.singlepage.demo.listener.TestListenerEvent;

/**
 * @author jack.lin
 *
 */
@RestController
@RequestMapping("/event")
public class EventController {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/test")
	public String test() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		publisher.publishEvent(new TestListenerEvent(auth.getName() + "->publish"));
		return "ok";
	}
	
	@GetMapping("/modify")
	public String modify() throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(":: auth class = {}", auth.getClass().getName());
		Collection<GrantedAuthority> gas = new ArrayList<>();
		gas.add(new SimpleGrantedAuthority("GET:/user"));
		gas.add(new SimpleGrantedAuthority("GET:/index"));
		gas.add(new SimpleGrantedAuthority("GET:/me"));
		
		if (null != auth) {
			UserDetails user = userDetailsService.loadUserByUsername("AAAA");
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			/*Class<AbstractAuthenticationToken> clazz = AbstractAuthenticationToken.class;
			Field field = clazz.getDeclaredField("authorities");
			field.setAccessible(true);
			field.set(auth, gas);*/
			SecurityContextHolder.getContext().setAuthentication(token);
			auth = SecurityContextHolder.getContext().getAuthentication();
		}
		return JSONObject.toJSONString(auth);
	}
	
	@GetMapping("/me")
	public String me() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return JSONObject.toJSONString(auth);
	}
}
