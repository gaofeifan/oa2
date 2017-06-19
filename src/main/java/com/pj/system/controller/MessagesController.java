package com.pj.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.system.pojo.Message;
import com.pj.system.pojo.User;
import com.pj.system.service.MessageService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="message", description="消息通知", position=1)
@Controller
@RequestMapping("/message")
public class MessagesController extends BaseController {
	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(MessagesController.class); 
	@Resource
	private MessageService messageService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private SessionProvider sessionProvider;
	
	/**
	 * 
	 * 根据查询条件查询消息列表
	 * @param message
	 * @return
	 */
	@ApiOperation(value = "根据查询条件查询消息列表", httpMethod = "GET", response=Map.class, notes ="根据查询条件查询消息列表")
	@RequestMapping(value = "/list.do",produces = "application/json;charset=utf-8")
	@ResponseBody
	public MappingJacksonValue listAll(String callback,@ApiParam(value="通知类型(1,入职 ， 2，离职  3 请假，4，转正，5，异动，6，续签 ) ") @RequestParam(value = "type",defaultValue="") String type , HttpServletRequest request , HttpServletResponse response,@RequestParam(value="key",required= false) String key){
		Map<String, Object> map = new HashMap<String, Object>();
		String ug = request.getHeader("user-agent").toLowerCase();
		MappingJacksonValue mjv = null;
		String email = "";
		try {
			if(StringUtils.isNotBlank(key) && ug.indexOf("micromessenger")>0){
				String emailKey = key.split(":")[0];
				email = sessionProvider.getAttibute(emailKey);
			}else{
				email = sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			}
			User user = this.userService.selectByemail(email);
			Integer userid = user.getId();
			List<Message> messages = messageService.findMessageList(type , userid);
			map = this.success(messages);
		} catch (Exception e) {
			logger.error("查询消息列表异常信息：：：" + e.getMessage());
			map = this.error(e.getMessage());
		}
		mjv = new MappingJacksonValue(map);
		mjv.setJsonpFunction(callback);
		map.put("key", key);
    	return mjv;
	}
	/**
	 * 
	 * 获取消息类型对应的数量
	 * @param message
	 * @return
	 */
	@ApiOperation(value = "获取消息类型对应的数量", httpMethod = "GET", response=Map.class, notes ="根据查询条件查询消息列表")
	@RequestMapping(value = "/getMessageTypeAndNumber.do",produces = "application/json;charset=utf-8")
	@ResponseBody
	public MappingJacksonValue getMessageTypeAndNumber(String callback,@ApiParam(value="通知类型(1,入职 ， 2，离职  3 请假，4，转正，5，异动，6，续签 ) ") @RequestParam(value = "type",defaultValue="") String type , HttpServletRequest request , HttpServletResponse response,@RequestParam(value="key",required= false) String key){
		Map<String, Object> map = new HashMap<String, Object>();
		String ug = request.getHeader("user-agent").toLowerCase();
		MappingJacksonValue mjv = null;
		String email = "";
		try {
			if(StringUtils.isNotBlank(key) && ug.indexOf("micromessenger")>0){
				String emailKey = key.split(":")[0];
				email = sessionProvider.getAttibute(emailKey);
				logger.info("通过客户端传递key获取email");
			}else{
				email = sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
				logger.info("通过cookie获取当前登录用户");
			}
			User user = this.userService.selectByemail(email);
			Integer userid = user.getId();
			Map<String, Object> typeNumber = messageService.getMessageTypeAndNumber(type , userid);
			logger.info("获取消息的未读类型与数量");
			map = this.success(typeNumber);
		} catch (Exception e) {
			logger.error("查询消息列表异常信息：：：" + e.getMessage());
			map = this.error(e.getMessage());
		}
		mjv = new MappingJacksonValue(map);
		mjv.setJsonpFunction(callback);
		map.put("key", key);
		return mjv;
	}
	@ApiOperation(value = "消息详情", httpMethod = "GET", response=Map.class, notes ="消息详情")
	@RequestMapping(value = "/getMessageDetails.do")
	@ResponseBody
	public MappingJacksonValue getMessageDetails(String callback,@ApiParam("message") @ModelAttribute("message")Message message,HttpServletRequest request ,HttpServletResponse response,@RequestParam(value="key",required= false) String key){
		Map<String, Object> success = new HashMap<>();
		String ug = request.getHeader("user-agent").toLowerCase();
		MappingJacksonValue mjv = null;
		String email = "";
		try {
			if(StringUtils.isNotBlank(key) && ug.indexOf("micromessenger")>0){
				String emailKey = key.split(":")[0];
				email = sessionProvider.getAttibute(emailKey);
			}else{
				email = sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			}
			User u= this.userService.selectByemail(email);
			User user = messageService.getMessageDetails(message,u);
			success = this.success(user);
		} catch (Exception e) {
			logger.error("消息详情异常信息：：：" + e.getMessage());
			success = this.error(e.getMessage());
		}
		success.put("key", key);
		mjv = new MappingJacksonValue(success);
		mjv.setJsonpFunction(callback);
		return mjv;
	}
}
