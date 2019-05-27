/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author jack.lin
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(":: load user by username {}", username);
		
		return new User(username, passwordEncoder.encode("000000"), obtionGrantedAuthority(username));
	}

	private Set<GrantedAuthority> obtionGrantedAuthority(String username) {
		Set<GrantedAuthority> set = new HashSet<>();
		//资源标识
		set.add(new SimpleGrantedAuthority("GET:/index"));
		//set.add(new SimpleGrantedAuthority("GET:/user"));
		set.add(new SimpleGrantedAuthority("GET:/me"));
		return set;
	}
}
