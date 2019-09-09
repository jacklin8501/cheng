package com.cheng.mp.demo.model.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author jack.lin
 * @since 2019-09-09
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AH_USER")
public class AhUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "USERNAME", type = IdType.AUTO)
    private String username;

    @TableField("PASSWORD")
    private String password;

    @Builder.Default
    private List<AhRole> roles = new ArrayList<>();

    @Builder.Default
    private List<AhPerm> perms = new ArrayList<>();
}
