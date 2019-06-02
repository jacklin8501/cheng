/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cheng.beetl.auditor.AuditorProvider;

/**
 * @author jack.lin
 *
 */
@Component
public class AuditorProviderImpl implements AuditorProvider {

	@Override
	public String get() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return isNotEmpty(auth) ? auth.getName() : "UNKNOWN";
	}

}
