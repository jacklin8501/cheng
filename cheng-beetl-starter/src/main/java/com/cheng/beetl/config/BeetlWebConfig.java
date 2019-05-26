/**
 * 
 */
package com.cheng.beetl.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @author jack.lin
 *
 */
public class BeetlWebConfig {

	@Bean(name = "beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
		BeetlGroupUtilConfiguration cfg = new BeetlGroupUtilConfiguration();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = BeetlWebConfig.class.getClassLoader();
		}

		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader(loader, "/resources");
		cfg.setResourceLoader(resourceLoader);
		cfg.init();
		cfg.getGroupTemplate().setClassLoader(loader);
		return cfg;
	}
	
	@Bean(name = "beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlConfig) {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlConfig);
		return beetlSpringViewResolver;
	}
	
}
