/**
 * 
 */
package com.cheng.beetlsql.annotation.builder;

import java.lang.annotation.Annotation;

import org.beetl.sql.core.annotatoin.builder.AttributePersistBuilder;
import org.beetl.sql.core.db.AbstractDBStyle;
import org.beetl.sql.core.db.TableDesc;

/**
 * @author jack.lin
 *
 */
public class NowDatetimeBuilder implements AttributePersistBuilder {

	@Override
	public String toSql(AbstractDBStyle paramAbstractDBStyle, String fieldName, String colName,
			Annotation an, TableDesc tableDesc) {
		return "date()";
	}

}
