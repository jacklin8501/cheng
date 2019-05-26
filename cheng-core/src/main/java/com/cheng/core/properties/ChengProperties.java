/**
 * 
 */
package com.cheng.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.cheng.core.properties.admin.ChengAdminProperties;
import com.cheng.core.properties.security.ChengSecurityProperties;
import com.cheng.core.properties.web.ChenWebProperties;

/**
 * @author jack.lin
 *
 */
@ConfigurationProperties(prefix="cheng")
public class ChengProperties {

	private ChengSecurityProperties security = new ChengSecurityProperties();
	private ChenWebProperties web = new ChenWebProperties();
	private ChengAdminProperties admin = new ChengAdminProperties();
	
	public ChengSecurityProperties getSecurity() {
		return security;
	}
	public void setSecurity(ChengSecurityProperties security) {
		this.security = security;
	}
	public ChenWebProperties getWeb() {
		return web;
	}
	public void setWeb(ChenWebProperties web) {
		this.web = web;
	}
	public ChengAdminProperties getAdmin() {
		return admin;
	}
	public void setAdmin(ChengAdminProperties admin) {
		this.admin = admin;
	}
}
