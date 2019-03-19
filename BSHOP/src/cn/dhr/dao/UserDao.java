package cn.dhr.dao;

import cn.dhr.domain.User;

/**
 * 用户dao操作
 * @author Mr DU
 *
 */
public interface UserDao {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User getByName(String username)throws Exception;
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	User loginUser(String username, String password)throws Exception;

	/**
	 * 用户注册
	 * @param user
	 * @throws Exception
	 */
	void addUser(User user)throws Exception;
}
