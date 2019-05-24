package com.dhr.service.impl;

import com.dhr.dao.CustomerDao;
import com.dhr.dao.impl.CustomerDaoImpl;
import com.dhr.domain.Customer;
import com.dhr.service.CustomerService;

/**
 * 用户业务
 * 
 * @author Mr DU
 *
 */
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * 注册
	 * 
	 * @param customer
	 */
	public void regist(Customer customer) {
		customerDao.save(customer);
	}

	/**
	 * 用户登录
	 * 
	 * @param email
	 * @param phoneNumber
	 * @return
	 */
	public Customer login(String email, String phoneNumber) {
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		return customerDao.uniqueResult(customer);
	}

	/**
	 * 更新用户
	 * 
	 * @param customer
	 */
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

	/**
	 * 根据激活码查询是否存在该用户
	 * 
	 * @param activeCode
	 * @return
	 */
	public Customer findCustomerByActiveCode(String activeCode) {
		Customer customer = new Customer();
		customer.setActiveCode(activeCode);
		return customerDao.uniqueResult(customer);
	}

}
