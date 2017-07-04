package com.pj.message.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;
import com.pj.system.service.SessionProvider;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *	@author		GFF
 *	@date		2017年6月26日下午2:43:48
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Controller
@RequestMapping("/message/content")
public class MessageContentController extends BaseController {

	@Resource
	private  MessageContentService  messageContentService;
	@Resource
	private SessionProvider sessionProvider;
	@ApiOperation(value = "消息查询", httpMethod = "GET", response = MappingJacksonValue.class)
	@RequestMapping(value="/selectMessageAll.do" , method=RequestMethod.GET)
	public @ResponseBody MappingJacksonValue selectMessageAll(@ApiParam("消息类型 1(默认)申请已发送 2申请以审批") @RequestParam(name="notificationType",defaultValue="1",required=false) Integer notificationType ,HttpServletResponse response, HttpServletRequest request){
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request,response));
			List<MessageContent> list = this.messageContentService.selectMessageAllByEamilAndNotificationType(email, notificationType);
			return this.successJsonp(list);
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp(e.getMessage());
		}
	}
}
