/**
 * 
 */
package com.cheng.beetl.builder;

import static com.cheng.core.utils.EmptyUtils.isNotEmpty;

import java.lang.annotation.Annotation;

import org.beetl.sql.core.annotatoin.builder.AttributePersistBuilder;
import org.beetl.sql.core.db.AbstractDBStyle;
import org.beetl.sql.core.db.TableDesc;

import com.cheng.beetl.auditor.AuditorProvider;
import com.cheng.core.holder.SpringContextHolder;

/**
 * @author jack.lin
 *
 */
public class AuditorBuilder implements AttributePersistBuilder {

	@Override
	public String toSql(AbstractDBStyle arg0, String arg1, String arg2, Annotation arg3, TableDesc arg4) {
		String name = "UNKNOWN";
		AuditorProvider auditor = SpringContextHolder.getBean(AuditorProvider.class);
		if (isNotEmpty(auditor)) {
			name = auditor.get();
		}
		return "'" + name.toUpperCase() + "'";
	}

}
