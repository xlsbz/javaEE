package cn.dhr.service;

import cn.dhr.domain.Order;
import cn.dhr.domain.User;
import cn.dhr.utils.PageBean;

public interface OrderService {

	/**
	 * ���涩��
	 * @param order
	 * @throws Exception
	 */
	void saveOrder(Order order)throws Exception;

	/**
	 * ��ҳ��ѯĳ���û������ж���
	 * @param pageNumber
	 * @param pageSize
	 * @param user
	 * @return
	 * @throws Exception
	 */
	PageBean<Order> pageOrderlist(int pageNumber, int pageSize, User user)throws Exception;

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
	void sureOrder(String oid)throws Exception;

}
