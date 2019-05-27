/**
 * 
 */
package com.cheng.security.core.utils;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;

/**
 * @author jack.lin
 *
 */
public final class AuthenticationUtils {

	public static boolean isAnonymousUser(Authentication authentication) {
		if (isEmpty(authentication)) {
			return false;
		}
		if (isEmpty(authentication.getPrincipal())) {
			return false;
		}
		if (String.class != authentication.getPrincipal().getClass()) {
			return false;
		}
		if (!StringUtils.equalsIgnoreCase("AnonymousUser", authentication.getPrincipal().toString())) {
			return false;
		}
		return true;
	}
	
}
