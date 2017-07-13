package com.pj.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.DempMapper;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Organization;
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
	@Autowired
	private AuthUserService authUserService;
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

	/**
	 * 	查询
	 *	@author 	GFF
	 *	@date		2017年7月5日下午7:17:14	
	 * 	@param dempId
	 * 	@return
	 */
	@Override
	public Demp selectParentDempById(Integer dempId) {
		return this.dempMapper.selectParentDempById(dempId);
	}

	/**
	 * 	查询部门通过人事权限
	 *	@author 	GFF
	 *	@date		2017年7月5日下午7:19:00	
	 * 	@return
	 */
	@Override
	public List<Demp> selectDempByPersonnelAuthority(Integer companyId) {
		List<Demp> demps = null; 
		if(companyId != null){
			Demp record = new Demp();
			record.setCompanyid(companyId);
			record.setIsdelete(0);
			demps = this.select(record );
		}else{
			demps = this.selectNotDeleteALL();
		}
		List<Demp> deleteDemp = new ArrayList<>();
		for (Demp demp : demps) {
			List<Post> deletePost = new ArrayList<>();
			Post record = new Post();
			record.setDempId(demp.getId());
			record.setIsdelete(0);
			List<Post> posts = this.postService.select(record);
			AuthUser authUser = new AuthUser();
			authUser.setDempid(demp.getId());
			List<AuthUser> authPosts = this.authUserService.select(authUser );
			List<Integer> postIds = authPosts.stream().map(post -> post.getPostid()).collect(Collectors.toList());
			for (Post post : posts) {
				if(postIds.contains(post.getId())){
					deletePost.add(post);
				}
			}
			for (Post post : deletePost) {
				posts.remove(post);
			}
			
			if(posts.size() == 0){
				deleteDemp.add(demp);
			}
		}
		for (Demp demp : deleteDemp) {
			demps.remove(demp);
		}
		return demps;
	}

	@Override
	public List<Demp> SelectByUserid(Integer menuid, Integer userid,Integer companyid) {
		return this.dempMapper.SelectByUserid(menuid,userid,companyid);
	}

	@Override
	public List<Organization> selectOrgansByCompanyId(Integer companyId) {
		return dempMapper.selectOrgsByCompanyId(companyId);
	}

	@Override
	public List<Organization> selectOrgansByPId(Integer dempId) {
		return dempMapper.selectOrgsByPId(dempId);
	}
	
	
	
}
