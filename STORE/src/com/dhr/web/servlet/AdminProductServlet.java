package com.dhr.web.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.CategoryService;
import com.dhr.service.ProductService;
import com.dhr.service.impl.CategoryServiceImpl;
import com.dhr.service.impl.ProductServiceImpl;
import com.dhr.web.domain.Category;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * 后台商品管理
 * 
 * @author Mr DU
 *
 */
@WebServlet("/adminproduct")
public class AdminProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 分页查看所有上架商品
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public String findAllProduct(HttpServletRequest req, HttpServletResponse res) {
		// 1.获取pageNumber 设置pageSize
		try {
			int pageNumber = 1;
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			int pageSize = 8;
			// 2.调用service 返回pageBean
			PageBean<Product> pageBean = null;
			ProductService ps = new ProductServiceImpl();
			pageBean = ps.findAllProduct(pageNumber, pageSize);
			// 3.保存转发
			req.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "商品查询失败");
		}
		return "/admin/product/list.jsp";
	}
	
	/**
	 * 分页查看所有下架商品
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public String findAllOutProduct(HttpServletRequest req, HttpServletResponse res) {
		// 1.获取pageNumber 设置pageSize
		try {
			int pageNumber = 1;
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			int pageSize = 8;
			// 2.调用service 返回pageBean
			PageBean<Product> pageBean = null;
			ProductService ps = new ProductServiceImpl();
			pageBean = ps.findAllOutProduct(pageNumber, pageSize);
			if(pageBean.getData().size()==0) {
				req.setAttribute("msg", "没有下架商品!");
			}
			// 3.保存转发
			req.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "下架商品查询失败");
		}
		return "/admin/product/list.jsp";
	}

	
	/**
	 * 通往商品修改
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public String updataProductUI(HttpServletRequest req, HttpServletResponse res) {
		try {
			String pid = req.getParameter("pid");
			//查询商品
			ProductService ps = new ProductServiceImpl();
			Product product = ps.getProductById(pid);
			//查询所有分类
			CategoryService cs = new CategoryServiceImpl();
			List<Category> cateList = cs.findAllCate();
			req.setAttribute("product", product);
			req.setAttribute("allCategory", cateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/product/edit.jsp";
	}
	/**
	 * 实现修改
	 * @param req
	 * @param res
	 * @return
	 */
	public String updateProduct(HttpServletRequest req,HttpServletResponse res) {
		//1.获取参数
		String pid = req.getParameter("pid");
	    String pname = req.getParameter("pname");
	    Double market_price = Double.valueOf(req.getParameter("market_price"));
	    Double shop_price = Double.valueOf(req.getParameter("shop_price"));
		Integer is_hot = Integer.parseInt(req.getParameter("is_hot"));
		Integer pflag = Integer.parseInt(req.getParameter("pflag"));
		String pdesc = req.getParameter("pdesc");
		String cid = req.getParameter("cid");
		//2.封装
		Product product = new Product();
		product.setPid(pid);
		product.setPname(pname);
		product.setMarket_price(market_price);
		product.setShop_price(shop_price);
		product.setIs_hot(is_hot);
		product.setPflag(pflag);
		product.setPdesc(pdesc);
		Category category = new Category();
		category.setCid(cid);
		product.setCategory(category);
		
		//3.调用service
		ProductService ps = new ProductServiceImpl();
		boolean flag = false;
		try {
			flag = ps.updataProduct(product);
		} catch (Exception e) {
			req.setAttribute("msg", "商品修改失败!");
			e.printStackTrace();
		}
		if(flag) {
			req.setAttribute("msg", "商品修改成功!");
		}else {
			req.setAttribute("msg", "商品修改失败!");
		}
		return "/admin/product/list.jsp";
	}
	/**
	 * 通往商品上架
	 * @param req
	 * @param res
	 * @return
	 */
	public String addProductUI(HttpServletRequest req,HttpServletResponse res) {
		try {
			//查出所有分类
			CategoryService cs = new CategoryServiceImpl();
			List<Category> cList = cs.findAllCate();
			req.setAttribute("cList", cList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/product/add.jsp";
	}
}
