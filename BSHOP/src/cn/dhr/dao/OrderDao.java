package cn.dhr.dao;

import java.util.List;

import cn.dhr.domain.Order;
import cn.dhr.domain.OrderItem;
import cn.dhr.utils.PageBean;

public interface OrderDao {

	/**
	 * 保存订单
	 * @param order
	 * @throws Exception
	 */
	void saveOrder(Order order)throws Exception;

	/**
	 * 保存订单项
	 * @param orderItems
	 * @throws Exception
	 */
	void saveOrderItems(OrderItem orderItems)throws Exception;

	/**
	 * 获取每页的订单
	 * @param pageBean
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	List<Order> getPageData(PageBean<Order> pageBean, String uid)throws Exception;

	/**
	 * 获取总订单数
	 * @param uid
	 * @return
	 */
	int getAllRecords(String uid)throws Exception;

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
	void sureOrder(String oid)throws Exception;;

}
