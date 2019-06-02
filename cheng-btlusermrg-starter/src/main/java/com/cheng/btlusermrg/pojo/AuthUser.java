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
public class AuthUser extends org.beetl.sql.core.TailBean {
	private static final long serialVersionUID = 5585276574252922289L;

	//PK
    private Long userId ;
        
    //账户没过期?
    private Boolean accountNonExpired = true;
        
    //账户没锁定?
    private Boolean accountNonLocked = true;
        
    //证书没过期?
    private Boolean credentialsNonExpired = true;
        
    //可用?
    private Boolean enabled = true;
        
    //创建者
    @Auditor
    @UpdateIgnore
    private String createBy ;
        
    //最后修改者
    @Auditor
    private String lastModifiedBy ;
        
    //密码
    private String password ;
        
    //用户名
    @UpperCase
    private String username ;
        
    //版本号
    @Version
    private Long version = 0L;
        
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
    public Long getUserId() {
	    return this.userId;
    }
	
    /**
    * PK
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
    * 账户没过期?
    */
    public Boolean getAccountNonExpired() {
	    return this.accountNonExpired;
    }
	
    /**
    * 账户没过期?
    */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    
    /**
    * 账户没锁定?
    */
    public Boolean getAccountNonLocked() {
	    return this.accountNonLocked;
    }
	
    /**
    * 账户没锁定?
    */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    
    /**
    * 证书没过期?
    */
    public Boolean getCredentialsNonExpired() {
	    return this.credentialsNonExpired;
    }
	
    /**
    * 证书没过期?
    */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    
    /**
    * 可用?
    */
    public Boolean getEnabled() {
	    return this.enabled;
    }
	
    /**
    * 可用?
    */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
    * 密码
    */
    public String getPassword() {
	    return this.password;
    }
	
    /**
    * 密码
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
    * 用户名
    */
    public String getUsername() {
	    return this.username;
    }
	
    /**
    * 用户名
    */
    public void setUsername(String username) {
        this.username = username;
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