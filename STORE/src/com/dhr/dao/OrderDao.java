package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.Order;
import com.dhr.web.domain.OrderItem;
import com.dhr.web.domain.PageBean;

public interface OrderDao {
	/**
	 * 保存订单
	 * @param order
	 */
	void saveOrder(Order order)throws Exception;
	/**
	 * 保存订单项
	 * @param oItem
	 * @throws Exception
	 */
	void saveOrderItem(OrderItem oItem)throws Exception;
	/**
	 * 分页查询订单
	 * @param bean
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	List<Order> findOrderByPage(PageBean<Order> bean, String userid)throws Exception;
	/**
	 * 总数据
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	int findAllCount(String userid)throws Exception;
	/**
	 * 查询指定订单
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Order getById(String oid)throws Exception;
	/**
	 * 更新订单
	 * @param order
	 * @throws Exception
	 */
	void update(Order order)throws Exception;
	/**
	 * 取消订单
	 * @param oid
	 * @throws Exception
	 */
	void deleteOrder(String oid)throws Exception;
	
	
	/*---------------admin-----------------*/
	/**
	 * 查看所有订单admin
	 * @param bean
	 * @param state
	 * @return
	 * @throws Exception
	 */
	List<Order> findAllOrder(PageBean<Order> bean, int state)throws Exception;
	/**
	 * 统计各种订单数量
	 * @param state
	 * @return
	 * @throws Exception
	 */
	int findAllCountOrder(int state)throws Exception;
	
	
}
