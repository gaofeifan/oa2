package com.pj.auth.service;

import java.util.List;

import com.pj.auth.pojo.AuthMenu;
import com.pj.config.base.service.BaseService;


public interface AuthMenuService extends BaseService<AuthMenu, Integer> {


	List<AuthMenu> GetMenu(AuthMenu authmenu);

}
