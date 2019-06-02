/**
 * 
 */
package com.cheng.web.util;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public final class RequestUtils {

	public static boolean isAjaxRequest(HttpServletRequest request) {
		if (isEmpty(request)) {
			return false;
		}
		ChengProperties cheng = SpringContextHolder.getBean(ChengProperties.class);
		String xmlHeader = request.getHeader(cheng.getWeb().getAjaxRequestKey());
		if (isEmpty(xmlHeader) || !StringUtils.equals(cheng.getWeb().getAjaxRequestValue(), xmlHeader)) {
			return false;
		}
		return true;
	}
	
	public static String calculateUri(HttpServletRequest request) {
		if (isEmpty(request)) {
			return null;
		}
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (StringUtils.startsWith(uri, contextPath)) {
			return StringUtils.substring(uri, contextPath.length());
		}
		return uri;
	}
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
	}
}
