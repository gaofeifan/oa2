package com.pj.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.web.controller.BaseController;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.User;
import com.pj.system.service.AccountService;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="accountManage-api",description="有关账号管理")
@Controller
@RequestMapping("/accountManage")
public class AccountManageController  extends BaseController{
	
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private DempService dempService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	
	//与sso进行邮箱更新
	@ApiOperation(value="同步sso邮箱" ,httpMethod="GET")
	@RequestMapping(value = "/syncEmail",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String SyncUpdateEmail(
			@ApiParam(value = "id") @RequestParam Integer id,
			@ApiParam(value = "newEmail") @RequestParam  String newEmail){
		//查找用户
		User user = userService.selectByPrimaryKey(id);
		user.setCompanyEmail((newEmail));
		//更新数据
		accountService.SyncUpdateEmail(user);
		return "200";
	}
	
	//加载页面所有数据
	@ApiOperation(value="页面公司,部门数据加载",httpMethod="GET")
	@RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> AMlist(){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		//查询所有公司
		List<Company> companys = companyService.selectNotDeleteALL();
		// 查询所有部门
		List<Demp> demps = this.dempService.selectNotDeleteALL();
	
		map.put("companys", companys);
		map.put("demps", demps);              
		map2 = this.success(map);
		return map2;
	} 
	
	//账号管理列表
	@ApiOperation(value="账号信息" ,httpMethod="GET")
	@RequestMapping(value = "/collection", method = RequestMethod.GET ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> Collection(@RequestParam(required =false) Integer pageNo,
			@ApiParam(value ="员工姓名") @RequestParam(required =false) String username,
			@ApiParam(value = "部门id") @RequestParam(required =false) Integer dempid,
			@ApiParam(value = "公司id")@RequestParam(required =false) Integer companyid ){
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Pagination list = userService.selectByQuery(pageNo, username, null, dempid, companyid, null, null);
		if(list !=null){
			map.put("userpage",list);
			map2 = this.success(map);
			return map2;
		}{
			map2.put("code", "400");
			return  map2;
		}
	}



	//查询工账号信息
	@SuppressWarnings("rawtypes")
	@ApiOperation(value="查询用户信息",notes="通过用户id查询到用户信息",httpMethod="GET")
	@RequestMapping(value="/id",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<Map> SelectById(@RequestParam Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		User user = userService.selectByPrimaryKey(id);
		map.put("user", user);
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	





}
