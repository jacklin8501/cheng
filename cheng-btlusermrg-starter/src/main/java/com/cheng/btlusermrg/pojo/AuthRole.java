package com.cheng.btlusermrg.pojo;
import java.util.Date;

import org.beetl.sql.core.annotatoin.UpdateIgnore;
import org.beetl.sql.core.annotatoin.Version;

import com.cheng.beetl.annotation.Auditor;
import com.cheng.beetl.annotation.NowDefault;
import com.cheng.beetl.annotation.UpperCase;

/*
* 
* gen by jack.lin 2019-06-02
*/
public class AuthRole extends org.beetl.sql.core.TailBean {
	private static final long serialVersionUID = -2661049302639378791L;

	//PK
    private Long roleId ;
        
    //创建者
    @Auditor
    @UpdateIgnore
    private String createBy ;
        
    //最后修改者
    @Auditor
    private String lastModifiedBy ;
        
    //角色编码
    @UpperCase
    private String roleCode ;
        
    //角色描述
    private String roleDescription ;
        
    //角色名称
    private String roleName ;
        
    //版本号
    @Version
    private Long version ;
        
    //创建日期
    @UpdateIgnore
    @NowDefault
    private Date createDate ;
        
    //最后修改日期
    @NowDefault
    private Date lastModifiedDate ;
        
    /**
    * PK
    */
    public Long getRoleId() {
	    return this.roleId;
    }
	
    /**
    * PK
    */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    /**
    * 创建者
    */
    public String getCreateBy() {
	    return this.createBy;
    }
	
    /**
    * 创建者
    */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    /**
    * 最后修改者
    */
    public String getLastModifiedBy() {
	    return this.lastModifiedBy;
    }
	
    /**
    * 最后修改者
    */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    /**
    * 角色编码
    */
    public String getRoleCode() {
	    return this.roleCode;
    }
	
    /**
    * 角色编码
    */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    
    /**
    * 角色描述
    */
    public String getRoleDescription() {
	    return this.roleDescription;
    }
	
    /**
    * 角色描述
    */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    
    /**
    * 角色名称
    */
    public String getRoleName() {
	    return this.roleName;
    }
	
    /**
    * 角色名称
    */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
    * 版本号
    */
    public Long getVersion() {
	    return this.version;
    }
	
    /**
    * 版本号
    */
    public void setVersion(Long version) {
        this.version = version;
    }
    
    /**
    * 创建日期
    */
    public Date getCreateDate() {
	    return this.createDate;
    }
	
    /**
    * 创建日期
    */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    /**
    * 最后修改日期
    */
    public Date getLastModifiedDate() {
	    return this.lastModifiedDate;
    }
	
    /**
    * 最后修改日期
    */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
}