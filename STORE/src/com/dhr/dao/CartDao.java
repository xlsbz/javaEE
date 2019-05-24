package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.CartVo;

public interface CartDao {
	/**
	 * 把商品写回数据库
	 * @param cartVo
	 * @return
	 */
	boolean addCart(CartVo cartVo)throws Exception;
	/**
	 * 查询数据库的信息放到map集合
	 * @param uid
	 * @return
	 */
	List<CartVo> findCart(String uid)throws Exception;
	/**
	 * 把数据库自己的信息清空
	 * @param uid
	 */
	void deleteCart(String uid)throws Exception;

}
