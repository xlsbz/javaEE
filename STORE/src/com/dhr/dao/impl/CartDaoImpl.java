package com.dhr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.dhr.dao.CartDao;
import com.dhr.util.UUIDUtils;
import com.dhr.web.domain.CartVo;
/**
 * 数据层操作
 * @author Mr DU
 *
 */
public class CartDaoImpl implements CartDao{
	private PreparedStatement prep;
	private Connection conn;
	public CartDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	/**
	 * 添加到购物车
	 */
	public boolean addCart(CartVo cartVo) throws Exception{
		boolean flag = false;
		String sql = "INSERT INTO cart VALUES(?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cartVo.getUid());
		prep.setString(2, cartVo.getPid());
		prep.setInt(3, cartVo.getCount());
		prep.setString(4, UUIDUtils.getId());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	/**
	 * 查询购物车的商品
	 */
	public List<CartVo> findCart(String uid) throws Exception {
		CartVo cartVo = null;
		List<CartVo> all = new ArrayList<>();
		String sql = "SELECT * FROM cart WHERE uid=? ORDER BY uid DESC";
		prep = conn.prepareStatement(sql);
		prep.setString(1, uid);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			cartVo = new CartVo();
			cartVo.setUid(rs.getString(1));
			cartVo.setPid(rs.getString(2));
			cartVo.setCount(rs.getInt(3));
			all.add(cartVo);
		}
		return all;
	}
	@Override
	/**
	 * 删除
	 */
	public void deleteCart(String uid) throws Exception {
		String sql = "DELETE FROM cart WHERE uid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, uid);
		prep.executeUpdate();
	}

}
