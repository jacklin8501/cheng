package com.cheng.as.demo.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * HttpWebUtils
 */
public class HttpWebUtils {

    private HttpWebUtils() {}

    public static boolean isAsynRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (StringUtils.equals("XMLHttpRequest", requestType)) {
            return true;
        }
        return false;
    }
}