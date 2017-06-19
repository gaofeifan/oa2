package com.pj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 类名称：DateUtils   
 * 类描述：   
 * 创建人：limr   
 * 创建时间：2016年8月2日 下午5:40:18   
 * 修改人：limr   
 * 修改时间：2016年8月2日 下午5:40:18   
 * 修改备注：   
 * @version    
 *
 */
public class DateUtils {

	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

	public static final String DATE_TIME_FORMAT_H = "yyyy-MM-dd HH";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_MIN_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String DATE_FORMAT_C = "yyyy年MM月dd日";

	private DateUtils() {
	}

	private static final String[] FORMATS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH:mm:ss", "HH:mm", "HH:mm:ss", "yyyy-MM", "yyyyMMdd" };

	public static Date convert(String str) {
		if (str != null && str.length() > 0) {
			if (str.length() > 10 && str.charAt(10) == 'T')
				str = str.replace('T', ' '); // ȥ��json-lib�ӵ�T��ĸ
			for (String format : FORMATS) {
				if (str.length() == format.length()) {
					try {
						if (logger.isDebugEnabled())
							logger.debug("convert " + str + " to date format "
									+ format);

						Date date = new SimpleDateFormat(format).parse(str);

						if (logger.isDebugEnabled())
							logger.debug("****" + date + "****");

						return date;
					} catch (ParseException e) {
						logger.warn(e.getMessage());
					}
				}
			}
		}
		return null;
	}

