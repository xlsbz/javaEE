package cn.dhr.service;

import cn.dhr.domain.Order;
import cn.dhr.domain.User;
import cn.dhr.utils.PageBean;

public interface OrderService {

	/**
	 * 保存订单
	 * @param order
	 * @throws Exception
	 */
	void saveOrder(Order order)throws Exception;

	/**
	 * 分页查询某个用户的所有订单
	 * @param pageNumber
	 * @param pageSize
	 * @param user
	 * @return
	 * @throws Exception
	 */
	PageBean<Order> pageOrderlist(int pageNumber, int pageSize, User user)throws Exception;

	/**
	 * 取消订单
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	int deleteOrder(String oid)throws Exception;

	/**
	 * 查询单个订单付款
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Order gotoOrder(String oid)throws Exception;

	/**
	 * 确认收货
	 * @param oid
	 * @throws Exception
	 */
	void sureOrder(String oid)throws Exception;

}
