package com.pj.system.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.constant.ActionLogOperation;
import com.pj.config.base.constant.EntryApplyResult;
import com.pj.config.base.constant.EntryApplyState;
import com.pj.config.base.constant.RecruitApplyResult;
import com.pj.config.base.constant.RecruitApplyState;
import com.pj.config.base.constant.RecruitTodoState;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.config.base.tool.HttpClienTool;
import com.pj.flow.mapper.FlowActionLogMapper;
import com.pj.flow.mapper.FlowRecruitTodoMapper;
import com.pj.flow.pojo.FlowActionLog;
import com.pj.flow.pojo.FlowEntry;
import com.pj.flow.pojo.FlowRecruit;
import com.pj.flow.pojo.FlowRecruitTodo;
import com.pj.flow.service.FlowEntryService;
import com.pj.flow.service.FlowRecruitService;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.Education;
import com.pj.system.pojo.FamilyMember;
import com.pj.system.pojo.Salary;
import com.pj.system.pojo.User;
import com.pj.system.pojo.WorkExperience;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.EducationService;
import com.pj.system.service.FamilyMemberService;
import com.pj.system.service.PositionService;
import com.pj.system.service.SalaryService;
import com.pj.system.service.UserService;
import com.pj.system.service.WorkExperienceService;
import com.pj.system.utils.GetJsonFileUtils;
import com.pj.utils.AESUtils;
import com.pj.utils.DateUtils;

