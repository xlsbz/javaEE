package com.dhr.dao;

import java.util.List;

import com.dhr.domain.CustomerStatus;

/**
 * 客户状态数据层
 * 
 * @author Mr DU
 *
 */
public interface CustomerStatusDao {

	/**
	 * 查询所有客户状态
	 * 
	 * @return
	 */
	List<CustomerStatus> findAll();

	/**
	 * 根据ID查询单个客户状态
	 * 
	 * @param customerStatusId
	 * @return
	 */
	CustomerStatus findOne(String customerStatusId);

	/**
	 * 新增客户状态
	 * 
	 * @param customerStatus
	 */
	void save(CustomerStatus customerStatus);

}
