/**
 * 
 */
package com.cheng.security.core.metadatasource;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

/**
 * @author jack.lin
 * 安全资源加载
 */
public interface CustomerSecurityMetadataSourceProvider extends SecurityMetadataSource {

	default AntPathMatcher getPathMatcher() {
		return new AntPathMatcher();
	}
}
