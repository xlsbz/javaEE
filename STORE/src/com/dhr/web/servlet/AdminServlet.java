package com.dhr.web.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.Userservice;
import com.dhr.service.impl.UserserviceImpl;
import com.dhr.util.XMLUtils;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * 管理员操作
 * @author Mr DU
 *
 */
@WebServlet("/admin")
public class AdminServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * 管理员登录
	 * @param req
	 * @param res
	 * @return
	 * 采用xml小型数据库存放管理员信息
	 */
	public String loginAdmin(HttpServletRequest req,HttpServletResponse res) {
		//1.获取页面传来的参数
		try {
			String adminName = req.getParameter("adminName");
			String password = req.getParameter("password");
			//2.把参数与xml信息对比
			boolean flag = XMLUtils.loginAdmin(adminName, password);
			//3.转发
			if(flag) {
				req.getSession().setAttribute("admin", adminName);
				res.sendRedirect(req.getContextPath()+"/admin/home.jsp");
			}else {
				req.setAttribute("msg", "用户名密码错误!");
				return "/admin/index.jsp";
			}
		} catch (IOException e) {
			req.setAttribute("msg", "用户名密码错误!");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 退出
	 * @param req
	 * @param res
	 * @return
	 * @throws IOException 
	 */
	public String logonAdmin(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String admin = (String)req.getSession().getAttribute("name");
		if(admin!=null) {
			req.getSession().invalidate();
		}
		res.sendRedirect(req.getContextPath()+"/admin/index.jsp");
		return null;
	}
	/**
	 * 查询所有用户
	 * @param req
	 * @param res
	 * @return
	 */
	public String findAllUser(HttpServletRequest req,HttpServletResponse res) {
		int pageNumber = 1;
		int pageSize = 4;
		try {
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			PageBean<User> pageBean = null;
			Userservice us = new UserserviceImpl();
			pageBean = us.findAllUser(pageNumber,pageSize);
			if(pageBean.getData().size()!=0) {
				req.setAttribute("allUserBean", pageBean);
			}else {
				req.setAttribute("msg", "没有查询到用户!");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "用户查询失败");
			e.printStackTrace();
		}
		return "/admin/user/list.jsp";
	}
}
