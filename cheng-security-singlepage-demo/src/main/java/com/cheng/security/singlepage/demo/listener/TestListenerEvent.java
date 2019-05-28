/**
 * 
 */
package com.cheng.security.singlepage.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * @author jack.lin
 *
 */
public class TestListenerEvent extends ApplicationEvent {

	private static final long serialVersionUID = -7372229896291459363L;

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	public TestListenerEvent(Object source) {
		super(source);
	}

}
