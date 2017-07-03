package com.pj.spider;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pj.spider.tool.SpiderHttpTool;

import net.sf.json.JSONObject;

/**
 * @author GFF
 * @date 2017年6月9日下午3:07:28
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class SpiderTest {
	private static SpiderHttpTool httpTool = new SpiderHttpTool();
	
	private static String cookie = "aliyungf_tc=AQAAAKDyXRkzFggAMgGQ02JRSWBIOJeb;                                                                                                                  "
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
			+ "__utmv=51854390.110--|2=registration_date=20160313=1^3=entry_date=20160313=1";
	
	public static void main(String[] args) {
//		getTitle();
//		findTitleDetails();
//		jsoupTest();
		laGou();
	}
	
	private static void getTitle(){
		try {
			boolean b = httpTool.postAndCookie("https://www.zhihu.com/topic", cookie,null);
			if(b){
				System.out.println("已爬出资源");
			}else{
				System.out.println("失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void findTitleDetails(){
		try {
			Map<String, Object> map = new HashMap<>();
			JSONObject object = new JSONObject();
			object.set("offset", "0");                 
			object.set("topic_id", "10033");           
			object.set("feed_type", "smart_feed");  
			map.put("params", object.toString());
			map.put("method", "next");
			boolean b = httpTool.postAndCookie("https://www.zhihu.com/node/TopicFeedList",cookie,map );
			if(b){
				System.out.println("已爬出资源");
			}else{
				System.out.println("失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void jsoupTest(){
		try {
			String fileName ="E:\\zhihu\\";
			File file = null;
			Document document = zhihuTopics("https://www.zhihu.com/topics");
			Elements elements = document.getElementsByClass("zm-topic-cat-item");
			for (Element element : elements) {
				fileName += element.text()+"\\";
				Document documentTopics = zhihuTopics("https://www.zhihu.com/topics#"+element.text());
				Elements elementsDiv = documentTopics.getElementsByClass("item");
				for (Element div : elementsDiv) {
					Elements tag = div.getElementsByTag("strong");
					String href = div.select("a").first().attr("href");
					fileName += tag.text();
					href = spilt(href);
					Document detailsDocument = zhihuTopics("https://www.zhihu.com/topic/"+href+"/hot");
					Elements details = detailsDocument.getElementsByClass("feed-content");
					for (Element detail : details) {
						Elements aClass = detail.getElementsByClass("question_link");
						file = new File(fileName);
						if(!file.exists()){
							file.mkdirs();
						}
						file = new File(file, aClass.text()+".txt");
						file.createNewFile();
						href = detail.select("a").first().attr("href");
						href = spilt(href);
						Document hrefsFiles = zhihuTopics("https://www.zhihu.com/question/"+href);
						PrintStream printStream = new PrintStream(file);
						Elements hrefsFileClass = hrefsFiles.getElementsByClass("RichText");
						for (Element hrefsFile : hrefsFileClass) {
							System.out.println(hrefsFile.text()+"\r\n");
							printStream.append(hrefsFile.text()+"\r\n");
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void laGou(){
		String cookie = "20170613091748-1cbfaa36-4fd6-11e7-9af2-5254005c3644";
		try {
			String fileName ="E:\\lagou\\";
			File file = null;
			Document document = laGouCookie("https://www.lagou.com/", cookie);
			Elements elements = document.getElementsByClass("mainNavs");
			for (Element element : elements) {
				Elements titleAEles = element.getElementsByTag("a");
				for (Element titleAEle : titleAEles) {
					System.out.println(titleAEle.text());
					System.out.println(titleAEle.attr("href"));
				}
				
		/*		fileName += element.text()+"\\";
				Document documentTopics = zhihuTopics("https://www.zhihu.com/topics#"+element.text());
				Elements elementsDiv = documentTopics.getElementsByClass("item");
				for (Element div : elementsDiv) {
					Elements tag = div.getElementsByTag("strong");
					String href = div.select("a").first().attr("href");
					fileName += tag.text();
					href = spilt(href);
					Document detailsDocument = zhihuTopics("https://www.zhihu.com/topic/"+href+"/hot");
					Elements details = detailsDocument.getElementsByClass("feed-content");
					for (Element detail : details) {
						Elements aClass = detail.getElementsByClass("question_link");
						file = new File(fileName);
						if(!file.exists()){
							file.mkdirs();
						}
						file = new File(file, aClass.text()+".txt");
						file.createNewFile();
						href = detail.select("a").first().attr("href");
						href = spilt(href);
						Document hrefsFiles = zhihuTopics("https://www.zhihu.com/question/"+href);
						PrintStream printStream = new PrintStream(file);
						Elements hrefsFileClass = hrefsFiles.getElementsByClass("RichText");
						for (Element hrefsFile : hrefsFileClass) {
							System.out.println(hrefsFile.text()+"\r\n");
							printStream.append(hrefsFile.text()+"\r\n");
						}
					}
				}*/
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Document zhihuTopics(String url) throws IOException{
		Document document = Jsoup.connect(url)
				.cookie("Cookie", cookie)
				.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
				.get();
		return document;
	}
	public static Document laGouCookie(String url,String cookie) throws IOException{
		Document document = Jsoup.connect(url)
				.cookie("Cookie", cookie)
				.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
				.get();
		return document;
	}
	
	private static String spilt(String str){
		String[] strings = str.split("/");
		return strings[strings.length-1];
	}
}