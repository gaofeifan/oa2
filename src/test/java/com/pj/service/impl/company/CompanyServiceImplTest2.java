package com.pj.service.impl.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.config.base.tool.HttpClienTool;
import com.pj.system.pojo.Company;
import com.pj.system.service.CompanyService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class CompanyServiceImplTest2 {

	@Resource
	private CompanyService companyService;
	
	@Test
	public void testFindCompanyById() {
		Company company = this.companyService.selectByPrimaryKey(1);
		System.out.println(company);
	}

	@Test
	public void testUpdateCompany() {
		Company company = new Company();
		company.setId(2);
		company.setAddress("广州");
		this.companyService.updateByPrimaryKeySelective(company );
	}

	@Test
	public void testFindAllCompant() {
		List<Company> compant = this.companyService.selectAll();
		for (Company company : compant) {
			System.out.println(company);
		}
		
	}

	@Test
	public void testIsDelete() {
		this.companyService.deleteByPrimaryKey(2);		
	}
	
	
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			Map<String, Object> ma = new HashMap<String, Object>();
			ma.put("pageNo", i);
			String string = doGet("http://139.129.236.180:8080/oa/user/list.do", ma );
			JSONArray fromString = JSONArray.fromString(string);
			for (int j = 0; j < fromString.length(); j++) {
				JSONArray array = fromString.getJSONArray(i);
				System.out.println(array);
			}
			
		}
		
	}
	
	public static String doGet(String uri, Map<String, Object> map) {
		List<NameValuePair> params = getUrlParams(map);
		CloseableHttpResponse res = null;
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		try {
			HttpGet get = new HttpGet(new URIBuilder(uri).addParameters(params).build());
			res = httpclient.execute(get);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				EntityUtils.toString(res.getEntity());
				return "200";
			}
		} catch (Exception e) {
		} finally {
			// 关闭连接 ,释放资源
			try {
				if(httpclient != null){
					httpclient.close();
				}
				if(res != null){
					res.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static List<NameValuePair> getUrlParams(Map<String, Object> map){
		Set<Entry<String,Object>> entrySet = map.entrySet();
		List<NameValuePair> pairs = new ArrayList<NameValuePair>(); 
		for (Entry<String, Object> entry : entrySet) {
			if(entry.getValue() != null){
				if(!(entry.getValue() instanceof Date)){
					pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}else{
					pairs.add(new BasicNameValuePair(entry.getKey(), com.pj.utils.DateUtils.convert((Date) entry.getValue(),  com.pj.utils.DateUtils.DATE_TIME_FORMAT)));
				}
			}
		}
		return pairs;
	}

}
