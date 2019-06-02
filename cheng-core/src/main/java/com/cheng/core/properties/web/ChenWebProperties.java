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
}
