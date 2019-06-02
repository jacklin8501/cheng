package com.cheng.btlusermrg.pojo;
import java.util.Date;

import org.beetl.sql.core.annotatoin.UpdateIgnore;

import com.cheng.beetl.annotation.Auditor;
import com.cheng.beetl.annotation.NowDefault;

/*
* 
* gen by jack.lin 2019-06-02
*/
public class AuthRolePerm extends org.beetl.sql.core.TailBean {
	private static final long serialVersionUID = 2093536494097158455L;

	private Long id ;
    
	@Auditor
	@UpdateIgnore
    private String createBy ;
	@Auditor   
    private String lastModifiedBy ;
        
    private Long permId ;
        
    private Long roleId ;
        
    @UpdateIgnore
    @NowDefault
    private Date createDate ;
        
    @NowDefault
    private Date lastModifiedDate ;
        
    public Long getId() {
	    return this.id;
    }
	
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCreateBy() {
	    return this.createBy;
    }
	
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    public String getLastModifiedBy() {
	    return this.lastModifiedBy;
    }
	
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    
    public Long getPermId() {
	    return this.permId;
    }
	
    public void setPermId(Long permId) {
        this.permId = permId;
    }
    
    public Long getRoleId() {
	    return this.roleId;
    }
	
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public Date getCreateDate() {
	    return this.createDate;
    }
	
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getLastModifiedDate() {
	    return this.lastModifiedDate;
    }
	
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
}