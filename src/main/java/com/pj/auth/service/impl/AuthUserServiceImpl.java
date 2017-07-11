package com.pj.auth.service.impl;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
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
	
	@Resource
	private CompanyService companyService;
	
	@Resource
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
		
		if("menu".equals(type)){
			//只需要保存或取消菜单权限
			if(grade == 1){
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
			}else if(grade == 2){
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
			}else if(grade == 3){
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
			}
			
		}else if("post".endsWith(type)){
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
			if(grade == 1){
				if(isSelected == 1){
					List<Integer> secondMenuIds = authMenuMapper.selectByFid(menuId);
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
								insertAuthUserByPost(menuId, userid, menuids, postId, signNum);
							}
						}
					}
				}
			}else if(grade == 2){
				List<Integer> thirdMenuIds = authMenuMapper.selectByFid(menuId);
				Integer topFid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
				for (Integer thirdMenuId : thirdMenuIds) {
					
					String menuids = topFid + "-" + menuId + "-" + thirdMenuId;
					
					//得到所有的岗位
					List<Post> posts = postService.selectNotDeleteALL();
					for(Post post : posts){
						Integer postId = post.getId();
						String signNum = post.getSignNum();
						
						insertAuthUserByPost(menuId, userid, menuids, postId, signNum);
					}
				}
			}else if(grade == 3){
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
			}else if(grade > 3){
				Integer fid = authMenuMapper.selectByPrimaryKey(menuId).getFid();
				Integer topFid = authMenuMapper.selectByPrimaryKey(fid).getFid();
				String menuids = topFid + "-" + fid + "-" + menuId;
				
				if (number.startsWith("C")) {
					//根据number得到所有的子公司和子部门
					Organization company = companyMapper.selectByNumber(number);
					//查找公司下边的直接部门或者公司下边直接的岗位
					Integer companyId = company.getId();
					//得到所有子公司,加上选中公司
					List<Organization> companys = companyMapper.selectByPId(companyId);
					if(companys != null && companys.size() > 0){
						companys.add(company);
					}else{
						companys = new ArrayList<Organization>();
						companys.add(company);
					}
					List<Organization> posts = companyService.getDempsAndPosts(companys, "post");
					
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
					List<Organization> demps = dempMapper.selectOrgsByPId(demp.getId());
					//得到所有子部门,加上选中部门
					if(demps != null && demps.size() > 0){
						demps.add(demp);
					}else{
						demps = new ArrayList<Organization>();
						demps.add(demp);
					}
					
					List<Organization> posts = new ArrayList<Organization>();
					
					for(Organization organization : demps){
						Integer dempId = organization.getId();
						List<Organization> dempList = dempMapper.selectOrgsByPId(dempId);
						List<Organization> postList = postMapper.selectLinealsByDempId(dempId);
						
						posts.addAll(postList);
						posts.addAll(companyService.getDepts(dempList, "post"));
					}
					//TODO 找不同
//					List<Organization> posts = companyService.getDepts(demps, "post");
					
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
					Post post = postMapper.selectByNumber(number);
					if(isSelected == 1){
						insertAuthUserByPost(menuId, userid, menuids, post.getId(), post.getSignNum());
					}else{
						authUserMapper.deleteByUserMenuPost(userid, menuId, post.getId());
					}
					
				}
			}
			
		}
		
	}

	//根据post保存权限
	private void insertAuthUserByPost(Integer menuId, Integer userid, String menuids, Integer postId, String signNum) {
		AuthUser authUser = new AuthUser();
		authUser.setMenuid(menuId);
		authUser.setMenuids(menuids);
		authUser.setType("post");
		authUser.setUserid(userid);
		
		authUser.setPostid(postId);
		authUser.setPostSignNum(signNum);
		
		authUserMapper.insertSelective(authUser);
	}

	//根据menu保存权限
	private void insertAuthUser(Integer userid, Integer thirdMenuId, String menuids) {
		AuthUser authUser = new AuthUser();
		authUser.setMenuids(menuids);
		authUser.setMenuid(thirdMenuId);
		authUser.setUserid(userid);
		authUser.setType("menu");
		authUserMapper.insertSelective(authUser);
	}
