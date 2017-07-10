package com.pj.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pj.config.base.mapper.MyMapper;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Organization;

public interface CompanyMapper extends MyMapper<Company> {

	/**
	 * 根据用户权限查询所负责公司信息
	 * @author limr
	 * @param userId
	 * @return
	 */
	List<Company> getByAuthUser(@Param(value = "userId") Integer userId);

	/**
	 * 	根据id获取父节节点
	 *	@author 	GFF
	 *	@date		2017年6月28日上午10:23:16	
	 * 	@param id
	 * 	@return
	 */
	Company selectParentCompanyById(int id);
	
	
	List<Company> selectByUserid(@Param(value = "userid") Integer userid,@Param(value = "menuid") Integer menuid);

	/**
	 * 得到所有公司，pId记录number
	 * @author limr
	 * @return
	 */
	List<Organization> selectOransNotDeleteALL();

	/**
	 * 根据id得到所有父级以及本机编号
	 * @author limr
	 * @param id
	 * @return
	 */
	List<String> selectParentsById(Integer id);
	
}