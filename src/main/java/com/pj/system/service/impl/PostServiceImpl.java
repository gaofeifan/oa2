package com.pj.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.PostMapper;
import com.pj.system.pojo.Post;
import com.pj.system.service.PostService;
import com.pj.system.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class PostServiceImpl extends AbstractBaseServiceImpl<Post, Integer> implements PostService {

	@Resource
	private PostMapper postMapper;

	@Resource
	private UserService userService;
	
	@Resource
	private AuthUserService authUserService;

	@Override
	public MyMapper<Post> getMapper() {
		return postMapper;
	}

	/**
	 * 	根据条件查询岗位
	 */
	@Override
	public List<Post> selectALL(Post post) {
		List<Post> posts = this.postMapper.selectALL(post);
		return posts;
	}

	/**
	 * 	根据name查询
	 */
	@Override
	public Integer selectByName(String postName) {
		Example example = new Example(Post.class);
		example.createCriteria().andCondition(" name LIKE "+"%"+postName+"%").andCondition(" isdelete = 0 ");
		List<Post> list = this.postMapper.selectByExample(example);
		return list.size() != 0 ?list.get(0).getId():null;
	}


	/**
	 * 	查询是否可以删除
	 */
	@Override
	public Boolean isDeleteDemp(Integer id) {
		Boolean flag = false;
		return flag;
	}


	/**
	 * 根据名称部门id查询
	 */
	@Override
	public Integer selectByNameANDDempId(Integer dempId, String postName) {
		Example example = new Example(Post.class);
		tk.mybatis.mapper.entity.Example.Criteria criteria = example.createCriteria();
		if(dempId != null){
			criteria.andCondition(" dempId = "+dempId);
		}
		if(StringUtils.isNoneBlank(postName)){
			criteria.andCondition(" name LIKE "+"%"+postName+"%");
		}
		criteria.andCondition(" isdelete = 0 ");
		List<Post> list = this.postMapper.selectByExample(example);
		return list.size() != 0 ? list.get(0).getId() : null;
	}

	@Override
	public List<Post> SelectByUserid(Integer userid,Integer menuid,Integer dempid) {

		List<Post> posts = this.postMapper.SelectByUserid(userid,menuid,dempid);
		return posts;
	}
	

}
