package com.dhr.service.impl;
import java.util.List;

import com.dhr.conn.Conn;
import com.dhr.dao.OrderDao;
import com.dhr.dao.impl.OrderDaoImpl;
import com.dhr.service.OrderService;
import com.dhr.web.domain.Order;
import com.dhr.web.domain.OrderItem;
import com.dhr.web.domain.PageBean;
public class OrderServiceImpl implements OrderService{
	private Conn conn = null;
	private OrderDao orderDao = null;
	public OrderServiceImpl() {
		conn = new Conn();
		orderDao = new OrderDaoImpl(conn.getConnection());
	}
	@Override
	/**
	 * 保存订单和订单项
	 */
	public void saveOrder(Order order) throws Exception {
			orderDao.saveOrder(order);
			for(OrderItem oItem:order.getItems()) {
				orderDao.saveOrderItem(oItem);
			}
		conn.close();
	}
	@Override
	/**
	 * 分页查询订单
	 */
	public PageBean<Order> findOrderByPage(int pageNumber, int pageSize, String userid) throws Exception {
		//0.分页五大要素  
		//a.每页有什么数据,获取   b.每页有多少条数据自己设置  c.一共有多少条数据  获取  d.这是第几页 自己设置   e.一共多少页 总数据/每页数据
		//1.创建pageBean
		PageBean<Order> bean = new PageBean<>(pageNumber, pageSize);
		//2.获取每页数据并设置
		List<Order> olist= orderDao.findOrderByPage(bean,userid);
		bean.setData(olist);
		//3.获取一共多少条数据并设置
		int count = orderDao.findAllCount(userid);
		bean.setTotalRecord(count);
		return bean;
	}
	@Override
	/**
	 * ID查询订单
	 */
	public Order getById(String oid) throws Exception {
		Order order = null;
		order = orderDao.getById(oid);
		return order;
	}
	@Override
	/**
	 * 更新订单
	 */
	public void updateOrder(Order order) throws Exception {
		orderDao.update(order);
		conn.close();
	}
	@Override
	/**
	 * 删除订单
	 */
	public void deleteOrder(String oid) throws Exception {
		orderDao.deleteOrder(oid);
		conn.close();
	}
	
	
	/*--------------------------admin---------------------------------*/
	@Override
	/**
	 * 查询所有订单
	 */
	public PageBean<Order> findAllOrder(int pageNumber, int pageSize, int state) throws Exception {
		PageBean<Order> bean = new PageBean<>(pageNumber, pageSize);
		//2.获取每页数据并设置
		List<Order> olist= orderDao.findAllOrder(bean,state);
		bean.setData(olist);
		//3.获取一共多少条数据并设置
		int count = orderDao.findAllCountOrder(state);
		bean.setTotalRecord(count);
		return bean;
	}
}
