package com.pj.system.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.timer.MessageTimer;
import com.pj.config.base.tool.JedisTool;
import com.pj.config.web.controller.BaseController;
import com.pj.system.pojo.User;
import com.pj.system.service.UserService;
import com.pj.utils.QRCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="accesstoken",description="微信公众平台")
@Controller
@RequestMapping("/weiXin")
public class WeiXinController extends BaseController {
//	@Resource
//	private WeiXinService weiXinService;
	
	@Resource
	private JedisTool jedisTool;
	
	@Resource
	private UserService userService;
	
	private static Logger log = Logger.getLogger(WeiXinController.class.getName());
	@ApiOperation(value="同步微信账号" ,httpMethod="GET")
	@RequestMapping(value = "/authorization",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getOAuthAccessToken(HttpServletRequest request , HttpServletResponse response , String email){
	    //	TODO 获取当前登录用户
		String[] strings = email.split(",");
		Integer version = null;
		if(strings.length > 0){
			email = strings[0];
			version = Integer.decode(strings[1]);
		}else{
			return "二维码异常";
		}
		String value = this.jedisTool.getStringData(JedisTool.WEI_XIN_QR_CODE_VERSION+":"+email,null);
		if(StringUtils.isNotBlank(value) || version != Integer.decode(value)){
			return "二维码已过期";
		}
	    try {
			request.setCharacterEncoding("utf-8"); 
			String code = request.getParameter("code");
			log.info("code:"+code);
//	    	userService.saveWeiXinUserMessage(useValue.AppId, useValue.AppSecret,code,email);
	    	log.info("WeiXinController.getOAuthAccessToken 同步微信账号成功");
		} catch (Exception e) {
			log.error("绑定微信账号异常:"+e.getMessage());
			throw new RuntimeException("绑定微信账号异常:"+e.getMessage());
		}
		return "绑定成功";
	}
	@ApiOperation(value="获取token" ,httpMethod="GET")
	@RequestMapping(value = "/token",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public void getaccess_token(){
		String accesstoken = this.jedisTool.getAccesstoken();
		System.out.println(accesstoken);
	}
	@ApiOperation(value="微信登录" ,httpMethod="GET")
	@RequestMapping(value = "/weiXinLogin",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> weiXinLogin(HttpServletRequest request , HttpServletResponse response){
		MessageTimer messageTimer= new MessageTimer();
				messageTimer.deleteQRCode(request);
		return null; 
	}
	
	@ApiOperation(value="获取绑定二维码" ,httpMethod="GET")
	@RequestMapping(value = "/getQRCode",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> getQRCode(HttpServletRequest request ,HttpServletResponse response ,@RequestParam("email")String email){
		int version = 1;
		String ctxPath = null;
		String filename = null;
		try {
			String reVersion = this.jedisTool.getStringData(JedisTool.WEI_XIN_QR_CODE_VERSION+":"+email,0);
			if(StringUtils.isNotBlank(reVersion)){
				version = (Integer.decode(reVersion))+version;
			}
			this.jedisTool.setStringData(JedisTool.WEI_XIN_QR_CODE_VERSION+":"+email, version+"", 5);
			email = email + "," +version;
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx17f788165832cdc9&redirect_uri=http%3A%2F%2Fpjhighurl3.tunnel.qydev.com%2Foa%2FweiXin%2Fauthorization?email=" + email + "&response_type=code&scope=snsapi_userinfo&state=state#wechat_redirect";
			 ctxPath = request.getSession().getServletContext().getRealPath("tempPic");
			 log.info("文件上传路径 ："+ctxPath);
			filename = QRCodeUtil.encode(url, ctxPath, false);
			log.info("获取二维码 ："+filename);
			return  this.success("10.0.0.127:8080/"+request.getContextPath()+"/tempPic"+"/"+filename);
		} catch (Exception e) {
			log.error("获取二维码异常"+ e.getMessage());
			return  this.error("获取二维码异常"+ e.getMessage());
		}
	}
	@ApiOperation(value="查询是否绑定二维码" ,httpMethod="GET")
	@RequestMapping(value = "/getIsBindingQrCode",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> getIsBindingQrCode(HttpServletRequest request ,HttpServletResponse response ,@RequestParam("email")String email){
		Map<String, Object> success = null;
		User user = this.userService.findUserByCondition(new User(email), false);
		if(StringUtils.isNotBlank(user.getWeChatName())){
			success = this.success(user.getWeChatName());
		}else{
			success = this.success(null);
		}
		return success;
	}
}
