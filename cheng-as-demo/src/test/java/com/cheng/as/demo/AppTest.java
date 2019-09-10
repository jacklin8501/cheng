package com.cheng.as.demo;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * AppTest
 */
@Slf4j
public class AppTest extends AbstractMvcTest {

    @Test
    public void whenOk() {
        log.info(":: ok");
    }
}