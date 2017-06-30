package com.pj.system.controller;


import java.util.HashMap;
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

import com.pj.config.base.properties.FtpProperties;
import com.pj.config.base.properties.ManageProperties;
import com.pj.config.base.tool.NumberTool;
import com.pj.config.web.controller.SystemManageController;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(value="demp", description="部门的相关操作", position=3)
@RequestMapping("/demp")
@Controller
public class DempController extends SystemManageController{

	@Resource
	private ManageProperties manageProperties;
	@Resource
	private FtpProperties ftpProperties;
	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(DempController.class); 
	@Resource
	private DempService dempService;
	@Resource
	private NumberTool numberUtils;
	@Resource
	private CompanyService companyService;
	/**
	 * 	获取部门number
	 */
	@ApiOperation(value = "获取部门number", httpMethod = "GET", response=Map.class, notes ="获取部门number")
	@RequestMapping("/getDempNumber.do")
	@ResponseBody
	public Map<String , Object> getDempNumber(){
		Map<String, Object> map;
		try {
			String number = this.numberUtils.getSingleNumber(dempService, four);
			map = this.success(number);
		} catch (Exception e) {
			logger.error("获取部门单号异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return map;
	}
	
	/**
	 * 	添加部门信息
	 */
	@ResponseBody
	@ApiOperation(value = "添加部门", httpMethod = "POST", response=String.class, notes ="添加部门")
	@RequestMapping(value="/save.do" , method=RequestMethod.POST)
	public Map<String, Object> saveDemp(@ModelAttribute("demp") Demp demp){
		try {
			this.dempService.insertSelective(demp);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加部门信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	回现部门信息
	 */
	@ResponseBody
	@ApiOperation(value = "修改部门时回现对应部门的信息", httpMethod = "GET", response=String.class, notes ="修改部门时回现对应部门的信息")
	@RequestMapping(value={"/find.do"} , method = RequestMethod.GET)
	public Map<String, Object> findDempById( @ApiParam("id") @RequestParam("id")Integer id , Model model){
		Map<String, Object> map;
		try {
			Demp demp = this.dempService.selectByPrimaryKey(id);
			map = this.success(demp);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("回现部门信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	修改部门信息
	 */
	@ResponseBody
	@RequestMapping(value="/edit.do" , method=RequestMethod.POST)
	@ApiOperation(value = "保存修改部门后的信息", httpMethod = "POST", response=String.class, notes ="保存修改部门后的信息")
	public Map<String, Object> updateDemp( @ModelAttribute("demp")Demp demp){
		try {
		
			this.dempService.updateByPrimaryKeySelective(demp);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改部门信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	查询所有的部门信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询所有的部门", httpMethod = "GET", response=String.class, notes ="查询所有的部门")
	@RequestMapping(value="/list.do" , method = RequestMethod.GET)
	public Map<String, Object> findAllDemp(Model model){
		Map<String, Object> map;
		try {
			Map<String, Object> hashMap = new HashMap<>();
			List<Demp> demps = this.dempService.selectNotDeleteALL();
			List<Company> compants = this.companyService.selectNotDeleteALL();
			hashMap.put("demps", demps);
			hashMap.put("compants", compants);
			map = this.success(hashMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询所有的部门信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		
    	return map;
	}
	
	/**
	 * 	根据id删除部门
	 */
	@ApiOperation(value = "根据id删除部门", httpMethod = "GET", response=Map.class, notes ="根据id删除部门")
	@RequestMapping(value="/delete.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteDempById(@ApiParam("id") @RequestParam("id")Integer id){
		try {
//			this.dempService.deleteByPrimaryKeyToLogic(new Demp(id, null, 1));
			this.dempService.deleteByPrimaryKeyToLogic(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除部门信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	根据公司id查询所有的部门
	 */
	@ApiOperation(value = "根据公司id查询所有的部门", httpMethod = "GET", response=Map.class, notes ="根据公司id查询所有的部门")
	@RequestMapping(value="/findDemps.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findDempsByCompanyId(@ApiParam("companyId") @RequestParam("companyId")Integer companyId){
		Map<String, Object> map;
		try {
			Map<String, Object> hashMap = new HashMap<>();
			List<Demp> demps = this.dempService.selectByCompanyId(companyId);
			List<Company> companys = this.companyService.selectNotDeleteALL();
			hashMap.put("demps", demps);
			hashMap.put("companys", companys);
			map = this.success(hashMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("根据公司id查询所有的部门" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	查询是否可以删除
	 */
	@ApiOperation(value = "查询是否可以删除", httpMethod = "GET", response=Map.class, notes ="查询是否可以删除")
	@RequestMapping(value="/isDelete.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> isDeleteDemp(@ApiParam("id") @RequestParam("id")Integer id){
		Boolean flag = this.dempService.isDeleteDemp(id);
			Map<String, Object> map = this.success(flag);
		return map;
		
	}
	
	/**
	 * 获取公司下面的所有部门（排除该部门下面的所有子集）
	 *	@author 	GFF
	 *	@date		2017年1月24日下午4:19:20	
	 * 	@param id
	 * 	@return
	 */
	@ApiOperation(value = "查询是否可以删除", httpMethod = "GET", response=Map.class, notes ="查询是否可以删除")
	@RequestMapping(value="/findDempsANDEliminateSubset.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findDempsANDEliminateSubset(@ApiParam("id") @RequestParam("id")Integer id){
		List<Demp> demps = this.dempService.selectEliminateSubset(id);
		Map<String, Object> map = this.success(demps);
		return map;
	}
	
	/**
	 * 获取公司下面的所有部门（排除该部门下面的所有子集）
	 *	@author 	GFF
	 *	@date		2017年1月24日下午4:19:20	
	 * 	@param id
	 * 	@return
	 */
	@ApiOperation(value = "查询是否可以删除", httpMethod = "GET", response=Map.class, notes ="查询是否可以删除")
	@RequestMapping(value="/findDempsANDParentNode.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findDempsAnd(@ApiParam("id") @RequestParam("id")Integer id){
		List<Demp> demps = this.dempService.selectEliminateSubset(id);
		Map<String, Object> map = this.success(demps);
		return map;
	}
	@RequestMapping(value="/getXxx.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getXxx(){
		Map<String, Object> map = new HashMap<>();
		map.put("password", ftpProperties.getPassword());
		map.put("url", manageProperties.ftpProperties.getUrl());
		map.put("ssocreateUrl", manageProperties.httpClienUrlProperties.getSsoCreateUrl());
		return map;
	}
	
}
