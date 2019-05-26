package com.cheng.beetlsql.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.beetl.sql.core.annotatoin.Tail;
import org.beetl.sql.core.annotatoin.UpdateIgnore;
import org.beetl.sql.core.annotatoin.Version;

import com.cheng.beetlsql.annotation.NowDefault;
import com.cheng.beetlsql.enums.Gender;

/**
 * @author jack.lin
 *
 */
@Tail(set="mapRole")
public class User {
	private Integer id ;
    private Integer age ;
    //用户角色
    private Integer roleId ;
    private String name ;
    //用户名称
    private String userName ;
    
    @UpdateIgnore
    @NowDefault
    private Date createDate ;
    
    @NowDefault
    private Date modifiedDate;
    
    @Version
    private Long version = 0L;
    
    private Gender gender = Gender.FEMALE;
    
    private Map<String, Object> role = new HashMap<>();
    
    public User mapRole(String k, Object v) {
    	role.put(k, v);
    	return this;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
