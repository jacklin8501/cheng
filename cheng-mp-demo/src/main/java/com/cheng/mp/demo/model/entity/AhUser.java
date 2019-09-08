package com.cheng.mp.demo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

/**
 * AhUser
 */
@Data
@Builder
@TableName("AH_USER")
public class AhUser {

    @TableId(value = "USERNAME", type = IdType.NONE)
    private String username;

    private String password;
}