package com.dhr.service;

import com.dhr.domain.Customer;

/**
 * 客户业务
 * 
 * @author Mr DU
 *
 */
public interface CustomerService {
	/**
	 * 新用户注册
	 * 
	 * @param customer
	 */
	void regist(Customer customer);

	/**
	 * 用户登陆
	 * 
	 * @param email
	 * @param phoneNumber
	 * @return
	 */
	Customer login(String email, String phoneNumber);

	/**
	 * 修改个人信息
	 * 
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * 根据激活码查询客户
	 * 
	 * @param activeCode
	 * @return
	 */
	Customer findCustomerByActiveCode(String activeCode);

}
