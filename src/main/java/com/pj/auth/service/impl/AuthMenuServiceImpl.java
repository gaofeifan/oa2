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
import com.pj.config.base.constant.Constant;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.PostMapper;


@Transactional
@Service
public class AuthMenuServiceImpl extends AbstractBaseServiceImpl<AuthMenu, Integer> implements AuthMenuService {

	@Resource
	private AuthMenuMapper authMenuMapper;
	
//	@Resource
//	private AuthUserService authUserService;
	
	@Resource
	private AuthUserMapper authUserMapper;
	
	@Resource
	private PostMapper postMapper;
	

	@Override
	public MyMapper<AuthMenu> getMapper() {
		return authMenuMapper;
	}
	
	@Override
	public List<AuthMenu> GetMenu(AuthMenu authmenu) {
		List<AuthMenu> authmenus = this.authMenuMapper.GetMenu(authmenu);
		return authmenus;
	}
	
	public List<AuthMenu> GetMenu(AuthMenu authmenu, Integer userid) {
		List<AuthMenu> authmenus = this.authMenuMapper.GetMenu(authmenu);
		

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
						//查询所有post
						List<Integer> allPostIds = postMapper.selectAllPostId(0);
						if(!compare(postIds, allPostIds)){
							break first;
						}
					}
				}
				
				//TODO
				AuthMenu choiceAuthmenu = authMenuMapper.selectByPrimaryKey(firstMenuId);
				int index = authmenus.indexOf(choiceAuthmenu);
				authmenus.get(index).setChoice("1");
//				for(AuthMenu authMenu : authmenus){
//					if(authmenu.getId().equals(firstMenuId)){
//						authmenu.setChoice("1");
//					}
//				}
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
						   getSelectNums(authmenus, childAuthList, pMenuId);
						  }
				}
			}
		}
		
		return authmenus;
	}
	@Override
	public List<AuthMenu> GetMenubyUserid(Integer grade, Integer auth, Integer userid) {
		List<AuthMenu> authmenus =authMenuMapper.GetMenubyUserid(grade, auth, userid);
		return authmenus;
	}

	@Override
	public List<AuthUser> selectUserByMessageCenterId() {
		AuthUser record = new AuthUser();
		record.setMenuid(Constant.messageCenterMenuId);
		List<AuthUser> list = this.authUserMapper.select(record );
		return list;
	}
	
	@Override
	public List<AuthMenu> GetOneMenubyUserid(Integer userid) {
		List<AuthMenu> authmenus =authMenuMapper.GetOneMenubyUserid(userid);
		return authmenus;
	}

	@Override
	public List<AuthMenu> GetTwoMenubyUserid(Integer userid, Integer fid) {
		List<AuthMenu> authmenus =authMenuMapper.GetTwoMenubyUserid(userid,fid);
		return authmenus;
	}
	@Override
	public List<AuthMenu> GetThreeMenubyUserid(Integer userid, Integer fid) {
		List<AuthMenu> authmenus =authMenuMapper.GetThreeMenubyUserid(userid,fid);
		return authmenus;
	}

	@Override
	public int GetAuthMenubyUserid(String name, Integer userid) {
		int num =authMenuMapper.GetAuthMenubyUserid(name,userid);
		return num;
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
	private void getSelectNums(List<AuthMenu> authmenus, List<Integer> childAuthList, Integer pMenuId) {
		//查询数据库中pMenuId菜单的所有子菜单
		List<Integer> menuIds = authMenuMapper.selectByFid(pMenuId);
		if(compare(childAuthList,menuIds)){
			
			AuthMenu choiceAuthmenu = authMenuMapper.selectByPrimaryKey(pMenuId);
			int index = authmenus.indexOf(choiceAuthmenu);
			authmenus.get(index).setChoice("1");
			
		}
	}

}
