package com.cheng.as.demo;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * AppTest
 */
@Slf4j
public class AppTest extends AbstractMvcTest {

    final static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Test
    public void whenOk() {
        new Thread(() -> {
            log.info(":: A start");
            threadLocal.set("A");
            log.info(":: A = {}", threadLocal.get());
            try {
                Thread.sleep(1000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            log.info(":: B start");
            threadLocal.set("B");
            log.info(":: B = {}", threadLocal.get());
            try {
                Thread.sleep(1000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}