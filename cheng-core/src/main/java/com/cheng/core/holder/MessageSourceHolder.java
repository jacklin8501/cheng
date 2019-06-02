/**
 * 
 */
package com.cheng.core.holder;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import java.nio.charset.StandardCharsets;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author jack.lin
 *
 */
public final class MessageSourceHolder {

	private static MessageSource messageSource;
	
	public static MessageSource create(String ... baseNames) {
		if (isEmpty(messageSource)) {
			ReloadableResourceBundleMessageSource tmp = new ReloadableResourceBundleMessageSource();
			tmp.setCacheSeconds(-1);
			tmp.setDefaultEncoding(StandardCharsets.UTF_8.name());
			tmp.setBasenames(baseNames);
			messageSource = tmp;
		}
		return messageSource;
	}
}
