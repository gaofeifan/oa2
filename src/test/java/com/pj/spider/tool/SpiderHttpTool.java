package com.pj.spider.tool;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;

/**
 *	@author		GFF
 *	@date		2017年6月12日上午10:08:09
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class SpiderHttpTool {
	private static HttpClient httpClient = new HttpClient();

	/**
	 * @param path
	 *            目标网页的链接
	 * @return 返回布尔值，表示是否正常下载目标页面
	 * @throws Exception
	 *             读取网页流或写入本地文件流的IO异常
	 */
	public boolean postAndCookie(String path,String cookie,Map<String,Object> map) throws Exception {
		// 得到 post 方法
		GetMethod getMethod = new GetMethod(path);
		if(StringUtils.isNotBlank(cookie)){
			getMethod.addRequestHeader("Cookie",cookie);
		}
		if(map != null){
			HttpMethodParams params = new HttpMethodParams();
//			String json = JSONObject.fromBean(map).toString();
			Set<Entry<String,Object>> entrySet = map.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				params.setParameter(entry.getKey(), entry.getValue());
			}
			getMethod.setParams(params);
		}
		// 执行，返回状态码 "
		int statusCode = httpClient.executeMethod(getMethod);
		// 针对状态码进行处理
		// 简单起见，只处理返回值为 200 的状态码
		if (statusCode == HttpStatus.SC_OK) {
			setResource(getMethod.getResponseBodyAsStream(),path);
			return true;
		}
		return false;
	}
	/**
	 * @param path
	 *            目标网页的链接
	 * @return 返回布尔值，表示是否正常下载目标页面
	 * @throws Exception
	 *             读取网页流或写入本地文件流的IO异常
	 */
	public boolean post(String path,Map<String,Object> map) throws Exception {
		return this.postAndCookie(path, null,map);
	}
	

	private void setResource(InputStream input , String path) {
		// 通过对URL的得到文件名
		String filename = path.substring(path.lastIndexOf('/') + 1) + ".html";
		// 获得文件输出流
	    OutputStream output = null;
		try {
			output = new FileOutputStream(filename);
			int tempByte = -1;
			while ((tempByte = input.read()) > 0) {
				output.write(tempByte);
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 输出到文件
			// 关闭输入流
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
