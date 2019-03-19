package cn.dhr.service;

import cn.dhr.domain.Admin;

/**
 * 管理员接口
 * @author Mr DU
 *
 */
public interface AdminService {

	/**
	 * 管理员登录
	 * @param user
	 */
	Admin loginAdmin(String user);
	
}
