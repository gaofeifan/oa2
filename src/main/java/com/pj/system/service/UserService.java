package com.pj.system.service;

import java.util.Date;
import java.util.List;

import com.pj.config.base.pojo.page.Pagination;
import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.User;

public interface UserService extends BaseService<User, Integer> {

	/**
	 * 根据id查询
	 * 
	 * @author GFF
	 * @date 2017年4月11日下午2:06:48
	 * @param id
	 * @return
	 */
	User selectById(Integer id);

	/**
	 * 	查询用户(并进行分页)
	 *	@author 	GFF
	 *	@date		2017年4月11日下午2:20:58	
	 * 	@param pageNo
	 * 	@param username
	 * 	@param isstatus
	 * 	@param dempid
	 * 	@param companyid
	 * 	@param pageSize
	 * 	@param roleid
	 * 	@param terrace
	 * 	@return
	 */
	Pagination selectByQuery(Integer pageNo, String username, Integer isstatus, Integer dempid,
			Integer companyid, Integer pageSize, Integer roleid, String terrace);

	/**
	 * @author limr 得到合同到期员工
	 * @param comppdate
	 * @return
	 */
	List<User> selectByComppdate(String comppdate);

	/**
	 * @author limr 得到要转正员工
	 * @param comppdate
	 * @return
	 */
	List<User> selectByPbspdate(String pbspdate);

	/**
	 * 根据职位查询用户
	 * 
	 * @author GFF
	 * @date 2017年4月11日下午2:07:44
	 * @param positionid
	 * @return
	 */
	User selectByPositionId(Integer positionid);

	/**
	 * 根据用户名查找用户
	 * 
	 * @author GFF
	 * @date 2017年4月11日下午2:13:37
	 * @param username
	 * @return
	 */
	public User selectByUsername(String username);

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */

	/**
	 * 根据用户名称和入职时间获取用户
	 * 
	 * @author GFF
	 * @date 2017年4月11日下午2:08:13
	 * @param entrydate
	 * @param changesname
	 * @return
	 */
	User selectByHiredateAndUsername(Date entrydate, String changesname);

	/**
	 * 根据email查询
	 * 
	 * @author GFF
	 * @date 2017年4月11日下午2:08:32
	 * @param email
	 * @return
	 */
	User selectByemail(String email);



	/**
	 * 根据sso（单点登录系统）id查询user
	 * @author GFF
	 * @date 2017年4月11日下午2:08:56
	 * @param ssoId
	 * @return
	 */
	User selectBySsoId(Integer ssoId);

//	void saveWeiXinUserMessage(String appid, String appsecret, String code, String email) throws Exception;

	/**
	 * 
	 * @param user
	 *            优化代码二期使用
	 * @param isDecodePay
	 *            是否返回薪资解密信息 true false（默认）
	 * @return 返回满足条件数据（list集合）
	 */
	User findUserByCondition(User user, Boolean isDecodePay);


	/**
	 * 查询用户是否可以登录
	 * 
	 * @author GFF
	 * @date 2017年1月22日下午5:27:43
	 * @param id
	 * @return
	 */
	boolean selectUserIsLogin(Integer id);

	/**
	 * 	更新
	 *	@author 	GFF
	 *	@date		2017年4月11日下午2:34:26	
	 * 	@param user
	 */
	void updateUserBJ(User user);

	/**
	 * 	批量擦还让
	 *	@author 	GFF
	 *	@date		2017年4月11日下午2:35:39	
	 * 	@param list
	 */
	void saveBatch(List<User> list);
	
	/**
	 * 	查询审批用户
	 *	@author 	GFF
	 *	@date		2017年4月11日下午2:38:03	
	 * 	@param user
	 * 	@return
	 */
	User selectApproveUser(User user);

}
