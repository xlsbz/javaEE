package cn.dhr.web.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.Product;
import cn.dhr.service.ProductService;
import cn.dhr.service.impl.ProductServiceImpl;
import cn.dhr.utils.PageBean;
import cn.dhr.web.baseservlet.BaseSerlvet;
/**
 * 商品控制器
 * @author Mr DU
 *
 */
@WebServlet("/product")
public class ProductServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	/*
	 * 异步加载商品
	 * @param req
	 * @param res
	 * @return
	 */
	public String findCategory(HttpServletRequest req,HttpServletResponse res) {
		 /* 四大分类*/
		try {
			//响应编码
			req.setCharacterEncoding("utf-8");
			ProductService ps = new ProductServiceImpl();
			String cid = req.getParameter("cid");
			String products = ps.findCategory(cid);
			res.getWriter().print(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 分页显示分类商品
	 * @return
	 */
	public String findPageNumber(HttpServletRequest req,HttpServletResponse res) {
		try {
			//1.获取第几页开始，每页多少条数据,商品类型
		
			int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			String cid = req.getParameter("cid");
			int pageData =2;
			//2.创建pageBean
			PageBean<Product> pageBean = null;
			//3.调用service
			ProductService ps = new ProductServiceImpl();
			pageBean = ps.findPageNumber(pageNumber,pageData,cid);
			req.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/book_list.jsp";
	}
	
	/**
	 * 商品详情展示
	 * @param req
	 * @param res
	 * @return
	 */
	public String productInfo(HttpServletRequest req,HttpServletResponse res) {
		try {
			//1.获取商品ID
			String bid = req.getParameter("bid");
			//2.调用service
			ProductService ps = new ProductServiceImpl();
			Product product = ps.getProductInfo(bid);
			//3.封装数据转发
			req.setAttribute("product", product);
		} catch (Exception e) {
			req.setAttribute("msg", "商品详情获取失败！");
			e.printStackTrace();
			return "/jsp/msg.jsp";
		}
		return "/jsp/book_info.jsp";
	}
}
