package com.pj.utils;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.pj.flow.pojo.FlowOffer;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年6月30日下午4:24:02
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class OfferUtils {

	/**
	 * 	将offer模板中的内容替换
	 *	@author 	GFF
	 *	@date		2017年6月27日上午11:40:42	
	 * 	@param offerTemp
	 * 	@param offer
	 * 	@return
	 */
	public static String replaceOfferContent(String offerTemp, FlowOffer offer) {
		Class<? extends FlowOffer> clazz = offer.getClass();
		Field[] fields = clazz.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				boolean b = field.isAnnotationPresent(ApiModelProperty.class);
				if (b) {
					Object fileValue = field.get(offer);
					if (fileValue != null) {
						if(fileValue instanceof  Date ){
							Date date = (Date)fileValue;
							fileValue = DateUtils.convert(date, DateUtils.DATE_FORMAT_C);
						}
						ApiModelProperty api = field.getDeclaredAnnotation(ApiModelProperty.class);
						String notes = api.notes();
						if(StringUtils.isNoneBlank(notes)){
							offerTemp = offerTemp.replaceAll(notes, fileValue.toString());
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return offerTemp;
	}
}
