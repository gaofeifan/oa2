package com.pj.auth.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthMenuMapper;
import com.pj.auth.mapper.AuthUserMapper;
import com.pj.auth.pojo.AuthMenu;
import com.pj.auth.pojo.AuthUser;
import com.pj.auth.service.AuthMenuService;
import com.pj.auth.service.AuthUserService;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Post;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.system.service.PostService;

@Service
@Transactional
public class AuthUserServiceImpl extends AbstractBaseServiceImpl<AuthUser, Integer> implements AuthUserService{

	@Resource
	private AuthUserMapper authUserMapper;
	
	@Resource
	private AuthMenuService authMenuService;

	@Resource
	private CompanyService companyService;
	
	@Resource
	private DempService dempService;
	
	@Resource
	private PostService postService;
	
	@Resource
	private AuthMenuMapper authMenuMapper;
	
	@Override
	public MyMapper<AuthUser> getMapper() {
		return authUserMapper;
	}

	@Override
	public int insertAuthUser(String type,Integer id,Integer fid,Integer userid,Integer current) {
		int state = 0;
		Post post=new Post();
		
		switch(type){
			case "One":
				if(current==1){
					AuthMenu authMenu=new AuthMenu();
					authMenu.setGrade(2);
					authMenu.setAuth(1);
					authMenu.setFid(id);
					//循环二级菜单
					List<AuthMenu> towauthMenulist =authMenuService.GetMenu(authMenu);
					for(int i = 0 ;  i <towauthMenulist.size(); i++ ){
						//根据二级菜单ID循环三级菜单
						authMenu=new AuthMenu();
						authMenu.setGrade(3);
						authMenu.setAuth(1);
						authMenu.setFid(towauthMenulist.get(i).getId());
						List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
						for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
							//如果菜单下面不包含公司选项Post为0 包含为1，如果包含 循环添加公司 部门 岗位
							if(ThreeauthMenulist.get(j).getPost() == 0){
								AuthUser authuser=new AuthUser();
								authuser.setMenuid(ThreeauthMenulist.get(j).getId());
								authuser.setUserid(userid);
								authUserMapper.insertAuthUser(authuser);
							}else{
								//循环所有公司
								List<Company> companys = this.companyService.selectByUserid(userid, ThreeauthMenulist.get(j).getId());
								for(int a = 0 ;  a <companys.size(); a++ ){
									//循环所有部门
									List<Demp> demps = this.dempService.SelectByUserid(userid,  ThreeauthMenulist.get(j).getId(), companys.get(a).getId());
									if(demps.size()==0){
										AuthUser authuser=new AuthUser();
										authuser.setUserid(userid);
										authuser.setMenuid(ThreeauthMenulist.get(j).getId());
										authuser.setCompanyid(companys.get(a).getId());
										authUserMapper.insertAuthUser(authuser);
										
									}else{
										for(int q = 0 ;  q <demps.size(); q++ ){
											List<Post> posts = this.postService.SelectByUserid(userid, ThreeauthMenulist.get(j).getId(), demps.get(q).getId());
											if(posts.size()==0){
												AuthUser authuser=new AuthUser();
												authuser.setUserid(userid);
												authuser.setMenuid(ThreeauthMenulist.get(j).getId());
												authuser.setCompanyid(companys.get(a).getId());
												authuser.setDempid(demps.get(q).getId());
												authUserMapper.insertAuthUser(authuser);
												
											}else{
												for(int w = 0 ;  w <posts.size(); w++ ){
													AuthUser authuser=new AuthUser();
													authuser.setUserid(userid);
													authuser.setMenuid(ThreeauthMenulist.get(j).getId());
													authuser.setCompanyid(companys.get(a).getId());
													authuser.setDempid(demps.get(q).getId());
													authuser.setPostid(posts.get(w).getId());
													authUserMapper.insertAuthUser(authuser);
												}
											}
										}
									}
						 		}
							}
						}
					}
				}else{
					
					AuthMenu authMenu=new AuthMenu();
					authMenu.setGrade(2);
					authMenu.setAuth(1);
					authMenu.setFid(id);
					//循环二级菜单
					List<AuthMenu> towauthMenulist =authMenuService.GetMenu(authMenu);
					for(int i = 0 ;  i <towauthMenulist.size(); i++ ){
						//根据二级菜单ID循环三级菜单
						authMenu=new AuthMenu();
						authMenu.setGrade(3);
						authMenu.setAuth(1);
						authMenu.setFid(towauthMenulist.get(i).getId());
						List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
						for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
							AuthUser authuser=new AuthUser();
							authuser.setMenuid(ThreeauthMenulist.get(j).getId());
							authuser.setUserid(userid);
							authUserMapper.deleteByUserid(authuser);
						}
					}

				}
				
