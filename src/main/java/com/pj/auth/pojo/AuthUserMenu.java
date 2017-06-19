package com.pj.auth.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 *	@author		GFF
 *	@date		2017年6月19日上午10:35:32
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="auth_user_menu")
public class AuthUserMenu {

	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="menu_id")
	private Integer menuId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
