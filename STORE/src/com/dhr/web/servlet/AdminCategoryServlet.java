package com.dhr.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.CategoryService;
import com.dhr.service.impl.CategoryServiceImpl;
import com.dhr.util.UUIDUtils;
import com.dhr.web.domain.Category;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * 分类管理
 * @author Mr DU
 *
 */
@WebServlet("/admincategory")
public class AdminCategoryServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * 查询所有分类
	 * @param req
	 * @param res
	 * @return
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse res) {
		try {
			CategoryService cs = new CategoryServiceImpl();
			List<Category> cateList = cs.findAllCate();
			req.setAttribute("allCategory", cateList);
		} catch (Exception e) {
			req.setAttribute("msg", "查询分类失败");
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
	/**
	 * 通往修改的UI
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryUpdateUI(HttpServletRequest req,HttpServletResponse res) {
		try {
			String cid = req.getParameter("cid");
			CategoryService cs = new CategoryServiceImpl();
			Category category = cs.getById(cid);
			req.setAttribute("category", category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/category/edit.jsp";
	}
	/**
	 * 修改分类名称
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryUpdate(HttpServletRequest req,HttpServletResponse res) {
		//1.获取相关参数
		try {
			String cid = req.getParameter("cid");
			String cname = req.getParameter("cname");
			//2.调用service
			CategoryService cs = new CategoryServiceImpl();
			boolean flag = cs.categoryUpdate(cid,cname);
			if(flag) {
				req.setAttribute("msg", "分类修改成功!");
				return "/admin/category/list.jsp";
			}else {
				req.setAttribute("msg", "分类修改失败!");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "分类修改失败!");
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
	/**
	 * 删除分类
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryDelete(HttpServletRequest req,HttpServletResponse res) {
		try {
			String cid = req.getParameter("cid");
			CategoryService cs = new CategoryServiceImpl();
			boolean flag = cs.categoryDelete(cid);
			if(flag) {
				req.setAttribute("msg", "分类删除成功!");
			}else {
				req.setAttribute("msg", "分类删除失败!");
			}
		}catch (Exception e) {
				req.setAttribute("msg", "分类删除失败!");
				e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
	/**
	 * 通往添加分类
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryAddUI(HttpServletRequest req,HttpServletResponse res) {
		return "/admin/category/add.jsp";
	}
	
	public String categoryAdd(HttpServletRequest req,HttpServletResponse res) {
		//1.获取页面参数,封装
		try {
			String cname = req.getParameter("cname");
			String cid = UUIDUtils.getId();
			Category category = new Category();
			category.setCid(cid);
			category.setCname(cname);
			//2.调用service
			CategoryService cs = new CategoryServiceImpl();
			boolean flag = cs.categoryAdd(category);
			//3.判断是否成功
			if(flag) {
				req.setAttribute("msg", "分类添加成功!");
			}else {
				req.setAttribute("msg", "分类添加失败!");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "分类添加失败!");
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
}
