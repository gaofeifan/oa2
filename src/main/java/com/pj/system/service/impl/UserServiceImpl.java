
package com.pj.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.mapper.UserMapper;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Post;
import com.pj.system.pojo.User;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.MessageService;
import com.pj.system.service.PositionService;
import com.pj.system.service.RankService;
import com.pj.system.service.UserService;
import com.pj.utils.DateUtils;

@Transactional
@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<User, Integer> implements UserService {

	private static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	@Resource
	private UserMapper userMapper;
	@Resource
	private DempMapper dempMapper;
	@Resource
	private PostMapper postMapper;
	@Resource
	private PositionService positionService;
	@Resource
	private RankService rankService;
	@Resource
	private MessageService messageService;
	@Resource
	private CompanyService companyService;
	@Resource
	private DempService dempService;
	@Override
	public MyMapper<User> getMapper() {
		return userMapper;
	}
	
	/**
	 * 	新增
	 */
	@Override
	public int insertSelective(User user) {
		// 根据dempid查询demp ， demp关联company ， 更新demp
		if (user.getDempid() != null) {
			Demp demp = this.dempMapper.selectByPrimaryKey(user.getDempid());
			user.setCompanyid(demp.getCompanyid());
		}
		// 根据postid查询post ， post关联position ， 更新position
		if (user.getPostid() != null) {
			Post post = this.postMapper.selectByPrimaryKey(user.getPostid());
			user.setPositionid(post.getPositionid());
		}
		user.setRoleid(user.getPositionid() != null ? user.getPositionid() : null);
		try {
//			String ssoId = HttpclientUtils.sendGet(user.getUsername(), MyApplyUtils.HTTPCLIENT_URL, user.getEmail(),
//					user.getPhone(), user.getRoleid());
//			user.setSsoId(Integer.decode(ssoId));
		} catch (Exception e) {
			throw new RuntimeException("同步sso库异常");
		}
		// 保存用户
		this.userMapper.insertSelective(user);
		return 0;

	}

	/**
	 * 	根据id查询
	 */
	public User selectById(Integer id) {
		User user = this.findUserByCondition(new User(id), true);
		return user;
	}

	/**
	 * 	更新
	 */
	@Override
	public int updateByPrimaryKeySelective(User user) {
		if (user.getDempid() != null) {
			Demp demp = this.dempMapper.selectByPrimaryKey(user.getDempid());
			user.setCompanyid(demp.getCompanyid());
		}
		// 更新post中的positionid
		if (user.getPostid() != null) {
			Post post = this.postMapper.selectByPrimaryKey(user.getPostid());
			user.setPositionid(post.getPositionid());
		}

		try {
			user.setRoleid(user.getPositionid() != null ? user.getPositionid() : null);
//			HttpclientUtils.update(user.getSsoId(), user.getUsername(), MyApplyUtils.HTTPCLIENT_URL_UPDATE,
//					user.getEmail(), user.getPhone(), user.getRoleid(), user.getOpenid());
//			log.info("HttpclientUtils.update 同步更新sso项目数据");
		} catch (Exception e) {
			log.error("同步更新sso项目数据失败 : " + e.getMessage());
			throw new RuntimeException("同步更新sso项目数据失败 : " + e.getMessage());
		}
		// 更新user
		this.userMapper.updateByPrimaryKey(user);
		log.info("更新用户 UserServiceImpl.userMapper.updateByPrimaryKeySelective");
		return 0;

	}
	/**
	 * 	分页查询
	 */
	@Override
	public Pagination selectByQuery(Integer pageNo, String username, Integer isstatus, Integer dempid,
			Integer companyid, Integer pageSize, Integer systemRoleid, String terrace) {
		User user = new User();
		// 判读查询条件不为空
		if (username != null && !username.equals("")) {
			user.setUsername("%" + username.trim() + "%");
		}

		if (isstatus != null) {
			user.setIsstatus(isstatus);
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

		user.setIsdelete(0);
		user.setPageNo(Pagination.cpn(pageNo));
		user.setPageSize(pageSize);
		List<User> list = this.userMapper.pageQuery(user);
		Integer totalCount = this.userMapper.selectUserCount(user);
		Pagination pagination = new Pagination(user.getPageNo(), user.getPageSize(), totalCount, list);
		return pagination;
	}

	/**
	 * 	批量插入
	 */
	public void saveBatch(List<User> list) {
		for (User user : list) {
			try {
				if (user.getPostid() != null) {
					Post post = this.postMapper.selectByPrimaryKey(user.getPostid());
					if (post != null) {
						user.setPositionid(post.getPositionid());
					}
				}
				user.setRoleid(user.getPositionid() != null ? user.getPositionid() : null);
//				String ssoId = HttpclientUtils.sendGet(user.getUsername(), MyApplyUtils.HTTPCLIENT_URL, user.getEmail(),
//						user.getPhone(), user.getRoleid());
//				user.setSsoId(Integer.decode(ssoId));
				// 将薪资进行加密
				this.userMapper.insertSelective(user);

				
				
				
				
			} catch (Exception e) {
				log.error("同步异常 ：" + user.getUsername() + " --> 用户数据异常 :" + e.getMessage());
				throw new RuntimeException(user.getUsername() + "用户数据异常");
			}
		}
	}
	
	/**
	 * 	根据合同终止时间查询
	 */
	@Override
	public List<User> selectByComppdate(String comppdate) {
		User user = new User();
		user.setComppdate(DateUtils.convert(comppdate, DateUtils.DATE_FORMAT));
		List<User> list = this.findUserListByCondition(user, true);
		return list;
	}

	/**
	 * 	根据试用期截止时间查询
	 */
	@Override
	public List<User> selectByPbspdate(String pbspdate) {
		User user = new User();
		user.setPbspdate(DateUtils.convert(pbspdate, DateUtils.DATE_FORMAT));
		List<User> userList = userMapper.selectByDate(user);
		return userList;
	}
	
	/**
	 * 	根据职位查询
	 */
	@Override
	public User selectByPositionId(Integer positionid) {
		User user = new User();
		user.setPositionid(positionid);
		user.setIsdelete(0);
		List<User> list = this.userMapper.select(user);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User selectByUsername(String username) {
		User user = this.findUserByCondition(new User(username, 0, null), true);
		return user;
	}


	
	/**
	 * 	根据用户名称和入职时间获取用户
	 */
	@Override
	public User selectByHiredateAndUsername(Date hiredate, String username) {
		List<User> list = this.userMapper.select(new User(username, 0, hiredate));
		return list.size() > 0 ? list.get(0) : null;
	}
	/**
	 * 	根据email查询
	 */
	@Override
	public User selectByemail(String email) {
		User user = this.findUserByCondition(new User(email), true);
		return user;
	}
	@Override
	public User selectBySsoId(Integer ssoId) {
		User user = new User();
		user.setSsoId(ssoId);
		return this.findUserByCondition(user, false);
	}



	/**
	 * 
	 * @param user
	 *            根据条件查询user（返回所有）
	 * @param isDecodePay
	 *            是否返回薪资解密信息 true false（默认）
	 * @return 返回满足条件数据（list集合）
	 */
	public List<User> findUserListByCondition(User user, Boolean isDecodePay) {
		List<User> users = this.userMapper.findUserListByCondition(user);
		if (isDecodePay) {
//			for (User u : users) {
//			}
		}
		return users;
	}

	/**
	 * 
	 * @param user
	 *            根据条件获取user（当查询的数据存在多条时只会返回第一条）
	 * @param isDecodePay
	 *            是否返回薪资解密信息 true false（默认）
	 * @return 返回满足条件数据（user对象）
	 */
	public User findUserByCondition(User user, Boolean isDecodePay) {
		List<User> list = this.findUserListByCondition(user, isDecodePay);
		return list.size() != 0 ? list.get(0) : null;
	}

/*	public void saveWeiXinUserMessage(String appid, String appsecret, String code, String email) throws Exception {
		OAuthAccessToken accessToken = this.weiXinService.getOAuthAccessToken(appid, appsecret, code);
		UserEntity userEntity = this.weiXinService.acceptOAuthUserNews(accessToken.getAccessToken(),
				accessToken.getOpenid());
		log.info("accessToken(获取微信token) :" + accessToken.toString());
		// 将所需要的信息保存到数据库中
		User user = this.selectByemail(email);
		user.setAccessToken( accessToken.getAccessToken());
		user.setWeChatName(userEntity.getNickname());
		user.setOpenid(accessToken.getOpenid());
		this.updateByPrimaryKeySelective(user);
	}*/


	@Override
	public boolean selectUserIsLogin(Integer id) {
		User user = this.findUserByCondition(new User(id), false);
		if (user.getIsstatus() == 1) {
			return true;
		}
		return false;
	}

	/**
	 * 	更新(报价系统)
	 */
	@Override
	public void updateUserBJ(User user) {
		this.userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 	查询审批用户
	 */
	@Override
	public User selectApproveUser(User user) {
		return this.findUserByCondition(user, false);
	}

	
}
