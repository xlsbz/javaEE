package com.dhr.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.dhr.dao.OrderDao;
import com.dhr.util.DataSourceUtils;
import com.dhr.web.domain.Order;
import com.dhr.web.domain.OrderItem;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public class OrderDaoImpl implements OrderDao {
	private PreparedStatement prep;
	private Connection conn;
	public OrderDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	/**
	 * 保存订单
	 */
	public void saveOrder(Order order) throws Exception {
		String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1, order.getOid());
		prep.setDate(2, new Date(order.getOrdertime().getTime()));
		prep.setDouble(3, order.getTotal());
		prep.setInt(4, order.getState());
		prep.setString(5, order.getAddress());
		prep.setString(6, order.getName());
		prep.setString(7, order.getTelephone());
		prep.setString(8, order.getUser().getUid());
		prep.executeUpdate();
	}

	@Override
	/**
	 * 保存订单项
	 */
	public void saveOrderItem(OrderItem oItem) throws Exception {
		String sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1, oItem.getItemid());
		prep.setInt(2, oItem.getCount());
		prep.setDouble(3, oItem.getSubtotal());
		prep.setString(4, oItem.getProduct().getPid());
		prep.setString(5, oItem.getOrder().getOid());
		prep.executeUpdate();
	}

	@Override
	/**
	 * 分页查询订单
	 */
	public List<Order> findOrderByPage(PageBean<Order> bean, String userid) throws Exception {
		//1.List保存获取的所有订单order  这里面没有订单项数据
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			//1.1查询所有订单基本信息
			String sql = "SELECT * FROM orders WHERE uid=? ORDER BY oid DESC LIMIT ?,?";
			List<Order> listOrder = qr.query(sql,new BeanListHandler<>(Order.class),userid,bean.getStartIndex(),
					bean.getPageSize());
		//2.遍历上面的list  通过连接查询,关联订单表和商品表获得所有详细数据
		for(Order order:listOrder) {
			sql = "SELECT * FROM orderitem,product WHERE orderitem.pid=product.pid and oid=?";
			List<Map<String,Object>> maplist = qr.query(sql, new MapListHandler(),order.getOid());
			//3.用maplist获取每一个订单项详情,封装成orderItem,在把他加入到当前订单项的items中
			for(Map<String,Object> map:maplist) {
				OrderItem orderItem = new OrderItem();
				//1封装orderItem
				BeanUtils.populate(orderItem, map);
				//2.封装product
				Product p = new Product();
				BeanUtils.populate(p, map);
				orderItem.setProduct(p);
				//把数据给order
				order.getItems().add(orderItem);
			}
		}
		return listOrder;
	}
	
	
	@Override
	/**
	 * 查询总条数
	 */
	
	public int findAllCount(String userid) throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM orders WHERE uid = ?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, userid);
		ResultSet rs = prep.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	@Override
	/**
	 * 查询指定订单
	 */
	public Order getById(String oid) throws Exception {
		//查询指定的订单
		String sql = "SELECT * FROM orders WHERE oid=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		Order order = qr.query(sql, new BeanHandler<>(Order.class),oid);
		//查询这个订单里面的订单项封装到orderItem里,然后给order的items
		sql = "SELECT * FROM orderitem,product WHERE orderitem.pid = product.pid and oid=?";
		List<Map<String, Object>> maplist = qr.query(sql, new MapListHandler(),oid);
		for(Map<String, Object> map:maplist) {
			//封装orderitem数据
			OrderItem orderItem = new OrderItem();
			BeanUtils.populate(orderItem, map);
			//封装对象product
			Product product = new Product();
			BeanUtils.populate(product, map);
			orderItem.setProduct(product);
			
			//封装到某个订单里去
			order.getItems().add(orderItem);
		}
		return order;
	}

	@Override
	/**
	 * 更新订单
	 */
	public void update(Order order) throws Exception {
		String sql = "UPDATE orders SET state=? WHERE oid=?";
		if(order.getAddress()!=null&&order.getName()!=null&&order.getTelephone()!=null) {
			sql = "UPDATE orders SET state=?,address=?,name=?,telephone=? WHERE oid=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, order.getState());
			prep.setString(2, order.getAddress());
			prep.setString(3, order.getName());
			prep.setString(4, order.getTelephone());
			prep.setString(5, order.getOid());
			prep.executeUpdate();
		}else {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, order.getState());
			prep.setString(2, order.getOid());
			prep.executeUpdate();
		}
	}

	@Override
	/**
	 * 取消订单
	 */
	public void deleteOrder(String oid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "DELETE FROM orders WHERE oid=?";
		qr.update(sql,oid);
	}
	
	/*---------------------admin------------------------*/
	@Override
	/**
	 * 分页查询订单
	 */
	public List<Order> findAllOrder(PageBean<Order> bean, int state) throws Exception {
		List<Order> orderList = new ArrayList<>();
		Order order = null;
		String sql = "SELECT * FROM orders WHERE state=? LIMIT ?,?";
		if(state==4) {
			sql = "SELECT * FROM orders WHERE state!=? LIMIT ?,?";
		}
		prep = conn.prepareStatement(sql);
		prep.setInt(1, state);
		prep.setInt(2, bean.getStartIndex());
		prep.setInt(3, bean.getPageSize());
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			order = new Order();
			order.setOid(rs.getString(1));
			order.setOrdertime(rs.getDate(2));
			order.setTotal(rs.getDouble(3));
			order.setState(rs.getInt(4));
			order.setAddress(rs.getString(5));
			order.setName(rs.getString(6));
			order.setTelephone(rs.getString(7));
			orderList.add(order);
		}
		return orderList;
	}

	@Override
	public int findAllCountOrder(int state) throws Exception {
		int count = 0;
		String sql = "";
		if(state==4) {
			sql = "SELECT COUNT(*) FROM orders WHERE state!=?";
		}else {
			sql = "SELECT COUNT(*) FROM orders WHERE state=?";
		}
		prep = conn.prepareStatement(sql);
		prep.setInt(1, state);
		ResultSet rs = prep.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}
}