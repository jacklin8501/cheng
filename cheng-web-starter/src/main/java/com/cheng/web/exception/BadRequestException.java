/**
 * 
 */
package com.cheng.web.exception;

import org.springframework.http.HttpStatus;

/**
 * @author jack.lin
 *
 */
public class BadRequestException extends AbstractWebException {

	private static final long serialVersionUID = -8819238712288854580L;

	public BadRequestException(String reason) {
		super(HttpStatus.BAD_REQUEST.value(), reason);
		
	}

}
