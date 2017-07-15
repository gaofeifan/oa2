
package com.pj.system.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.service.BaseService;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Organization;

public interface CompanyService extends BaseService<Company, Integer> {
	
	/**
	 * 	根据名称查询
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:55:34	
	 * 	@param companyName
	 * 	@return
	 */
	Integer selectByName(String companyName);
	
	/**
	 * 	查询是否可以删除
	 *	@author 	GFF
	 *	@date		2017年4月10日下午4:55:57	
	 * 	@param companyId
	 * 	@return
	 */
	Boolean isDeleteCompany(Integer companyId);

	/**
	 * 根据用户权限查询所负责公司信息
	 * @author limr
	 * @param userId
	 * @return
	 */
	List<Company> getByAuthUser(Integer userId);

	/**
	 * 	根据id获取父节节点
	 *	@author 	GFF
	 *	@date		2017年6月28日上午10:09:06	
	 * 	@param companyId
	 * 	@return
	 */
	Company selectParentCompanyById(int companyId);

	/**
	 * 	查询公司 根据人事权限
	 *	@author 	GFF
	 *	@date		2017年7月5日下午7:27:29	
	 * 	@return
	 */
	List<Company> selectCompanyByPersonnelAuthority();

	List<Company> selectByUserid(Integer userid,Integer menuid);

	/**
	 * 得到所有公司，pId记录number
	 * @author limr
	 * @return
	 */
	List<Organization> selectOransNotDeleteALL();

	/**
	 * 查找各公司下边的直接部门或者公司下边直接的岗位,除去已经赋予除userid外的用户的权限
	 * @author limr
	 * @param userid
	 * @param menuid
	 * @param company
	 * @param type
	 * @return
	 */
	List<Organization> getDempsAndPosts(Integer userid, Integer menuid, Organization company, String type);
	/** 
     * @descript:递归部门 
     * @author limr
     * @param dempList 
     * @param type 值为post，只需要得到岗位 
     * @return 
     */  
    public List<Organization> getDepts(List<Organization> organizations, List<Organization> dempList);

    /**
	 * 查找各公司下边type=post时直接的岗位number
	 * @author limr
	 * @param organizations
	 * @return
	 */
	List<String> getPostNumByCompanys(List<Organization> companys);

	/** 
     * @descript:递归部门 只需要得到岗位number
     * @author limr
     * @param dempList 
     * @return 
     */ 
	List<String> getDeptNums(List<String> numbers, List<Organization> dempList);

	/**
	 * 根据pId得到公司list
	 * @author limr
	 * @param pId,pid=null查询第一级
	 * @return
	 */
	List<Organization> selectByPId(@Param(value = "pId") Integer pId);

	/**
	 * 
	 * @param companys
	 * @param string
	 * @return
	 */
	List<Organization> getAllDempsAndPosts(List<Organization> companys);

	
}
