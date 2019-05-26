/**
 * 
 */
package com.cheng.core.holder;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author jack.lin
 *
 */
public class SpringContextHolder implements ApplicationContextAware {

	
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return SpringContextHolder.applicationContext.getBean(clazz);
	}

	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) SpringContextHolder.applicationContext.getBean(name);
	}
	
	public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
		return SpringContextHolder.applicationContext.getBeansOfType(clazz);
	}
}
