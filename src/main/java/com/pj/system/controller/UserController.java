package com.pj.system.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.constant.Constant;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.web.controller.BaseController;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;
import com.pj.system.service.PostService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping("/user")
@Controller
@Api(value = "user", description = "用户", position = 4)
public class UserController extends BaseController {
	// 日志对象
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@Resource
	private CompanyService companyService;

	@Resource
	private DempService dempService;

	@Resource
	private PostService postService;

	@Resource
	private PositionService positionService;

	@Resource
	private SessionProvider sessionProvider;


	/**
	 * 添加用户
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	@ApiOperation(value = "添加用户", httpMethod = "POST", response = String.class, notes = "添加用户")
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	@ResponseBody()
	public Map<String, Object> saveUser(@ModelAttribute("user") User user){
		Map<String, Object> map;
		try {
			this.userService.insertSelective( user);
			map = this.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加用户失败" + e.getMessage());
			map = this.error();
		}
		return map;
	}

	/**
	 * 回现用户信息
	 */
	@ApiOperation(value = "查询用户根据id", httpMethod = "GET", response = String.class, notes = "修改用户回现相关信息")
	@RequestMapping(value = "/find.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectUserById(@ApiParam("主键") @RequestParam("id") Integer id) {
		Map<String, Object> map;
		try {
			User user = this.userService.selectById(id);
			map = this.success(user);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			map = this.error("获取用户信息异常" + e.getMessage());
		}
		return map;
	}
	
	/**
	 * 	根据id查询用户详情
	 */
	@ApiOperation(value = "根据id查询用户详情", httpMethod = "GET", response = String.class, notes = "修改用户回现相关信息")
	@RequestMapping(value = "/selectUserDetail.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectUserDetail(@ApiParam("主键") @RequestParam("id") Integer id) {
		Map<String, Object> map;
		try {
			User user = this.userService.selectUserDetail(id);
			map = this.success(user);
			return map;
		} catch (Exception e) {
			logger.error(e.getMessage());
			map = this.error("获取用户信息异常" + e.getMessage());
		}
		return map;
	}

	@ApiOperation(value = "根据用户名称查询", httpMethod = "GET", response = MappingJacksonValue.class)
	@RequestMapping(value = "/selectUserByUsername.do", method = RequestMethod.GET)
	public @ResponseBody MappingJacksonValue selectUserByUsername(@ApiParam("用户名称") @RequestParam("username") String username){
		try {
			List<User> users = this.userService.selectUserByUsername(username);
			return this.successJsonp(users);
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp("查询异常"+e.getMessage());
		}
	}
	
