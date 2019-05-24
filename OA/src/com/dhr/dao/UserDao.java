package com.dhr.dao;

import java.util.List;

import com.dhr.domain.User;

/**
 * 管理员数据接口
 * 
 * @author Mr DU
 *
 */
public interface UserDao {

	/**
	 * 查询用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User find(String username, String password);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	void save(User user);

	/**
	 * 查询单个用户
	 * 
	 * @param userId
	 * @return
	 */
	User find(String userId);

	/**
	 * 修改用户权限
	 * 
	 * @param userId
	 * @param roleIds
	 */
	void updateUserRole(String userId, String[] roleIds);

}
