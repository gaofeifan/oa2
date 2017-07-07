package com.pj.system.service.impl;

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
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.config.base.tool.HttpClienTool;
import com.pj.flow.pojo.FlowEntry;
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
import com.pj.utils.DateUtils;

import net.sf.json.JSONArray;
import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, Integer> implements UserService {
	
	@Resource
	private FlowRecruitService flowRecruitService;
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
//	@Resource
//	private ManageProperties manageProperties;
	private static String  ssoCreateUrl = "http://10.0.0.18:8082/sso/userSync/add";
	private static String  ssoUpdateUrl = "http://10.0.0.18:8082/sso/userSync/update";
											
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
			
			
			
			/**
			 * 	修改招聘入职人数
			 */
			/*FlowRecruit recruit = this.flowRecruitService.selectEntryNum(t.getEntryId());
			recruit.setEntryNum(recruit.getEntryNum() != null ?recruit.getEntryNum() +1 : 1);
			this.flowRecruitService.updateByPrimaryKeySelective(recruit);*/
			return i;
		}
		return 0;
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
		salaryList.stream().forEach(salary -> this.salaryService.updateByPrimaryKeySelective(salary));
		/**
		 * 	家庭成员
		 */
		String familyMemberJson = user.getFamilyMembersJson();
		JSONArray jsonArray = JSONArray.fromString(familyMemberJson);
		List<FamilyMember> list = JSONArray.toList(jsonArray, FamilyMember.class);
		list.stream().forEach(familyMember -> this.familyMemberService.updateByPrimaryKeySelective(familyMember));
		
		/**
		 * 	教育经历
		 */
		String educationJson = user.getEducationJson();
		JSONArray educationArray = JSONArray.fromString(educationJson);
		List<Education> educationList = JSONArray.toList(educationArray, Education.class);
		educationList.stream().forEach(education -> this.educationService.updateByPrimaryKeySelective(education));
		
		/**
		 * 	工作经历
		 */
		String workExperienceJson = user.getWorkExperienceJson();
		JSONArray workExperienceArray = JSONArray.fromString(workExperienceJson);
		List<WorkExperience> workExperienceList = JSONArray.toList(workExperienceArray, WorkExperience.class);
		workExperienceList.stream().forEach(work -> this.workExperienceService.updateByPrimaryKeySelective(work));
		updateSSOSystem(user);
		return super.updateByPrimaryKeySelective(user);
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
//		if(StringUtils.isNoneBlank(email)){
//			throw new NullPointerException("邮箱不能为空");
//		}
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
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", t.getUsername());
		map.put("email", t.getCompanyEmail());
		map.put("phone", t.getPhone());
		String id = HttpClienTool.doGet(ssoCreateUrl, map);
		return StringUtils.isNoneBlank(id) ? Integer.decode(id) : null;
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
		map.put("id", user.getSsoId());
		map.put("openid", user.getOpenid());
		return HttpClienTool.doGet(ssoUpdateUrl, map);
		
	}
	
	/**
	 * 	根据用户名称查询
	 */
	@Override
	public List<User> selectUserByUsername(String username) {
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
		user.setSalarys(salary);
		WorkExperience workExperience = new WorkExperience();
		workExperience.setUserId(user.getId());
		List<WorkExperience> workExperiences = this.workExperienceService.select(workExperience );
		user.setWorkExperiences(workExperiences);
		Education education = new Education();
		education.setUserId(user.getId());
		List<Education> educations = this.educationService.select(education );
		user.setEducations(educations);
		FamilyMember familyMember = new FamilyMember();
		familyMember.setUserId(user.getId());
		List<FamilyMember> familyMembers = this.familyMemberService.select(familyMember );
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
		Date endDate = DateUtils.updateDateByCondition(date, null, null, 31, null);
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


}
