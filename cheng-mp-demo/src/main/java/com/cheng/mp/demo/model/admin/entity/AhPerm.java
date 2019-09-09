package com.cheng.mp.demo.model.admin.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("AH_PERM")
public class AhPerm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PERMNAME", type = IdType.AUTO)
    private String permname;

    @TableField("URI")
    private String uri;

    @TableField("DESCRIPTION")
    private String description;


}
