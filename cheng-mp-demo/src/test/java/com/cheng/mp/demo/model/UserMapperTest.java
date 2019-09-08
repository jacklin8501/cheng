package com.cheng.mp.demo.model;

import com.cheng.mp.demo.AbstractMvcTest;
import com.cheng.mp.demo.model.entity.AhUser;
import com.cheng.mp.demo.model.mapper.AhUserMapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/**
 * UserMapperTest
 */
@Slf4j
public class UserMapperTest extends AbstractMvcTest {

    @Autowired
    private AhUserMapper ahUserMapper;

    @Before
    public void whenInserOk() {
        this.ahUserMapper.insert(AhUser.builder().username("XIAOJ8HUI").password("000000").build());
        this.ahUserMapper.insert(AhUser.builder().username("XIAOHUIHUI").password("000000").build());
        this.ahUserMapper.insert(AhUser.builder().username("XIAOHUIDOG").password("000000").build());
    }

    @Test
    public void whenOk() {
        AhUser user = this.ahUserMapper.selectById("XIAOJ8HUI");
        log.info(":: username = {}", user.getUsername());
        log.info(":: password = {}", user.getPassword());
    }
}