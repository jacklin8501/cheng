package com.cheng.beetl.spring.pojo;
import java.util.Date;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.UpdateIgnore;
import org.beetl.sql.core.annotatoin.Version;

import com.cheng.beetl.annotation.NowDefault;
import com.cheng.beetl.annotation.UpperCase;


/* 
* 
* gen by beetlsql 2019-05-12
*/
@SuppressWarnings("serial")
@Table(name="beetlsql.iden_user")
public class IdenUser extends TailBean  {
	
	// alias
	public static final String ALIAS_user_id = "user_id";
	public static final String ALIAS_account_non_expired = "account_non_expired";
	public static final String ALIAS_account_non_locked = "account_non_locked";
	public static final String ALIAS_credentials_non_expired = "credentials_non_expired";
	public static final String ALIAS_enabled = "enabled";
	public static final String ALIAS_create_by = "create_by";
	public static final String ALIAS_last_modified_by = "last_modified_by";
	public static final String ALIAS_password = "password";
	public static final String ALIAS_username = "username";
	public static final String ALIAS_version = "version";
	public static final String ALIAS_create_date = "create_date";
	public static final String ALIAS_last_modified_date = "last_modified_date";
	
	/*
	PK
	*/
	private Long userId ;
	/*
	账户没过期?
	*/
	private Boolean accountNonExpired = true;
	/*
	账户没锁定?
	*/
	private Boolean accountNonLocked = true;
	/*
	证书没过期?
	*/
	private Boolean credentialsNonExpired = true;
	/*
	可用?
	*/
	private Boolean enabled = true;
	/*
	创建者
	*/
	@UpperCase
	private String createBy ;
	/*
	最后修改者
	*/
	@UpperCase
	private String lastModifiedBy ;
	/*
	密码
	*/
	private String password ;
	/*
	用户名
	*/
	@UpperCase
	private String username ;
	
	@Version
	private Long version = 0L;
	/*
	创建时间
	*/
	@NowDefault
	@UpdateIgnore
	private Date createDate ;
	/*
	最后修改时间
	*/
	@NowDefault
	private Date lastModifiedDate ;
	
	public IdenUser() {
	}
	/**
	* PK
	*@return 
	*/
	public Long getUserId(){
		return  userId;
	}
	/**
	* PK
	*@param  userId
	*/
	public void setUserId(Long userId ){
		this.userId = userId;
	}
	
	/**
	* 账户没过期?
	*@return 
	*/
	public Boolean getAccountNonExpired(){
		return  accountNonExpired;
	}
	/**
	* 账户没过期?
	*@param  accountNonExpired
	*/
	public void setAccountNonExpired(Boolean accountNonExpired ){
		this.accountNonExpired = accountNonExpired;
	}
	
	/**
	* 账户没锁定?
	*@return 
	*/
	public Boolean getAccountNonLocked(){
		return  accountNonLocked;
	}
	/**
	* 账户没锁定?
	*@param  accountNonLocked
	*/
	public void setAccountNonLocked(Boolean accountNonLocked ){
		this.accountNonLocked = accountNonLocked;
	}
	
	/**
	* 证书没过期?
	*@return 
	*/
	public Boolean getCredentialsNonExpired(){
		return  credentialsNonExpired;
	}
	/**
	* 证书没过期?
	*@param  credentialsNonExpired
	*/
	public void setCredentialsNonExpired(Boolean credentialsNonExpired ){
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	/**
	* 可用?
	*@return 
	*/
	public Boolean getEnabled(){
		return  enabled;
	}
	/**
	* 可用?
	*@param  enabled
	*/
	public void setEnabled(Boolean enabled ){
		this.enabled = enabled;
	}
	
	/**
	* 创建者
	*@return 
	*/
	public String getCreateBy(){
		return  createBy;
	}
	/**
	* 创建者
	*@param  createBy
	*/
	public void setCreateBy(String createBy ){
		this.createBy = createBy;
	}
	
	/**
	* 最后修改者
	*@return 
	*/
	public String getLastModifiedBy(){
		return  lastModifiedBy;
	}
	/**
	* 最后修改者
	*@param  lastModifiedBy
	*/
	public void setLastModifiedBy(String lastModifiedBy ){
		this.lastModifiedBy = lastModifiedBy;
	}
	
	/**
	* 密码
	*@return 
	*/
	public String getPassword(){
		return  password;
	}
	/**
	* 密码
	*@param  password
	*/
	public void setPassword(String password ){
		this.password = password;
	}
	
	/**
	* 用户名
	*@return 
	*/
	public String getUsername(){
		return  username;
	}
	/**
	* 用户名
	*@param  username
	*/
	public void setUsername(String username ){
		this.username = username;
	}
	
	public Long getVersion(){
		return  version;
	}
	public void setVersion(Long version ){
		this.version = version;
	}
	
	/**
	* 创建时间
	*@return 
	*/
	public Date getCreateDate(){
		return  createDate;
	}
	/**
	* 创建时间
	*@param  createDate
	*/
	public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	
	/**
	* 最后修改时间
	*@return 
	*/
	public Date getLastModifiedDate(){
		return  lastModifiedDate;
	}
	/**
	* 最后修改时间
	*@param  lastModifiedDate
	*/
	public void setLastModifiedDate(Date lastModifiedDate ){
		this.lastModifiedDate = lastModifiedDate;
	}
	

}
