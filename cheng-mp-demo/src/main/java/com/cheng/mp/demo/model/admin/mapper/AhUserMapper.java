package com.cheng.mp.demo.model.admin.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.mp.demo.model.admin.entity.AhUser;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jack.lin
 * @since 2019-09-09
 */
public interface AhUserMapper extends BaseMapper<AhUser> {

    AhUser findByUsername(@Param("username") String username);

    List<AhUser> findByUsernameLike(@Param("username") String username);
}
