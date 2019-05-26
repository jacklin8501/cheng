/**
 * 
 */
package com.cheng.beetl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.beetl.sql.core.annotatoin.Builder;

import com.cheng.beetl.builder.UpperCaseBuilder;

/**
 * @author jack.lin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.FIELD})
@Builder(value=UpperCaseBuilder.class)
public @interface UpperCase {

}
