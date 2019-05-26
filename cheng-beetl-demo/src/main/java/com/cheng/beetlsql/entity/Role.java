package com.cheng.beetlsql.entity;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2019-05-11
*/
@Table(name="beetlsql.role")
public class Role   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_role_code = "role_code";
	public static final String ALIAS_role_name = "role_name";
	
	private Integer id ;
	private String roleCode ;
	private String roleName ;
	
	public Role() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public String getRoleCode(){
		return  roleCode;
	}
	public void setRoleCode(String roleCode ){
		this.roleCode = roleCode;
	}
	
	public String getRoleName(){
		return  roleName;
	}
	public void setRoleName(String roleName ){
		this.roleName = roleName;
	}
	

}
