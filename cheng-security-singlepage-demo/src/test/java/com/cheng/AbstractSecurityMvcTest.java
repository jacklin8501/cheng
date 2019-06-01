/**
 * 
 */
package com.cheng;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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
@Rollback(true)
public abstract class AbstractSecurityMvcTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected WebApplicationContext context;
	
	protected MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
}