				state=1;
				break;
			case "Two":
				if(current==1){
					AuthMenu authMenu=new AuthMenu();
					authMenu=new AuthMenu();
					authMenu.setGrade(3);
					authMenu.setAuth(1);
					authMenu.setFid(id);
					List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
					for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
						//如果菜单下面不包含公司选项Post为0 包含为1，如果包含 循环添加公司 部门 岗位
						if(ThreeauthMenulist.get(j).getPost() == 0){
							AuthUser authuser=new AuthUser();
							authuser.setMenuid(ThreeauthMenulist.get(j).getId());
							authuser.setUserid(userid);
							authUserMapper.insertAuthUser(authuser);
						}else{
							//循环所有公司
							List<Company> companys = this.companyService.selectByUserid(userid, ThreeauthMenulist.get(j).getId());
							for(int a = 0 ;  a <companys.size(); a++ ){
								//循环所有部门
								List<Demp> demps = this.dempService.SelectByUserid(userid, ThreeauthMenulist.get(j).getId(), companys.get(a).getId());
								if(demps.size()==0){
									AuthUser authuser=new AuthUser();
									authuser.setUserid(userid);
									authuser.setMenuid(ThreeauthMenulist.get(j).getId());
									authuser.setCompanyid(companys.get(a).getId());
									authUserMapper.insertAuthUser(authuser);
									
								}else{
									for(int q = 0 ;  q <demps.size(); q++ ){
										
										List<Post> posts = this.postService.SelectByUserid(userid, ThreeauthMenulist.get(j).getId(), demps.get(q).getId());
										if(posts.size()==0){
											AuthUser authuser=new AuthUser();
											authuser.setUserid(userid);
											authuser.setMenuid(ThreeauthMenulist.get(j).getId());
											authuser.setCompanyid(companys.get(a).getId());
											authuser.setDempid(demps.get(q).getId());
											authUserMapper.insertAuthUser(authuser);
											
										}else{
											for(int w = 0 ;  w <posts.size(); w++ ){
												AuthUser authuser=new AuthUser();
												authuser.setUserid(userid);
												authuser.setMenuid(ThreeauthMenulist.get(j).getId());
												authuser.setCompanyid(companys.get(a).getId());
												authuser.setDempid(demps.get(q).getId());
												authuser.setPostid(posts.get(w).getId());
												authUserMapper.insertAuthUser(authuser);
											}
										}
									}
								}
					 		}
						}
					}
				}
				else{
					AuthMenu authMenu=new AuthMenu();
					authMenu=new AuthMenu();
					authMenu.setGrade(3);
					authMenu.setAuth(1);
					authMenu.setFid(id);
					List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
					for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
						AuthUser authuser=new AuthUser();
						authuser.setMenuid(ThreeauthMenulist.get(j).getId());
						authuser.setUserid(userid);
						authUserMapper.deleteByUserid(authuser);
					}
				}
				
				state=1;
				break;
			case "Three":
				if(current==1){
					AuthMenu authMenu=new AuthMenu();
					authMenu=new AuthMenu();
					authMenu.setId(id);
					authMenu.setGrade(3);
					authMenu.setAuth(1);
					List<AuthMenu> TauthMenulist =authMenuService.GetMenu(authMenu);
					for(int j = 0 ;  j <TauthMenulist.size(); j++ ){
						//如果菜单下面不包含公司选项Post为0 包含为1，如果包含 循环添加公司 部门 岗位
						if(TauthMenulist.get(j).getPost() == 0){
							AuthUser authuser=new AuthUser();
							authuser.setMenuid(TauthMenulist.get(j).getId());
							authuser.setUserid(userid);
							authUserMapper.insertAuthUser(authuser);
						}else{
							//循环所有公司
							List<Company> companys = this.companyService.selectByUserid(userid, TauthMenulist.get(j).getId());
							for(int a = 0 ;  a <companys.size(); a++ ){
								//循环所有部门
								List<Demp> demps = this.dempService.SelectByUserid(userid, TauthMenulist.get(j).getId(), companys.get(a).getId());
								if(demps.size()==0){
									AuthUser authuser=new AuthUser();
									authuser.setUserid(userid);
									authuser.setMenuid(TauthMenulist.get(j).getId());
									authuser.setCompanyid(companys.get(a).getId());
									authUserMapper.insertAuthUser(authuser);
									
								}else{
									for(int q = 0 ;  q <demps.size(); q++ ){
										List<Post> posts = this.postService.SelectByUserid(userid, TauthMenulist.get(j).getId(), demps.get(q).getId());
										if(posts.size()==0){
											AuthUser authuser=new AuthUser();
											authuser.setUserid(userid);
											authuser.setMenuid(TauthMenulist.get(j).getId());
											authuser.setCompanyid(companys.get(a).getId());
											authuser.setDempid(demps.get(q).getId());
											authUserMapper.insertAuthUser(authuser);
											
										}else{
											for(int w = 0 ;  w <posts.size(); w++ ){
												AuthUser authuser=new AuthUser();
												authuser.setUserid(userid);
												authuser.setMenuid(TauthMenulist.get(j).getId());
												authuser.setCompanyid(companys.get(a).getId());
												authuser.setDempid(demps.get(q).getId());
												authuser.setPostid(posts.get(w).getId());
												authUserMapper.insertAuthUser(authuser);
											}
										}
									}
								}
					 		}
						}
					}
				}
				else{
					AuthMenu authMenu=new AuthMenu();
					authMenu=new AuthMenu();
					authMenu.setId(id);
					authMenu.setGrade(3);
					authMenu.setAuth(1);
					List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
					for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
						AuthUser authuser=new AuthUser();
						authuser.setMenuid(ThreeauthMenulist.get(j).getId());
						authuser.setUserid(userid);
						authUserMapper.deleteByUserid(authuser);
					}
					
				}
				
				state=1;
				break;
			case "Company":
				if(current==1){
					
					List<Demp> demps = this.dempService.SelectByUserid(userid, fid, id);
					if(demps.size()==0){
						AuthUser authuser=new AuthUser();
						authuser.setUserid(userid);
						authuser.setMenuid(fid);
						authuser.setCompanyid(id);
						authUserMapper.insertAuthUser(authuser);
						
					}else{
						for(int q = 0 ;  q <demps.size(); q++ ){
							List<Post> posts = this.postService.SelectByUserid(userid, fid, demps.get(q).getId());
							if(posts.size()==0){
								AuthUser authuser=new AuthUser();
								authuser.setUserid(userid);
								authuser.setMenuid(fid);
								authuser.setCompanyid(id);
								authuser.setDempid(demps.get(q).getId());
								authUserMapper.insertAuthUser(authuser);
								
							}else{
								for(int w = 0 ;  w <posts.size(); w++ ){
									AuthUser authuser=new AuthUser();
									authuser.setUserid(userid);
									authuser.setMenuid(fid);
									authuser.setCompanyid(id);
									authuser.setDempid(demps.get(q).getId());
									authuser.setPostid(posts.get(w).getId());
									authUserMapper.insertAuthUser(authuser);
								}
							}
						}
					}
				}else{
					AuthUser authuser=new AuthUser();
					authuser.setCompanyid(id);
					authuser.setUserid(userid);
					authUserMapper.deleteByUserid(authuser);
				}
					
				state=1;
				break;
			case "Demp":
				if(current==1){
					Demp demp = this.dempService.selectByPrimaryKey(id);
					post.setDempId(id);
					List<Post> posts = this.postService.SelectByUserid(userid, fid, id);
					if(posts.size()==0){
						AuthUser authuser=new AuthUser();
						authuser.setUserid(userid);
						authuser.setMenuid(fid);
						authuser.setCompanyid(demp.getCompanyid());
						authuser.setDempid(id);
						authUserMapper.insertAuthUser(authuser);
						
					}else{
						for(int w = 0 ;  w <posts.size(); w++ ){
							AuthUser authuser=new AuthUser();
							authuser.setUserid(userid);
							authuser.setMenuid(fid);
							authuser.setCompanyid(demp.getCompanyid());
							authuser.setDempid(id);
							authuser.setPostid(posts.get(w).getId());
							authUserMapper.insertAuthUser(authuser);
						}
					}
				}
				else{
					AuthUser authuser=new AuthUser();
					authuser.setDempid(id);
					authuser.setUserid(userid);
					authUserMapper.deleteByUserid(authuser);
				}
				state=1;
				break;
			case "Post":
				if(current==1){
					Post postss = this.postService.selectByPrimaryKey(id);
					AuthUser authuser=new AuthUser();
					authuser.setUserid(userid);
					authuser.setMenuid(fid);
					authuser.setCompanyid(postss.getCompanyId());
					authuser.setDempid(postss.getDempId());
					authuser.setPostid(id);
					authUserMapper.insertAuthUser(authuser);
				}else{
					AuthUser authuser=new AuthUser();
					authuser.setPostid(id);
					authuser.setUserid(userid);
					authUserMapper.deleteByUserid(authuser);
				}
				state=1;
				break;
		}
		return state;
	}

	@Override
	public int deleteByUserid(Integer userid) {
		AuthUser authuser=new AuthUser();
		authuser.setUserid(userid);
		return authUserMapper.deleteByUserid(authuser);
	}

	@Override
	public List<Integer> getSelectedMenuIds(Integer grade, Integer menuId, Integer userid) {

		List<Integer> selectMenuIds = new ArrayList<Integer>();
		List<AuthUser> authUsers = authUserMapper.selectByUserid(userid);
		//根据grade判断需要展示第几级
		List<Integer> firstAuthList = new ArrayList<Integer>();
		List<Integer> secondAuthList = new ArrayList<Integer>();
		/**
		 * 如果是第一级,得到menuids的第一个值记录firstAuthList集合，
		 * 第二个值记录secondAuthList集合
		 * 然后循环firstAuthList查询数据库得到各个menuId下所有的子菜单id
		 * 
		 * 第二级，传来的是第一级的id,若firstMenuId=menuId
		 * 则firstList记录secondId
		 * 
		 * 第三级，传来的是第二级的id
		 * 记录三级id
		 */
		//grade==1时使用
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(AuthUser authUser : authUsers){
			String[] menuidArr = authUser.getMenuids().split("-");
			Integer firstMenuId = Integer.parseInt(menuidArr[0]);
			Integer secondMenuId = Integer.parseInt(menuidArr[1]);
			Integer thirdMenuId = Integer.parseInt(menuidArr[2]);
			if (grade == 1) {
				List<Integer> secondList = map.get(firstMenuId);
				if(secondList != null && secondList.size() > 0){
					if(!secondList.contains(secondMenuId)){
						secondList.add(secondMenuId);
					}
				}else{
					secondList = new ArrayList<Integer>();
					secondList.add(secondMenuId);
				}
				map.put(firstMenuId, secondList);
				
			}else if(grade == 2){
				/**
				 * 如果firstMenuId == menuId,则记录二级和三级菜单id
				 */
				
				if(firstMenuId.equals(menuId)){  
					if(!firstAuthList.contains(secondMenuId)){
						firstAuthList.add(secondMenuId); 
					}
					if(!secondAuthList.contains(thirdMenuId)){  
						secondAuthList.add(thirdMenuId);  
					}
				}
				
			}else if(grade == 3){
				if(secondMenuId.equals(menuId)){ 
					if(!selectMenuIds.contains(thirdMenuId)){
						selectMenuIds.add(thirdMenuId);  
					}
				}
			}
		}
		/**
		 * 循环firstAuthList，得到逐个的所有子集菜单id
		 * 与用户已经有的菜单id secondList比对
		 * 若相同，则打勾，不同则不打勾
		 * 
		 */
		//判断grade=1的情况取值
		if(map != null && !map.isEmpty()){
			for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
				   Integer firstMenuId = entry.getKey();
				   List<Integer> secondList = entry.getValue();
				   getSelectNums(selectMenuIds, secondList, firstMenuId);
				  }
		}
		for(Integer firstMenuId : firstAuthList){
			getSelectNums(selectMenuIds, secondAuthList, firstMenuId);
		}
		return selectMenuIds;
	}

	private void getSelectNums(List<Integer> selectMenuIds, List<Integer> secondAuthList, Integer firstMenuId) {
		//查询数据库中firstMenuId菜单的所有子菜单
		List<Integer> menuIds = authMenuMapper.selectByFid(firstMenuId);
		if(compare(secondAuthList,menuIds)){
			if(!selectMenuIds.contains(firstMenuId)){
				selectMenuIds.add(firstMenuId);
			}
		}
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

}
