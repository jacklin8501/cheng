package com.cheng.mp.demo.model.mapper;

import java.util.List;

import com.cheng.mp.demo.AbstractMvcTest;
import com.cheng.mp.demo.model.admin.entity.AhUser;
import com.cheng.mp.demo.model.admin.mapper.AhUserMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/**
 * AhUserMapperTest
 */
@Slf4j
public class AhUserMapperTest extends AbstractMvcTest {

    @Autowired
    private AhUserMapper ahUserMapper;

    @Test
    public void whenSelectOneOk() {
        AhUser user = this.ahUserMapper.findByUsername("XIAOHUIHUI");
        log.info(":: user : {}", user.toString());
        user.getRoles().forEach(role -> {
            log.info(":: role : {}", role.toString());
        });
        user.getPerms().forEach(perm -> {
            log.info(":: perm : {}", perm.toString());
        });
    }

    @Test
    public void whenSelectAllOk() {
        List<AhUser> users = this.ahUserMapper.findByUsernameLike("X%");
        users.forEach(user -> {
            log.info(":: user : {}", user.toString());
            user.getRoles().forEach(role -> {
                log.info(":: role : {}", role.toString());
            });
            user.getPerms().forEach(perm -> {
                log.info(":: perm : {}", perm.toString());
            });
            log.info(":: --- 这是分割线 ---");
        });
    }
}