	public static Date convert(String str, String format) {
		if (!StringUtils.isEmpty(str)) {
			try {
				Date date = new SimpleDateFormat(format).parse(str);
				return date;
			} catch (ParseException e) {
				logger.warn(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 获取时差 日期
	 * @return
	 */
	public static String getTimeChangeDay(int timeChange) {
		 Date d=new Date();   
		 SimpleDateFormat df=new SimpleDateFormat(DATE_FORMAT);   
		 return df.format(new Date(d.getTime() +( timeChange * 60 * 60 * 1000) ));  
	}
//	public static void main(String[] args) {
//		for(int i=-24;i<24;i++)
//		System.out.println("i:"+i+",time:"+getTimeChangeDay(i));
//	}
	public static String convert(Date date) {
		return convert(date, DATE_TIME_FORMAT);
	}
	public static Date convertDate(Date date) {
		String dateFromat = convert(date, DATE_TIME_FORMAT);
		 SimpleDateFormat df=new SimpleDateFormat(DATE_FORMAT); 
		 Date parse = null;
		try {
			parse = df.parse(dateFromat);
			System.out.println(convert(parse));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}

	public static String convert(Date date, String dateFormat) {
		if (date == null)
			return null;

		if (null == dateFormat)
			dateFormat = DATE_TIME_FORMAT;

		return new SimpleDateFormat(dateFormat).format(date);
	}

	public static String formate(Object date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(DATE_TIME_FORMAT).format(date);
	}

	/**
	 * 返回一个指定日期的前某一天
	 * 
	 * @param date
	 *            初始日期
	 * @param num
	 *            加减的天数
	 * @param dateFormat
	 *            时间格式
	 * @return 初始日期减num后的日期
	 */
	public static String getSomeDate(Date date, int num,String dateFormat) {
		if(org.apache.commons.lang3.StringUtils.isNotBlank(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return convert(calendar.getTime(), dateFormat);
	}
	/**
	 * 返回一个指定日期的前某一天(return String时间格式数据)
	 * 
	 * @param date
	 *            初始日期
	 * @param num
	 *            加减的天数
	 * @return 初始日期减num后的日期
	 */
	public static String getSomeDate(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return convert(calendar.getTime(), DATE_FORMAT);
	}
	/**
	 * 返回一个指定日期的前某一天(return Date时间格式数据)
	 * 
	 * @param date
	 *            初始日期
	 * @param num
	 *            加减的天数
	 * @return 初始日期减num后的日期
	 */
	public static Date getSomedate(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return calendar.getTime();
	}
	
	/**
	 * 返回下一个月或上一个的日期
	 * 
	 * @param date
	 *            初始日期
	 * @param num
	 *            加减的月数
	 * @return 
	 */
	public static String getNextMonth(Date date, int num){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, num);
		return convert(calendar.getTime(), DATE_FORMAT);
		
	}
	public static void main(String[] args) throws ParseException {
	/*	Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, 1);
		String string = convert(calendar.getTime(),DATE_FORMAT_C);
		System.out.println(string);*/
//		Date assignDate = getAssignDate(null, 9,1 , null);
		
//		System.out.println(DateUtils.convert(assignDate, null) );
/*		String beginDate="2015-03-21 12:23:20";

		String endDate="2016-03-21 12:23:20";


		Date condition = updateDateByCondition(sdf.parse(beginDate), null, null, 0);
		System.out.println(sdf.format(condition));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar.get(Calendar.YEAR));;*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date yearFirst = getYearLast(2017);
		System.out.println(sdf.format(yearFirst));
	}
    
	 /**  
	 * 计算两个日期之间相差的天数  
	 * @param start		  开始时间
	 * @param end  		  结束时间
	 * @param dateFormat 时间格式
	 * @return 相差天数 
	 * @throws ParseException  
	 */    
	public static int daysBetween(Date start, Date end, String dateFormat) throws ParseException {
		if(org.apache.commons.lang3.StringUtils.isNotBlank(dateFormat)){
			dateFormat = DATE_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		start = sdf.parse(sdf.format(start));
		
		end = sdf.parse(sdf.format(getSomedate(end, 1)));
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		long time1 = cal.getTimeInMillis();
		cal.setTime(end);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
	public static int hourBetween(Date start, Date end, String dateFormat) throws ParseException{
		if(org.apache.commons.lang3.StringUtils.isNotBlank(dateFormat)){
			dateFormat = DATE_TIME_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		start = sdf.parse(sdf.format(start));
		
		end = sdf.parse(sdf.format(end));
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		long time1 = cal.getTimeInMillis();
		cal.setTime(end);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) /  ((60 * 60 * 1000) - 1 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	/**  
	 * 计算两个日期之间相差的天数  
	 * @param date		  时间
	 * @param dateFormat 时间格式
	 * @return 相差天数 
	 * @throws ParseException  
	 */    
	public static boolean isBeekend(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取两个日期之间双休日的天数
	 *	@author 		GFF
	 *	@date			2016年12月29日上午11:10:08	
	 * 	@param start	开始时间
	 * 	@param end		结束时间
	 * 	@param overtimes	需要排除的周末时间
	 * 	@param holidayDate  法定假日时间
	 * 	@return weekendDate	返回
	 * @throws ParseException 
	 */
	public static Integer getDifferenceDate(Date start , Date end ,List<Date> overtimes, List<Date> holidayDate) throws ParseException{
		int weekendDate= 0;
		while (true){
			if(!start.after(end)){
				//	判读法定假日时间与周末需要加班的时间
				if((overtimes != null && overtimes.size() != 0 && overtimes.contains(start)) || (holidayDate != null && holidayDate.size() != 0 && holidayDate.contains(start))){
					start = getSomedate(start, 1);
					continue;
				}
				//	判读当前时间是否为周末
				boolean beekend = isBeekend(start);
				if(beekend){
					weekendDate++;
				}
				start = getSomedate(start, 1);
			}else{
				return weekendDate;
			}
		}
		
	}
	
	/**
	 * 	获取指定某年,某月,某日后的的时间  
	 *	@author 	GFF
	 *	@date		2017年1月3日上午10:40:44	
	 * 	@param year		年份	（指定时间多少年后（年前）的时间）
	 * 	@param month	月份（指定时间多少月后（月前）的时间）
	 * 	@param day		天数（指定时间多少天后（天前）的时间）
	 * 	@param date		所需要计算的时间（默认为当前时间）
	 * 	@return	
	 */
	public static Date getAssignDate(Integer year , Integer month , Integer day , Date date ){
		Calendar calendar = Calendar.getInstance();
		if(date == null){
			date = new Date();
		}
		if(year != null){
			date = updateDateByCondition(Calendar.YEAR, year, date, calendar);
		}
		if(month != null){
			date = updateDateByCondition(Calendar.MONTH, month, date, calendar);
		}
		if(day != null){
			date = updateDateByCondition(Calendar.DAY_OF_MONTH, day, date, calendar);
		}
		return date;
		
	}
	
	/**
	 * 根据条件更新时间
	 *	@author 	GFF
	 *	@date		2017年1月3日上午11:01:47	
	 * 	@param DateType		所需要计算的 年份或者月份或者天
	 * 	@param computeDate	指定年,月,日 后的时间
	 * 	@param date			所需要计算的时间（默认当前时间）
	 * 	@return
	 */
	public static Date updateDateByCondition(Integer DateType,Integer computeDate, Date date,Calendar calendar){
		if(date == null){
			date = new Date();
		}
		calendar.setTime(date);
		calendar.add(DateType, computeDate);
		return calendar.getTime();
		
	}
	
	/**
	 *	修改为指定的年月日 
	 *	@author 	GFF
	 *	@date		2017年1月5日下午1:31:48	
	 * 	@param date		需要修改的时间
	 * 	@param year		修改后的年份
	 * 	@param month	修改后的月份
	 * 	@param day		修改后的天
	 * 	@param hour		修改后的小时
	 * 	@return			修改后的时间
	 */
	public static Date updateDateByCondition(Date date,Integer year , Integer month , Integer day ,Integer hour){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(year != null){
			calendar.set(Calendar.YEAR, year);
		}
		if(month != null){
			calendar.set(Calendar.MONTH, month-1);
		}
		if(day != null){
			calendar.set(Calendar.DAY_OF_MONTH, day);
		}
		if(hour != null){
			calendar.set(Calendar.HOUR_OF_DAY, hour);
		}
		
		return calendar.getTime();
	}
	/**
	 * 	获取指定时间的年份或者月份或者天数
	 *	@author 	GFF
	 *	@date		2017年1月5日下午1:49:52	
	 * 	@param date		指定的时间
	 * 	@param field	calendar中的年月日对应的常量值
	 * 	@return
	 */
	public static Integer getInTimeYearORmonthORday(Date date,int field ){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(field);
	}
	
    /** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }  
    
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
          
        return currYearLast;  
    }  
  
}
