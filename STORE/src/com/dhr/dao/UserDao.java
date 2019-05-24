package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;

public interface UserDao {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	User loginUser(String username, String password) throws Exception;
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	boolean registerUser(User user)throws Exception;
	/**
	 * 用户注册验证
	 * @param username
	 * @return
	 */
	boolean registerUserByName(String username)throws Exception;
	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	boolean updatePassword(String oldPassword, String newPassword,String uid)throws Exception;
	
	
	/*---------------admin-------------------*/
	/**
	 * 分页查询用户----->admin
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	List<User> findAllUser(PageBean<User> bean)throws Exception;
	/**
	 * 用户总个数
	 * @return
	 * @throws Exception
	 */
	int getAllUserCount() throws Exception;

}
