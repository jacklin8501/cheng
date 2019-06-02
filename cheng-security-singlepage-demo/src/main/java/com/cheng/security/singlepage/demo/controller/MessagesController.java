/**
 * 
 */
package com.cheng.security.singlepage.demo.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheng.security.singlepage.demo.pojo.DemoPojo;

/**
 * @author jack.lin
 *
 */
@RestController
@RequestMapping("/msg")
public class MessagesController {

	@Autowired
	private MessageSource messageSource;
	
	@PostMapping
	public String getMsg(@Validated @RequestBody DemoPojo pojo) {
		String[] params = {"1111", "2222"};
		return "";
	}
	
}
