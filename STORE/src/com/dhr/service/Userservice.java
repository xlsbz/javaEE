package com.dhr.service;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;

public interface Userservice {
	/**
	 * 用户登录
	 * @return
	 */
	User loginUser(String username,String password) throws Exception;
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	boolean registerUser(User user)throws Exception;
	/**
	 * 注册验证
	 * @param username
	 * @return
	 */
	boolean getUserByName(String username)throws Exception;
	/**
	 * 修改用户密码
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	boolean updatePassword(String oldPassword, String newPassword,String uid)throws Exception;
	
	/*---------------admin-------------------*/
	/**
	 * 分页查询用户---->admin
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageBean<User> findAllUser(int pageNumber, int pageSize)throws Exception;

}
