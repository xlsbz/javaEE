package com.dhr.web.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.ProductService;
import com.dhr.service.impl.ProductServiceImpl;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;
import com.dhr.web.servlet.baseservlet.BaseServlet;
@WebServlet("/product")
public class ProductServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询商品详情
	 */
	public String getProductById(HttpServletRequest req,HttpServletResponse res) {
		cookieProduct(req);
		String pid = req.getParameter("pid");
		//service
		ProductService ps = new ProductServiceImpl();
		Product product;
		try {
			product = ps.getProductById(pid);
			req.setAttribute("productBean", product);
		} catch (Exception e) {
			req.setAttribute("msg", "查询商品信息失败");
			return "/jsp/msg.jsp";
		}
		if(product==null) {
			req.setAttribute("msg", "查询商品信息失败");
			return "/jsp/msg.jsp";
		}
		return "/jsp/product_info.jsp";
	}
	/**
	 * 显示最近浏览
	 * @param req
	 * @return
	 */
	public String cookieProduct(HttpServletRequest req) {
		ProductService ps = new ProductServiceImpl();
		//查询cookie存不存在
		try {
			Cookie[] cs =req.getCookies();
			for(Cookie c:cs) {
				if(c.getName().equals("userLooked")) {
					String userlooked = c.getValue();
					String[] p = userlooked.split("#");
					List<Product> proList = new ArrayList<>();
					for(int i=0;i<p.length&&i<15;i++) {
						String productId = p[i];
						Product pro = ps.getProductById(productId);
						proList.add(pro);
					}
					req.setAttribute("proList", proList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 点击搜索
	 * @param req
	 * @param res
	 * @return
	 */
	public String searchProduct(HttpServletRequest req,HttpServletResponse res) {
		try {
			//0.获取参数
			String search = req.getParameter("search");
			//1.调用service方法
			ProductService ps = new ProductServiceImpl();
			List<Product> searchList = ps.searchProduct(search);
			//2.转发
			req.setAttribute("sList", searchList);
			if(searchList.size()==0) {
				req.setAttribute("msg", "对不起,没有找到您要的商品!");
				return "/jsp/msg.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "对不起,没有找到您要的商品!");
			return "/jsp/msg.jsp";
		}
		return "/jsp/product_search.jsp";
	}
	/**
	 * 分页查询商品
	 * @param req
	 * @param res
	 * @return
	 */
	public String findByPage(HttpServletRequest req,HttpServletResponse res) {
		int pageNumber=1;
		pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		int pageSize = 12;
		String cid = req.getParameter("cid");
		//调用service
		ProductService ps = new ProductServiceImpl();
		PageBean<Product> pagebean;
		try {
			pagebean = ps.findBypage(pageNumber,pageSize,cid);
			req.setAttribute("pagebean", pagebean);
		} catch (Exception e) {
			req.setAttribute("msg", "分页查询失败！");
			return "/jsp/msg.jsp";
		}
		return "/jsp/product_list.jsp";
	}
}
