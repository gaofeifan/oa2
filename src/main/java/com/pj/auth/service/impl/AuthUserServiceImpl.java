package com.pj.auth.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthMenuMapper;
import com.pj.auth.mapper.AuthUserMapper;
import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.pojo.Organization;
import com.pj.system.pojo.Post;
import com.pj.system.service.CompanyService;
import com.pj.system.service.PostService;

@Service
@Transactional
public class AuthUserServiceImpl extends AbstractBaseServiceImpl<AuthUser, Integer> implements AuthUserService{

	@Resource
	private AuthUserMapper authUserMapper;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PostService postService;
	
	@Resource
	private CompanyMapper companyMapper;
	
	@Resource
	private DempMapper dempMapper;
	
	@Resource
	private PostMapper postMapper;
	
	@Resource
	private AuthMenuMapper authMenuMapper;
	
	@Override
	public MyMapper<AuthUser> getMapper() {
		return authUserMapper;
	}

	@Override
	public void insertAuthUser(String type, Integer menuId, Integer grade, String number, Integer userid, Integer isSelected) {
		/**
		 * 判断type类型，如果是post，则岗位编码不为空，
		 * 若是menu，只需要menuid,根据menuid查询菜单表，得到menuid下边所有的第三级的menu
		 * 		isSelected==1，保存菜单权限,根据menuId得到两级父类id保存到menuids
		 * 		isSelected==0，取消菜单权限,根据menuId查找auth_user，得到数据删除
		 * 
		 * 若是post,,menuId是第三级id,
		 * grade==1,则得到所有的三级菜单全选，保存所有岗位,menuid均保存第三级id
		 * 			如取消，得到所有三级thirdMenuId,则根据thirdMenuId和userid删除
		 * grade==2,保存2级下的子菜单的所有岗位
		 * 			如取消，得到所有三级thirdMenuId,则根据thirdMenuId和userid删除
		 * grade==3,保存此三级下的所有岗位，
		 * 			如取消，则根据menuId和userid删除
		 * grade>3,则判断number以什么开头，
		 * 		若是C,则是公司，查找公司下边所有的岗位，包含子公司以及子部门下的
		 * 			若取消，则根据userid,menuid和公司下所有岗位number删除
		 * 		若是DEMP,则是部门，查找部门下所有岗位，包含子部门下的
		 * 			若取消，则根据userid,menuid和部门下所有岗位number删除
		 * 		若是ST,则是岗位，直接保存或取消
		 * 			若取消，则根据userid,menuid和number删除
		 */
		
		switch (type) {
		case "menu":

			//只需要保存或取消菜单权限,查找数据库如果已存在，则不保存
			switch (grade) {
			case 1:

				//选中，则保存
				List<Integer>  secondMenuIds = authMenuMapper.selectByFid(menuId);
				if(isSelected == 1){
					for(Integer secondMenuId : secondMenuIds){
						List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuId);
						for (Integer thirdMenuId : thirdMenuIds) {
							//选中，则保存
							String menuids = menuId + "-" + secondMenuId + "-" + thirdMenuId;
							insertAuthUser(userid, thirdMenuId, menuids);
						}
					}
				}else{
					//取消选中，删除
					for(Integer secondMenuId : secondMenuIds){
						List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuId);
						for (Integer thirdMenuId : thirdMenuIds) {
							authUserMapper.deleteByUserMenuPost(userid, thirdMenuId, null);
						}
					}
				}
			
				break;

			case 2:

				List<Integer> thirdMenuIds = authMenuMapper.selectByFid(menuId);
				if(isSelected == 1){
					//选中，则保存
					Integer topFid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
					for (Integer thirdMenuId : thirdMenuIds) {
						//选中，则保存
						String menuids = topFid + "-" + menuId + "-" + thirdMenuId;
						
						insertAuthUser(userid, thirdMenuId, menuids);
					}
				}else{
					//取消选中，删除
					for (Integer thirdMenuId : thirdMenuIds) {
						authUserMapper.deleteByUserMenuPost(userid, thirdMenuId, null);
					}
				}
			
				break;
			case 3:

				if(isSelected == 1){
					//选中，则保存
					Integer fid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
					Integer topFid = authMenuMapper.selectByPrimaryKey(fid).getFid();
					String menuids = topFid + "-" + fid + "-" + menuId;
					insertAuthUser(userid, menuId, menuids);
				}else{
					//取消选中，删除
					authUserMapper.deleteByUserMenuPost(userid, menuId, null);
				}
			
				break;
			}
			
