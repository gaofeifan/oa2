package com.pj.system.service;

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
	 * 根据公司email查询
	 * 
	 * @author GFF
	 * @date 2017年4月11日下午2:06:48
	 * @param id
	 * @return
	 */
	User selectByEamil(String email);

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
	 * 	@param terrace
	 * 	@return
	 */
	Pagination selectByQuery(Integer pageNo, String username, Integer isstatus, Integer dempid,
			Integer companyid, Integer pageSize, String terrace);


	/**
	 * 	更新
	 *	@author 	GFF
	 *	@date		2017年4月11日下午2:34:26	
	 * 	@param user
	 */
	void updateUserBJ(User user);

	/**
	 * 	通过条件查询用户
	 *	@author 	GFF
	 *	@date		2017年6月20日下午2:45:30	
	 * 	@param user
	 * 	@return
	 */
	List<User> selectUsersByCondition(User user);
	
	/**
	 * 	通过条件查询用户
	 *	@author 	GFF
	 *	@date		2017年6月20日下午2:45:30	
	 * 	@param user
	 * 	@return
	 */
	User selectUserByCondition(User user);

	
}
