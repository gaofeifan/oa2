package com.pj.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Organization;
import com.pj.system.pojo.Post;
import com.pj.system.service.PostService;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class PostServiceImpl extends AbstractBaseServiceImpl<Post, Integer> implements PostService {

	@Resource
	private PostMapper postMapper;
	
	@Resource
	private CompanyMapper companyMapper;
	
	@Resource
	private DempMapper dempMapper;

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

	@Override
	public List<Organization> selectLinealsByCompanyId(Integer companyId) {
		return postMapper.selectLinealsByCompanyId(companyId);
	}

	@Override
	public List<Organization> selectLinealsByDempId(Integer dempId) {
		return postMapper.selectLinealsByDempId(dempId);
	}
	@Override
	public int insertSelective(Post post) {
		post.setSignNum(getSignNum(post));
		return super.insertSelective(post);
	}
	@Override
	public void updateSignNum() {
		List<Post> posts = selectNotDeleteALL();
		
		for(Post post : posts){
			List<String> cNum = new ArrayList<String>();
			Integer dempId = post.getDempId();
			Integer companyId = post.getCompanyId();
			if(dempId == null){
				cNum = getCNum(cNum, companyId);
			}else{
				cNum = getDNum(cNum, dempId);
			}
			String cdNums = cNum.get(cNum.size() - 1);
			for(int i = cNum.size() - 2; i>=0; i--){
				cdNums += "-" + cNum.get(i);
			}
			
			post.setSignNum(cdNums + "-" + post.getNumber());
			postMapper.updateByPrimaryKeySelective(post);
		}
		
	}
	public void updateSignNum1() {
		List<Post> posts = selectNotDeleteALL();
		for(Post post : posts){
			List<String> companyNumList = companyMapper.selectParentsById(post.getCompanyId());
			String companyNums = companyNumList.get(0);
			for (int i = 1; i < companyNumList.size(); i++) {
				companyNums += "-" + companyNumList.get(i);
			}
			Integer dempId = post.getDempId();
			String dempNums = "";
			if(dempId != null && dempId != 0){
				List<Demp> demps = dempMapper.selectDempParentListById(dempId);
				for (int i = 0; i < demps.size(); i++) {
					dempNums += "-" + demps.get(i).getNumber();
				}
			}
			post.setSignNum(companyNums + dempNums + "-" + post.getNumber());
			postMapper.updateByPrimaryKeySelective(post);
		}
		
	}
	private List<String> getCNum(List<String> cNum, Integer companyId) {
		Company company = companyMapper.selectByPrimaryKey(companyId);
		String pCNum = company.getNumber();
		cNum.add(pCNum);
		if(company.getpId() != null){
			cNum = getCNum(cNum, company.getpId());
		}
		return cNum;
	}
	private List<String> getDNum(List<String> cNum, Integer dempId) {
		Demp demp = dempMapper.selectByPrimaryKey(dempId);
		String pDNum = demp.getNumber();
		cNum.add(pDNum);
		if(demp.getpId() == null){
			//找公司
			cNum = getCNum(cNum, demp.getCompanyid());
		}else{
			cNum = getDNum(cNum, demp.getpId());
		}
		return cNum;
	}

	@Override
	public void updatePost(Post post) {
		
		post.setSignNum(getSignNum(post));
		super.updateByPrimaryKeySelective(post);
		
	}
	private String getSignNum(Post post) {
		/**
		 * 得到选中的公司id得到所有上级以及本级公司编号，
		 * 根据选中的部门id得到所有上级以及本级部门编号，
		 * 拼接为机构编码保存
		 */
		List<String> companyNumList = companyMapper.selectParentsById(post.getCompanyId());
		String companyNums = companyNumList.get(0);
		for (int i = 1; i < companyNumList.size(); i++) {
			companyNums += "-" + companyNumList.get(i);
		}
		Integer dempId = post.getDempId();
		String dempNums = "";
		if(dempId != null && dempId != 0){
			List<Demp> demps = dempMapper.selectDempParentListById(dempId);
			for (int i = 0; i < demps.size(); i++) {
				dempNums += "-" + demps.get(i).getNumber();
			}
		}
		String signNum = companyNums + dempNums + "-" + post.getNumber();
		return signNum;
	}
}
