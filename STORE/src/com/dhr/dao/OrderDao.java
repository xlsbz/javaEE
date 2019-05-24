package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.Order;
import com.dhr.web.domain.OrderItem;
import com.dhr.web.domain.PageBean;

public interface OrderDao {
	/**
	 * ���涩��
	 * @param order
	 */
	void saveOrder(Order order)throws Exception;
	/**
	 * ���涩����
	 * @param oItem
	 * @throws Exception
	 */
	void saveOrderItem(OrderItem oItem)throws Exception;
	/**
	 * ��ҳ��ѯ����
	 * @param bean
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	List<Order> findOrderByPage(PageBean<Order> bean, String userid)throws Exception;
	/**
	 * ������
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	int findAllCount(String userid)throws Exception;
	/**
	 * ��ѯָ������
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Order getById(String oid)throws Exception;
	/**
	 * ���¶���
	 * @param order
	 * @throws Exception
	 */
	void update(Order order)throws Exception;
	/**
	 * ȡ������
	 * @param oid
	 * @throws Exception
	 */
	void deleteOrder(String oid)throws Exception;
	
	
	/*---------------admin-----------------*/
	/**
	 * �鿴���ж���admin
	 * @param bean
	 * @param state
	 * @return
	 * @throws Exception
	 */
	List<Order> findAllOrder(PageBean<Order> bean, int state)throws Exception;
	/**
	 * ͳ�Ƹ��ֶ�������
	 * @param state
	 * @return
	 * @throws Exception
	 */
	int findAllCountOrder(int state)throws Exception;
	
	
}
