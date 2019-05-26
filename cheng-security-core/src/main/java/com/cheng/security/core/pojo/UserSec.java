package com.cheng.security.core.pojo;

public class UserSec  {
	
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
	密码
	*/
	private String password ;
	/*
	用户名
	*/
	private String username ;
	
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
