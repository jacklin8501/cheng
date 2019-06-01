/**
 * 
 */
package com.cheng.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.cheng.AbstractSecurityMvcTest;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
@Transactional
@WithUserDetails(value="maxadmin", userDetailsServiceBeanName="userDetailsServiceImpl")
public class SecurityLoginTest extends AbstractSecurityMvcTest {

	@Autowired
	ChengProperties cheng;
	
	@Test
	public void login() throws Exception {
		String contextPath = context.getServletContext().getContextPath();
		String url = contextPath + cheng.getSecurity().getForm().getLoginProcessingUrl();
		logger.info(":: url = {}", url);
		mvc.perform(formLogin(url).user("maxadmin").password("000000")).andExpect(authenticated());
	}
	
	@Test
	public void whenLoginSuccess() throws Exception {
		String me = mvc.perform(get("/sec/me"))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
		logger.info(":: me = {}", me);
	}
}
