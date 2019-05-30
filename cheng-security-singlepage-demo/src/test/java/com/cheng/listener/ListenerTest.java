/**
 * 
 */
package com.cheng.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void whenAddAllOk() {
		List<String> list1 = Arrays.asList("A", "B", "C");
		List<String> list2 = Arrays.asList("D", "E", "F");
		
		List<String> list = new ArrayList<>();
		list.addAll(list1);
		list.addAll(list2);
		
		list.forEach(item -> logger.info(item));
	}
}
