package com.pj.config.base.tool;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.pj.config.base.service.BaseService;

/**
 * @author GFF
 * @date 2017年6月6日下午2:43:57
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Component
public class NumberTool {
	
	@SuppressWarnings("rawtypes")
	public String getSingleNumber(BaseService baseService , int num) {
		if (baseService != null) {
			String number = baseService.selectEndNumber();
			if(StringUtils.isBlank(number)){
				throw new RuntimeException("不存在该类型的编号请进行初始化");
			}
			return getNumber(number, num);
		}
		return null;
	}

	/**
	 * 	截取字符串中的数字   从第一个不是0的数字开始截取
	 *	@author 	GFF
	 *	@date		2017年6月6日下午4:02:46	
	 * 	@param number
	 * 	@return
	 */
	private StringBuilder subNumber(String number) {
		StringBuilder sb = new StringBuilder(number);
		for (int i = 0; i < sb.length(); i++) {
			char str = sb.charAt(i);
			if(str >= 49 && str <= 57){
				return new StringBuilder(Integer.decode(sb.substring(i)) + 1+"");
			}
		}
		return null;
	}

	/**
	 * 	设置编号的长度
	 *	@author 	GFF
	 *	@date		2017年6月6日下午4:05:46	
	 * 	@param number
	 * 	@param num
	 * 	@return
	 */
	private String getNumber(String number , int num){
		StringBuilder sb = subNumber(number);
		for (int i = sb.length(); i < num; i++) {
			sb.insert(0, '0');
		}
		return sb.toString();
	}
	
}
