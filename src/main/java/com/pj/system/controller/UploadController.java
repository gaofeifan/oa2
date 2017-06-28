package com.pj.system.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pj.config.base.properties.ManageProperties;
import com.pj.config.web.controller.BaseController;
import com.pj.system.service.SessionProvider;
import com.pj.utils.FtpUtils;
import com.pj.utils.StringUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
//	@Resource
//	private UploadService uploadService;
	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class); 
	@Resource
	private SessionProvider sessionProvider;
	@Autowired
	private ManageProperties manageProperties;
	
	/**
	 * 附件上传
	 * @param pic
	 * @throws Exception 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value="/uploadPic.do",method={RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "附件上传", httpMethod = "GET", response=Map.class, notes ="附件上传")
	@ResponseBody
	public MappingJacksonValue uploadPic(@ApiParam("上传的文件") @RequestParam("filePic")MultipartFile[] filePic, HttpServletResponse response ,HttpServletRequest request) throws FileNotFoundException, IOException, Exception{
		MappingJacksonValue success = null;
		List<String> pics = new ArrayList<>();
		try {
			for (MultipartFile myfile : filePic) {
				if (myfile.isEmpty()) {
				} else {
					DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					String picName = df.format(new Date());
					// 随机再生成3位 10以内的数
					Random r = new Random();
					for (int i = 0; i < 3; i++) {
						picName += r.nextInt(10);
					}
					// 重置文件名
					long time = System.currentTimeMillis();
					String timeStr = String.valueOf(time);
					String[] originalFileName = myfile.getOriginalFilename().split("\\.");
					@SuppressWarnings("unused")
					String fileName = timeStr + "." + originalFileName[1];
					String picPath = FtpUtils.uploadFile(picName,
							myfile.getOriginalFilename(), myfile.getInputStream(),manageProperties.ftpProperties);
					if (picPath != null) {
						if(filePic.length == 1){
							success = this.successJsonp(picPath);
							return success;
						}else{
							pics.add(picPath);
						}
					}
				}
			}
			success = this.successJsonp(pics.toString());
		} catch (Exception e) {
			logger.error("上传文件异常"+ e.getMessage());
			success = this.errorToJsonp("上传文件异常");
			throw new RuntimeException("操作资源异常");		}
		return success;
	}
	@ApiOperation(value = "附件下载", httpMethod = "POST", response=Map.class, notes ="加载 公司  和职位信息")
	@RequestMapping(value="/downloadFtp.do" , method={RequestMethod.POST,RequestMethod.GET})  
	public void downloadFtp(@ApiParam("文件名称") @RequestParam("downloadName") String downloadName ,HttpServletResponse response , HttpServletRequest request){
		String[] strings = downloadName.split("-------");
		String path = strings[0];
		String fileName = strings[1];
		if(path == null){
			path = "";
		}
         try {
        	 fileName = StringUtils.toUtf8String(request, fileName, response);
        	 FtpUtils.downloadFile(path, fileName,new BufferedOutputStream( response.getOutputStream()) , manageProperties.ftpProperties);
        	 response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        	 response.setContentType("application/x-msdownload;");  
			response.setHeader("Content-disposition", "attachment; filename="  
			         + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(path));  
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("上传下载异常"+ e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传下载异常"+ e.getMessage());
		}
		
		
	}
	 
	@RequestMapping(value="/download.do" , method=RequestMethod.GET)  
	public void download(@RequestParam("fileName")
	    String fileName, HttpServletRequest request, HttpServletResponse response)  
	            throws Exception {  
	  
	        response.setContentType("text/html;charset=utf-8");  
	        request.setCharacterEncoding("UTF-8");  
	        java.io.BufferedInputStream bis = null;  
	        java.io.BufferedOutputStream bos = null;  
	  
	        String ctxPath = request.getSession().getServletContext().getRealPath(  
	                "/")  
	                + "/" + "WEB-INF/" + "images/";  
	        String downLoadPath = ctxPath + fileName;  
	        System.out.println(downLoadPath);  
	        try {  
	            long fileLength = new File(downLoadPath).length();  
	            StringUtils.downloadEncoding(request, fileName);
	            response.setHeader("Content-Length", String.valueOf(fileLength));  
	            bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	            bos = new BufferedOutputStream(response.getOutputStream());  
	            byte[] buff = new byte[2048];  
	            int bytesRead;  
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	                bos.write(buff, 0, bytesRead);  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            logger.error("下载异常"+ e.getMessage());
	        } finally {  
	            if (bis != null){
	            	bis.close();  
	            }  
	            if (bos != null){
	            	bos.close();  
	            }  
	        }  
	    }  
	
	@RequestMapping(value="/getFTPPic.do",method={RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "获取ftp图片", httpMethod = "GET", response=Map.class, notes ="获取ftp图片")
	@ResponseBody
	public Map<String, Object> getFTPPic(@ApiParam("图片路径") @RequestParam("url")String url) {
		String[] strings = url.split(",");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			if(string.contains("-------")){
				String[] urls = string.split("-------");
				sb.append(manageProperties.ftpProperties.getUrl()+ urls[0]+"/" + urls[1]);
			}
		}
		return this.success(sb.toString());
	}
}