			break;

		case "post":

			/* 若是post,
			 * grade==1,则得到所有的三级菜单全选，保存所有岗位,menuid均保存第三级id
			 * 			如取消，得到所有三级thirdMenuId,则根据thirdMenuId和userid删除
			 * grade==2,保存2级下的子菜单的所有岗位
			 * 			如取消，得到所有三级thirdMenuId,则根据thirdMenuId和userid删除
			 * grade==3,保存此三级下的所有岗位，
			 * 			如取消，则根据menuId和userid删除
			 * grade>3,则判断number以什么开头，
			 * 		若是C,则是公司，查找公司下边所有的岗位，包含子公司以及子部门下的
			 * 			若取消，则根据userid,menuid和公司下所有岗位number删除
			 * 		若是DEMP,则是部门，查找部门下所有岗位，包含子部门下的
			 * 			若取消，则根据userid,menuid和部门下所有岗位number删除
			 * 		若是ST,则是岗位，直接保存或取消
			 * 			若取消，则根据userid,menuid和number删除
			 * 		
			 * 		
			 */
			switch (grade) {
			case 1:

				List<Integer> secondMenuIds = authMenuMapper.selectByFid(menuId);
				if(isSelected == 1){
					for(Integer secondMenuId : secondMenuIds){
						List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuId);
						for (Integer thirdMenuId : thirdMenuIds) {
							String menuids = menuId + "-" + secondMenuId + "-" + thirdMenuId;
							
							//得到所有的岗位
							List<Post> posts = postService.selectNotDeleteALL();
							for(Post post : posts){
								Integer postId = post.getId();
								String signNum = post.getSignNum();
								//保存权限
								insertAuthUserByPost(thirdMenuId, userid, menuids, postId, signNum);
							}
						}
					}
				}else{
					//取消选中，删除
					for(Integer secondMenuId : secondMenuIds){
						List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuId);
						for (Integer thirdMenuId : thirdMenuIds) {
							authUserMapper.deleteByUserMenuPost(userid, thirdMenuId, null);
						}
					}
					
				}
			
				break;
			case 2:

				List<Integer> thirdMenuIds = authMenuMapper.selectByFid(menuId);
				if (isSelected == 1) {
					Integer topFid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
					for (Integer thirdMenuId : thirdMenuIds) {
						
						String menuids = topFid + "-" + menuId + "-" + thirdMenuId;
						
						//得到所有的岗位
						List<Post> posts = postService.selectNotDeleteALL();
						for(Post post : posts){
							Integer postId = post.getId();
							String signNum = post.getSignNum();
							
							insertAuthUserByPost(thirdMenuId, userid, menuids, postId, signNum);
						}
					}
				}else{
					for (Integer thirdMenuId : thirdMenuIds) {
						authUserMapper.deleteByUserMenuPost(userid, thirdMenuId, null);
					}
				}
				
				break;
			case 3:

				if(isSelected == 1){
					Integer fid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
					Integer topFid = authMenuMapper.selectByPrimaryKey(fid).getFid();
					
					String menuids = topFid + "-" + fid + "-" + menuId;
					
					//得到所有的岗位
					List<Post> posts = postService.selectNotDeleteALL();
					for(Post post : posts){
						Integer postId = post.getId();
						String signNum = post.getSignNum();
						
						insertAuthUserByPost(menuId, userid, menuids, postId, signNum);
					}
				}else{
					authUserMapper.deleteByUserMenuPost(userid, menuId, null);
				}
			
				break;
			case 4: case 5:

				Integer fid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
				Integer topFid = authMenuMapper.selectByPrimaryKey(fid).getFid();
				String menuids = topFid + "-" + fid + "-" + menuId;
				
				if (number.startsWith("C")) {
					//根据number得到所有的子公司和子部门
					Organization company = companyMapper.selectByNumber(number);
					//查找公司下边的直接部门或者公司下边直接的岗位
					Integer companyId = company.getId();
					//得到所有子公司,加上选中公司
					List<Organization> companys = companyMapper.selectChildsById(companyId);
//					if(companys != null && companys.size() > 0){
//						companys.add(company);
//					}else{
//						companys = new ArrayList<Organization>();
//						companys.add(company);
//					}
					List<Organization> posts = companyService.getAllDempsAndPosts(companys);
					
					if(isSelected == 1){
						//保存
						for(Organization post : posts){
							Integer postId = post.getId();
							String signNum = post.getSignNum();
							
							insertAuthUserByPost(menuId, userid, menuids, postId, signNum);
						}
					}else{
						//取消
						for(Organization post : posts){
							authUserMapper.deleteByUserMenuPost(userid, menuId, post.getId());
						}
					}
				}else if (number.startsWith("DEMP")) {
					//部门
					//根据number得到所有的子部门
					Organization demp = dempMapper.selectOrgByNumber(number);
					//查找公司下边的直接部门或者部门下边直接的岗位
					List<Organization> demps = dempMapper.selectOrgChildListById(demp.getId());
//					//得到所有子部门,加上选中部门
//					if(demps != null && demps.size() > 0){
//						demps.add(demp);
//					}else{
//						demps = new ArrayList<Organization>();
//						demps.add(demp);
//					}
					
					List<Organization> posts = new ArrayList<Organization>();
					
//					for(Organization organization : demps){
//						Integer dempId = organization.getId();
//						List<Organization> dempList = dempMapper.selectOrgsByPId(dempId);
//						List<Organization> postList = postMapper.selectLinealsByDempId(dempId);
//						
//						posts.addAll(postList);
//						posts = companyService.getDepts(posts,dempList, "post");
//					}
					//TODO 找不同
//					posts = companyService.getDepts(posts, demps, "post");
					posts = companyService.getDepts(posts, demps);
					
					if(isSelected == 1){
						//保存
						for(Organization post : posts){
							Integer postId = post.getId();
							String signNum = post.getSignNum();
							
							insertAuthUserByPost(menuId, userid, menuids, postId, signNum);
						}
					}else{
						//取消
						for(Organization post : posts){
							authUserMapper.deleteByUserMenuPost(userid, menuId, post.getId());
						}
					}
					
				}else if (number.startsWith("ST")) {
					Organization post = postMapper.selectByNumber(number);
					if(isSelected == 1){
						insertAuthUserByPost(menuId, userid, menuids, post.getId(), post.getSignNum());
					}else{
						authUserMapper.deleteByUserMenuPost(userid, menuId, post.getId());
					}
					
				}
				break;
			}
			
			break;
		}
		
	}

	//根据post保存权限
	private void insertAuthUserByPost(Integer menuId, Integer userid, String menuids, Integer postId, String signNum) {
		
		AuthUser sqlAuthUser = authUserMapper.selectByUserMenuPost(userid, menuId, postId);
		if(sqlAuthUser == null){
			AuthUser authUser = new AuthUser();
			authUser.setMenuid(menuId);
			authUser.setMenuids(menuids);
			authUser.setType("post");
			authUser.setUserid(userid);
			
			authUser.setPostid(postId);
			authUser.setPostSignNum(signNum);
			
			authUserMapper.insertSelective(authUser);
		}
	}

	//根据menu保存权限
	private void insertAuthUser(Integer userid, Integer thirdMenuId, String menuids) {
		//保存之前先查询数据库是否存在，存在则不保存
		AuthUser sqlAuthUser = authUserMapper.selectByUserMenuPost(userid, thirdMenuId, null);
		if(sqlAuthUser == null){
			AuthUser authUser = new AuthUser();
			authUser.setMenuids(menuids);
			authUser.setMenuid(thirdMenuId);
			authUser.setUserid(userid);
			authUser.setType("menu");
			authUserMapper.insertSelective(authUser);
		}
	}

	@Override
	public int deleteByUserid(Integer userid) {
		AuthUser authuser=new AuthUser();
		authuser.setUserid(userid);
		return authUserMapper.deleteByUserid(authuser);
	}

	@Override
	public List<String> getSelectedMenuIds(Integer grade, Integer post, String number, Integer menuId, Integer userid) {

		List<String> selectMenuIds = new ArrayList<String>();
		/**
		 * 如果是第一级,
		 * 根据用户和type=post得到岗位的权限，
		 * 	循环type=post的权限得到id
		 * 得到menuids的第一个值记录firstAuthList集合，
		 * 第二个值记录secondAuthList集合
		 * 然后循环firstAuthList查询数据库得到各个menuId下所有的子菜单id
		 * 
		 * 第二级，传来的是第一级的id,若firstMenuId=menuId
		 * 则firstList记录secondId
		 * 
		 * 第三级，传来的是第二级的id
		 * 记录三级id
		 */
		
		if(grade == 1){
			//得到需要岗位的权限
			List<AuthUser> postAuthUsers = authUserMapper.selectByUserid(userid, "post");
			
			//得到不需要岗位的权限
			List<AuthUser> menuAuthUsers = authUserMapper.selectByUserid(userid, "menu");
			
			if(postAuthUsers != null && postAuthUsers.size() > 0){
				//得到第一级菜单id firstMenuId
				first : for(AuthUser authUser : postAuthUsers){
					String[] menuidArr = authUser.getMenuids().split("-");
					Integer firstMenuId = Integer.parseInt(menuidArr[0]);

					List<Integer> secondMenuIds = authMenuMapper.selectByFid(firstMenuId);
					for(Integer secondMenuid : secondMenuIds){
						List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuid);
						for (int i = 0; i < thirdMenuIds.size(); i++) {
							List<Integer> postIds = authUserMapper.selectPostidByMenuidAndUserid(userid, thirdMenuIds.get(i));
							//查询所有除去被其他用户选中的post
							//已经占用的postid
							List<Integer> otherAuthPosts = authUserMapper.selectByNotUserMenuPost(userid, thirdMenuIds.get(i));
							
							//所有的postid
							List<Integer> allPostIds = postMapper.selectAllPostId(0);
							//除去已经占用的，得到要展示的postid 
							allPostIds.removeAll(otherAuthPosts);
							
//							List<Integer> allPostIds = postMapper.selectAllPostId(0);
							if(!compare(postIds, allPostIds)){
								break first;
							}
						}
					}
					if(!selectMenuIds.contains(firstMenuId + "")){
						selectMenuIds.add(firstMenuId + "");
					}
				}
			}
			//纯菜单权限
			if(menuAuthUsers != null && menuAuthUsers.size() > 0){
				Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
				for(int i = 0; i < menuAuthUsers.size(); i ++){
					AuthUser authUser = menuAuthUsers.get(i);
					String[] menuidArr = authUser.getMenuids().split("-");
					Integer firstMenuId = Integer.parseInt(menuidArr[0]);
					Integer secondMenuId = Integer.parseInt(menuidArr[1]);
					Integer thirdMenuId = Integer.parseInt(menuidArr[2]);
					/**
					 * 判断第二级下边的第三级，如果全部三级，则记录2级
					 */
					
					String firstSecondId = firstMenuId + "-" + secondMenuId;
					List<Integer> thirdList = map.get(firstSecondId);
					if(thirdList != null && thirdList.size() > 0){
						if(!thirdList.contains(thirdMenuId)){
							thirdList.add(thirdMenuId);
						}
					}else{
						thirdList = new ArrayList<Integer>();
						thirdList.add(thirdMenuId);
					}
					map.put(firstSecondId, thirdList);
						
				}
				
				/**
				 * 循环childAuthList，得到逐个的所有子集菜单id
				 * 与用户已经有的菜单id secondList比对
				 * 若相同，则打勾，不同则不打勾
				 * 
				 */
				//判断二级的全部菜单取值
				if(map != null && !map.isEmpty()){
					Map<Integer, List<Integer>> firstMap = new HashMap<Integer, List<Integer>>();
					for (Entry<String, List<Integer>> entry : map.entrySet()) {
						   String firstSecondMenuId = entry.getKey();
						   Integer firstMenuId = Integer.parseInt(firstSecondMenuId.split("-")[0]);
						   Integer secondMenuId = Integer.parseInt(firstSecondMenuId.split("-")[1]);
						   List<Integer> childAuthList = entry.getValue();
						   
							//查询数据库中pMenuId菜单的所有子菜单三级
							List<Integer> menuIds = authMenuMapper.selectByFid(secondMenuId);
							if(compare(childAuthList,menuIds)){    
								List<Integer> secondList = firstMap.get(secondMenuId);
								if(secondList != null && secondList.size() > 0){
									if(!secondList.contains(secondMenuId)){
										secondList.add(secondMenuId);
									}
								}else{
									secondList = new ArrayList<Integer>();
									secondList.add(secondMenuId);
								}
								firstMap.put(firstMenuId, secondList);
							}
						   
						   
						  }
					if(firstMap != null && !firstMap.isEmpty()){
						for (Entry<Integer, List<Integer>> entry : firstMap.entrySet()) {
							   Integer pMenuId = entry.getKey();
							   List<Integer> childAuthList = entry.getValue();
							   selectMenuIds = getSelectNums(selectMenuIds, childAuthList, pMenuId);
							  }
					}
				}
			}
			
			
		}else {
			 if (post == 1) {
				 //有岗位
				 selectMenuIds = getSelectedByPost(grade, post, number, menuId, userid);
			}else{
				selectMenuIds = getSelectedByMenu(grade, post, number, menuId, userid);
			}
		}
		
		return selectMenuIds;
	}

	private List<String> getSelectNums(List<String> selectMenuIds, List<Integer> childAuthList, Integer pMenuId) {
		//查询数据库中pMenuId菜单的所有子菜单
		List<Integer> menuIds = authMenuMapper.selectByFid(pMenuId);
		if(compare(childAuthList,menuIds)){
			if(!selectMenuIds.contains(pMenuId + "")){
				selectMenuIds.add(pMenuId + "");
			}
		}
		return selectMenuIds;
	}
	/**
	 * 队列比较
	 * @param <T>
	 * @param a
	 * @param b
	 * @return
	 */
	public <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
	  if(a.size() != b.size())
	    return false;
	  Collections.sort(a);
	  Collections.sort(b);
	  for(int i=0;i<a.size();i++){
	    if(!a.get(i).equals(b.get(i)))
	      return false;
	  }
	  return true;
	}

	public List<String> getSelectedByMenu(Integer grade, Integer post, String number, Integer menuId, Integer userid) {
		List<String> selectMenuIds = new ArrayList<String>();
		
		//纯菜单,只有三级
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		switch (grade) {
		case 2:
			
			/**
			 * 传来第一级菜单id,查询数据库，查询userid和menuids like "menuid-"
			 * 循环,记录二级和三级菜单id
			 */
			
			List<AuthUser> authUsersByPMenu = authUserMapper.selectByUseridAndMenuids(userid, menuId + "-%");
			
			for(AuthUser authUser : authUsersByPMenu){
				String[] menuidArr = authUser.getMenuids().split("-");
				Integer secondMenuId = Integer.parseInt(menuidArr[1]);
				Integer thirdMenuId = Integer.parseInt(menuidArr[2]);
				
				List<Integer> secondList = map.get(secondMenuId);
				if(secondList != null && secondList.size() > 0){
					if(!secondList.contains(thirdMenuId)){
						secondList.add(thirdMenuId);
					}
				}else{
					secondList = new ArrayList<Integer>();
					secondList.add(thirdMenuId);
				}
			
				map.put(secondMenuId, secondList);
					
			}
			/**
			 * 循环childAuthList，得到逐个的所有子集菜单id
			 * 与用户已经有的菜单id secondList比对
			 * 若相同，则打勾，不同则不打勾
			 * 
			 */
			//判断取值
			if(map != null && !map.isEmpty()){
				for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
					   Integer pMenuId = entry.getKey();
					   List<Integer> childAuthList = entry.getValue();
					   selectMenuIds = getSelectNums(selectMenuIds, childAuthList, pMenuId);
					  }
			}
			break;
		case 3:
			/*
			 * 传来第二级的menuid,得到子菜单，
			 * 循环根据userid和childmenuid，type=menu查询数据库看是否存在
			 */
			List<Integer> childMenuids = authMenuMapper.selectByFid(menuId);
			for(Integer childId : childMenuids){
				AuthUser authUser = authUserMapper.selectByUserMenuType(userid, childId, "menu").get(0);
				if(authUser != null){
					if(!selectMenuIds.contains(childId + "")){
						selectMenuIds.add(childId + "");  
					}
				}
			}
			break;
		}
		return selectMenuIds;
	}
	public List<String> getSelectedByPost(Integer grade, Integer post, String number, Integer menuId, Integer userid) {
		//待我审批
//		List<Integer> selectMenuIds = new ArrayList<Integer>();
		List<String> selectOrgNums = new ArrayList<String>();
		//得到post的权限列表
		switch(grade){
		case 2 :
			//展示第二级，传入第一级id,查出子三级菜单的选中状态
			List<Integer> secondMenuIds = authMenuMapper.selectByFid(menuId);
			second: 
				for(Integer secondMenuid : secondMenuIds){
					List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuid);
					for (int i = 0; i < thirdMenuIds.size(); i++) {
						List<Integer> postIds = authUserMapper.selectPostidByMenuidAndUserid(userid, thirdMenuIds.get(i));
						//查询所有post
//						List<Integer> allPostIds = postMapper.selectAllPostId(0);
						//已经占用的postid
						List<Integer> otherAuthPosts = authUserMapper.selectByNotUserMenuPost(userid, thirdMenuIds.get(i));
						
						//所有的postid
						List<Integer> allPostIds = postMapper.selectAllPostId(0);
						//除去已经占用的，得到要展示的postid 
						allPostIds.removeAll(otherAuthPosts);
						
						if(!compare(postIds, allPostIds)){
							continue second;
						}
					}
					selectOrgNums.add(secondMenuid + "");
				}
				break;
		case 3 :
			//如果是展示第三级,传入第二级menuid，查出子菜单，查出此三级菜单下所有岗位与组织机构所有权限对比
			List<Integer> thirdMenuIds = authMenuMapper.selectByFid(menuId);
			for(Integer thirdMenuId : thirdMenuIds){
				List<Integer> postIds = authUserMapper.selectPostidByMenuidAndUserid(userid, thirdMenuId);
				//查询所有post
//				List<Integer> allPostIds = postMapper.selectAllPostId(0);
				
				//已经占用的postid
				List<Integer> otherAuthPosts = authUserMapper.selectByNotUserMenuPost(userid, thirdMenuId);
				
				//所有的postid
				List<Integer> allPostIds = postMapper.selectAllPostId(0);
				//除去已经占用的，得到要展示的postid 
				allPostIds.removeAll(otherAuthPosts);
				
				if(compare(postIds, allPostIds)){
					selectOrgNums.add(thirdMenuId + "");
				}
			}
			break;
		case 4 :
			//得到总公司，根据userid和menuid判断，查出此三级菜单下所有岗位与组织机构所有权限对
			List<Integer> postIds = authUserMapper.selectPostidByMenuidAndUserid(userid, menuId);
			//查询所有post
//			List<Integer> allPostIds = postMapper.selectAllPostId(0);
			
			//已经占用的postid
			List<Integer> otherAuthPosts = authUserMapper.selectByNotUserMenuPost(userid, menuId);
			
			//所有的postid
			List<Integer> allPostIds = postMapper.selectAllPostId(0);
			//除去已经占用的，得到要展示的postid 
			allPostIds.removeAll(otherAuthPosts);
			
			if(compare(postIds, allPostIds)){
				//加载总公司number
				Organization company = companyMapper.selectByPId(null).get(0);
				selectOrgNums.add(company.getNumber());
			}
			break;
		case 5 :
			//已经占用的postid
			List<Integer> otherUserAuthPosts = authUserMapper.selectByNotUserMenuPost(userid, menuId);
//			List<String> selectOrgNums = new ArrayList<String>();
			List<AuthUser> authUsers = authUserMapper.selectByUserMenuType(userid, menuId, "post");
			//传入number,menuid,userid
			
			if(number.startsWith("ST")){
				//TODO
			}else{
				/**
				 * 
				 * 根据number 查询权限signNum 得到相应功能的权限
				 * 
				 * 根据number得到直接子公司，子部门，或岗位
				 * 循环authuser得到signNum,
				 * 	查找signNum中是否包括当前number,
				 * 		包括则查找当前位置的下一级记上述子级list，
				 * 		再根据记录的子级查子级下一级，记录，
				 * 			与自己的所有自己及和比对，相同则选中，记录本子级的id
				 * 		不包括则不处理
				 */
				String pNumber = "";
				Map<String, List<String>> map = new HashMap<String, List<String>>();
				for(AuthUser authUser : authUsers){
					String signNum = authUser.getPostSignNum();
					int index = signNum.indexOf(number);
					if(index != -1){
						//则存在，且index是字符串的位置
						signNum = signNum.substring(index);
						if(signNum.contains("-")){
							String [] sNumArr = signNum.split("-");
							if(sNumArr.length > 2){
								//至少两级
								pNumber = sNumArr[1];
								List<String> childNums = map.get(pNumber);
								String postNum = sNumArr[sNumArr.length-1];
								if(childNums == null){
									childNums = new ArrayList<String>();
								}
								if(!childNums.contains(postNum)){
									//记录最后一级，是岗位
									childNums.add(postNum);
								}
								map.put(pNumber, childNums);
							}else if(sNumArr.length == 2){
								//则说明下一级直接是岗位,则岗位选中
								selectOrgNums.add(sNumArr[1]);
							}
						}
					}
					
				}
				if(number.startsWith("C")){
					if(map != null && !map.isEmpty()){
						for (Entry<String, List<String>> entry : map.entrySet()) {
							String parentOrgNum = entry.getKey();
							List<String> existPostNums = entry.getValue();
							//判断parentOrgNum是公司，部门
							if(parentOrgNum.startsWith("C")){
								//得到公司下所有的岗位，与existPostNums比对
								//根据parentOrgNum得到所有的子公司和子部门
								Organization company = companyMapper.selectByNumber(parentOrgNum);
								//查找公司下边的直接部门或者公司下边直接的岗位
								Integer companyId = company.getId();
								//得到所有子公司,加上选中公司
								List<Organization> companys = companyMapper.selectChildsById(companyId);
//								if(companys != null && companys.size() > 0){
//									companys.add(company);
//								}else{
//									companys = new ArrayList<Organization>();
//									companys.add(company);
//								}
								
								List<String> postNums = companyService.getPostNumByCompanys(companys);
								
								//除去已经占用的，得到要展示的postid 
								postNums.removeAll(otherUserAuthPosts);
								
								if(compare(postNums, existPostNums)){
									selectOrgNums.add(parentOrgNum);
								}
								
							}else if(parentOrgNum.startsWith("DEMP")){
								selectOrgNums.addAll(checkDemp(otherUserAuthPosts, parentOrgNum, existPostNums));
							}
						}
					}
					
				}else if(number.startsWith("DEMP")){
					//子级只可能是部门或岗位

					if(map != null && !map.isEmpty()){
						for (Entry<String, List<String>> entry : map.entrySet()) {
							String parentOrgNum = entry.getKey();
							List<String> existPostNums = entry.getValue();
							//只能是部门
							selectOrgNums.addAll(checkDemp(otherUserAuthPosts, parentOrgNum, existPostNums));
								
						}
					}
				}
			}
			break;
		}
		return selectOrgNums; 
	}

	private List<String> checkDemp(List<Integer> otherUserAuthPosts, String parentOrgNum, List<String> existPostNums) {
		List<String> selectOrgNums = new ArrayList<String>();
		//得到部门下所有的岗位，与existPostNums比对
		//根据number得到所有的子部门
		Organization demp = dempMapper.selectOrgByNumber(parentOrgNum);
		//查找公司下边的直接部门或者部门下边直接的岗位
		//得到所有子部门,根据选中部门得到岗位
		List<Organization> demps = dempMapper.selectOrgChildListById(demp.getId());
		
//		if(demps != null && demps.size() > 0){
//			demps.add(demp);
//		}else{
//			demps = new ArrayList<Organization>();
//			demps.add(demp);
//		}
		
		List<String> postNums = new ArrayList<String>();
		//根据选中部门得到岗位
		
		for(Organization organization : demps){
			List<String> pPostList = postMapper.selectLinealNumsByDempId(organization.getId());
			postNums.addAll(pPostList);
//			Integer dempId = organization.getId();
//			List<Organization> dempList = dempMapper.selectOrgsByPId(dempId);
//			List<String> postList = postMapper.selectLinealNumsByDempId(dempId);
//			
//			postNums.addAll(postList);
//			postNums = companyService.getDeptNums(postNums, dempList);
		}
		//除去已经占用的，得到要展示的postid 
		postNums.removeAll(otherUserAuthPosts);
		if(compare(postNums, existPostNums)){
			selectOrgNums.add(parentOrgNum);
		}
		return selectOrgNums;
	}
	
}
