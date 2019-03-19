package cn.dhr.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dhr.domain.User;
import cn.dhr.service.UserService;
import cn.dhr.service.impl.UserServiceImpl;
import cn.dhr.utils.UUIDUtils;
import cn.dhr.web.baseservlet.BaseSerlvet;
import cn.itcast.commons.CommonUtils;
/**
 * 用户模块控制器
 * @author Mr DU
 *
 */
@WebServlet("/user")
public class UserServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 通往用户登录
	 * @param res
	 * @param res
	 */
	public String loginUserUI(HttpServletRequest req,HttpServletResponse res) {
		return "/jsp/login.jsp";
	}
	/**
	 * 用户登录
	 * @param req
	 * @param res
	 * @return
	 */
	public String loginUser(HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			//1.获取参数
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String code = req.getParameter("code");
			//判断验证码是否正确
			HttpSession session = req.getSession();
			String codeServer = (String)session.getAttribute("code");
			if(!code.equalsIgnoreCase(codeServer)) {
				req.setAttribute("msg", "验证码错误");
				return "/jsp/login.jsp";
			}
			User userBean = new User();
			userBean.setUsername(username);
			userBean.setPassword(password);
			UserService us = new UserServiceImpl();
			User user = us.getByName(userBean.getUsername());
			if(user==null) {
				req.setAttribute("msg", "该用户不存在！");
				return "/jsp/login.jsp";
			}
			user = us.loginUser(userBean.getUsername(),userBean.getPassword());
			if(user!=null) {
				req.getSession().setAttribute("user", user);
				//登陆成功销毁验证码
				session.removeAttribute(code);
			}else {
				req.setAttribute("msg", "密码错误");
				return "/jsp/login.jsp";
			}
			//判断是否勾选了记住用户名
			String savename = req.getParameter("savename");
			if("ok".equals(savename)) {
				Cookie cookie = new Cookie("savename",username);
				cookie.setPath(req.getContextPath()+"/");
				cookie.setMaxAge(Integer.MAX_VALUE);
				res.addCookie(cookie);
			}
			res.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			req.setAttribute("msg", "登陆失败！");
			e.printStackTrace();
			return "/jsp/login.jsp";
		}
		return null;
	}
	
	/**
	 * 注销登录
	 * @param req
	 * @param res
	 * @return
	 */
	public String logonUser(HttpServletRequest req,HttpServletResponse res) {
		try {
			HttpSession session = req.getSession();
			session.invalidate();
			res.sendRedirect(req.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通往注册
	 * @param req
	 * @param res
	 * @return
	 */
	public String registerUserUI(HttpServletRequest req,HttpServletResponse res) {
		return "/jsp/register.jsp";
	}
	
	/**
	 * ajax异步验证用户名是否正确
	 * @param req
	 * @param res
	 * @return
	 */
	public String registerCheck(HttpServletRequest req,HttpServletResponse res) {
		try {
			//设置响应编码
			res.setCharacterEncoding("utf-8");
			PrintWriter out = res.getWriter();
			String username = req.getParameter("username");
			//1.调用查看用户名
			UserService us = new UserServiceImpl();
			User user = us.getByName(username);
			if(user!=null) {
				out.print("false");
			}else {
				out.print("true");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用户注册
	 * @param req
	 * @param res
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String registerUser(HttpServletRequest req,HttpServletResponse res){
		//判断验证码
		String code = req.getParameter("code");
		String codeServer = (String)req.getSession().getAttribute("code");
		if(!code.equalsIgnoreCase(codeServer)) {
			req.setAttribute("msg", "验证码错误！");
			return "/jsp/register.jsp";
		}
		//1.封装获取参数
		try {
			User user = CommonUtils.toBean(req.getParameterMap(), User.class);
			//手动封装ID
			user.setUid(UUIDUtils.getUUIDUtils());
			//2.调用service
			UserService us = new UserServiceImpl();
			us.addUser(user);
			req.setAttribute("msg", "恭喜注册成功,快去登陆吧");
			//销毁验证码session
			req.getSession().removeAttribute("code");
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			req.setAttribute("msg", "注册失败！");
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
	}
}
