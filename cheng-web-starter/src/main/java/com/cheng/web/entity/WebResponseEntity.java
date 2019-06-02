/**
 * 
 */
package com.cheng.web.entity;

/**
 * @author jack.lin
 *
 */
public class WebResponseEntity {

	private Integer status = 0;
	private String description;
	private String reason;
	private Object body;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
