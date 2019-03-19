package cn.dhr.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Or;

import cn.dhr.domain.Cart;
import cn.dhr.domain.CartItem;
import cn.dhr.domain.Order;
import cn.dhr.domain.OrderItem;
import cn.dhr.domain.Product;
import cn.dhr.domain.User;
import cn.dhr.service.OrderService;
import cn.dhr.service.ProductService;
import cn.dhr.service.impl.OrderServiceImpl;
import cn.dhr.service.impl.ProductServiceImpl;
import cn.dhr.utils.PageBean;
import cn.dhr.utils.UUIDUtils;
import cn.dhr.web.baseservlet.BaseSerlvet;

/**
 * ����������
 * @author Mr DU
 *
 */
@WebServlet("/order")
public class OrderServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;

	/**
	 * ���涩�����䶩����
	 * @param req
	 * @param res
	 * @return
	 *  private String oid;
		private Double total;
		private Date ordertime;
		private Integer state;
		private List<OrderItem> orderItems;//1:n
		
		private String itemid;
		private Integer count;
		private Double subtotal;
		private Product bid;//1:n
		private Order oid;
	 * @throws IOException 
	 * @throws Exception 
	 */
	public String saveOrder(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
			//1.��ȡ��ز���
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			Cart cart = (Cart)session.getAttribute("cart");
			Order order = new Order();
			//2.��װ�������
			order.setOid(UUIDUtils.getUUIDUtils());
			order.setTotal(cart.getTotal());
			order.setOrdertime(new Date());
			order.setState(0);
			order.setUser(user);
			//2.1��װ������
			List<OrderItem> items = new ArrayList<>();
			for (CartItem oi : cart.getCartItems()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setItemid(UUIDUtils.getUUIDUtils());
				orderItem.setOrdercount(oi.getCount());
				orderItem.setSubtotal(oi.getSubTotal());
				orderItem.setProduct(oi.getProduct());
				orderItem.setOrder(order);
				items.add(orderItem);
			}
			order.setOrderItems(items);
			//3.����service
			OrderService os = new OrderServiceImpl();
			os.saveOrder(order);
			session.setAttribute("order", order);
			//����ɹ�������ﳵ
			cart.clear2Cart();
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "��������ʧ�ܣ�");
			return "/jsp/msg.jsp";
		}
		//4.ת��
		res.sendRedirect(req.getContextPath()+"/jsp/order_info.jsp");
		return null;
		
	}
	
	
	/**
	 * ��ҳ��ѯ�ҵĶ���
	 * @param req
	 * @param res
	 * @return
	 */
	public String pageOrderlist(HttpServletRequest req,HttpServletResponse res) {
		PageBean<Order> pageBean = null;
		try {
			//1.�ӵڼ�ҳ��ʼ��ÿҳ��ʾ����������
			int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			int pageSize = 3;
			//1.1��ȡ��ǰ��¼�û�����
			User user = (User) req.getSession().getAttribute("user");
			//2.����service����pageBean
			OrderService os = new OrderServiceImpl();
			pageBean = os.pageOrderlist(pageNumber,pageSize,user);
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "������ȡʧ�ܣ������µ�¼���Կ�");
		}
		//4.����ֵת��
		req.setAttribute("pageBean", pageBean);
		return "/jsp/order_list.jsp";
	}
	
	/**
	 * ȡ������
	 * @param req
	 * @param res
	 * @return
	 */
	public String deleteOrder(HttpServletRequest req,HttpServletResponse res) {
		try {
			String oid = req.getParameter("oid");
			OrderService os = new OrderServiceImpl();
			int flag = os.deleteOrder(oid);
			if(flag>0) {
				req.setAttribute("msg", "���"+oid+"ȡ���ɹ���");
			}else {
				req.setAttribute("msg", "����ȡ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "����ȡ��ʧ�ܣ�");
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
	}
	
	
	/**
	 * ��ѯ������������
	 * @param req
	 * @param res
	 * @return
	 */
	public String gotoOrder(HttpServletRequest req,HttpServletResponse res) {
		try {
			String oid = req.getParameter("oid");
			OrderService os = new OrderServiceImpl();
			Order order = os.gotoOrder(oid);
			req.setAttribute("order", order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/order_info.jsp";
	}
	
	
	/**
	 * ȷ���ջ�
	 * @param req
	 * @param res
	 * @return
	 */
	public String sureOrder(HttpServletRequest req,HttpServletResponse res) {
		try {
			String oid = req.getParameter("oid");
			OrderService os = new OrderServiceImpl();
			os.sureOrder(oid);
			req.setAttribute("msg", "�ջ��ɹ�����ȥ���۰�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
	}
}
