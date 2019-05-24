package com.dhr.service.impl;

import java.util.List;

import com.dhr.dao.FunctionDao;
import com.dhr.dao.RoleDao;
import com.dhr.dao.UserDao;
import com.dhr.dao.impl.FunctionDaoImpl;
import com.dhr.dao.impl.RoleDaoImpl;
import com.dhr.dao.impl.UserDaoImpl;
import com.dhr.domain.Function;
import com.dhr.domain.Role;
import com.dhr.domain.User;
import com.dhr.service.PrivilegeService;

/**
 * 权限业务
 * 
 * @author Mr DU
 *
 */
public class PrivilegeServiceImpl implements PrivilegeService {
	private UserDao userDao = new UserDaoImpl();
	private FunctionDao functionDao = new FunctionDaoImpl();
	private RoleDao roleDao = new RoleDaoImpl();

	/**
	 * 管理员登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		return userDao.find(username, password);
	}

	/**
	 * 查询所有功能列表
	 * 
	 * @return
	 */
	public List<Function> findAllFunctions() {
		return functionDao.findAll();
	}

	/**
	 * 新增功能
	 * 
	 * @param function
	 */
	public void addFunction(Function function) {
		functionDao.save(function);
	}

	/**
	 * 查询所有角色列表
	 * 
	 * @return
	 */
	public List<Role> findAllRoles() {
		return roleDao.findAll();
	}

	/**
	 * 新增角色
	 * 
	 * @param role
	 */
	public void addRole(Role role) {
		roleDao.save(role);
	}

	/**
	 * 根据ID查询角色
	 * 
	 * @param roleId
	 * @return
	 */
	public Role findRoleById(String roleId) {
		return roleDao.find(roleId);
	}

	/**
	 * 给角色分配功能
	 * 
	 * @param roleId
	 * @param functionIds
	 */
	public void grantFunction2Role(String roleId, String[] functionIds) {
		roleDao.updateRoleFunction(roleId, functionIds);
	}

	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	/**
	 * 新增管理员
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userDao.save(user);
	}

	/**
	 * 查询单个管理员
	 * 
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId) {
		return userDao.find(userId);
	}

	/**
	 * 给管理员分配角色
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void grantRole2User(String userId, String[] roleIds) {
		userDao.updateUserRole(userId, roleIds);
	}

}
