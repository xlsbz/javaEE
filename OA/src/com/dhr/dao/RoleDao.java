package com.dhr.dao;

import java.util.List;

import com.dhr.domain.Role;

/**
 * 角色数据接口层
 * 
 * @author Mr DU
 *
 */
public interface RoleDao {

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	List<Role> findAll();

	/**
	 * 新增角色
	 * 
	 * @param role
	 */
	void save(Role role);

	/**
	 * 查询单个角色
	 * 
	 * @param roleId
	 * @return
	 */
	Role find(String roleId);

	/**
	 * 修改角色和功能的关系
	 * 
	 * @param roleId
	 * @param functionIds
	 */
	void updateRoleFunction(String roleId, String[] functionIds);

}
