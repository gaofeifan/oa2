package com.pj.system.service.impl;

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
import com.pj.config.base.properties.ManageProperties;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.config.base.tool.HttpClienTool;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.FamilyMemberService;
import com.pj.system.service.PositionService;
import com.pj.system.service.UserService;
import com.pj.system.service.WorkExperienceService;

@Transactional
@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, Integer> implements UserService {
	
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
	private ManageProperties manageProperties;
	@Resource 
	private FamilyMemberService familyMemberService;
	@Resource
	private WorkExperienceService workExperienceService;
	@Override
	public MyMapper<User> getMapper() {
		return userMapper;
	}
	
	@Override
	public int insertSelective(User t) {
		Integer ssoId = saveSSOSystem(t);
		if(ssoId != null){
			int i = insertSelective(updateUserByEntryFrom(t));
			//	保存家庭成员
//			List<FamilyMember> members = t.getFamilyMembers();
//			members.stream().forEach(member -> member.setUserId(t.getId()));
//			members.stream().forEach(familyMember -> this.familyMemberService.insertSelective(familyMember));
			//	保存工作经历
//			List<WorkExperience> workExperiences = t.getWorkExperiences();
//			workExperiences.stream().forEach(workExperience -> workExperience.setUserId(t.getId()));
//			workExperiences.stream().forEach(workExperience -> this.workExperienceService.insertSelective(workExperience));
			//	关联薪资
			
			return i;
		}
		return 0;
	}


	@Override
	public int updateByPrimaryKeySelective(User user) {
		//	更新家庭成员
//		user.getFamilyMembers().stream().forEach(familyMember -> this.familyMemberService.updateByPrimaryKeySelective(familyMember));
		//	更新工作经历
//		user.getWorkExperiences().stream().forEach(workExperience -> this.workExperienceService.updateByPrimaryKeySelective(workExperience));
		User u = this.selectByPrimaryKey(user.getId());
		if(
		   (StringUtils.isNoneBlank(user.getUsername()) ? !user.getUsername().equals(u.getUsername()) :true) ||  
		   (StringUtils.isNoneBlank(user.getCompanyEmail()) ? !user.getCompanyEmail().equals(u.getCompanyEmail()) : true) ||
		   (StringUtils.isNoneBlank(user.getOpenid()) ? !user.getOpenid().equals(u.getOpenid()) : true) ||
		   (StringUtils.isNoneBlank(user.getPhone()) ? !user.getPhone().equals(u.getPhone()) : true)){
			String stauts = updateSSOSystem(user);
			if(StringUtils.isNoneBlank(stauts)){
				return super.updateByPrimaryKeySelective(user);
			}
		}
		return 0;
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
		User user = new User();
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
		String id = HttpClienTool.doGet(manageProperties.httpClienUrlProperties.getSsoCreateUrl(), map);
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
		return HttpClienTool.doGet(manageProperties.httpClienUrlProperties.getSsoUpdateUrl(), map);
		
	}
	
	private User updateUserByEntryFrom(User t) {
		return t;
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
	
	

}
