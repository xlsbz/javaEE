package cn.dhr.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.dhr.dao.OrderDao;
import cn.dhr.dao.impl.OrderDaoImpl;
import cn.dhr.domain.Order;
import cn.dhr.domain.OrderItem;
import cn.dhr.domain.User;
import cn.dhr.service.OrderService;
import cn.dhr.utils.DataSourceUtils;
import cn.dhr.utils.PageBean;

public class OrderServiceImpl implements OrderService {

	@Override
	public void saveOrder(Order order) {
		try {
			//开启事务
			DataSourceUtils.beginTransaction();
			OrderDao od = new OrderDaoImpl();
			//保存订单和订单项
			od.saveOrder(order);
			//遍历订单项
			for (OrderItem oItem : order.getOrderItems()) {
				od.saveOrderItems(oItem);
			}
			//事务提交
			DataSourceUtils.commitTransaction();
		} catch (Exception e) {
			try {
				//出现异常回滚事务
				DataSourceUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public PageBean<Order> pageOrderlist(int pageNumber, int pageSize, User user) throws Exception {
		//封装号每页数据传回给web层
		PageBean<Order> pageBean = new PageBean<>(pageNumber, pageSize);
		//获取每页数据
		OrderDao od = new OrderDaoImpl();
		List<Order> orders = od.getPageData(pageBean,user.getUid());
		pageBean.setData(orders);
		//获取总数据
		int count = od.getAllRecords(user.getUid());
		pageBean.setPageDataTotal(count);
		return pageBean;
	}

	@Override
	public int deleteOrder(String oid) throws Exception {
		OrderDao od = new OrderDaoImpl();
		return od.deleteOrder(oid);
	}

	@Override
	public Order gotoOrder(String oid) throws Exception {
		OrderDao od = new OrderDaoImpl();
		return od.gotoOrder(oid);
	}

	@Override
	public void sureOrder(String oid) throws Exception {
		OrderDao od = new OrderDaoImpl();
		od.sureOrder(oid);
	}

}
