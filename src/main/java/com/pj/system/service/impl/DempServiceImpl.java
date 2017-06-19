package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.DempMapper;
import com.pj.system.pojo.Demp;
import com.pj.system.service.DempService;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class DempServiceImpl extends AbstractBaseServiceImpl<Demp, Integer> implements DempService {

	@Resource
	private UserService userService;
	@Resource
	private DempMapper dempMapper;

	@Override
	public MyMapper<Demp> getMapper() {
		return dempMapper;
	}
	
	/**
	 * 	获取公司下的所有部门
	 */
	@Override
	public List<Demp> selectByCompanyId(Integer companyId) {
		return this.dempMapper.select(new Demp(null, companyId, 0));
	}

	/**
	 * 	
	 *	@author 	GFF
	 *	@date		2017年4月10日下午5:38:57	
	 * 	@param id
	 * 	@return
	 */
	@Override
	public Boolean isDeleteDemp(Integer id) {
		Boolean flag = false;
//		List<User> users = this.userService.findUserByDempIdAndCompanyId(id, null);
//		List<Demp> list = this.select(new Demp(null, null, null, null, 0, id));
//		if(users.size() == 0 && list.size() == 0){
//			flag = true;
//		}else{
//			flag = false;
//		}
		return flag;
	}
	
	/**
	 * 根据部门名称公司id查询
	 */
	@Override
	public Integer selectByNameANDCompanyId(Integer companyId, String dempName) {
		Example example = new Example(Demp.class);
		tk.mybatis.mapper.entity.Example.Criteria criteria = example.createCriteria();
		if(companyId != null){
			criteria.andCondition(" companyid = "+companyId);
		}
		if(StringUtils.isNotBlank(dempName)){
			criteria.andCondition(" name LIKE "+"%"+dempName+"%");
		}
		criteria.andCondition(" isdelete = 0");
		List<Demp> list = this.dempMapper.selectByExample(example);
		return list.size() != 0 ? list.get(0).getId() : null;
	}

	@Override
	public List<Demp> selectEliminateSubset(Integer id) {
		return this.dempMapper.selectEliminateSubset(id);
	}

}
