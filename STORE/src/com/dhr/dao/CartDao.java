package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.CartVo;

public interface CartDao {
	/**
	 * ����Ʒд�����ݿ�
	 * @param cartVo
	 * @return
	 */
	boolean addCart(CartVo cartVo)throws Exception;
	/**
	 * ��ѯ���ݿ����Ϣ�ŵ�map����
	 * @param uid
	 * @return
	 */
	List<CartVo> findCart(String uid)throws Exception;
	/**
	 * �����ݿ��Լ�����Ϣ���
	 * @param uid
	 */
	void deleteCart(String uid)throws Exception;

}
