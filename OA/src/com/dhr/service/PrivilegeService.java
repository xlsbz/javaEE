package com.dhr.service;

import java.util.List;

import com.dhr.domain.Function;
import com.dhr.domain.Role;
import com.dhr.domain.User;

/**
 * 权限管理业务
 * 
 * @author wzhting
 *
 */
public interface PrivilegeService {

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 查询所有功能列表
	 * 
	 * @return
	 */
	List<Function> findAllFunctions();

	/**
	 * 新增功能
	 * 
	 * @param function
	 */
	void addFunction(Function function);

	/**
	 * 查询所有角色列表
	 * 
	 * @return
	 */
	List<Role> findAllRoles();

	/**
	 * 新增角色
	 * 
	 * @param role
	 */
	void addRole(Role role);

	/**
	 * 根据id查询某个角色同时把关联的功能也查询出来
	 * 
	 * @param roleId
	 * @return
	 */
	Role findRoleById(String roleId);

	/**
	 * 给角色功能添加功能
	 * 
	 * @param roleId
	 * @param functionIds
	 */
	void grantFunction2Role(String roleId, String[] functionIds);

	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	List<User> findAllUsers();

	/**
	 * 新增管理员
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 查询管理员同时把已经分配的角色查询出来
	 * 
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);

	/**
	 * 给管理员分配角色
	 * 
	 * @param userId
	 * @param roleIds
	 */
	void grantRole2User(String userId, String[] roleIds);

}
