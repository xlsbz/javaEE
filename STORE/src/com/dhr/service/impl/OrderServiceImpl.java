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
	 * ���涩���Ͷ�����
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
	 * ��ҳ��ѯ����
	 */
	public PageBean<Order> findOrderByPage(int pageNumber, int pageSize, String userid) throws Exception {
		//0.��ҳ���Ҫ��  
		//a.ÿҳ��ʲô����,��ȡ   b.ÿҳ�ж����������Լ�����  c.һ���ж���������  ��ȡ  d.���ǵڼ�ҳ �Լ�����   e.һ������ҳ ������/ÿҳ����
		//1.����pageBean
		PageBean<Order> bean = new PageBean<>(pageNumber, pageSize);
		//2.��ȡÿҳ���ݲ�����
		List<Order> olist= orderDao.findOrderByPage(bean,userid);
		bean.setData(olist);
		//3.��ȡһ�����������ݲ�����
		int count = orderDao.findAllCount(userid);
		bean.setTotalRecord(count);
		return bean;
	}
	@Override
	/**
	 * ID��ѯ����
	 */
	public Order getById(String oid) throws Exception {
		Order order = null;
		order = orderDao.getById(oid);
		return order;
	}
	@Override
	/**
	 * ���¶���
	 */
	public void updateOrder(Order order) throws Exception {
		orderDao.update(order);
		conn.close();
	}
	@Override
	/**
	 * ɾ������
	 */
	public void deleteOrder(String oid) throws Exception {
		orderDao.deleteOrder(oid);
		conn.close();
	}
	
	
	/*--------------------------admin---------------------------------*/
	@Override
	/**
	 * ��ѯ���ж���
	 */
	public PageBean<Order> findAllOrder(int pageNumber, int pageSize, int state) throws Exception {
		PageBean<Order> bean = new PageBean<>(pageNumber, pageSize);
		//2.��ȡÿҳ���ݲ�����
		List<Order> olist= orderDao.findAllOrder(bean,state);
		bean.setData(olist);
		//3.��ȡһ�����������ݲ�����
		int count = orderDao.findAllCountOrder(state);
		bean.setTotalRecord(count);
		return bean;
	}
}
