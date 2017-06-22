package com.pj.flow.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.web.controller.BaseController;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.service.FlowEntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/entry")
@Api(value="entry", description="入职申请", position=1)
public class EntryController extends BaseController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(EntryController.class); 
	@Resource
	private FlowEntryService flowEntryService;
	
	/**
	 * 	提交申请
	 */
	@ApiOperation(value = "提交入职申请", httpMethod = "POST", response=Map.class, notes ="提交入职申请")
	@RequestMapping("/commitEntry.do")
	@ResponseBody
	public Map<String , Object> commitEntry(@ModelAttribute("flowEntry")FlowEntry flowEntry){
		Map<String, Object> map;
		try {
			map = this.success(null);
		} catch (Exception e) {
			logger.error("异常" + e.getMessage());
			throw new RuntimeException("提交入职申请");
		}
		return map;
	}
	
	/**
	 * 去往添加页面
	 */
	@RequestMapping("/add.do")
	@ApiIgnore
	public String add(){
		return "entry/add";
	}
}
