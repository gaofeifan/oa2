package com.pj.message.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.message.pojo.MessageContent;
import com.pj.message.service.MessageContentService;

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
	
	@RequestMapping(value="/selectMessageAll.do" , method=RequestMethod.GET)
	@ApiOperation(value = "消息查询", httpMethod = "GET", response = MappingJacksonValue.class)
	public @ResponseBody MappingJacksonValue selectMessageAll(@ApiParam("消息类型 0(默认)申请已发送  1申请以审批") @RequestParam(name="notificationType",defaultValue="0",required=false) Integer notificationType){
		try {
			List<MessageContent> list = this.messageContentService.selectMessageAllByEamilAndNotificationType( getSession() , notificationType);
			return this.successJsonp(list);
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp(e.getMessage());
		}
	}
}
