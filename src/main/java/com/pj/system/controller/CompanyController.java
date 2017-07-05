package com.pj.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/company")
@Api(value="company", description="公司", position=7)
public class CompanyController extends SystemManageController{

	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class); 
	@Resource
	private CompanyService companyService;
	
	@Resource
	private NumberTool numberTool;
	
	@Resource
	private UserService userService;
	
	@Resource
	private SessionProvider sessionProvider;
	
	/**
	 * 	获取公司number
	 */
	@ApiOperation(value = "获取公司number", httpMethod = "GET", response=Map.class, notes ="获取公司number")
	@RequestMapping("/getCompanyNumber.do")
	@ResponseBody
	public Map<String , Object> getCompanyNumber(){
		Map<String, Object> success = null;
		try {
			String number = this.numberTool.getSingleNumber(companyService, four);
			success = this.success(number);
		} catch (Exception e) {
			logger.error("获取公司单号异常" + e.getMessage());
			success = this.error();
		}
		return success;
	}
	
	/**
	 * 去往添加页面
	 */
	@RequestMapping("/add.do")
	@ApiIgnore
	public String add(){
		return "company/add";
	}
	/**
	 * 	添加企业
	 */
	@ResponseBody
	@RequestMapping(value="/save.do" , method=RequestMethod.POST)
	@ApiOperation(value = "保存企业信息", httpMethod = "POST", response=String.class, notes ="保存企业信息")
	public Map<String, Object> saveCompany(@ModelAttribute("company")Company company){
		Map<String, Object> map;
		try {
			this.companyService.insertSelective(company);
			map = this.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加企业失败" + e.getMessage());
			throw new RuntimeException("添加企业异常");
		}
		return map;
	}
	
	/**
	 * 根据id查询企业信息用于回现
	 */
	@ResponseBody
	@ApiOperation(value = "根据id查询企业信息用于回现", httpMethod = "GET", response=String.class, notes ="根据id查询企业信息用于回现")
	@RequestMapping(value = "/find.do",method = RequestMethod.GET)
	public Map<String, Object> findCompanyById(@ApiParam("id") @RequestParam("id") Integer id , Model model){
		Map<String, Object> map;
		try {
			Company company = this.companyService.selectByPrimaryKey(id);
			map = this.success(company);
		} catch (Exception e) {
			logger.error("回现部门信息异常" + e.getMessage());
			throw new RuntimeException("根据id查询企业信息用于回现");
		}
    	return map;
	}
	
	/**
	 * 	修改企业信息
	 */
	@ResponseBody
	@ApiOperation(value = "修改企业信息", httpMethod = "POST", response=Map.class, notes ="修改企业信息")
	@RequestMapping(value="/edit.do" , method=RequestMethod.POST)
	public Map<String,Object> updateCompany(@ModelAttribute("company")Company company){
		try {
			this.companyService.updateByPrimaryKeySelective(company);
			return this.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更新企业异常" + e.getMessage());
			throw new RuntimeException("更新企业异常");
		}
	}
	
	/**
	 *	查询所有企业信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询所有企业信息", httpMethod = "GET", response=String.class, notes ="查询所有企业信息")
	@RequestMapping(value = "/list.do",method=RequestMethod.GET)
	public Map<String, Object> findCompanyList(Model Model){
		Map<String, Object> map;
		try {
			List<Company> companys = this.companyService.selectNotDeleteALL();
			map = this.success(companys);
		} catch (Exception e) {
			logger.error("查询所有的企业信息异常" + e.getMessage());
			throw new RuntimeException("查询所有企业信息");			
		}
    	return map;
	}
	
	/**
	 * 	根据id删除
	 */
	@ResponseBody
	@ApiOperation(value = "	根据id删除", httpMethod = "GET", response=Map.class, notes ="根据id删除")
	@RequestMapping(value="/delete.do" , method = RequestMethod.GET)
	public Map<String, Object> deleteCompanyById(@ApiParam("id") @RequestParam("id")Integer id){
		try {
			this.companyService.deleteByPrimaryKeyToLogic(id);
		
		} catch (Exception e) {
			logger.error("删除企业失败" + e.getMessage());
			throw new RuntimeException("根据id删除");		
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
		Boolean flag = this.companyService.isDeleteCompany(id);
		map = this.success(flag);
	} catch (Exception e) {
		logger.error("查询是否是否可以删除异常" + e.getMessage());
		throw new RuntimeException("查询是否是否可以删除");
	}
		return map;
	}
	
	/******************** 招聘待办 ******************/
	/**
	 * 根据用户权限查询所负责公司信息
	 * @author limr
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ApiOperation(value = "根据用户权限查询所负责公司信息", httpMethod = "GET", response=String.class, notes ="根据用户权限查询所负责公司信息")
	@RequestMapping(value = "/getCompanysByAuth.do",method=RequestMethod.GET)
	public Map<String, Object> findCompanyList(HttpServletResponse response,
			HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//得到当前登录用户
			String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request, response));
			User user = this.userService.selectByEamil(email);
			
			List<Company> companys = companyService.getByAuthUser(user.getId());
			map = this.success(companys);
		} catch (Exception e) {
			logger.error("根据用户权限查询所负责公司信息" + e.getMessage());
			throw new RuntimeException("根据用户权限查询所负责公司信息");			
		}
    	return map;
	}
	
	@ApiOperation(value = "查询公司  根据人事权限查询", httpMethod = "GET", response=Map.class, notes ="查询公司  根据人事权限查询")
	@RequestMapping(value="/selectCompanyByPersonnelAuthority.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectCompanyByPersonnelAuthority(){
		try {
			List<Company> companys = this.companyService.selectCompanyByPersonnelAuthority();
			return this.success(companys);
		} catch (Exception e) {
			e.printStackTrace();
			return this.error("查询异常"+e.getMessage());
		}
		
	}
}
