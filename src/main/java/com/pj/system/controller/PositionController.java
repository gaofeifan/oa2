package com.pj.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.tool.NumberTool;
import com.pj.config.web.controller.SystemManageController;
import com.pj.system.pojo.Position;
import com.pj.system.service.PositionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 职位
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/Position")
@Api(value="Position", description="职位", position=11)
public class PositionController extends SystemManageController {
	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(PositionController.class); 
	@Resource
	private PositionService positionService;
	
	@Resource
	private NumberTool numberUtils;
	
	/**
	 * 	获取职位number
	 */
	@ApiOperation(value = "获取职位number", httpMethod = "GET", response=Map.class, notes ="获取职位number")
	@RequestMapping("/getPositionNumber.do")
	@ResponseBody
	public Map<String , Object> getPositionNumber(){
		Map<String, Object> map;
		try {
			String number = this.numberUtils.getSingleNumber(positionService, four);
			map = this.success(number);
		} catch (Exception e) {
			logger.error("获取职位单号异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return map;
	}
	
	/**
	 *	去往添加页面
	 */
	@ApiIgnore
	@RequestMapping("/add.do")
	public String add(){
		return "position/add";
	}
	
	/**
	 *	添加职位
	 */
	@ResponseBody
	@ApiOperation(value = "添加职位", httpMethod = "POST", response=String.class, notes ="添加职位")
	@RequestMapping(value="/save.do" , method=RequestMethod.POST)
	public Map<String, Object> savePosition(@ModelAttribute("position")Position position ){
		try {
			this.positionService.insertSelective(position);
		} catch (Exception e) {
			logger.error("添加职位异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	回现职位信息
	 */
	@ResponseBody
	@ApiOperation(value = "回现职位信息", httpMethod = "GET", response=String.class, notes ="回现职位信息")
	@RequestMapping(value={"/find.do"} , method = RequestMethod.GET )
	public Map<String, Object> findPositionById(@ApiParam("id") @RequestParam("id")Integer id , Model model){
		Map<String, Object> map;
		try {
			Position position = this.positionService.selectByPrimaryKey(id);
			map = this.success(position);
		} catch (Exception e) {
			logger.error("回现职位信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	修改职位信息
	 */
	@ApiOperation(value = "保存修改后职位信息", httpMethod = "POST", response=String.class, notes ="保存修改后职位信息")
	@RequestMapping(value="/edit.do" , method =RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatePosition(@ModelAttribute("position") Position position){
		this.positionService.updateByPrimaryKeySelective(position);
		return this.success(null);
	}
	
	/**
	 * 	查询所有的职位信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询所有的职位信息", httpMethod = "GET", response=String.class, notes ="查询所有的职位信息")
	@RequestMapping(value="/list.do", method =RequestMethod.GET)
	public Map<String, Object> findAllPosition(Model model){
		Map<String, Object> map;
		try {
			List<Position> positions = this.positionService.selectNotDeleteALL();
			map = this.success(positions);
		} catch (Exception e) {
			logger.error("查询所有的职位信息" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	根据id删除职位
	 */
	@ApiOperation(value = "根据id删除职位", httpMethod = "GET", response=String.class, notes ="根据id删除职位")
	@RequestMapping(value="/delete.do", method =RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deletePositionById(@ApiParam("id") @RequestParam("id") Integer id){
		try {
			this.positionService.deleteByPrimaryKeyToLogic(id);
		} catch (Exception e) {
			logger.error("删除职位信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	查询是否是否可以删除
	 */
	@ResponseBody
	@ApiOperation(value = "查询是否是否可以删除", httpMethod = "GET", response=Map.class, notes ="查询是否是否可以删除")
	@RequestMapping(value="/isDelete.do" , method = RequestMethod.GET)
	public Map<String, Object> isDeleteCompany(@ApiParam("id") @RequestParam("id")Integer id){
	Map<String, Object> map;
	try {
		Boolean flag = this.positionService.isDeletePosition(id);
		map = this.success(flag);
	} catch (Exception e) {
		logger.error("查询是否是否可以删除异常" + e.getMessage());
		throw new RuntimeException("查询是否是否可以删除");
	}
	return map;
	}
	
}

