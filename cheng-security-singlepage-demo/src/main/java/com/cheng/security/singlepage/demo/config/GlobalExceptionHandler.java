/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jack.lin
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public void handler400(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException ex) throws IOException {
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		StringBuffer sb = new StringBuffer();
		
		for (ObjectError error : errors) {
			sb.append(error.getDefaultMessage()).append(";");
		}
		logger.info(":: all error = " + sb.toString());
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		try (PrintWriter writer = response.getWriter();) {
			writer.write(sb.toString());
		}
	}
}
