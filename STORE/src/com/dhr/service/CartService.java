package com.dhr.service;

import java.util.List;

import com.dhr.web.domain.CartVo;

public interface CartService {
	/**
	 * 回写数据库
	 * @param cartVo
	 * @return
	 */
	boolean addCart(CartVo cartVo)throws Exception;
	/**
	 * 查询出来数据库的数据
	 * @param uid
	 * @return
	 */
	List<CartVo> findCart(String uid)throws Exception;
	/**
	 * 删除
	 * @param uid
	 */
	void deleteCart(String uid)throws Exception;

}
