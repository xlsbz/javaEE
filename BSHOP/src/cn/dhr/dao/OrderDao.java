package cn.dhr.dao;

import java.util.List;

import cn.dhr.domain.Order;
import cn.dhr.domain.OrderItem;
import cn.dhr.utils.PageBean;

public interface OrderDao {

	/**
	 * ���涩��
	 * @param order
	 * @throws Exception
	 */
	void saveOrder(Order order)throws Exception;

	/**
	 * ���涩����
	 * @param orderItems
	 * @throws Exception
	 */
	void saveOrderItems(OrderItem orderItems)throws Exception;

	/**
	 * ��ȡÿҳ�Ķ���
	 * @param pageBean
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	List<Order> getPageData(PageBean<Order> pageBean, String uid)throws Exception;

	/**
	 * ��ȡ�ܶ�����
	 * @param uid
	 * @return
	 */
	int getAllRecords(String uid)throws Exception;

	/**
	 * ȡ������
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	int deleteOrder(String oid)throws Exception;

	/**
	 * ��ѯ������������
	 * @param oid
	 * @return
	 * @throws Exception
	 */
	Order gotoOrder(String oid)throws Exception;

	/**
	 * ȷ���ջ�
	 * @param oid
	 * @throws Exception
	 */
	void sureOrder(String oid)throws Exception;;

}
