/**
 * 
 */
package com.cheng.beetlsql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.beetl.sql.core.annotatoin.Builder;

import com.cheng.beetlsql.annotation.builder.NowDatetimeBuilder;

/**
 * @author jack.lin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.FIELD})
@Builder(value=NowDatetimeBuilder.class)
public @interface NowDefault {

}
