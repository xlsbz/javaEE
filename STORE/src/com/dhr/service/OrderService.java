package com.dhr.service;


import com.dhr.web.domain.Order;
import com.dhr.web.domain.PageBean;

public interface OrderService {
	/**
	 * 保存订单信息
	 * @param order
	 * @throws Exception
	 */
	void saveOrder(Order order)throws Exception;
	/**
	 * 分页查询指定订单
	 * @param pageNumber
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	PageBean<Order> findOrderByPage(int pageNumber, int pageSize, String userid)throws Exception;
	/**
	 * 查询某个订单去付款
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Order getById(String oid)throws Exception;
	/**
	 * 更新订单信息
	 * @param order
	 */
	void updateOrder(Order order)throws Exception;
	/**
	 * 取消订单
	 * @param oid
	 */
	void deleteOrder(String oid)throws Exception;
	
	
	/*------------------admin--------------------*/
	/**
	 * 查询所有订单
	 * @param state
	 * @return
	 * @throws Exception
	 */
	PageBean<Order> findAllOrder(int pageNumber, int pageSize, int state)throws Exception;


}
