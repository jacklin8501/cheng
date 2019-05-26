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
@Table(name="beetlsql.iden_role")
public class IdenRole extends TailBean {
	
	// alias
	public static final String ALIAS_role_id = "role_id";
	public static final String ALIAS_create_by = "create_by";
	public static final String ALIAS_last_modified_by = "last_modified_by";
	public static final String ALIAS_role_code = "role_code";
	public static final String ALIAS_role_description = "role_description";
	public static final String ALIAS_role_name = "role_name";
	public static final String ALIAS_version = "version";
	public static final String ALIAS_create_date = "create_date";
	public static final String ALIAS_last_modified_date = "last_modified_date";
	
	/*
	PK
	*/
	private Long roleId ;
	/*
	创建者
	*/
	@UpperCase
	@UpdateIgnore
	private String createBy ;
	/*
	最后修改者
	*/
	@UpperCase
	private String lastModifiedBy ;
	/*
	角色编码
	*/
	@UpperCase
	private String roleCode ;
	/*
	角色描述
	*/
	private String roleDescription ;
	/*
	角色名称
	*/
	private String roleName ;
	/*
	版本
	*/
	@Version
	private Long version = 0L;
	/*
	创建日期
	*/
	@UpdateIgnore
	@NowDefault
	private Date createDate ;
	/*
	最后修改日期
	*/
	@NowDefault
	private Date lastModifiedDate ;
	
	public IdenRole() {
	}
	
	/**
	* PK
	*@return 
	*/
	public Long getRoleId(){
		return  roleId;
	}
	/**
	* PK
	*@param  roleId
	*/
	public void setRoleId(Long roleId ){
		this.roleId = roleId;
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
	* 角色编码
	*@return 
	*/
	public String getRoleCode(){
		return  roleCode;
	}
	/**
	* 角色编码
	*@param  roleCode
	*/
	public void setRoleCode(String roleCode ){
		this.roleCode = roleCode;
	}
	
	/**
	* 角色描述
	*@return 
	*/
	public String getRoleDescription(){
		return  roleDescription;
	}
	/**
	* 角色描述
	*@param  roleDescription
	*/
	public void setRoleDescription(String roleDescription ){
		this.roleDescription = roleDescription;
	}
	
	/**
	* 角色名称
	*@return 
	*/
	public String getRoleName(){
		return  roleName;
	}
	/**
	* 角色名称
	*@param  roleName
	*/
	public void setRoleName(String roleName ){
		this.roleName = roleName;
	}
	
	/**
	* 版本
	*@return 
	*/
	public Long getVersion(){
		return  version;
	}
	/**
	* 版本
	*@param  version
	*/
	public void setVersion(Long version ){
		this.version = version;
	}
	
	/**
	* 创建日期
	*@return 
	*/
	public Date getCreateDate(){
		return  createDate;
	}
	/**
	* 创建日期
	*@param  createDate
	*/
	public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	
	/**
	* 最后修改日期
	*@return 
	*/
	public Date getLastModifiedDate(){
		return  lastModifiedDate;
	}
	/**
	* 最后修改日期
	*@param  lastModifiedDate
	*/
	public void setLastModifiedDate(Date lastModifiedDate ){
		this.lastModifiedDate = lastModifiedDate;
	}
	

}
