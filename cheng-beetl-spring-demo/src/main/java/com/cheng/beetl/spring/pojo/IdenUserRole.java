package com.cheng.beetl.spring.pojo;
import java.util.Date;

import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.annotatoin.UpdateIgnore;

import com.cheng.beetl.annotation.NowDefault;
import com.cheng.beetl.annotation.UpperCase;


/* 
* 
* gen by beetlsql 2019-05-12
*/
@SuppressWarnings("serial")
@Table(name="beetlsql.iden_user_role")
public class IdenUserRole extends TailBean {
	
	// alias
	public static final String ALIAS_ur_id = "ur_id";
	public static final String ALIAS_create_by = "create_by";
	public static final String ALIAS_last_modified_by = "last_modified_by";
	public static final String ALIAS_role_id = "role_id";
	public static final String ALIAS_user_id = "user_id";
	public static final String ALIAS_create_date = "create_date";
	public static final String ALIAS_last_modified_date = "last_modified_date";
	
	/*
	PK
	*/
	private Long urId ;
	@UpperCase
	@UpdateIgnore
	private String createBy ;
	@UpperCase
	private String lastModifiedBy ;
	/*
	角色ID
	*/
	private Long roleId ;
	/*
	用户ID
	*/
	private Long userId ;
	@NowDefault
	@UpdateIgnore
	private Date createDate ;
	@NowDefault
	private Date lastModifiedDate ;
	
	public IdenUserRole() {
	}
	
	/**
	* PK
	*@return 
	*/
	public Long getUrId(){
		return  urId;
	}
	/**
	* PK
	*@param  urId
	*/
	public void setUrId(Long urId ){
		this.urId = urId;
	}
	
	public String getCreateBy(){
		return  createBy;
	}
	public void setCreateBy(String createBy ){
		this.createBy = createBy;
	}
	
	public String getLastModifiedBy(){
		return  lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy ){
		this.lastModifiedBy = lastModifiedBy;
	}
	
	/**
	* 角色ID
	*@return 
	*/
	public Long getRoleId(){
		return  roleId;
	}
	/**
	* 角色ID
	*@param  roleId
	*/
	public void setRoleId(Long roleId ){
		this.roleId = roleId;
	}
	
	/**
	* 用户ID
	*@return 
	*/
	public Long getUserId(){
		return  userId;
	}
	/**
	* 用户ID
	*@param  userId
	*/
	public void setUserId(Long userId ){
		this.userId = userId;
	}
	
	public Date getCreateDate(){
		return  createDate;
	}
	public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	
	public Date getLastModifiedDate(){
		return  lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate ){
		this.lastModifiedDate = lastModifiedDate;
	}
	

}
