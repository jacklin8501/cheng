package com.cheng.btlusermrg.pojo;
import java.util.Date;

import org.beetl.sql.core.annotatoin.UpdateIgnore;

import com.cheng.beetl.annotation.Auditor;
import com.cheng.beetl.annotation.NowDefault;

/*
* 
* gen by jack.lin 2019-06-02
*/
public class AuthUserRole extends org.beetl.sql.core.TailBean {
	private static final long serialVersionUID = 8101042567072843596L;

	//PK
    private Long urId ;
        
    //创建者
    @Auditor
    @UpdateIgnore
    private String createBy ;
        
    //最后修改者
    @Auditor
    private String lastModifiedBy ;
        
    //角色ID
    private Long roleId ;
        
    //用户ID
    private Long userId ;
        
    //创建时间
    @UpdateIgnore
    @NowDefault
    private Date createDate ;
        
    //最后修改时间
    @NowDefault
    private Date lastModifiedDate ;
        
    /**
    * PK
    */
    public Long getUrId() {
	    return this.urId;
    }
	
    /**
    * PK
    */
    public void setUrId(Long urId) {
        this.urId = urId;
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
    * 角色ID
    */
    public Long getRoleId() {
	    return this.roleId;
    }
	
    /**
    * 角色ID
    */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    /**
    * 用户ID
    */
    public Long getUserId() {
	    return this.userId;
    }
	
    /**
    * 用户ID
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
    * 创建时间
    */
    public Date getCreateDate() {
	    return this.createDate;
    }
	
    /**
    * 创建时间
    */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    /**
    * 最后修改时间
    */
    public Date getLastModifiedDate() {
	    return this.lastModifiedDate;
    }
	
    /**
    * 最后修改时间
    */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
}