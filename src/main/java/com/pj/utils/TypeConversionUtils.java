package com.pj.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author GFF
 * @date 2017年2月28日下午4:06:02
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class TypeConversionUtils {
	/**
	 * 	base转map
	 *	@author 	GFF
	 *	@date		2017年3月3日上午11:19:57	
	 * 	@param obj
	 * 	@return	map
	 * 	@throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if (obj == null)
			
			return null;
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (!field.getName().equals("serialVersionUID")) {
				field.setAccessible(true);
				Object object = field.get(obj);
				if (object != null && !"".equals(object)) {
					if(object instanceof List){
						List<Object> objs = jsonStringToListBase(object, Object.class);
						if(objs.size() != 0){
							map.put(field.getName(), object);
						}
					}/*else if(object instanceof Map){
						Map<String, Object> objMap = objectToMap(object);
						if(objMap.size() != 0){
							map.put(field.getName(), objMap);
						}
					}*/else{
						map.put(field.getName(), object);
					}
				}
			}
		}
		return map;
	}

	/**
	 * 	json转map
	 *	@author 	GFF
	 *	@date		2017年3月3日上午11:20:45	
	 * 	@param		jsonObject
	 * 	@return
	 */
	public static Map<String, Object> jsonToMap(JSONObject jsonObject) {
		 Map<String, Object> map = new HashMap<String, Object>();  
		 @SuppressWarnings("unchecked")
		Iterator<String> it = jsonObject.keys();  
		 String name;
			while (it.hasNext()) {
				name = it.next();
				map.put(name, jsonObject.getString(name));
			}
			return map;
		}
	
	/**
	 *  json集合字符串转list
	 *	@author 	GFF
	 *	@date		2017年3月3日上午11:22:19	
	 * 	@param 		jsonString
	 * 	@param 		clazz
	 * 	@return
	 */
	@SuppressWarnings("rawtypes")
	public static List jsonStringToListBase(Object jsonString, Class clazz) {
		if (jsonString != null) {
			List<Object> list = new ArrayList<>();
			JSONArray jsonArray = JSONArray.fromObject(jsonString);
			for (int i = 0; i < jsonArray.length(); i++) {
				Object o = jsonArray.get(i);
				JSONObject jsonObject2 = JSONObject.fromObject(o);
				Object bean = JSONObject.toBean(jsonObject2, clazz);
				list.add(bean);
			}
			return list;
		}
		return null;
	}
	
	/**
	 *  json字符串转base
	 *	@author 	GFF
	 *	@date		2017年3月3日上午11:23:18
	 * 	@param obj
	 * 	@param clazz
	 * 	@return
	 */
	@SuppressWarnings("rawtypes")
	public static Object jsonStringToBase(Object obj, Class clazz) {
		if (obj != null) {
			JSONObject object = JSONObject.fromObject(obj);
			return JSONObject.toBean(object, clazz);
		}
		return null;
	}
	
	/**
	 *  获取json字符串中的数据值
	 *	@author 	GFF
	 *	@date		2017年3月3日上午11:23:52	
	 * 	@param jsonObject
	 * 	@return
	 */
	public static Object jsonToString(JSONObject jsonObject) {
		if (jsonObject != null) {
			Map<String, Object> map = jsonToMap(jsonObject);
			Set<Entry<String, Object>> entrySet = map.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				if (entry.getKey().equals("data")) {
					return entry.getValue();
				}
			}
		}
		return null;

	}
}