	/**
	 * 根据当前登录用户获取用户信息
	 */
	@ApiOperation(value = " 根据当前登录用户获取用户信息", httpMethod = "GET", response = String.class, notes = " 根据当前登录用户获取用户信息")
	@RequestMapping(value = "/findLoginUser.do", method = RequestMethod.GET)
	@ResponseBody
	public MappingJacksonValue selectUserByLoginUser(String callback, HttpServletResponse response,
			HttpServletRequest request) {
		String email = 
		 this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(request,
		 response));
		User user = this.userService.selectByEamil(email);
		MappingJacksonValue mjv = new MappingJacksonValue(user);
		mjv.setJsonpFunction(callback);
		return mjv;
	}

	/**
	 * 更新用户
	 */
	@ApiOperation(value = "更新用户", httpMethod = "POST", response = String.class, notes = "更新用户")
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUser(@ModelAttribute("user") User user) {
		try {
			this.userService.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更新用户信息异常" + e.getMessage());
		}
		return this.success(null);
	}

	/**
	 * 根据条件查询所有用户
	 */
	@ApiOperation(value = "根据筛选条件获取用户", httpMethod = "POST", response = String.class, notes = "根据筛选条件获取用户")
	@RequestMapping(value = "/list.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> selectUserAll(
			@ApiParam("企业id") @RequestParam(value = "companyid", required = false) Integer companyid,
			@ApiParam("部门id") @RequestParam(value = "dempid", required = false) Integer dempid,
			@ApiParam("根据名称查询") @RequestParam(value = "username", required = false) String username,
			@ApiParam("根据状态查询") @RequestParam(value = "isstatus", required = false) Integer isstatus,
			@ApiParam("查询页码") @RequestParam(value = "pageNo", required = false) Integer pageNo, Model model,
			@ApiParam("系统角色id") @RequestParam(value = "systemRoleid", required = false) Integer systemRoleid,
			@ApiParam("页数") @RequestParam(value = "pagesi", required = false) Integer pagesi,
			@ApiParam("系统编号") @RequestParam(value = "terrace", required = false) String terrace) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result;
		try {
//			List<Company> companys = this.companyService.selectNotDeleteALL();
			// 查询所有部门
//			List<Demp> demps = this.dempService.selectNotDeleteALL();
			Pagination pagination = this.userService.selectByQuery(pageNo, username, isstatus, dempid,
					companyid, systemRoleid, terrace);
			map.put("pagination", pagination);
			map.put("username", username);
			map.put("isstatus", isstatus);
			map.put("dempid", dempid);
			map.put("companyid", companyid);
			result = this.success(map);
		} catch (Exception e) {
			logger.error("根据条件查询用户失败" + e.getMessage());
			result = this.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 删除用户（逻辑删除）
	 */
	@ApiOperation(value = "根据id删除用户", httpMethod = "GET", response = String.class, notes = "根据id删除用户")
	@RequestMapping("/delete.do")
	@ResponseBody
	public Map<String, Object> deleteUserById(@ApiParam("id") @RequestParam("id") Integer id) {
		this.userService.deleteByPrimaryKeyToLogic(id);
		Map<String, Object> map = this.success(null);
		return map;
	}


	/**
	 * 根据email称获取user信息
	 */
	@ApiOperation(value = "根据email称获取user信息", httpMethod = "GET", response = String.class, notes = "根据名称查询用户")
	@RequestMapping("/findUserByemail.do")
	@ResponseBody
	public MappingJacksonValue findUserByEmali(String callback, @ApiParam("用户名称") @RequestParam("email") String email) {
		MappingJacksonValue mjv = null;
		Map<String, Object> map;
		try {
			User user = this.userService.selectByEamil(email);
			map = this.success(user);
			mjv = new MappingJacksonValue(map);
			mjv.setJsonpFunction(callback);
		} catch (Exception e) {
			map = this.error(e.getMessage());
			logger.error("根据email称获取user信息" + e.getMessage());
			e.printStackTrace();
		}
		return mjv;
	}

	/**
	 * 根据ssoid称获取user信息
	 */
	@ApiOperation(value = "根据email称获取user信息", httpMethod = "GET", response = String.class, notes = "根据名称查询用户")
	@RequestMapping("/findUserByssoId.do")
	@ResponseBody
	public MappingJacksonValue findUserByssoId(String callback,
			@ApiParam("用户名称") @RequestParam("ssoId") Integer ssoId) {
		MappingJacksonValue mjv = null;
		Map<String, Object> map;
		try {
			User record = new User();
			record.setSsoId(ssoId);
			List<User> user = this.userService.select(record);
			map = this.success(user.size() != 0 ? user.get(0) : null);
			mjv = new MappingJacksonValue(map);
			mjv.setJsonpFunction(callback);
		} catch (Exception e) {
			map = this.error(e.getMessage());
			
			
			
			logger.error("根据email称获取user信息" + e.getMessage());
			e.printStackTrace();
		}
		return mjv;
	}

	@ApiOperation(value = "updateUserBJ更新user(报价系统使用)", httpMethod = "GET", response = String.class, notes = "更新user(报价系统使用)")
	@RequestMapping("/updateUserBJ.do")
	@ResponseBody
	public void updateUserBJ(@ModelAttribute("user") User user) {
		this.userService.updateUserBJ(user);
	}
	
	@ApiOperation(value = "根据入职时间查询员工 工号", httpMethod = "GET", response = String.class, notes = "根据入职时间查询员工 工号")
	@RequestMapping("/selectEmployeeNumberByHiredateAndEntryId.do")
	@ResponseBody
	public MappingJacksonValue selectEmployeeNumberByHiredateAndEntryId(@ApiParam("入职id") @RequestParam("entryId") Integer entryId){
		try {
			String number = this.userService.selectEmployeeNumberByHiredateAndEntryId(entryId);
			return this.successJsonp(number);
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp("获取单号异常  ："+e.getMessage());
		}
	}
	@ApiOperation(value = "查询用户通过公司id岗位id", httpMethod = "GET", response = String.class, notes = "查询用户通过公司id岗位id")
	@RequestMapping("/selectUserByCompanyIdAndPostId.do")
	@ResponseBody
	public MappingJacksonValue selectUserByCompanyIdAndPostId(@ApiParam("公司id") @RequestParam("companyId") Integer companyId,
															  @ApiParam(name="岗位id",required=false) @RequestParam(value="postId",required=false) Integer postId){
		try {
			User record = new User();
			record.setCompanyid(companyId);
			if(postId != null){
				record.setPostid(postId);
			}
			record.setIsdelete(0);
			return this.successJsonp(this.userService.select(record));
		} catch (Exception e) {
			e.printStackTrace();
			return this.errorToJsonp("查询异常 :"+e.getMessage());
		}
	}
	
	@ApiOperation(value = "根据用户名称查询企业邮箱", httpMethod = "GET", response = String.class, notes = "根据用户名称查询企业邮箱")
	@RequestMapping("selectPeopleWhoCopiedEmailByUsername.do")
	@ResponseBody
	public Object selectPeopleWhoCopiedEmailByUsername(@ApiParam("用户名称") @RequestParam("username") String username
			,@ApiParam("申请单id") @RequestParam("applyId") Integer applyId){
		try {
			Object[] objects = this.userService.selectPeopleWhoCopiedEmailByUsername(username ,applyId );
			return this.successJsonp(objects);
		} catch (Exception e) { 
			e.printStackTrace();
			return this.errorToJsonp(e.getMessage());
		}
	}
	
	/**
	 * 	查询CHO人员
	 *	@author 	GFF
	 *	@date		2017年7月8日下午12:59:07	
	 * 	@return
	 */
	@ApiOperation(value = "查询CHO人员Email", httpMethod = "GET", response = String.class, notes = "查询CHO人员Email")
	@RequestMapping("selectCHOEmail.do")
	@ResponseBody
	public Object selectCHOEmail(){
		User record = new User();
		record.setPostid(Constant.CHO);
		record.setIsdelete(0);
		List<User> list = this.userService.select(record );
		if(list.size() > 0){
			String email = list.get(0).getCompanyEmail();
			return this.successJsonp(new String[]{email});
		}
		return this.errorToJsonp("没有查询到CHO");
	}
}
