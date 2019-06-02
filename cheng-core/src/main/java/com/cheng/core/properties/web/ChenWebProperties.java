/**
 * 
 */
package com.cheng.core.properties.web;

/**
 * @author jack.lin
 *
 */
public class ChenWebProperties {
	
	private String ajaxRequestKey = "X-Requested-With";
	private String ajaxRequestValue =  "XMLHttpRequest";
	
	private String errorUrl = "/error";
	private String sessionInvalid = "/session/invalid";
	private String sessionExpired = "/session/expired";
	
	private Boolean apiStyle = false;
	
	public String getAjaxRequestKey() {
		return ajaxRequestKey;
	}
	public void setAjaxRequestKey(String ajaxRequestKey) {
		this.ajaxRequestKey = ajaxRequestKey;
	}
	public String getAjaxRequestValue() {
		return ajaxRequestValue;
	}
	public void setAjaxRequestValue(String ajaxRequestValue) {
		this.ajaxRequestValue = ajaxRequestValue;
	}
	public String getErrorUrl() {
		return errorUrl;
	}
	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
	public String getSessionInvalid() {
		return sessionInvalid;
	}
	public void setSessionInvalid(String sessionInvalid) {
		this.sessionInvalid = sessionInvalid;
	}
	public String getSessionExpired() {
		return sessionExpired;
	}
	public void setSessionExpired(String sessionExpired) {
		this.sessionExpired = sessionExpired;
	}
	public Boolean getApiStyle() {
		return apiStyle;
	}
	public void setApiStyle(Boolean apiStyle) {
		this.apiStyle = apiStyle;
	}
}
