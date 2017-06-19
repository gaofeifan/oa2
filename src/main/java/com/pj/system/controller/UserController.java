package com.pj.system.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import org.springframework.web.multipart.MultipartFile;

import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.web.controller.BaseController;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Position;
import com.pj.system.pojo.Post;
import com.pj.system.pojo.Rank;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;
import com.pj.system.service.PostService;
import com.pj.system.service.RankService;
import com.pj.system.service.SessionProvider;
import com.pj.system.service.UserService;
import com.pj.utils.ExcleUtils;
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
	private RankService rankService;

	@Resource
	private DempService dempService;

	@Resource
	private PostService postService;

	@Resource
	private PositionService positionService;


	@Resource
	private SessionProvider sessionProvider;
	public static String errmessage = ""; // 显示异常信息

	public static Integer pageSize = 10;

	/**
	 * 去往添加页面
	 */

	@ApiOperation(value = "去往添加页面", httpMethod = "GET", response = String.class, notes = "去往添加页面")
	@RequestMapping("/add.do")
	@ResponseBody
	public Map<String, Object> add(Model model) {
		Map<String, Object> map2;
		try {
			// 查询所有公司
			List<Company> companys = this.companyService.selectNotDeleteALL();
			// 查询所有职级
			List<Rank> ranks = this.rankService.selectNotDeleteALL();
			// 查询所有部门
			List<Demp> demps = this.dempService.selectNotDeleteALL();
			// 查询所有岗位
			List<Post> posts = this.postService.selectNotDeleteALL();
			// 查询所有职位
			List<Position> positions = this.positionService.selectNotDeleteALL();


			Map<String, Object> map = new HashMap<String, Object>();
			map.put("companys", companys);
			map.put("ranks", ranks);
			map.put("demps", demps);
			map.put("posts", posts);
			map.put("positions", positions);

			map2 = this.success(map);
		} catch (Exception e) {
			e.printStackTrace();
			map2 = this.error("获取页面信息异常" + e.getMessage());
		}
		return map2;
	}

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
	public Map<String, Object> saveUser(@ModelAttribute("user") User user)
			throws ClientProtocolException, IOException, URISyntaxException {
		Map<String, Object> map;
		try {
			this.userService.insertSelective(user);
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
	@ApiOperation(value = "修改用户回现相关信息", httpMethod = "GET", response = String.class, notes = "修改用户回现相关信息")
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
		User user = this.userService.findUserByCondition(new User(email), false);
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
	public Map<String, Object> findUserAllByCondition(
			@ApiParam("企业id") @RequestParam(value = "companyid", required = false) Integer companyid,
			@ApiParam("部门id") @RequestParam(value = "dempid", required = false) Integer dempid,
			@ApiParam("根据名称查询") @RequestParam(value = "username", required = false) String username,
			@ApiParam("根据状态查询") @RequestParam(value = "isstatus", required = false) Integer isstatus,
			@ApiParam("查询页码") @RequestParam(value = "pageNo", required = false) Integer pageNo, Model model,
			@ApiParam("系统角色id") @RequestParam(value = "systemRoleid", required = false) Integer systemRoleid,
			@ApiParam("页数") @RequestParam(value = "pagesi", required = false) Integer pagesi,
			@ApiParam("系统编号") @RequestParam(value = "terrace", required = false) String terrace) {
		// 查询所有公司
		if (pagesi != null) {
			pageSize = pagesi;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result;
		try {
			List<Company> companys = this.companyService.selectNotDeleteALL();
			// 查询所有部门
			List<Demp> demps = this.dempService.selectNotDeleteALL();
			Pagination pagination = this.userService.selectByQuery(pageNo, username, isstatus, dempid,
					companyid, pageSize, systemRoleid, terrace);

			map.put("pagination", pagination);
			map.put("username", username);
			map.put("isstatus", isstatus);
			map.put("dempid", dempid);
			map.put("companyid", companyid);
			map.put("companys", companys);
			map.put("demps", demps);
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
	 * 根据用户名称获取user
	 */
	@ApiOperation(value = "根据名称查询用户", httpMethod = "GET", response = String.class, notes = "根据名称查询用户")
	@RequestMapping("/findUserByUsername.do")
	@ResponseBody
	public Map<String, Object> findUserByUsername(@ApiParam("用户名称") @RequestParam("username") String username) {
		Map<String, Object> map;
		try {
			User user = this.userService.selectByUsername(username);
			map = this.success(user);
		} catch (Exception e) {
			map = this.error(e.getMessage());
			logger.error("根据用户名称获取user" + e.getMessage());
			e.printStackTrace();
		}
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
			User user = this.userService.selectByemail(email);
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
			User user = this.userService.selectBySsoId(ssoId);
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
	 * 批量导入user
	 */
	@RequestMapping(value = "/uploadExcle.do", method = RequestMethod.POST)
	@ApiOperation(value = "批量导入用户信息", httpMethod = "POST", response = String.class, notes = "批量导入用户信息")
	@ResponseBody
	public Map<String, Object> importXls(@ApiParam("excel文件") @RequestParam("userImport") MultipartFile userImport,
			HttpServletResponse response) throws FileNotFoundException, IOException {
		Map<String, Object> map = null;
		@SuppressWarnings("unused")
		boolean flag = false;
		try {
			List<User> list = this.getBankListByExcel(userImport.getInputStream(), userImport.getOriginalFilename());
			this.userService.saveBatch(list);
			map = this.success(flag = true);
		} catch (Exception e1) {
			logger.error("导入用户信息异常" + e1.getMessage());
			// map = this.error(e1.getMessage());
		}

		return map;
	}

	/**
	 * 描述：获取IO流中的数据，组装成List<List<Object>>对象
	 * 
	 * @param in,fileName
	 * @throws IOException
	 */
	public List<User> getBankListByExcel(InputStream in, String fileName) throws Exception {

		List<User> users = new ArrayList<>();
		// 创建Excel工作薄
		Workbook work = WorkbookFactory.create(in);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}

		// 读取第一个标签页
		Sheet sheet = work.getSheetAt(0);

		// 遍历出所有行数据
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0 || row.getCell(1) == null) {
				continue;
			}
			// String positionName = this.getCellValue(row.getCell(6));
			// String numer = this.getCellValue(row.getCell(0));
			try {
				String filenumber = this.getCellValue(row.getCell(1));
				String iscompact = this.getCellValue(row.getCell(2));
				String username = this.getCellValue(row.getCell(3));
				String sex = this.getCellValue(row.getCell(4));
				String rankName = this.getCellValue(row.getCell(5));
				String postName = this.getCellValue(row.getCell(6));
				String companyName = this.getCellValue(row.getCell(7));
				String dempName = this.getCellValue(row.getCell(8));
				String hiredate = this.getCellValue(row.getCell(9));
				String probationpay = this.getCellValueString(row.getCell(10));
				String regularpay = this.getCellValueString(row.getCell(11));
				String pbspdate = this.getCellValue(row.getCell(12));
				String comppdate = this.getCellValue(row.getCell(13));
				String phone = this.getCellValue(row.getCell(14));
				String email = this.getCellValue(row.getCell(15));
				String identityproof = this.getCellValue(row.getCell(16));

				String annum = this.getCellValue(row.getCell(17));
				String month = this.getCellValue(row.getCell(18));
				String sky = this.getCellValue(row.getCell(19));

				String birthdate = "";
				if (StringUtils.isBlank(annum) && StringUtils.isBlank(month) && StringUtils.isBlank(sky)) {
					birthdate = null;
				} else {
					month = StringUtils.isNotBlank(month) ? month : "01";
					sky = StringUtils.isNotBlank(sky) ? sky : "01";
					birthdate = annum + "." + month + "." + sky;
				}

				String leavedate = this.getCellValue(row.getCell(20));
				String address = this.getCellValue(row.getCell(21));
				String contacts = this.getCellValue(row.getCell(22));
				String nation = this.getCellValue(row.getCell(23));
				String newsecurity = this.getCellValue(row.getCell(24));
				String issecurity = this.getCellValue(row.getCell(25));
				String nativeplace = this.getCellValue(row.getCell(26));
				String alnature = this.getCellValue(row.getCell(27));
				String edubg = this.getCellValue(row.getCell(28));
				String school = this.getCellValue(row.getCell(29));
				String isfulltime = this.getCellValue(row.getCell(30));
				String depositbank = this.getCellValue(row.getCell(31));
				String bankcard = this.getCellValue(row.getCell(32));

				// String isnowtarget = this.getCellValue(row.getCell(30));
				// String roleName = this.getCellValue(row.getCell(32));
				// String labelcompacttype = this.getCellValue(row.getCell(33));
				// String worktype = this.getCellValue(row.getCell(34));

				Integer iscompactint = null;
				Integer newsecurityint = null;
				Integer issecurityint = null;
				Integer isfulltimeint = null;
				Integer isnowtargetint = null;
				if (StringUtils.isNotBlank(iscompact)) {
					iscompactint = ExcleUtils.isboolean(iscompact);
				}

				if (StringUtils.isNotBlank(newsecurity)) {
					newsecurityint = ExcleUtils.isboolean(newsecurity);
				}

				if (StringUtils.isNotBlank(issecurity)) {
					issecurityint = ExcleUtils.isboolean(issecurity);
				}

				if (StringUtils.isNotBlank(isfulltime)) {
					isfulltimeint = ExcleUtils.isboolean(isfulltime);
				}

				// if (!"".equals(isnowtarget.trim()) && isnowtarget != null) {
				// isnowtargetint = ExcleUtils.isboolean(isnowtarget);
				// }

				Date hiredatedate = null;
				Date pbspdatedate = null;
				Date comppdatedate = null;
				Date birthdatedate = null;
				Date leavedatedate = null;
				if (StringUtils.isNotBlank(hiredate)) {
					hiredatedate = ExcleUtils.dateConvert(hiredate);
				}

				if (StringUtils.isNotBlank(pbspdate)) {
					pbspdatedate = ExcleUtils.dateConvert(pbspdate);
				}

				if (StringUtils.isNotBlank(comppdate)) {
					comppdatedate = ExcleUtils.dateConvert(comppdate);
				}

				if (StringUtils.isNotBlank(birthdate)) {
					birthdatedate = ExcleUtils.dateConvert(birthdate);
				}

				if (StringUtils.isNotBlank(leavedate)) {
					leavedatedate = ExcleUtils.dateConvert(leavedate);
				}

				// 获取对应的id
				Integer companyId = null;
				Integer rankId = null;
				// Integer positionId = null;
				Integer postId = null;
				Integer dempId = null;
				// Integer roleId = null;
				// if (!"".equals(positionName.trim()) && positionName != null)
				// {
				// positionId =
				// this.positionService.findPositionByName(positionName);
				// }
				if (StringUtils.isNotBlank(companyName)) {
					companyId = this.companyService.selectByName(companyName);
				}

				if (StringUtils.isNotBlank(rankName)) {
					rankId = this.rankService.selectByName(rankName);
				}

				if (StringUtils.isNotBlank(dempName)) {
					dempId = this.dempService.selectByNameANDCompanyId(companyId, dempName);
				}

				if (StringUtils.isNotBlank(postName)) {
					postId = this.postService.selectByNameANDDempId(dempId, postName);
				}

				// if (!"".equals(roleName.trim()) && roleName != null) {
				// roleId = this.roleService.findRoleByName(roleName);
				// }

				User user = new User();

				user.setFilenumber(filenumber); // 档案编号
				user.setIscompact(iscompactint); // 是否发放合同
				user.setUsername(username); // 姓名
				user.setSex(sex); // 性别
				user.setCompanyid(companyId); // 公司id
				user.setRankid(rankId); // 职级id
				// user.setPositionid(positionId); // 职位id
				user.setPostid(postId); // 岗位id
				user.setDempid(dempId); // 部门id
				user.setProbationpay(probationpay); // 试用期薪水
				user.setRegularpay(regularpay); // 转正后薪水
				user.setPbspdate(pbspdatedate); // 试用期终止时间
				user.setHiredate(hiredatedate); // 入职时间
				user.setComppdate(comppdatedate); // 合同终止时间
				user.setBirthdate(birthdatedate); // 出生时期
				user.setLeavedate(leavedatedate); // 离职时间
				user.setPhone(phone); // 联系方式
				user.setIdentityproof(identityproof); // 身份证号
				user.setAddress(address); // 当前住址
				user.setContacts(contacts); // 紧急联系人及电话
				user.setNation(nation); // 民族
				user.setNewsecurity(newsecurityint); // 是否为新社保
				user.setIssecurity(issecurityint); // 是否有社保卡
				user.setNativeplace(nativeplace); // 籍贯
				user.setAlnature(alnature); // 户口性质
				user.setEdubg(edubg); // 最高学历
				user.setSchool(school); // 学校
				user.setIsfulltime(isfulltimeint); // 是否全日制
				user.setDepositbank(depositbank); // 开户行信息
				user.setBankcard(bankcard); // 银行卡号
				user.setIsnowtarget(isnowtargetint); // 是否开通今目标
				user.setEmail(email); // 邮箱
				// user.setRoleid(roleId); // 角色
				// user.setLabelcompacttype(Integer.decode(labelcompacttype));
				// // 合同类型

				users.add(user);
			} catch (Exception e) {
				int errorNumber = rowNum + 1;
				logger.error("数据格式错误 / " + e.getMessage() + ": 行" + errorNumber);
				throw new RuntimeException("数据格式错误 ： " + e.getMessage() + " 第" + errorNumber + "行");
			}

		}
		in.close();
		work.close();
		return users;
	}

	/**
	 * 转换excel格式
	 */
	public String getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		cell.setCellType(Cell.CELL_TYPE_STRING);
		if (!"".equals(cell.getStringCellValue().trim())) {
			return cell.getStringCellValue();
		} else {
			return null;
		}
	}

	public String getCellValueString(Cell cell) {
		if (cell == null) {
			return null;
		}
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);

		if (!"".equals(cell.getNumericCellValue())) {
			return cell.getNumericCellValue() + "";
		} else {
			return null;
		}
	}

	@ApiOperation(value = "updateUserBJ更新user(报价系统使用)", httpMethod = "GET", response = String.class, notes = "更新user(报价系统使用)")
	@RequestMapping("/updateUserBJ.do")
	@ResponseBody
	public void updateUserBJ(@ModelAttribute("user") User user) {
		this.userService.updateUserBJ(user);
	}
	@ApiOperation(value = "查询用户是否可以登录", httpMethod = "GET", response = String.class, notes = "查询用户是否可以登录")
	@RequestMapping("/findUserIsLogin.do")
	@ResponseBody
	public Map<String, Object> findUserIsLogin(@ApiParam("id") @RequestParam("id") String id ,HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> success;
		try {
			Integer userid = Integer.decode(id);
			boolean status = this.userService.selectUserIsLogin(userid);
			success = this.success(status);
		} catch (Exception e) {
			logger.error("查询用户是否可登录登录:"+e.getMessage());
			success = this.error(e.getMessage());
			e.printStackTrace();
		}
		return success;
	}
}
