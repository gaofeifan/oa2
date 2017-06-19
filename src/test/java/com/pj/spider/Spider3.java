package com.pj.spider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author GFF
 * @date 2017年6月9日下午3:07:28
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class Spider3 {
	private static HttpClient httpClient = new HttpClient();

	/**
	 * @param path
	 *            目标网页的链接
	 * @return 返回布尔值，表示是否正常下载目标页面
	 * @throws Exception
	 *             读取网页流或写入本地文件流的IO异常
	 */
	public static boolean downloadPage(String path) throws Exception {
		// 定义输入输出流
		InputStream input = null;
		OutputStream output = null;
		// 得到 post 方法
		GetMethod getMethod = new GetMethod(path);
		getMethod.addRequestHeader("Cookie",
						  "aliyungf_tc=AQAAAKDyXRkzFggAMgGQ02JRSWBIOJeb;                                                                                                                  "
						+ "q_c1=617dc84e62c74f48867a359c8c569515|1496988742000|1496988742000;                                                                                             "
						+ "_xsrf=bdbdec3247a867cbac0743968b8f0c4e;                                                                                                                        "
						+ "d_c0=" + "AJDC74jy4guPTtaIjA5hP1pMXhj7WRdB-tI=|1496988743" + ";"
						+ "_zap=a796642d-5a4b-47ca-a654-faf5580f5f31;                                                                                                                     "
						+ "auth_type=cXFjb25u|1496988871|44186a9c595a5fa06edb1fd661969fbc92521d0d;                                                                                        "
						+ "token="
						+ "NEVGMDMxRDBFMTcyMDc0RkE0QTQ3NkU3MTYwMjk2RDM=|1496988871|8ec05cb0a7724dc5d2385f26eb84fdf8f1b1d6eb"
						+ ";" + "client_id="
						+ "MDJBQkYxMjBEMDZBMkY3OEJBRjVBQzQxMjMyMDY5QTM=|1496988871|7fdf7acf81021da98f437b8868b1703c7e93cff3"
						+ ";" + "r_cap_id="
						+ "ODY2ZmM2ZjA2Y2Q5NGIyYWI1MzFjODdlNTg3NGVjM2M=|1496997343|153afbf6e9a3338717e90bb0d08bd093c0868e99"
						+ ";" + "cap_id="
						+ "ODI4YjFhZWJlYTc4NGEyY2FiZjY0ZWM3YTQ4ZGMxOTE=|1496997343|80d4dd692712194297b7de1f6788b1fec19f4823"
						+ ";"
						+ "z_c0=Mi4wQUNBQTRoa0htd2tBa01MdmlQTGlDeGNBQUFCaEFsVk5qZXhoV1FEZEIzVUN0RTVTWEE2OHVOaFFoNGI2WDhDVFdn|1496997775|0cc3b76f04135972d097cefd9db2cb0905a8ab49;         "
						+ "__utma=51854390.1154561590.1496988516.1496988516.1496995337.2;                                                                                                 "
						+ "__utmb=51854390.0.10.1496995337;                                                                                                                               "
						+ "__utmc=51854390;                                                                                                                                               "
						+ "__utmz=51854390.1496995337.2.2.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/;"
						+ "__utmv=51854390.110--|2=registration_date=20160313=1^3=entry_date=20160313=1");
		// 执行，返回状态码 "
		int statusCode = httpClient.executeMethod(getMethod);
		// 针对状态码进行处理
		// 简单起见，只处理返回值为 200 的状态码
		if (statusCode == HttpStatus.SC_OK) {
			input = getMethod.getResponseBodyAsStream();
			// 通过对URL的得到文件名
			String filename = path.substring(path.lastIndexOf('/') + 1) + ".html";
			// 获得文件输出流
			output = new FileOutputStream(filename);
			// 输出到文件
			int tempByte = -1;
			while ((tempByte = input.read()) > 0) {
				output.write(tempByte);
			}
			// 关闭输入流
			if (input != null) {
				input.close();
			}
			// 关闭输出流
			if (output != null) {
				output.close();
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			// 抓取百度首页，输出
			//	获取某个标题
			boolean page = Spider2.downloadPage("https://www.zhihu.com/topic#Java");
			//	获取关注的所有话题
//			boolean page = Spider2.downloadPage("https://www.zhihu.com/topic");
			
//			Spider3.loadHtml("D:/topic#Java.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void loadHtml(String filePath){
		try {
			Document document = Jsoup.parse(new FileInputStream(filePath),"UTF-8", "https://www.zhihu.com");
			Elements elements = document.getElementsByClass("question_link");
			Elements elementsContent = document.getElementsByClass("content");
			for (int i = 0; i < elements.size(); i++) {
				
				System.out.println(elements.get(i).text());
				System.out.println("  "+(elementsContent.get(i).text()));
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static String re(String str){
		if(str.substring(0, 3).equals("<p>")){
			str = str.replaceAll("<p>", "");
		}
		if(str.contains("p>") || str.contains("b>")){
			int start = 0 ;
			int end = 0;
			for (int i = 0; i < str.length(); i++) {
				char charAt = str.charAt(i);
				if(charAt == '<'){
					start = i;
				}else if(charAt == '>'){
					end = i+1;
				}
				if(start != 0 && end != 0){
					String string = str.substring(start, end);
					str.replaceAll(string, "");
					re(str);
				}
			}
		}
		return str;
	}*/
}
