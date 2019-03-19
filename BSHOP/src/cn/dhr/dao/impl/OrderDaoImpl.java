package cn.dhr.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.dhr.dao.OrderDao;
import cn.dhr.domain.Order;
import cn.dhr.domain.OrderItem;
import cn.dhr.domain.Product;
import cn.dhr.utils.DataSourceUtils;
import cn.dhr.utils.PageBean;

public class OrderDaoImpl implements OrderDao {
	Connection con = null;
	@Override
	public void saveOrder(Order order) throws Exception {
		QueryRunner qr = new QueryRunner();
		//手动获取连接
		con = DataSourceUtils.getConnection();
		String sql = "insert into orders values(?,?,?,?,?,?)";
		Object[] params = {order.getOid(),order.getTotal(),order.getOrdertime(),order.getState(),order.getAddress(),order.getUser().getUid()};
		qr.update(con,sql,params);
		DataSourceUtils.closeTransaction(con);
	}

	@Override
	public void saveOrderItems(OrderItem orderItems) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "insert into orderitem values(?,?,?,?,?)";
		Object[] params = {orderItems.getItemid(),orderItems.getOrdercount(),orderItems.getSubtotal(),orderItems.getProduct().getBid(),orderItems.getOrder().getOid()};
		qr.update(con,sql,params);
		DataSourceUtils.closeTransaction(con);
	}

	@Override
	public List<Order> getPageData(PageBean<Order> pageBean, String uid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		//1.获取所有订单
		String sql = "select * from orders where uid=? order by ordertime desc limit ?,?";
		List<Order> listOrder = qr.query(sql, new BeanListHandler<>(Order.class),uid,pageBean.getStartIndex(),pageBean.getPageData());
		//2.遍历订单，获取每一个订单里面的订单项
		for (Order order : listOrder) {
			sql = "select * from orderitem o,book b where o.bid=b.bid and oid=?";
			List<Map<String, Object>> list = qr.query(sql, new MapListHandler(),order.getOid());
			OrderItem item = null;
			for (Map<String, Object> map : list) {
				item = new OrderItem();
				BeanUtils.populate(item, map);
				//封装product
				Product product = new Product();
				BeanUtils.populate(product, map);
				item.setProduct(product);
				//把订单项设置到订单他那个集合里面
				order.getOrderItems().add(item);
			}
		}
		return listOrder;
	}

	@Override
	public int getAllRecords(String uid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "select count(*) from orders where uid=?";
		long c = (long) qr.query(sql, new ScalarHandler(),uid);
		int count = (int)c;
		return count;
	}

	@Override
	public int deleteOrder(String oid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "delete from orders where oid=?";
		int update = qr.update(sql,oid);
		return update;
	}

	@Override
	public Order gotoOrder(String oid) throws Exception {
		//1.查询单个订单
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "select * from orders where oid=?";
		Order order = qr.query(sql, new BeanHandler<>(Order.class),oid);
		//2.查询订单里面的订单项
		sql = "select * from book,orderitem where book.bid = orderitem.bid and oid=?";
		List<Map<String,Object>> listOrders = qr.query(sql, new MapListHandler(),oid);
		for (Map<String, Object> map : listOrders) {
			//遍历封装订单项到order里
			OrderItem oItem = new OrderItem();
			BeanUtils.populate(oItem, map);
			//封装product
			Product product = new Product();
			BeanUtils.populate(product, map);
			oItem.setProduct(product);
			
			order.getOrderItems().add(oItem);
		}
		return order;
	}

	@Override
	public void sureOrder(String oid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "update orders set state=? where oid=?";
		qr.update(sql,3,oid);
	}

}
