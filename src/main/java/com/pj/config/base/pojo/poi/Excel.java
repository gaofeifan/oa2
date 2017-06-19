package com.pj.config.base.pojo.poi;

import java.lang.reflect.Field;

/**
 *	@author		GFF
 *	@date		2017年1月19日下午1:18:58
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class Excel {

	/**
	 * 	文件名称
	 */
	private String fileName;
	
	/**
	 * 	标题
	 */
	private String[] headers;
	
	/**
	 * 	对应的字段
	 */
	Field[] fields;
	
	public Excel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Excel(String fileName, String[] headers, Field[] fields) {
		super();
		this.fileName = fileName;
		this.headers = headers;
		this.fields = fields;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}
}
