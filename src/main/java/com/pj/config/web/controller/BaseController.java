package com.pj.config.web.controller;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.pj.system.service.SessionProvider;
import com.pj.utils.RequestUtils;
/**
 * 
 * 项目名称：oa   
 * 类名称：BaseController   
 * 类描述：   
 * 创建人：limr   
 * 创建时间：2016年8月2日 上午10:17:01   
 * 修改人：limr   
 * 修改时间：2016年8月2日 上午10:17:01   
 * 修改备注：   
 * @version    
 *
 */

public class BaseController extends AdvanceControllerSupport{

	@Autowired
	private SessionProvider sessionProvider;
	
	protected Logger logger = LoggerFactory.getLogger(BaseController.class); 
	public Map<String,Object> success(Object data){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",true);
		datas.put("msg","操作成功！");
		datas.put("code","200");
		datas.put("data",data);
		return datas;
	}
	public Map<String,Object> success(){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",true);
		datas.put("msg","操作成功！");
		datas.put("code","200");
		return datas;
	}

	public MappingJacksonValue successJsonp(Object obj){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",true);
		datas.put("msg","操作成功！");
		datas.put("code","200");
		datas.put("data",obj);
		MappingJacksonValue mjv = new MappingJacksonValue(datas);
		mjv.setJsonpFunction(getCallBack());
		return mjv;
	}
	
	public Map<String,Object> error(){
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("status",false);
		data.put("msg","操作失败！");
		data.put("code","400");
		return data;
	}
	
	public MappingJacksonValue errorToJsonp(){
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("status",false);
		data.put("msg","操作失败！");
		data.put("code","400");
		MappingJacksonValue mjv = new MappingJacksonValue(data);
		mjv.setJsonpFunction(getCallBack());
		return mjv;
	}

	public MappingJacksonValue errorToJsonp(Object data){
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("status",false);
		map.put("msg",data);
		map.put("code","400");
		MappingJacksonValue mjv = new MappingJacksonValue(map);
		mjv.setJsonpFunction(getCallBack());
		return mjv;
	}
	
	public Map<String,Object> error(Object data){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",false);
		datas.put("msg",data);
		datas.put("code","400");
		datas.put("data",data);
		return datas;
	}
	
	/**
	 * 	获取当前session中的信息
	 *	@author 	GFF
	 *	@date		2017年6月6日下午1:46:11	
	 * 	@return
	 */
	public String getSession(){
		String ua  = buildPipelineContent().getRequest().getHeader("user-agent").toLowerCase();
		String key = buildPipelineContent().getRequest().getParameter("key");
		if(StringUtils.isNotBlank(key) && ua.indexOf("micromessenger") > 0){
			String emailKey = key.split(":")[0];
			return sessionProvider.getAttibute(emailKey);
		}
		return sessionProvider.getAttibute(RequestUtils.getCSESSIONID(buildPipelineContent().getRequest(), buildPipelineContent().getResponse()));
	}
	
	/**
	 * 	获取当前callback
	 *	@author 	GFF
	 *	@date		2017年6月6日下午1:46:11	
	 * 	@return
	 */
	public String getCallBack(){
		return buildPipelineContent().getRequest().getParameter("callback");
	}
	
	
	
}
