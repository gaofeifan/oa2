package com.pj.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
								List<Company> companys = this.companyService.selectNotDeleteALL();
								for(int a = 0 ;  a <companys.size(); a++ ){
									//循环所有部门
									List<Demp> demps = this.dempService.selectByCompanyId(companys.get(a).getId());
									
									for(int q = 0 ;  q <demps.size(); q++ ){
										post.setDempId(demps.get(q).getId());
										List<Post> posts = this.postService.selectALL(post);
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
							List<Company> companys = this.companyService.selectNotDeleteALL();
							for(int a = 0 ;  a <companys.size(); a++ ){
								//循环所有部门
								List<Demp> demps = this.dempService.selectByCompanyId(companys.get(a).getId());
								
								for(int q = 0 ;  q <demps.size(); q++ ){
									post.setDempId(demps.get(q).getId());
									List<Post> posts = this.postService.selectALL(post);
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
							List<Company> companys = this.companyService.selectNotDeleteALL();
							for(int a = 0 ;  a <companys.size(); a++ ){
								//循环所有部门
								List<Demp> demps = this.dempService.selectByCompanyId(companys.get(a).getId());
								
								for(int q = 0 ;  q <demps.size(); q++ ){
									post.setDempId(demps.get(q).getId());
									List<Post> posts = this.postService.selectALL(post);
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
					List<Demp> demps = this.dempService.selectByCompanyId(id);
					for(int q = 0 ;  q <demps.size(); q++ ){
						post.setDempId(demps.get(q).getId());
						
						List<Post> posts = this.postService.selectALL(post);
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
					List<Post> posts = this.postService.selectALL(post);
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

}
