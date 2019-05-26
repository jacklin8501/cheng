/**
 * 
 */
package com.cheng.beetlsql.function;

import java.util.Date;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * @author jack.lin
 *
 */
public class TimeStampFunction implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		if (paras.length == 0)
			return null;
		
		Object value = paras[0];
		if (null == value) 
			return null;
		
		if (String.class != value.getClass())
			return null;
		
		String val = value.toString();
		return val + new Date().getTime();
	}

}