//	public int insertAuthUser(String type,Integer id,Integer fid,Integer userid,Integer current) {
//		int state = 0;
//		Post post=new Post();
//		
//		switch(type){
//			case "One":
//				if(current==1){
//					AuthMenu authMenu=new AuthMenu();
//					authMenu.setGrade(2);
//					authMenu.setAuth(1);
//					authMenu.setFid(id);
//					//循环二级菜单
//					List<AuthMenu> towauthMenulist =authMenuService.GetMenu(authMenu);
//					for(int i = 0 ;  i <towauthMenulist.size(); i++ ){
//						//根据二级菜单ID循环三级菜单
//						authMenu=new AuthMenu();
//						authMenu.setGrade(3);
//						authMenu.setAuth(1);
//						authMenu.setFid(towauthMenulist.get(i).getId());
//						List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
//						for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
//							//如果菜单下面不包含公司选项Post为0 包含为1，如果包含 循环添加公司 部门 岗位
//							if(ThreeauthMenulist.get(j).getPost() == 0){
//								AuthUser authuser=new AuthUser();
//								authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//								authuser.setUserid(userid);
//								authUserMapper.insertAuthUser(authuser);
//							}else{
//								//循环所有公司
//								List<Company> companys = this.companyService.selectByUserid(userid, ThreeauthMenulist.get(j).getId());
//								for(int a = 0 ;  a <companys.size(); a++ ){
//									//循环所有部门
//									List<Demp> demps = this.dempService.SelectByUserid(userid,  ThreeauthMenulist.get(j).getId(), companys.get(a).getId());
//									if(demps.size()==0){
//										AuthUser authuser=new AuthUser();
//										authuser.setUserid(userid);
//										authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//										authuser.setCompanyid(companys.get(a).getId());
//										authUserMapper.insertAuthUser(authuser);
//										
//									}else{
//										for(int q = 0 ;  q <demps.size(); q++ ){
//											List<Post> posts = this.postService.SelectByUserid(userid, ThreeauthMenulist.get(j).getId(), demps.get(q).getId());
//											if(posts.size()==0){
//												AuthUser authuser=new AuthUser();
//												authuser.setUserid(userid);
//												authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//												authuser.setCompanyid(companys.get(a).getId());
//												authuser.setDempid(demps.get(q).getId());
//												authUserMapper.insertAuthUser(authuser);
//												
//											}else{
//												for(int w = 0 ;  w <posts.size(); w++ ){
//													AuthUser authuser=new AuthUser();
//													authuser.setUserid(userid);
//													authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//													authuser.setCompanyid(companys.get(a).getId());
//													authuser.setDempid(demps.get(q).getId());
//													authuser.setPostid(posts.get(w).getId());
//													authUserMapper.insertAuthUser(authuser);
//												}
//											}
//										}
//									}
//						 		}
//							}
//						}
//					}
//				}else{
//					
//					AuthMenu authMenu=new AuthMenu();
//					authMenu.setGrade(2);
//					authMenu.setAuth(1);
//					authMenu.setFid(id);
//					//循环二级菜单
//					List<AuthMenu> towauthMenulist =authMenuService.GetMenu(authMenu);
//					for(int i = 0 ;  i <towauthMenulist.size(); i++ ){
//						//根据二级菜单ID循环三级菜单
//						authMenu=new AuthMenu();
//						authMenu.setGrade(3);
//						authMenu.setAuth(1);
//						authMenu.setFid(towauthMenulist.get(i).getId());
//						List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
//						for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
//							AuthUser authuser=new AuthUser();
//							authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//							authuser.setUserid(userid);
//							authUserMapper.deleteByUserid(authuser);
//						}
//					}
//
//				}
//				
//				state=1;
//				break;
//			case "Two":
//				if(current==1){
//					AuthMenu authMenu=new AuthMenu();
//					authMenu=new AuthMenu();
//					authMenu.setGrade(3);
//					authMenu.setAuth(1);
//					authMenu.setFid(id);
//					List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
//					for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
//						//如果菜单下面不包含公司选项Post为0 包含为1，如果包含 循环添加公司 部门 岗位
//						if(ThreeauthMenulist.get(j).getPost() == 0){
//							AuthUser authuser=new AuthUser();
//							authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//							authuser.setUserid(userid);
//							authUserMapper.insertAuthUser(authuser);
//						}else{
//							//循环所有公司
//							List<Company> companys = this.companyService.selectByUserid(userid, ThreeauthMenulist.get(j).getId());
//							for(int a = 0 ;  a <companys.size(); a++ ){
//								//循环所有部门
//								List<Demp> demps = this.dempService.SelectByUserid(userid, ThreeauthMenulist.get(j).getId(), companys.get(a).getId());
//								if(demps.size()==0){
//									AuthUser authuser=new AuthUser();
//									authuser.setUserid(userid);
//									authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//									authuser.setCompanyid(companys.get(a).getId());
//									authUserMapper.insertAuthUser(authuser);
//									
//								}else{
//									for(int q = 0 ;  q <demps.size(); q++ ){
//										
//										List<Post> posts = this.postService.SelectByUserid(userid, ThreeauthMenulist.get(j).getId(), demps.get(q).getId());
//										if(posts.size()==0){
//											AuthUser authuser=new AuthUser();
//											authuser.setUserid(userid);
//											authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//											authuser.setCompanyid(companys.get(a).getId());
//											authuser.setDempid(demps.get(q).getId());
//											authUserMapper.insertAuthUser(authuser);
//											
//										}else{
//											for(int w = 0 ;  w <posts.size(); w++ ){
//												AuthUser authuser=new AuthUser();
//												authuser.setUserid(userid);
//												authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//												authuser.setCompanyid(companys.get(a).getId());
//												authuser.setDempid(demps.get(q).getId());
//												authuser.setPostid(posts.get(w).getId());
//												authUserMapper.insertAuthUser(authuser);
//											}
//										}
//									}
//								}
//					 		}
//						}
//					}
//				}
//				else{
//					AuthMenu authMenu=new AuthMenu();
//					authMenu=new AuthMenu();
//					authMenu.setGrade(3);
//					authMenu.setAuth(1);
//					authMenu.setFid(id);
//					List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
//					for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
//						AuthUser authuser=new AuthUser();
//						authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//						authuser.setUserid(userid);
//						authUserMapper.deleteByUserid(authuser);
//					}
//				}
//				
//				state=1;
//				break;
//			case "Three":
//				if(current==1){
//					AuthMenu authMenu=new AuthMenu();
//					authMenu=new AuthMenu();
//					authMenu.setId(id);
//					authMenu.setGrade(3);
//					authMenu.setAuth(1);
//					List<AuthMenu> TauthMenulist =authMenuService.GetMenu(authMenu);
//					for(int j = 0 ;  j <TauthMenulist.size(); j++ ){
//						//如果菜单下面不包含公司选项Post为0 包含为1，如果包含 循环添加公司 部门 岗位
//						if(TauthMenulist.get(j).getPost() == 0){
//							AuthUser authuser=new AuthUser();
//							authuser.setMenuid(TauthMenulist.get(j).getId());
//							authuser.setUserid(userid);
//							authUserMapper.insertAuthUser(authuser);
//						}else{
//							//循环所有公司
//							List<Company> companys = this.companyService.selectByUserid(userid, TauthMenulist.get(j).getId());
//							for(int a = 0 ;  a <companys.size(); a++ ){
//								//循环所有部门
//								List<Demp> demps = this.dempService.SelectByUserid(userid, TauthMenulist.get(j).getId(), companys.get(a).getId());
//								if(demps.size()==0){
//									AuthUser authuser=new AuthUser();
//									authuser.setUserid(userid);
//									authuser.setMenuid(TauthMenulist.get(j).getId());
//									authuser.setCompanyid(companys.get(a).getId());
//									authUserMapper.insertAuthUser(authuser);
//									
//								}else{
//									for(int q = 0 ;  q <demps.size(); q++ ){
//										List<Post> posts = this.postService.SelectByUserid(userid, TauthMenulist.get(j).getId(), demps.get(q).getId());
//										if(posts.size()==0){
//											AuthUser authuser=new AuthUser();
//											authuser.setUserid(userid);
//											authuser.setMenuid(TauthMenulist.get(j).getId());
//											authuser.setCompanyid(companys.get(a).getId());
//											authuser.setDempid(demps.get(q).getId());
//											authUserMapper.insertAuthUser(authuser);
//											
//										}else{
//											for(int w = 0 ;  w <posts.size(); w++ ){
//												AuthUser authuser=new AuthUser();
//												authuser.setUserid(userid);
//												authuser.setMenuid(TauthMenulist.get(j).getId());
//												authuser.setCompanyid(companys.get(a).getId());
//												authuser.setDempid(demps.get(q).getId());
//												authuser.setPostid(posts.get(w).getId());
//												authUserMapper.insertAuthUser(authuser);
//											}
//										}
//									}
//								}
//					 		}
//						}
//					}
//				}
//				else{
//					AuthMenu authMenu=new AuthMenu();
//					authMenu=new AuthMenu();
//					authMenu.setId(id);
//					authMenu.setGrade(3);
//					authMenu.setAuth(1);
//					List<AuthMenu> ThreeauthMenulist =authMenuService.GetMenu(authMenu);
//					for(int j = 0 ;  j <ThreeauthMenulist.size(); j++ ){
//						AuthUser authuser=new AuthUser();
//						authuser.setMenuid(ThreeauthMenulist.get(j).getId());
//						authuser.setUserid(userid);
//						authUserMapper.deleteByUserid(authuser);
//					}
//					
//				}
//				
//				state=1;
//				break;
//			case "Company":
//				if(current==1){
//					
//					List<Demp> demps = this.dempService.SelectByUserid(userid, fid, id);
//					if(demps.size()==0){
//						AuthUser authuser=new AuthUser();
//						authuser.setUserid(userid);
//						authuser.setMenuid(fid);
//						authuser.setCompanyid(id);
//						authUserMapper.insertAuthUser(authuser);
//						
//					}else{
//						for(int q = 0 ;  q <demps.size(); q++ ){
//							List<Post> posts = this.postService.SelectByUserid(userid, fid, demps.get(q).getId());
//							if(posts.size()==0){
//								AuthUser authuser=new AuthUser();
//								authuser.setUserid(userid);
//								authuser.setMenuid(fid);
//								authuser.setCompanyid(id);
//								authuser.setDempid(demps.get(q).getId());
//								authUserMapper.insertAuthUser(authuser);
//								
//							}else{
//								for(int w = 0 ;  w <posts.size(); w++ ){
//									AuthUser authuser=new AuthUser();
//									authuser.setUserid(userid);
//									authuser.setMenuid(fid);
//									authuser.setCompanyid(id);
//									authuser.setDempid(demps.get(q).getId());
//									authuser.setPostid(posts.get(w).getId());
//									authUserMapper.insertAuthUser(authuser);
//								}
//							}
//						}
//					}
//				}else{
//					AuthUser authuser=new AuthUser();
//					authuser.setCompanyid(id);
//					authuser.setUserid(userid);
//					authUserMapper.deleteByUserid(authuser);
//				}
//					
//				state=1;
//				break;
//			case "Demp":
//				if(current==1){
//					Demp demp = this.dempService.selectByPrimaryKey(id);
//					post.setDempId(id);
//					List<Post> posts = this.postService.SelectByUserid(userid, fid, id);
//					if(posts.size()==0){
//						AuthUser authuser=new AuthUser();
//						authuser.setUserid(userid);
//						authuser.setMenuid(fid);
//						authuser.setCompanyid(demp.getCompanyid());
//						authuser.setDempid(id);
//						authUserMapper.insertAuthUser(authuser);
//						
//					}else{
//						for(int w = 0 ;  w <posts.size(); w++ ){
//							AuthUser authuser=new AuthUser();
//							authuser.setUserid(userid);
//							authuser.setMenuid(fid);
//							authuser.setCompanyid(demp.getCompanyid());
//							authuser.setDempid(id);
//							authuser.setPostid(posts.get(w).getId());
//							authUserMapper.insertAuthUser(authuser);
//						}
//					}
//				}
//				else{
//					AuthUser authuser=new AuthUser();
//					authuser.setDempid(id);
//					authuser.setUserid(userid);
//					authUserMapper.deleteByUserid(authuser);
//				}
//				state=1;
//				break;
//			case "Post":
//				if(current==1){
//					Post postss = this.postService.selectByPrimaryKey(id);
//					AuthUser authuser=new AuthUser();
//					authuser.setUserid(userid);
//					authuser.setMenuid(fid);
//					authuser.setCompanyid(postss.getCompanyId());
//					authuser.setDempid(postss.getDempId());
//					authuser.setPostid(id);
//					authUserMapper.insertAuthUser(authuser);
//				}else{
//					AuthUser authuser=new AuthUser();
//					authuser.setPostid(id);
//					authuser.setUserid(userid);
//					authUserMapper.deleteByUserid(authuser);
//				}
//				state=1;
//				break;
//		}
//		return state;
//	}

	@Override
	public int deleteByUserid(Integer userid) {
		AuthUser authuser=new AuthUser();
		authuser.setUserid(userid);
		return authUserMapper.deleteByUserid(authuser);
	}

	@Override
	public List<Integer> getSelectedMenuIds(Integer grade, Integer post, String number, Integer menuId, Integer userid) {

		List<Integer> selectMenuIds = new ArrayList<Integer>();
		List<AuthUser> authUsers = authUserMapper.selectByUserid(userid, "menu");
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

	public List<String> getSelectedByPost(Integer grade, Integer post, String number, Integer menuId, Integer userid) {
		//待我审批
//		List<Integer> selectMenuIds = new ArrayList<Integer>();
		List<String> selectOrgNums = new ArrayList<String>();
		//得到post的权限列表
		if(grade == 1){
			//展示第一级，查询type=post的菜单，得到menuidlist，循环查出下级的选中状态
			List<Integer> firstPostMenuIds = authMenuMapper.selectByPostAndGrade(post, 1);
			first:
				for(Integer firstId : firstPostMenuIds){
					List<Integer> secondMenuIds = authMenuMapper.selectByFid(firstId);
					for(Integer secondMenuid : secondMenuIds){
						List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuid);
						for (int i = 0; i < thirdMenuIds.size(); i++) {
							List<Integer> postIds = authUserMapper.selectByMenuidAndUserid(userid, thirdMenuIds.get(i));
							//查询所有post
							List<Integer> allPostIds = postMapper.selectAllPostId(0);
							if(!compare(postIds, allPostIds)){
								break first;
							}
						}
					}
					selectOrgNums.add(firstId + "");
				}
			
		}else if(grade == 2){
			//展示第二级，传入第一级id,查出子三级菜单的选中状态
			
			List<Integer> secondMenuIds = authMenuMapper.selectByFid(menuId);
			second: 
				for(Integer secondMenuid : secondMenuIds){
					List<Integer> thirdMenuIds = authMenuMapper.selectByFid(secondMenuid);
					for (int i = 0; i < thirdMenuIds.size(); i++) {
						List<Integer> postIds = authUserMapper.selectByMenuidAndUserid(userid, thirdMenuIds.get(i));
						//查询所有post
						List<Integer> allPostIds = postMapper.selectAllPostId(0);
						if(!compare(postIds, allPostIds)){
							break second;
						}
					}
					selectOrgNums.add(secondMenuid + "");
				}
				
			}else if(grade == 3){
			//如果是展示第三级,传入第二级menuid，查出子菜单，查出此三级菜单下所有岗位与组织机构所有权限对比
			List<Integer> thirdMenuIds = authMenuMapper.selectByFid(menuId);
			for(Integer thirdMenuId : thirdMenuIds){
				List<Integer> postIds = authUserMapper.selectByMenuidAndUserid(userid, thirdMenuId);
				//查询所有post
				List<Integer> allPostIds = postMapper.selectAllPostId(0);
				if(compare(postIds, allPostIds)){
					selectOrgNums.add(thirdMenuId + "");
				}
			}
		}else if(grade == 4){
			//得到总公司，根据userid和menuid判断，查出此三级菜单下所有岗位与组织机构所有权限对
			List<Integer> postIds = authUserMapper.selectByMenuidAndUserid(userid, menuId);
			//查询所有post
			List<Integer> allPostIds = postMapper.selectAllPostId(0);
			if(compare(postIds, allPostIds)){
				selectOrgNums.add(menuId + "");
			}
		}else if(grade > 4){
//			List<String> selectOrgNums = new ArrayList<String>();
			List<AuthUser> authUsers = authUserMapper.selectByUserid(userid, "post");
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
				List<String> childNums = new ArrayList<String>();
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
								childNums = map.get(pNumber);
								String postNum = sNumArr[sNumArr.length-1];
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
								List<Organization> companys = companyMapper.selectByPId(companyId);
								if(companys != null && companys.size() > 0){
									companys.add(company);
								}else{
									companys = new ArrayList<Organization>();
									companys.add(company);
								}
								
								List<String> postNums = companyService.getPostNumByCompanys(companys);
								if(compare(postNums, existPostNums)){
									selectOrgNums.add(parentOrgNum);
								}
								
							}else if(parentOrgNum.startsWith("DEMP")){
								selectOrgNums.addAll(checkDemp(parentOrgNum, existPostNums));
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
							selectOrgNums.addAll(checkDemp(parentOrgNum, existPostNums));
								
						}
					}
				}
			}
		}
		return selectOrgNums; 
	}

	private List<String> checkDemp(String parentOrgNum, List<String> existPostNums) {
		List<String> selectOrgNums = new ArrayList<String>();
		//得到部门下所有的岗位，与existPostNums比对
		//根据number得到所有的子部门
		Organization demp = dempMapper.selectOrgByNumber(parentOrgNum);
		//查找公司下边的直接部门或者部门下边直接的岗位
		List<Organization> demps = dempMapper.selectOrgsByPId(demp.getId());
		//得到所有子部门,加上选中部门
		if(demps != null && demps.size() > 0){
			demps.add(demp);
		}else{
			demps = new ArrayList<Organization>();
			demps.add(demp);
		}
		
		List<String> postNums = new ArrayList<String>();
		
		for(Organization organization : demps){
			Integer dempId = organization.getId();
			List<Organization> dempList = dempMapper.selectOrgsByPId(dempId);
			List<String> postList = postMapper.selectLinealNumsByDempId(dempId);
			
			postNums.addAll(postList);
			postNums.addAll(companyService.getDeptNums(dempList));
		}
		
		if(compare(postNums, existPostNums)){
			selectOrgNums.add(parentOrgNum);
		}
		return selectOrgNums;
	}
	
	 // 查找指定字符串是否存在 
	  public static void main(String[] args) { 
	    String str1 = "abcdefghijklmnabc"; 
	    // 从头开始查找是否存在指定的字符 
	    System.out.println(str1.indexOf("c")); 
	    // 从第四个字符位置开始往后继续查找 
	    System.out.println(str1.indexOf("c", 3)); 
	    //若指定字符串中没有该字符则系统返回-1 
	    System.out.println(str1.indexOf("x")); 
	  }
	
}
