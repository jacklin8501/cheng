/**
 * 
 */
package com.cheng.core.exception;

/**
 * @author jack.lin
 *
 */
public abstract class AbstractWebException extends Exception {

	private static final long serialVersionUID = -308525665778572723L;
	
	private Integer status = 0;
	private String description;
	private String reason;
	private Object body;
	
	public AbstractWebException(Integer status) {
		super();
		this.status = status;
	}
	
	public AbstractWebException(Integer status, String reason) {
		super(reason);
		this.status = status;
		this.reason = reason;
	}
	
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
