/**
 * 
 */
package com.cheng.core.properties.security;

/**
 * @author jack.lin
 *
 */
public class SecurityFormProperties {

	private String loginPage;
	private String loginProcessingUrl;
	private String logoutProccessUrl;
	private String indexPage;
	
	public String getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	public String getLoginProcessingUrl() {
		return loginProcessingUrl;
	}
	public void setLoginProcessingUrl(String loginProcessingUrl) {
		this.loginProcessingUrl = loginProcessingUrl;
	}
	public String getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}
	public String getLogoutProccessUrl() {
		return logoutProccessUrl;
	}
	public void setLogoutProccessUrl(String logoutProccessUrl) {
		this.logoutProccessUrl = logoutProccessUrl;
	}
}
