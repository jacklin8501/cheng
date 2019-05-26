/**
 * 
 */
package com.cheng.core.properties.security;

/**
 * @author jack.lin
 *
 */
public class ChengSecuritySessionProperties {

	private Integer maximumSessions = 1;
	private Boolean maxSessionsPreventsLogin = false;
	private String invalidSessionUrl;
	private String expiredUrl;
	
	public Integer getMaximumSessions() {
		return maximumSessions;
	}
	public void setMaximumSessions(Integer maximumSessions) {
		this.maximumSessions = maximumSessions;
	}
	public Boolean getMaxSessionsPreventsLogin() {
		return maxSessionsPreventsLogin;
	}
	public void setMaxSessionsPreventsLogin(Boolean maxSessionsPreventsLogin) {
		this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
	}
	public String getInvalidSessionUrl() {
		return invalidSessionUrl;
	}
	public void setInvalidSessionUrl(String invalidSessionUrl) {
		this.invalidSessionUrl = invalidSessionUrl;
	}
	public String getExpiredUrl() {
		return expiredUrl;
	}
	public void setExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
	}
}
