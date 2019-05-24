package com.dhr.service.impl;

import java.util.List;

import com.dhr.conn.Conn;
import com.dhr.dao.CartDao;
import com.dhr.dao.impl.CartDaoImpl;
import com.dhr.service.CartService;
import com.dhr.web.domain.CartVo;

public class CartServiceImpl implements CartService{
	private Conn conn = null;
	private CartDao cartDao = null;
	public CartServiceImpl() {
		conn = new Conn();
		cartDao = new CartDaoImpl(conn.getConnection());
	}
	@Override
	/**
	 * ��ӵ����ﳵ
	 */
	public boolean addCart(CartVo cartVo) throws Exception {
		boolean flag = false;
		flag = cartDao.addCart(cartVo);
		conn.close();
		return flag;
	}
	@Override
	/**
	 * ��ѯ���ﳵ
	 */
	public List<CartVo> findCart(String uid) throws Exception {
		List<CartVo> cartVo = null;
		cartVo = cartDao.findCart(uid);
		conn.close();
		return cartVo;
	}
	@Override
	/**
	 * ɾ�����ﳵ
	 */
	public void deleteCart(String uid) throws Exception {
		cartDao.deleteCart(uid);
		conn.close();
	}

}
