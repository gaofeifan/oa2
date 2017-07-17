package com.pj.system.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.pj.system.pojo.Education;
import com.pj.system.pojo.FamilyMember;
import com.pj.system.pojo.Salary;
import com.pj.system.pojo.WorkExperience;
import com.pj.system.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;

/**
 *	@author		GFF
 *	@date		2017年7月17日上午11:15:14
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@SuppressWarnings("unchecked")
public class GetJsonFileUtils {
	
	public static List<Education> getEducationList(){
		JSONArray jsonArray = getResourceJson("/json/educationJson.json");
		return JSONArray.toList(jsonArray, Education.class);
	}
	public static List<FamilyMember> getFamilyMembers(){
		JSONArray jsonArray = getResourceJson("/json/familyMembersJson.json");
		return JSONArray.toList(jsonArray, FamilyMember.class);
	}
	public static List<Salary> getSalary(){
		JSONArray jsonArray = getResourceJson("/json/salaryJson.json");
		return JSONArray.toList(jsonArray, Salary.class);
	}
	
	
	public static List<WorkExperience> getWorkExperience(){
		JSONArray jsonArray = getResourceJson("/json/workExperienceJson.json");
		return JSONArray.toList(jsonArray, WorkExperience.class);
	}
	
	public static JSONArray getResourceJson(String path){
		InputStream inputStream = UserServiceImpl.class.getResourceAsStream(path);
		InputStreamReader iReader;
		StringBuilder sb = new StringBuilder();
		try {
			iReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(iReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char charAt = line.charAt(i);
					sb.append(charAt);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return JSONArray.fromObject(sb.toString());
	}
}
