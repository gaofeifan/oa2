package com.pj.system.service; 
/** 
* @author 作者 E-mail: 
* @version 创建时间：2016年9月1日 上午9:17:06 
* 类说明 
*/
public interface SessionProvider {

	//保存用户名到redis
	public void setAttribute(String key,String value);
	
	//获取出用户名
	public String getAttibute(String key);
	
}
 