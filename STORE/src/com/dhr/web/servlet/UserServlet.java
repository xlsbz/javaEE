package com.dhr.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhr.constant.Constant;
import com.dhr.service.ProductService;
import com.dhr.service.Userservice;
import com.dhr.service.impl.ProductServiceImpl;
import com.dhr.service.impl.UserserviceImpl;
import com.dhr.util.UUIDUtils;
import com.dhr.web.domain.Product;
import com.dhr.web.domain.User;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * 用户模块servlet
 * 
 * @author Mr DU、
 *
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 跳转用户登录页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loginUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//同步加载'为你推选'商品模块
			ProductService ps = new ProductServiceImpl();
			List<Product> chooseList = ps.findChoose();
			request.setAttribute("cList", chooseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/login.jsp";
	}
	
	/**
	 * 实现用户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//验证码机制
		String codevalue = request.getParameter("code");
		String code = (String) session.getAttribute("code");
		if(!codevalue.equalsIgnoreCase(code)) {
			request.setAttribute("msg", "验证码不正确!");
			return "/jsp/login.jsp";
		}
		// 调用service
		Userservice us = new UserserviceImpl();
		User user = null;
		try {
			user = us.loginUser(username, password);
		} catch (Exception e) {
			request.setAttribute("msg", "用户名或密码错误！");
			return "/jsp/login.jsp";
		}
		if (user == null) {
			request.setAttribute("msg", "用户名或密码错误！");
			return "/jsp/login.jsp";
		} else {
			session.setAttribute("userid", user.getUid());
			// 设置user
			session.setAttribute("user", user);
			//登录成功后释放验证码保存的数字
			session.removeAttribute("code");
		}
		// 判断用户是否勾选了记住用户名,把他发给浏览器,下一次去直接获取
		if (Constant.SAVE_NAME.equals(request.getParameter("savename"))) {
			Cookie cookie = new Cookie("saveName", URLEncoder.encode(username, "utf-8"));
			//设置cookie的保存时间和路径
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setPath(request.getContextPath() + "/");
			response.addCookie(cookie);
		}
		response.sendRedirect("index.jsp");
		return null;
	}

	/**
	 * 用户退出
	 * 
	 * @throws IOException
	 */
	public String logonUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		if (session.getAttribute("cart") != null) {
			// 用户退出时把购物车数据写回去
			CartServlet cartServlet = new CartServlet();
			cartServlet.saveDB(req, res);
			session.removeAttribute("cart");
			session.removeAttribute("userid");
		}
		res.sendRedirect(req.getContextPath());
		return null;
	}

	/**
	 * 跳转到用户注册
	 */
	public String registerUI(HttpServletRequest req, HttpServletResponse res) {
		return "jsp/register.jsp";
	}

	/**
	 * 用户登录
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public String registerUser(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		User user = new User(UUIDUtils.getId(), username, password, name, email, telephone, birthday, sex);
		// 调用service
		Userservice us = new UserserviceImpl();
		boolean flag = false;
		try {
			flag = us.registerUser(user);
		} catch (Exception e) {
			req.setAttribute("msg", "注册失败！");
			e.printStackTrace();
		}
		if (!flag) {
			req.setAttribute("msg", "注册失败！");
			return "/jsp/msg.jsp";
		}
		req.setAttribute("msg", "注册成功！");
		return "/jsp/msg.jsp";
	}

	/**
	 * ajax异步验证用户是否可用
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public String registerCheck(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.setCharacterEncoding("utf-8");
			PrintWriter out = res.getWriter();
			String username = req.getParameter("username");
			Userservice us = new UserserviceImpl();
			boolean msg = us.getUserByName(username);
			if (msg) {
				out.print("true");
			} else {
				out.println("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 前往修改用户密码
	 */
	public String updatePasswordUI(HttpServletRequest req, HttpServletResponse res) {
		return "/jsp/updatePassword.jsp";
	}

	/**
	 * 修改密码
	 * @param req
	 * @param res
	 * @return
	 */
	public String updatePassword(HttpServletRequest req,HttpServletResponse res) {
		res.setCharacterEncoding("gbk");
		try {
			//1.接收用户参数
			String uid = req.getParameter("userid");
			String oldPassword = req.getParameter("oldPassword");
			String newPassword = req.getParameter("newPassword");
			//2.调用service方法
			Userservice us = new UserserviceImpl();
			boolean flag = us.updatePassword(oldPassword,newPassword,uid);
			if(!flag) {
				req.setAttribute("msg", "用户密码修改失败!");
				return "/jsp/msg.jsp";
			}
			// 3.请求转发
			req.setAttribute("msg", "用户密码修改成功,请重新登录");
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "用户密码修改失败!");
		}
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		if (session.getAttribute("cart") != null) {
			// 用户退出时把购物车数据写回去
			CartServlet cartServlet = new CartServlet();
			cartServlet.saveDB(req, res);
			session.removeAttribute("cart");
			session.removeAttribute("userid");
		}
		return "/jsp/msg.jsp";
	}
}
