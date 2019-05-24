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
 * 购物车处理
 * @author Mr DU
 *
 */
@WebServlet("/cart")
public class CartServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * 产生一个购物车(session)
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
	 * 用户退出把购物车数据封装回数据库
	 * @param req
	 * @param res
	 * @return
	 */
	public String saveDB(HttpServletRequest req,HttpServletResponse res) {
		//获取购物车
		Cart cart = getCart(req);
		//获取用户ID
		String uid = (String) req.getSession().getAttribute("userid");
		//把购物车的购物项放到集合遍历
		Collection<CartItem> map = cart.getCartItems();
		//遍历购物车
		Iterator<CartItem> iterator = map.iterator();
		
		while(iterator.hasNext()) {
			CartItem item = iterator.next();
			String pid = item.getProduct().getPid();
			int count = item.getCount();
			//封装购物车
			CartVo cartVo = new CartVo(uid, pid, count);
			//调用service封装回数据库
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
	 * 查看购物车,从数据库取出来,并删除数据库的数据
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
				//1.封装商品信息和购买数量到商品项
				CartItem cartItem = new CartItem(product, count);
				//2.获取一个购物车
				Cart cart = getCart(req);
				//3.执行添加的方法
				cart.add2Cart(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		deleteCart(req,res);
		return "/jsp/cart.jsp";
	}
	/**
	 * 删除数据库的内容
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
	 * 添加到购物车
	 */
	private static String cookieproduct = "";
	public String add2Cart(HttpServletRequest req,HttpServletResponse res) {
		try {
			findCart(req,res);
			//1.获取页面传过来的商品id和数量
			String pid = req.getParameter("pid");
			int count = Integer.parseInt(req.getParameter("count"));
			//2.通过商品id获取调用service方法获取商品基本信息
			ProductService ps = new ProductServiceImpl();
			Product product = ps.getProductById(pid);
			//3.封装商品信息和购买数量到商品项
			CartItem cartItem = new CartItem(product,count);
			//4.获取一个购物车
			Cart cart = getCart(req);
			//把这次浏览的数据放到cookie发给客户端
			cookieproduct += pid+"#";
			Cookie cookie = new Cookie("userLooked",cookieproduct);
			cookie.setPath(req.getContextPath()+"/");
			cookie.setMaxAge(Integer.MAX_VALUE);
			res.addCookie(cookie);
			//5.执行添加的方法
			cart.add2Cart(cartItem);
			res.sendRedirect(req.getContextPath()+"/jsp/cart.jsp");
		} catch (Exception e) {
			req.setAttribute("msg", "添加到购物车失败");
			e.printStackTrace();
			return "/jsp/msg.jsp";
		}
		deleteCart(req,res);
		return null;
	}
	
	/**
	 * 移除某个商品
	 */
	public String removeProduct(HttpServletRequest req,HttpServletResponse res) {
		Cart cart = getCart(req);
		String pid = req.getParameter("pid");
		cart.removeProduct(pid);
		return "/jsp/cart.jsp";
	}
	/**
	 * 清除购物车
	 */
	public String clearCart(HttpServletRequest req,HttpServletResponse res) {
		Cart cart = getCart(req);
		cart.clearCart();
		return "jsp/cart.jsp";
	}
}
