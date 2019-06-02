/**
 * 
 */
package com.cheng.security.singlepage.demo.message;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;

import com.cheng.AbstractMvcTest;
import com.cheng.core.holder.MessageSourceHolder;
import com.cheng.security.singlepage.demo.pojo.DemoPojo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jack.lin
 *
 */
public class MessageSourceTest extends AbstractMvcTest {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Test
	public void whenGetMessageSuccess() {
		String[] params = {"123", "456"};
		String message = messageSource.getMessage("hit.local.cache", params, Locale.CHINA);
		logger.info(":: " + message);
	}
	
	@Test
	public void whenHolderGetMessageSuccess() {
		MessageSource ms = MessageSourceHolder.create("/messages/messages_zh");
		String[] params = {"123", "456"};
		Locale locale = LocaleContextHolder.getLocale();
		String message = ms.getMessage("clear.history", params, locale);
		logger.info(":: " + message);
	}
	
	@Test
	public void whenGetSuccess() throws Exception {
		DemoPojo pojo = new DemoPojo();
		pojo.setName("xxxx");
		pojo.setAge(2);
		mvc.perform(post("/msg")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(pojo))
				)
		.andExpect(status().isOk());
	}
}
