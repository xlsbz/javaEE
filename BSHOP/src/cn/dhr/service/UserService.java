package cn.dhr.service;

import cn.dhr.domain.User;

public interface UserService {
	
	/**
	 * 查看用户是否存在
	 * @param username
	 * @return
	 */
	User getByName(String username) throws Exception;
	
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
