/**
 * 
 */
package com.cheng.web.config;

import static com.cheng.web.util.RequestUtils.isAjaxRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cheng.core.properties.ChengProperties;
import com.cheng.web.entity.WebResponseEntity;
import com.cheng.web.exception.AbstractWebException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jack.lin
 *
 */
@ControllerAdvice
public class WebExceptionAdvice {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ChengProperties cheng;
	
	@ExceptionHandler(AbstractWebException.class)
	public void webExceptionHandler(HttpServletRequest request, HttpServletResponse response, AbstractWebException ex) throws IOException {
		response.setCharacterEncoding("UTF-8");
		if (isAjaxRequest(request)) {
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			response.setStatus(ex.getStatus());
			Object res = ex;
			if (cheng.getWeb().getApiStyle()) {
				response.setStatus(HttpStatus.OK.value());
				res = new WebResponseEntity();
				BeanUtils.copyProperties(ex, res);
			}
			try(PrintWriter writer = response.getWriter();) {
				writer.write(objectMapper.writeValueAsString(res));
			}
		} else {
			response.sendRedirect(
					cheng.getWeb().getErrorUrl() + "?status=" + ex.getStatus() + "&description=" + ex.getDescription() + "&reason=" + ex.getReason());
		}
	}
}
