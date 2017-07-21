package com.pj.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pj.system.controller.UserController;

/**
 * @author GFF
 * @date 2017年2月9日上午11:30:35
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class ClassUtils {
	// 日志对象
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 通过反射获取成员变量对应的get方法名称
	 * 
	 * @author GFF
	 * @date 2017年2月9日上午11:39:35
	 * @param obj
	 *            类
	 * @param variables
	 *            成员变量
	 * @return
	 */
	public static Field[] getGetMethodName(Object obj, List<String> variables) {
		Class<? extends Object> clazz = obj.getClass();
		Field[] fields = new Field[variables.size()];
		try {
			for (int i = 0; i < variables.size(); i++) {
				fields[i] = clazz.getDeclaredField(variables.get(i));
			}
		} catch (NoSuchFieldException e) {
			logger.error("This field is not found");
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.error("No permission to access this field , To see whether private");
			e.printStackTrace();
		}
		return fields;
	}

	/**
	 * 通过反射获取字段属性值
	 * @author GFF
	 * @date 2017年4月10日下午4:05:41
	 * @param t
	 * @param asList
	 * @return
	 */
	public static List<String> getGetMethodValue(Object t, List<String> asList) {
		List<String> values = new ArrayList<>();
		Class<? extends Object> clazz = t.getClass();
		try {
			for (String fieldName : asList) {
				Field field = clazz.getDeclaredField(fieldName);
				if (field != null) {
					PropertyDescriptor pd;
					pd = new PropertyDescriptor(field.getName(), clazz);
					Method getMethod = pd.getReadMethod();
					Object o = getMethod.invoke(t);
					if (o != null) {
						values.add(o.toString());
					}
				}
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	/**
	 * 	通过反射设置成员属性值
	 *	@author 			GFF
	 *	@date				2017年4月14日下午2:06:49	
	 * 	@param clazz		对象
	 * 	@param asList		成员属性名称	
	 * 	@param asList2		成员属性值
	 */
	public static <T> T setFieldValue(Class<T> clazz, List<String> fieldNames, List<Serializable> fieldValues) {
		try {
			T t = clazz.newInstance();
			for (int i = 0; i < fieldNames.size(); i++) {
				Field field = clazz.getDeclaredField(fieldNames.get(i));
				field.setAccessible(true);
				field.set(t, fieldValues.get(i));
			}
			return t;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
