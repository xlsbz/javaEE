package com.dhr.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhr.service.CartService;
import com.dhr.service.ProductService;
import com.dhr.service.impl.CartServiceImpl;
import com.dhr.service.impl.ProductServiceImpl;
import com.dhr.web.domain.Cart;
import com.dhr.web.domain.CartItem;
import com.dhr.web.domain.CartVo;
import com.dhr.web.domain.Product;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * ���ﳵ����
 * @author Mr DU
 *
 */
@WebServlet("/cart")
public class CartServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * ����һ�����ﳵ(session)
	 */
	public Cart getCart(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	/**
	 * �û��˳��ѹ��ﳵ���ݷ�װ�����ݿ�
	 * @param req
	 * @param res
	 * @return
	 */
	public String saveDB(HttpServletRequest req,HttpServletResponse res) {
		//��ȡ���ﳵ
		Cart cart = getCart(req);
		//��ȡ�û�ID
		String uid = (String) req.getSession().getAttribute("userid");
		//�ѹ��ﳵ�Ĺ�����ŵ����ϱ���
		Collection<CartItem> map = cart.getCartItems();
		//�������ﳵ
		Iterator<CartItem> iterator = map.iterator();
		
		while(iterator.hasNext()) {
			CartItem item = iterator.next();
			String pid = item.getProduct().getPid();
			int count = item.getCount();
			//��װ���ﳵ
			CartVo cartVo = new CartVo(uid, pid, count);
			//����service��װ�����ݿ�
			CartService cs = new CartServiceImpl();
			try {
				cs.addCart(cartVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * �鿴���ﳵ,�����ݿ�ȡ����,��ɾ�����ݿ������
	 * @throws IOException 
	 */
	public String findCart(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
			String uid = (String) req.getSession().getAttribute("userid");
			CartService cs = new CartServiceImpl();
			List<CartVo> vo = cs.findCart(uid);
			Iterator<CartVo> iterator = vo.iterator();
			while(iterator.hasNext()) {
				CartVo cartVo = iterator.next();
				String pid = cartVo.getPid();
				int count = cartVo.getCount();
				ProductService ps = new ProductServiceImpl();
				Product product = ps.getProductById(pid);
				//1.��װ��Ʒ��Ϣ�͹�����������Ʒ��
				CartItem cartItem = new CartItem(product, count);
				//2.��ȡһ�����ﳵ
				Cart cart = getCart(req);
				//3.ִ����ӵķ���
				cart.add2Cart(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		deleteCart(req,res);
		return "/jsp/cart.jsp";
	}
	/**
	 * ɾ�����ݿ������
	 */
	public String deleteCart(HttpServletRequest req,HttpServletResponse res) {
		try {
			String uid = (String) req.getSession().getAttribute("userid");
			CartService cs = new CartServiceImpl();
			cs.deleteCart(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��ӵ����ﳵ
	 */
	private static String cookieproduct = "";
	public String add2Cart(HttpServletRequest req,HttpServletResponse res) {
		try {
			findCart(req,res);
			//1.��ȡҳ�洫��������Ʒid������
			String pid = req.getParameter("pid");
			int count = Integer.parseInt(req.getParameter("count"));
			//2.ͨ����Ʒid��ȡ����service������ȡ��Ʒ������Ϣ
			ProductService ps = new ProductServiceImpl();
			Product product = ps.getProductById(pid);
			//3.��װ��Ʒ��Ϣ�͹�����������Ʒ��
			CartItem cartItem = new CartItem(product,count);
			//4.��ȡһ�����ﳵ
			Cart cart = getCart(req);
			//�������������ݷŵ�cookie�����ͻ���
			cookieproduct += pid+"#";
			Cookie cookie = new Cookie("userLooked",cookieproduct);
			cookie.setPath(req.getContextPath()+"/");
			cookie.setMaxAge(Integer.MAX_VALUE);
			res.addCookie(cookie);
			//5.ִ����ӵķ���
			cart.add2Cart(cartItem);
			res.sendRedirect(req.getContextPath()+"/jsp/cart.jsp");
		} catch (Exception e) {
			req.setAttribute("msg", "��ӵ����ﳵʧ��");
			e.printStackTrace();
			return "/jsp/msg.jsp";
		}
		deleteCart(req,res);
		return null;
	}
	
	/**
	 * �Ƴ�ĳ����Ʒ
	 */
	public String removeProduct(HttpServletRequest req,HttpServletResponse res) {
		Cart cart = getCart(req);
		String pid = req.getParameter("pid");
		cart.removeProduct(pid);
		return "/jsp/cart.jsp";
	}
	/**
	 * ������ﳵ
	 */
	public String clearCart(HttpServletRequest req,HttpServletResponse res) {
		Cart cart = getCart(req);
		cart.clearCart();
		return "jsp/cart.jsp";
	}
}
