package com.dhr.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.OrderService;
import com.dhr.service.impl.OrderServiceImpl;
import com.dhr.util.JsonUtil;
import com.dhr.web.domain.Order;
import com.dhr.web.domain.OrderItem;
import com.dhr.web.domain.PageBean;
import com.dhr.web.servlet.baseservlet.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 管理员订单管理
 * @author Mr DU
 *
 */
@WebServlet("/adminorder")
public class AdminOrderServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * 分页查询订单
	 * @param req
	 * @param res
	 * @return
	 */
	public String findAllOrder(HttpServletRequest req,HttpServletResponse res) {
		int pageNumber=1;
		int pageSize = 8;
		try {
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			PageBean<Order> pageBean = null;
			int state = Integer.parseInt(req.getParameter("state"));
			OrderService os = new OrderServiceImpl();
			pageBean = os.findAllOrder(pageNumber,pageSize,state);
			if(pageBean.getData()==null||pageBean.getData().size()==0) {
				req.setAttribute("msg", "没有查询到相应的订单!");
			}else {
				req.setAttribute("pageBean",pageBean );
			}
		}  catch (Exception e) {
			req.setAttribute("msg", "订单获取失败!");
			e.printStackTrace();
		}
		return "/admin/order/list.jsp";
	}
	/**
	 * 查看订单详情
	 * @param req
	 * @param res
	 * @return
	 */
	public String showOrder(HttpServletRequest req,HttpServletResponse res) {
		res.setCharacterEncoding("utf-8");
		try {
			String oid = req.getParameter("oid");
			OrderService os = new OrderServiceImpl();
			Order order = os.getById(oid);
			if(order!=null) {
				List<OrderItem> orders = order.getItems();
				//转换为json
				//res.getWriter().print(JsonUtil.list2json(orders));这里不需要的可以过滤掉
				JsonConfig config = JsonUtil.configJson(new String[] {"order","pdesc","itemd","pdate"});
				res.getWriter().println(JSONArray.fromObject(orders,config));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 去发货
	 * @param req
	 * @param res
	 * @return
	 */
	public String updateState(HttpServletRequest req,HttpServletResponse res) {
		try {
			String oid = req.getParameter("oid");
			OrderService os = new OrderServiceImpl();
			Order order = new Order();
			order.setOid(oid);
			order.setState(2);
			os.updateOrder(order);
			req.setAttribute("msg", "发货成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/order/list.jsp";
	}
}
