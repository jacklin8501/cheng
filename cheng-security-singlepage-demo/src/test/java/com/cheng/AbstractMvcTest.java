/**
 * 
 */
package com.cheng;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author jack.lin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractMvcTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected WebApplicationContext context;
	
	protected MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	protected <T> void showMessage(T t) {
		logger.info(":: {}", ReflectionToStringBuilder.toString(t, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	protected <T> void showMessages(List<T> list) {
		if (isNotEmpty(list)) {
			list.forEach(t -> showMessage(t));
		}
	}
}
