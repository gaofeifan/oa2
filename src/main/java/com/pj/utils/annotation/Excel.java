package com.pj.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

	/**
	 * @return
	 */
	String name()default "";

	/**
	 * 标识为集合
	 * 
	 * @return
	 */
	String excelCollection()default "";

	/**
	 * 标识为base
	 * 
	 * @return
	 */
	boolean excelBase()default false;

	/**
	 * 导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string 类型,这个需要设置这个数据库格式
	 */
	String databaseFormat() default "yyyyMMddHHmmss";

	/**
	 * 排序
	 * 
	 * @return
	 */
	String orderNum() default "0";

	/**
	 * 时间格式
	 */
	String format() default "";
	
	/**
	 * 标识该字段内容为是或否
	 */
	boolean isBoolean() default false;
	
	/**
	 * 标识该字段内容为已未
	 */
	boolean isStatus() default false;
}
