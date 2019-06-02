/**
 * 
 */
package com.cheng.beetl.function;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * @author jack.lin
 *
 */
public class GetSetUtil implements Function {

	@Override
	public Object call(Object[] arg0, Context arg1) {
		if (isEmpty(arg0) || String.class != arg0[0].getClass()) {
			return null;
		}
		String value = arg0[0].toString();
		String first = StringUtils.substring(value, 0, 1);
		String end = StringUtils.substring(value, 1);
		return first.toUpperCase() + end;
	}

}
