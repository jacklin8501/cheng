/**
 * 
 */
package com.cheng.core.properties.security;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack.lin
 *
 */
public class ChengSecurityProperties {

	private SecurityFormProperties form = new SecurityFormProperties();
	private ChengSecuritySessionProperties session = new ChengSecuritySessionProperties();
	private List<String> permitAll = new ArrayList<>();
	private List<String> anyRequestAuthenticated = new ArrayList<>();

	public SecurityFormProperties getForm() {
		return form;
	}

	public void setForm(SecurityFormProperties form) {
		this.form = form;
	}

	public ChengSecuritySessionProperties getSession() {
		return session;
	}

	public void setSession(ChengSecuritySessionProperties session) {
		this.session = session;
	}

	public List<String> getPermitAll() {
		return permitAll;
	}

	public void setPermitAll(List<String> permitAll) {
		this.permitAll = permitAll;
	}

	public List<String> getAnyRequestAuthenticated() {
		return anyRequestAuthenticated;
	}

	public void setAnyRequestAuthenticated(List<String> anyRequestAuthenticated) {
		this.anyRequestAuthenticated = anyRequestAuthenticated;
	}
}
