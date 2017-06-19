package com.pj.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pj.config.base.pojo.poi.Excel;

public class ExcleUtils {

	public static String errmessage = "";

	// 转换保存时的数字
	public static Integer isboolean(String condition) {
		try {
			condition = condition.trim();
			if (condition.equals("是")) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(condition + "请选择 是 或 否");
		}
	}

	// 转换时间格式
	public static Date dateConvert(String source) {
		try {
			source = source.trim();
			String replace = "";
			if (source.contains(".")) {
				replace = source.replace(".", "-");
				if (source.length() > 4 && source.length() < 8) {
					replace = replace + "-" + "01";
				}
			} else if (source.contains("/")) {
				replace = source.replace("/", "-");
			} else if (source.length() == 4) {
				replace = source + "-" + "01" + "-" + "01";
			} else if (source.equals("0")) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date parse;
			parse = sdf.parse(replace);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("时间类型格式填写错误");
		}
	}
	
	/**
	 * 	批量导出excel工具类
	 *	@author 	GFF
	 *	@date		2017年2月9日上午11:05:14	
	 * 	@param		excel			excel
	 * 	@param 		list			所需要写出到excel的结果集
	 *  @return 	HSSFWorkbook	
	 */
	public static <T> HSSFWorkbook exportExcel(Excel excel, List<T> list) {
		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(excel.getFileName());
		// 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFCell cell = null;
		//	设置标题内容
		for (int i = 0; i < excel.getHeaders().length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(excel.getHeaders()[i]);
			cell.setCellStyle(style);
		}
		try {
			PropertyDescriptor pd = null;
			for (int y = 0; y < list.size(); y++) {
				row = sheet.createRow((int) y + 1);
				for (int i = 0; i < excel.getFields().length; i++) {
					pd = new PropertyDescriptor(excel.getFields()[i].getName(), list.get(y).getClass());
					if(pd.getReadMethod().invoke(list.get(y)) != null){
						//	判断当前类型为double类型时  设置该cell格式为数值类型
						if(pd.getReadMethod().invoke(list.get(y)) instanceof Double){
							row.createCell(i).setCellValue(Double.parseDouble(pd.getReadMethod().invoke(list.get(y)).toString()));
						}else{
							row.createCell(i).setCellValue(pd.getReadMethod().invoke(list.get(y)).toString());
						}
					}
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
				e.printStackTrace();
		}
		return wb;
	}
}
