package cn.dhr.dao;

import cn.dhr.domain.Admin;

/**
 * 管理员数据层
 * @author Mr DU
 *
 */
public interface AdminDao {

	/**
	 * 用户登录
	 * @param user
	 */
	Admin loginAdmin(String user);

}
