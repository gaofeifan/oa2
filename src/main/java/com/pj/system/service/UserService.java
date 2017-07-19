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

	/**
	 * 根据替代人员姓名查询用户
	 * @author limr
	 * @param companyId
	 * @param dempId
	 * @param username
	 * @return
	 */
	User getReplaceUser(Integer companyId, Integer dempId, String username);

	/**
	 * 	根据用户名称查询
	 *	@author 	GFF
	 *	@date		2017年6月26日下午3:13:03	
	 * 	@param username
	 * 	@return
	 */
	List<User> selectUserByUsername(String username);

	/**
	 * 	查询用户详情
	 *	@author 	GFF
	 *	@date		2017年7月5日上午11:19:34	
	 * 	@param id
	 * 	@return
	 */
	User selectUserDetail(Integer id);

	/**
	 * 	
	 *	@author 	GFF
	 *	@date		2017年7月5日上午11:54:49	
	 * 	@param hiredate
	 * 
	 * 	@param entryId
	 * 	@return
	 */
	String selectEmployeeNumberByHiredateAndEntryId(Integer entryId);

	User getReplaceUser(Integer companyI);

	/**
	 * 	根据申请单 用户名称查询companyEmail
	 *	@author 	GFF
	 *	@date		2017年7月8日下午12:12:25	
	 * 	@param username
	 * 	@param applyId
	 * 	@return
	 */
	Object[] selectPeopleWhoCopiedEmailByUsername(String username, Integer applyId);

	/**
	 * 	修改用户邮箱及密码
	 *	@author 	GFF
	 *	@date		2017年7月18日下午6:10:57	
	 * 	@param companyEmail
	 * 	@param password
	 * @param id 
	 * @return 
	 */
	String updateCompanyEmailOnPassword(String companyEmail, String password, Integer id);

}
