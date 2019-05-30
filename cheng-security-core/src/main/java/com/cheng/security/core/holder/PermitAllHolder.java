/**
 * 
 */
package com.cheng.security.core.holder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public final class PermitAllHolder {

	public static ChengProperties getChengProperties() {
		return SpringContextHolder.getBean(ChengProperties.class);
	}
	
	public static List<String> getDefaultPermitAll() {
		ChengProperties cheng = getChengProperties();
		if (cheng.getSecurity().getEnabledDefaultPermitAll()) {
			return Arrays.asList(
					cheng.getSecurity().getForm().getLoginPage(),
					cheng.getSecurity().getForm().getLoginProcessingUrl(),
					cheng.getSecurity().getForm().getLogoutProccessUrl(),
					cheng.getSecurity().getSession().getInvalidSessionUrl(),
					cheng.getSecurity().getSession().getExpiredUrl(),
					"/error/**",
					"/**/*.js",
					"/**/*.css",
					"/**/*.html",
					"/**/*.jsp",
					"/**/*.btl",
					"/**/*.ico",
					"/**/*.jpg",
					"/**/*.png"
					);
		} else {
			return new ArrayList<>();
		}
	}
	
	public static List<String> getPermitAll() {
		List<String> defaultPermitAll = getDefaultPermitAll();
		List<String> permitAll = getChengProperties().getSecurity().getPermitAll();
		List<String> newPermitAll = new ArrayList<>();
		newPermitAll.addAll(defaultPermitAll);
		newPermitAll.addAll(permitAll);
		return newPermitAll;
	}
	
	public static String[] getPermitAllExpression() {
		List<String> permitAll = getPermitAll();
		String[] expression = new String[permitAll.size()];
		for (int i = 0; i < permitAll.size(); i++) {
			expression[i] = permitAll.get(i);
		}
		return expression;
	}
}
