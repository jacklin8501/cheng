package com.cheng.btlusermrg.pojo;
import java.util.Date;

import org.beetl.sql.core.annotatoin.UpdateIgnore;
import org.beetl.sql.core.annotatoin.Version;

import com.cheng.beetl.annotation.NowDefault;

/*
* 
* gen by jack.lin 2019-06-02
*/
public class AuthUser extends org.beetl.sql.core.TailBean {
	private static final long serialVersionUID = 5585276574252922289L;

	//PK
    private Long userId ;
        
    //账户没过期?
    private Integer accountNonExpired ;
        
    //账户没锁定?
    private Integer accountNonLocked ;
        
    //证书没过期?
    private Integer credentialsNonExpired ;
        
    //可用?
    private Integer enabled ;
        
    //创建者
    private String createBy ;
        
    //最后修改者
    private String lastModifiedBy ;
        
    //密码
    private String password ;
        
    //用户名
    private String username ;
        
    //版本号
    @Version
    private Long version ;
        
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
    public Integer getAccountNonExpired() {
	    return this.accountNonExpired;
    }
	
    /**
    * 账户没过期?
    */
    public void setAccountNonExpired(Integer accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    
    /**
    * 账户没锁定?
    */
    public Integer getAccountNonLocked() {
	    return this.accountNonLocked;
    }
	
    /**
    * 账户没锁定?
    */
    public void setAccountNonLocked(Integer accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    
    /**
    * 证书没过期?
    */
    public Integer getCredentialsNonExpired() {
	    return this.credentialsNonExpired;
    }
	
    /**
    * 证书没过期?
    */
    public void setCredentialsNonExpired(Integer credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    
    /**
    * 可用?
    */
    public Integer getEnabled() {
	    return this.enabled;
    }
	
    /**
    * 可用?
    */
    public void setEnabled(Integer enabled) {
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