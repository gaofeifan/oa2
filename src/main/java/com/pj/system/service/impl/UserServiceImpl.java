
package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.PositionService;
import com.pj.system.service.UserService;

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
	
	@Override
	public MyMapper<User> getMapper() {
		return userMapper;
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
		List<User> result = page.getResult();
		return new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), pageQuery);
	}
}
