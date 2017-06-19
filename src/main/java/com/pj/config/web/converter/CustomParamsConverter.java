package com.pj.config.web.converter;

import org.springframework.core.convert.converter.Converter;
/**
 *	自定义类型转换器 	
 * @author Administrator
 *
 */
public class CustomParamsConverter implements Converter<String, Object> 
{

	public String convert(String source) {
		if( source != null ){
			source = source.trim();				//	去除空格，进行判断
			if(!"".equals(source)){
				return source;
			}
		}
		return null;
	}


}