import net.sf.json.JSONArray;
import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, Integer> implements UserService {
	@Resource
	private FlowRecruitService flowRecruitService;
	@Resource
	private FlowActionLogMapper flowActionLogMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private DempMapper dempMapper;
	@Resource
	private PostMapper postMapper;
	@Resource
	private PositionService positionService;
	@Resource
	private CompanyService companyService;
	@Resource
	private DempService dempService;
	@Resource
	private SalaryService salaryService;
	@Resource
	private FlowEntryService flowEntryService;
	@Resource
	private EducationService educationService;
	@Resource
	private FlowRecruitTodoMapper flowRecruitTodoMapper;
	@Resource
	private AuthUserService authUserService;
	//	@Resource
//	private ManageProperties manageProperties;
	private static String  ssoCreateUrl = "http://10.0.0.18:8085/sso/userSync/add";
	private static String  ssoUpdateUrl = "http://10.0.0.18:8085/sso/userSync/update";
	private static String  ssoUpdateEmailOrPasswordUrl = "http://10.0.0.18:8085/sso/accountManage/saveManage";
	private static String  ssoUpdateBatchUpdate = "http://10.0.0.18:8085/sso/accountManage/batchUpdate";
											
	@Resource 
	private FamilyMemberService familyMemberService;
	@Resource
	private WorkExperienceService workExperienceService;
	@Override
	public MyMapper<User> getMapper() {
		return userMapper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int insertSelective(User t) {
		Integer ssoId = saveSSOSystem(t);
		if(ssoId != null){
			t.setSsoId(ssoId);
			int i = this.userMapper.insertSelective(t);
		
			/**
			 * 	更新薪资
			 */
			String salaryJson = t.getSalaryJson();
			JSONArray salaryArray = JSONArray.fromString(salaryJson);
			List<Salary> salaryList = JSONArray.toList(salaryArray, Salary.class);
			salaryList.stream().forEach(salary -> salary.setUserId(t.getId()));
			salaryList.stream().forEach(salary -> this.salaryService.updateByPrimaryKeySelective(salary));
			/**
			 * 	家庭成员
			 */
			String familyMemberJson = t.getFamilyMembersJson();
			JSONArray jsonArray = JSONArray.fromString(familyMemberJson);
			List<FamilyMember> list = JSONArray.toList(jsonArray, FamilyMember.class);
			list.stream().forEach(menber -> menber.setUserId(t.getId()));
			for (FamilyMember familyMember : list) {
				this.familyMemberService.insertSelective(familyMember);
			}
			
			/**
			 * 	教育经历
			 */
			String educationJson = t.getEducationJson();
			JSONArray educationArray = JSONArray.fromString(educationJson);
			List<Education> educationList = JSONArray.toList(educationArray, Education.class);
			educationList.forEach(educatino -> educatino.setUserId(t.getId()));
			for (Education education : educationList) {
				this.educationService.insertSelective(education);
			}
			
			/**
			 * 	工作经历
			 */
			String workExperienceJson = t.getWorkExperienceJson();
			JSONArray workExperienceArray = JSONArray.fromString(workExperienceJson);
			List<WorkExperience> workExperienceList = JSONArray.toList(workExperienceArray, WorkExperience.class);
			workExperienceList.stream().forEach(work -> work.setUserId(t.getId()));
			for (WorkExperience workExperience : workExperienceList) {
				this.workExperienceService.insertSelective(workExperience);
			}
			authUserService.insertDefaultAuthUser(t.getId());
			/**
			 * 	更新申请单状态
			 */
			this.updateApplyState(t.getEntryId());
			return i;
		}
		throw new RuntimeException("该企业邮箱已经存在");
		
	}

	private void updateApplyState(Integer entryId) {
		if(entryId == null){
			throw new RuntimeException("没有查询到入职申请单");
		}
		FlowEntry flowEntry = this.flowEntryService.selectByPrimaryKey(entryId);
		flowEntry.setState(EntryApplyState.FILING.getState());
		flowEntry.setResult(EntryApplyResult.ENTRY_SUCCESS.getState());
		flowEntry.setIsBookbuilding(1);
		flowEntryService.updateByPrimaryKeySelective(flowEntry);
		
		FlowRecruit flowRecruit = this.flowRecruitService.selectByPrimaryKey(flowEntry.getRecruitId());
		flowRecruit.setState(RecruitApplyState.FILING.getState());
		flowRecruit.setResult(RecruitApplyResult.ENTRY_SUCCESS.getState());
		
		/**
		 * 	更新入职人数
		 */
		int num = flowRecruit.getEntryNum() != null ? flowRecruit.getEntryNum() : 0;
		num +=1;
		flowRecruit.setEntryNum(num);
		this.flowRecruitService.updateByPrimaryKeySelective(flowRecruit);
		/**
		 *	更新状态
		 */
		FlowRecruitTodo inRecruitTodo = flowRecruitTodoMapper.selectByRecruitId(flowRecruit.getId(), RecruitTodoState.IN_RECRUIT.getState());
		int needNum = inRecruitTodo.getNeedNum();
		if(needNum > 1){
//			inRecruitTodo.setNumber(number - 1);
			inRecruitTodo.setNeedNum(inRecruitTodo.getNeedNum() - 1);;
			flowRecruitTodoMapper.updateByPrimaryKeySelective(inRecruitTodo);
		}else{
			if(inRecruitTodo != null){
				flowRecruitTodoMapper.delete(inRecruitTodo);
			}
		}
		FlowActionLog record = new FlowActionLog();
		record.setRecruitId(flowRecruit.getId());
		record.setEntryId(entryId);
		record.setOperateTime(new Date());
		record.setStatus(ActionLogOperation.ENTRY_END.getValue());
		this.flowActionLogMapper.insert(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateByPrimaryKeySelective(User user) {
		/**
		 * 	更新薪资
		 */
		String salaryJson = user.getSalaryJson();
		JSONArray salaryArray = JSONArray.fromString(salaryJson);
		List<Salary> salaryList = JSONArray.toList(salaryArray, Salary.class);
		for (Salary salary : salaryList) {
			salary.setUserId(user.getId());
			if(salary.getId() == null){
				 this.salaryService.insertSelective(salary);
			}else{
				this.salaryService.updateByPrimaryKeySelective(salary);
			}
		}
		/**
		 * 	家庭成员
		 */
		String familyMemberJson = user.getFamilyMembersJson();
		JSONArray jsonArray = JSONArray.fromString(familyMemberJson);
		List<FamilyMember> list = JSONArray.toList(jsonArray, FamilyMember.class);
		for (FamilyMember familyMember : list) {
			familyMember.setUserId(user.getId());
			if(familyMember.getId() == null){
				this.familyMemberService.insertSelective(familyMember);
			}else{
				this.familyMemberService.updateByPrimaryKeySelective(familyMember);
			}
		}
		
		/**
		 * 	教育经历
		 */
		String educationJson = user.getEducationJson();
		JSONArray educationArray = JSONArray.fromString(educationJson);
		List<Education> educationList = JSONArray.toList(educationArray, Education.class);
		for (Education education : educationList) {
			education.setUserId(user.getId());
			if(education.getId() == null){
				this.educationService.insertSelective(education);
			}else{
				this.educationService.updateByPrimaryKeySelective(education);
			}
		}
		
		/**
		 * 	工作经历
		 */
		String workExperienceJson = user.getWorkExperienceJson();
		JSONArray workExperienceArray = JSONArray.fromString(workExperienceJson);
		List<WorkExperience> workExperienceList = JSONArray.toList(workExperienceArray, WorkExperience.class);
		for (WorkExperience workExperience : workExperienceList) {
			workExperience.setUserId(user.getId());
			if(workExperience.getId() == null){
				this.workExperienceService.insertSelective(workExperience);
			}else{
				this.workExperienceService.updateByPrimaryKeySelective(workExperience);
			}
		}
		updateSSOSystem(user);
		return super.updateByPrimaryKey(user);
	}



	/**
	 * 	更新(报价系统)
	 */
	@Override
	public void updateUserBJ(User user) {
		this.userMapper.updateByPrimaryKeySelective(user);
	}
	
	/**
	 * 	通过条件查询用户
	 */
	@Override
	public List<User> selectUsersByCondition(User user){
		return this.userMapper.selectUsersByCondition(user);
	}

	/**
	 * 	通过条件查询用户
	 */
	@Override
	public User selectUserByCondition(User user){
		List<User> list = this.userMapper.selectUsersByCondition(user);
		return list.size() != 0 ? list.get(0) : null ;
	}

	/**
	 * 	根据id查询
	 */
	@Override
	public User selectById(Integer id) {
		User user = new User();
		user.setId(id);
		return selectUserByCondition(user);
	}

	/**
	 * 	根据email查询
	 */
	@Override
	public User selectByEamil(String email) {
		if(StringUtils.isBlank(email)){
			throw new NullPointerException("邮箱不能为空");
		}
		User user = new User();
		user.setCompanyEmail(email);
		return selectUserByCondition(user);
	}

	/**
	 * 	分页查询
	 */
	@Override
	public Pagination selectByQuery(Integer pageNo, String username, Integer isstatus, Integer dempid,
			Integer companyid, Integer systemRoleid, String terrace) {
		User user = new User();
		if (StringUtils.isNotBlank(username)) {
			user.setUsername(username.trim() + "%");
		}
		if (isstatus != null) {
			user.setIsStatus(isstatus);
		}
		if (dempid != null) {
			user.setDempid(dempid);
		}
		if (companyid != null) {
			user.setCompanyid(companyid);
		}
		if (StringUtils.isNotBlank(terrace)) {
			user.setTerrace(terrace);
		}
		if (systemRoleid != null) {
			user.setSystemRoleid(systemRoleid);
		}
		Page<User> page = PageHelper.startPage(Pagination.cpn(pageNo), 10, true);
		List<User> pageQuery = this.userMapper.pageQuery(user);
		return new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), pageQuery);
	}

	@Override
	public User getReplaceUser(Integer companyId, Integer dempId, String username) {
		User user = null;
		/**
		 * 如果dempId!=null,查找部门内的用户
		 * 否则查找公司内的
		 */
		if(dempId != null){
			List<User> list = userMapper.selectByNameAndDempId(dempId, username);
			if(list != null && list.size() > 0){
				user = list.get(0);
			}
		}else{
			List<User> list = userMapper.selectByNameAndCompanyId(companyId, username);
			if(list != null && list.size() > 0){
				user = list.get(0);
			}
		}
		String hex = AESUtils.decryptHex(user.getReplaceOffer(), AESUtils.ALGORITHM);
		user.setReplaceOffer(hex);
		return user;
	}
	
	/**
	 * 	同步到sso系统并返回ssoid
	 *	@author 	GFF
	 *	@date		2017年6月21日上午9:48:51	
	 * 	@param t
	 * 	@return
	 */
	private Integer saveSSOSystem(User t) {
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("username", t.getUsername());
			map.put("email", t.getCompanyEmail());
			map.put("phone", t.getPhone());
			String id = HttpClienTool.doGet(ssoCreateUrl, map);
			return StringUtils.isNoneBlank(id) ? Integer.decode(id) : null;
		} catch (NumberFormatException e) {
			throw new RuntimeException("该企业邮箱已经存在");
		}
	}

	/**
	 * 	更新sso系统
	 *	@author 	GFF
	 *	@date		2017年6月21日上午11:04:29	
	 * 	@param user
	 */
	private String updateSSOSystem(User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", user.getUsername());
		map.put("email", user.getCompanyEmail());
		map.put("phone", user.getPhone());
		map.put("roleId", user.getPositionid());
		map.put("id", user.getSsoId());
		map.put("openid", user.getOpenid());
		return HttpClienTool.doGet(ssoUpdateUrl, map);
		
	}
	
	/**
	 * 	根据用户名称查询
	 */
	@Override
	public List<User> selectUserByUsername(String username) {
		if(StringUtils.isBlank(username)){
			throw new RuntimeException("用户名不能为空");
		}
		User user = new User();
		user.setUsername(username);
		return this.selectUsersByCondition(user);
	}

	/**
	 * 	查询用户详情
	 */
	@Override
	public User selectUserDetail(Integer id) {
		User user = this.selectById(id);
		List<Salary> salary = this.salaryService.selectSalaryByUserId(user.getId());
		if(salary.size() == 0 ){
			salary = GetJsonFileUtils.getSalary();
		}
		salary.stream().forEach(sa -> sa.setUserId(user.getId()));
		user.setSalarys(salary);
		WorkExperience workExperience = new WorkExperience();
		workExperience.setUserId(user.getId());
		List<WorkExperience> workExperiences = this.workExperienceService.select(workExperience );
		if(workExperiences.size() == 0){
			workExperiences = GetJsonFileUtils.getWorkExperience();
		}
		workExperiences.stream().forEach(work -> work.setUserId(user.getId()));
		user.setWorkExperiences(workExperiences);
		Education education = new Education();
		education.setUserId(user.getId());
		List<Education> educations = this.educationService.select(education );
		if(educations.size() == 0){
			educations = GetJsonFileUtils.getEducationList();
		}
		educations.stream().forEach( edu -> edu.setUserId(user.getId()));
		user.setEducations(educations);
		FamilyMember familyMember = new FamilyMember();
		familyMember.setUserId(user.getId());
		List<FamilyMember> familyMembers = this.familyMemberService.select(familyMember );
		if(familyMembers.size() == 0){
			familyMembers = GetJsonFileUtils.getFamilyMembers();
		}
		familyMembers.stream().forEach(family -> family.setUserId(user.getId()));
		user.setFamilyMembers(familyMembers);
		return user;
	}

	@Override
	public User getReplaceUser(Integer companyI) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 	根据入职时间与入职申请单号获取工号
	 */
	@Override
	public String selectEmployeeNumberByHiredateAndEntryId(Integer entryId) {
		FlowEntry flowEntry = this.flowEntryService.selectByPrimaryKey(entryId);
		Date date = flowEntry.getEntryDate();
		Date startDate = DateUtils.updateDateByCondition(date, null, null, 1, null);
		System.out.println(DateUtils.convert(startDate, DateUtils.DATE_FORMAT_C));
		Date endDate = DateUtils.updateDateByCondition(date, null, null, 31, null);
		System.out.println(DateUtils.convert(endDate, DateUtils.DATE_FORMAT_C));
		Example example = new Example(User.class);
		example.createCriteria().andCondition(" hiredate >= " , startDate).andCondition(" hiredate <= ", endDate);
		example.orderBy(" hiredate ").desc();
		List<User> list = this.userMapper.selectByExample(example );
		String fileName = DateUtils.getInTimeYearORmonthORday(date, Calendar.YEAR)+"";
		Integer month = DateUtils.getInTimeYearORmonthORday(date, Calendar.MONTH)+1;
		if(month.toString().length() < 2){
			fileName = fileName + 0 + month;
		}else{
			fileName += month;
		}
		if(list.size() > 0){
			if(StringUtils.isNoneBlank(list.get(0).getFilenumber())){
			String fileNumber = list.stream().map(user -> user.getFilenumber()).max(new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					return Integer.decode(o1) - Integer.decode(o2);
				}
			}).get();
				String number = fileNumber.substring(fileNumber.length()-2, fileNumber.length());
				Integer decode = Integer.decode(number)+1;
				if(decode.toString().length() < 2){
					return fileName+0+decode;
				}else{
					return fileName+decode;
				}
			}
		}
		return fileName+0+1;
	}

	/**
	 * 	根据申请单 用户名称查询companyEmail
	 */
	@Override
	public Object[] selectPeopleWhoCopiedEmailByUsername(String username, Integer applyId) {
		
		if(StringUtils.isNoneBlank(username)){
			List<User> list = this.selectUserByUsername(username);
			if(list.size() > 0 ){
				return new String[]{list.get(0).getCompanyEmail()};
			}else{
				throw new RuntimeException("不存在该用户");
			}
		}
		FlowEntry flowEntry = this.flowEntryService.selectById(applyId);
		if(flowEntry == null){
			throw new RuntimeException("没有查询到申请单");
		}
		User record = new User();
		record.setCompanyid(flowEntry.getCompanyId());
		record.setUsername(username);
		record.setIsdelete(0);
		List<User> list = this.select(record );
		if(list.size() == 0){
			List<User> emails = this.selectUserByUsername(username);
			Object[] objects = emails.stream().map(email -> email.getCompanyEmail()).toArray();
			return objects;
		}
		Object[] objects = list.stream().map(user -> user.getCompanyEmail()).toArray();
		return objects;
	}

	@Override
	public String updateCompanyEmailOnPassword(String companyEmail, String password, Integer id) {
		Map<String, Object> map = new HashMap<>();
		User user = this.selectByPrimaryKey(id);
		if(!companyEmail.equals(user.getCompanyEmail())){
			user.setCompanyEmail(companyEmail);
			super.updateByPrimaryKeySelective(user);
		}
		map.put("email", companyEmail);
		map.put("newPassword", password);
		map.put("id", user.getId());
		map.put("ssoid", user.getSsoId());
		String string = HttpClienTool.doGet(ssoUpdateEmailOrPasswordUrl, map);
		if(StringUtils.isBlank(string)){
			throw new RuntimeException("请检测是否已存在该邮箱");
		}
		return string;
	}

	@Override
	public String resetPasswords(String emails, String newPassword) {
		String[] strings = emails.split(",");
		List<String> email = new ArrayList<>();
		if(strings == null || strings.length == 0 ){
			throw new RuntimeException("邮箱不能为空");
		}
		for (int i = 0; i < strings.length; i++) {
			if(StringUtils.isNoneBlank(strings[i].trim())){
				email.add(strings[i]);
			}
		}
		emails = StringUtils.join(email, ",");
		Map<String, Object> map = new HashMap<>();
		map.put("emails", emails);
		map.put("newPassword", newPassword);
		return HttpClienTool.doGet(ssoUpdateBatchUpdate, map);
	}

	@Override
	public List<User> selectUsers(User user) {
		return userMapper.selectUsers(user);
	}
	
}
