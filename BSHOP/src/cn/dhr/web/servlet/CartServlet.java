package cn.dhr.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dhr.domain.Cart;
import cn.dhr.domain.CartItem;
import cn.dhr.domain.Product;
import cn.dhr.service.ProductService;
import cn.dhr.service.impl.ProductServiceImpl;
import cn.dhr.web.baseservlet.BaseSerlvet;
/**
 * ���ﳵ������
 * @author Mr DU
 *
 */
@WebServlet("/cart")
public class CartServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	public Cart getCart(HttpServletRequest req) {
		Cart cart = new Cart();
		HttpSession session = req.getSession();
		if(session.getAttribute("cart")==null) {
			session.setAttribute("cart", cart);
		}else {
			cart = (Cart) session.getAttribute("cart");
		}
		return cart;
	}
	/**
	 * ��ӵ����ﳵ
	 * @param req
	 * @param res
	 * @return
	 */
	public String add2Cart(HttpServletRequest req,HttpServletResponse res) {
		try {
			//��ȡ��Ʒ����
			String bid = req.getParameter("bid");
			int count = Integer.parseInt(req.getParameter("count"));
			//��ѯ����Ʒ��װ��cartItem
			ProductService ps = new ProductServiceImpl();
			Product product = ps.getProductInfo(bid);
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCount(count);
			//2.��ȡһ��session���ﳵ
			Cart cart = getCart(req);
			cart.add2Cart(cartItem);
			res.sendRedirect(req.getContextPath()+"/jsp/cart.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �Ƴ����ﳵ
	 * @param req
	 * @param res
	 * @return
	 */
	public String delete2Cart(HttpServletRequest req,HttpServletResponse res) {
		try {
			String bid = req.getParameter("bid");
			//��ȡ���ﳵ
			Cart cart = getCart(req);
			cart.delete2Cart(bid);
			res.sendRedirect(req.getContextPath()+"/jsp/cart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��չ��ﳵ
	 * @param req
	 * @param res
	 * @return
	 */
	public String clear2Cart(HttpServletRequest req,HttpServletResponse res) {
		//���÷������map
		try {
			Cart cart = getCart(req);
			cart.clear2Cart();
			res.sendRedirect(req.getContextPath()+"/jsp/cart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
