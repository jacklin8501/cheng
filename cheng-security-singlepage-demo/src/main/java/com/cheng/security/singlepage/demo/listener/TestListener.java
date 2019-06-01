/**
 * 
 */
package com.cheng.security.singlepage.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author jack.lin
 *
 */
//@Component
public class TestListener implements ApplicationListener<TestListenerEvent> {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public void onApplicationEvent(TestListenerEvent event) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(":: {}接收到事件 : [{}]", auth.getName(), event.getSource());
		logger.info(":: class name {}", event.getClass());
	}

}
