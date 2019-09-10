package com.cheng.as.demo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * AbstractMvcTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractMvcTest {
    @Autowired
    protected WebApplicationContext context;
    protected MockMvc mvc;
    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}