/**
 * 
 */
package com.cheng.beetl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jack.lin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlWebTest {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	//beetl核心
	GroupTemplate strGt;
	GroupTemplate claPathGt;
	
	@Before
	public void startup() throws IOException {
		Configuration cfg = Configuration.defaultConfiguration();
		
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		strGt = new GroupTemplate(resourceLoader, cfg);
		
		ClasspathResourceLoader cresourceLoader = new ClasspathResourceLoader("/resources");
		claPathGt = new GroupTemplate(cresourceLoader, cfg);
	}
	
	@Test
	public void whenStringTemplateOk() {
		String tpl = "Hello, #name#";
		Template t = strGt.getTemplate(tpl);
		t.binding("name", "world");
		String result = t.render();
		logger.info(":: result = {}", result);
	}
	
	@Test
	public void whenClassPathTemplateOk() {
		Map<String, Object> shared = new HashMap<>();
		shared.put("name", "This is Shard value!");
		claPathGt.setSharedVars(shared);
		/*Template tpl1 = claPathGt.getTemplate("/hello.html");
		tpl1.binding("name", "This is Hello World!");//被共享变量覆盖
		String result1 = tpl1.render();
		logger.info(":: result1 = {}", result1);*/
		
		Template tpl2 = claPathGt.getTemplate("/test.btl");
		String result2 = tpl2.render();
		logger.info(":: result2 = {}", result2);
	}
	
	@Test
	public void whenLayoutOk() {
		Template tpl = claPathGt.getTemplate("/mainenter.html");
		tpl.binding("title", "hi world");
		tpl.binding("name", "hi world");
		String result = tpl.render();
		logger.info(":: result = {}", result);
	}
}
