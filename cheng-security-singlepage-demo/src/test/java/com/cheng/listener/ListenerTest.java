/**
 * 
 */
package com.cheng.listener;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.cheng.AbstractMvcTest;
import com.cheng.security.singlepage.demo.listener.TestListenerEvent;

/**
 * @author jack.lin
 *
 */
public class ListenerTest extends AbstractMvcTest {

	@Autowired
	private ApplicationEventPublisher cac;
	
	@Test
	public void whenOk() {
		cac.publishEvent(new TestListenerEvent(new Object()));
	}
}
