package com.pj.system.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.DempMapper;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Post;
import com.pj.system.pojo.User;
import com.pj.system.service.DempService;
import com.pj.system.service.PostService;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class DempServiceImpl extends AbstractBaseServiceImpl<Demp, Integer> implements DempService {

	@Resource
	private UserService userService;
	@Resource
	private DempMapper dempMapper;
	@Autowired
	private PostService postService;
	
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
		Boolean flag = true;
		//	查询user
		User user = new User();
		user.setIsdelete(0);
		user.setDempid(id);
		List<User> userList = this.userService.select(user );
		//	查询是否有子节点
		List<Demp> dempList = selectDempChildListById(id);
		Post record = new Post();
		record.setDempId(id);
		record.setIsdelete(0);
		List<Post> postList = this.postService.select(record );
		if(userList.size() == 0 || dempList.size() < 2 || postList.size() == 0){
			flag = false;
		}
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

	/**
	 * 	获取当前id的所有父节点
	 */
	@Override
	public List<Demp> selectDempParentListById(Integer id){
		return this.dempMapper.selectDempParentListById(id);
	}

	/**
	 * 	获取当前id的所有子集
	 */
	@Override
	public List<Demp> selectDempChildListById(Integer id){
		return this.dempMapper.selectDempChildListById(id);
	}

	/**
	 * 	获取当前id的所有父节点的名称并以-分隔
	 */
	@Override
	public String selectDempParentNameById(Integer id) {
		
		Object[] array = this.selectDempParentListById(id).stream().map(demp -> demp.getName()).toArray();
		String[] strs = Arrays.asList( array ).toArray( new String[0] );
		String names = StringUtils.join(strs, "-");
		return names;
	}
	
}
