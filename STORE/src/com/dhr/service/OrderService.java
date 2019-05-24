package com.dhr.service;


import com.dhr.web.domain.Order;
import com.dhr.web.domain.PageBean;

public interface OrderService {
	/**
	 * ���涩����Ϣ
	 * @param order
	 * @throws Exception
	 */
	void saveOrder(Order order)throws Exception;
	/**
	 * ��ҳ��ѯָ������
	 * @param pageNumber
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	PageBean<Order> findOrderByPage(int pageNumber, int pageSize, String userid)throws Exception;
	/**
	 * ��ѯĳ������ȥ����
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Order getById(String oid)throws Exception;
	/**
	 * ���¶�����Ϣ
	 * @param order
	 */
	void updateOrder(Order order)throws Exception;
	/**
	 * ȡ������
	 * @param oid
	 */
	void deleteOrder(String oid)throws Exception;
	
	
	/*------------------admin--------------------*/
	/**
	 * ��ѯ���ж���
	 * @param state
	 * @return
	 * @throws Exception
	 */
	PageBean<Order> findAllOrder(int pageNumber, int pageSize, int state)throws Exception;


}
