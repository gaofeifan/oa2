package com.pj.message.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.message.pojo.MessageContent;
import com.pj.message.pojo.MessageContentUser;
import com.pj.message.service.MessageContentService;
import com.pj.message.service.MessageContentUserService;
import com.pj.system.pojo.User;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
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
	private Logger logger = LoggerFactory.getLogger(MessageContentController.class); 
	@Resource
	private  MessageContentService  messageContentService;
	@Resource
	private SessionProvider sessionProvider;
	@Resource
	private MessageContentUserService messageContentUserService;
	@Resource
	private UserService userService;
	
	@ApiOperation(value = "消息查询", httpMethod = "GET", response = MappingJacksonValue.class)
	@RequestMapping(value="/selectMessageAll.do" , method=RequestMethod.GET)
	public @ResponseBody MappingJacksonValue selectMessageAll(@ApiParam("消息类型 1(默认)申请已发送 2申请以审批") @RequestParam(name="notificationType",defaultValue="1",required=false) Integer notificationType ,HttpServletResponse response, HttpServletRequest request){
		try {
			//得到当前登录用户
			String email =
					this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request,response));
			logger.debug("【MessageContentController.selectMessageAll】  邮箱"+email);
			List<MessageContent> list = this.messageContentService.selectMessageAllByEamilAndNotificationType(email, notificationType);
			return this.successJsonp(list);
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp(e.getMessage());
		}
	}

	@ApiOperation(value = "查询是否有未查看的消息", httpMethod = "GET", response = MappingJacksonValue.class)
	@RequestMapping(value="/selectMessageIsFind.do" , method=RequestMethod.GET)
	public @ResponseBody MappingJacksonValue selectMessageIsFind(){
		try {
			//得到当前登录用户
			String email = this.getSession();
			User user = this.userService.selectByEamil(email);
			logger.debug("【MessageContentController.selectMessageAll】  邮箱"+email);
			List<MessageContentUser> list = this.messageContentUserService.select(new MessageContentUser(user.getId(), null, 0));
			if(list.size() > 0){
				return this.successJsonp(true);
			}
			return this.successJsonp(false);
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp(e.getMessage());
		}
	}
}
