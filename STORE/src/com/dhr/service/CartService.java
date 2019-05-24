package com.dhr.service;

import java.util.List;

import com.dhr.web.domain.CartVo;

public interface CartService {
	/**
	 * ��д���ݿ�
	 * @param cartVo
	 * @return
	 */
	boolean addCart(CartVo cartVo)throws Exception;
	/**
	 * ��ѯ�������ݿ������
	 * @param uid
	 * @return
	 */
	List<CartVo> findCart(String uid)throws Exception;
	/**
	 * ɾ��
	 * @param uid
	 */
	void deleteCart(String uid)throws Exception;

}
