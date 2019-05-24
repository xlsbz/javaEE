package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.CompanyFy;
import vo.CompanyVo;

/**
 * 控制器，公司信息
 * @author Mr DU
 * 本控制器采用注解方式，所以无需配置xml
 */
@WebServlet("/company/CompanyS")
public class CompanyS extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");//获取用户提交的信息判断操作
		switch(option) {
		case "register_company":
			registerCompany(req, res);
			break;
		case "login_company":
			loginCompany(req, res);
			break;
		case "logon":
			logonCompany(req,res);
			break;
		case "to_update":
			toupdate(req,res);
			break;
		case "update_company":
			updateCompany(req, res);
			break;
		case "query_company":
			queryCompany(req, res);
		}
	}
	/*
	 * 处理注册请求
	 */
	public void registerCompany(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		String cname = req.getParameter("cname");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String manage = req.getParameter("manage");
		String address = req.getParameter("address");
		String resume = req.getParameter("resume");
		CompanyVo vo = new CompanyVo(cname, password, name, email, tel, manage, address, resume);
		boolean flag = false;
		try {
			flag = CompanyFy.getFactoryCompany().insertCompany(vo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(flag) {
			req.setAttribute("register_success", "用户注册成功！");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}else {
			req.setAttribute("register_error", "用户注册失败！可能是该用户已经注册");
			req.getRequestDispatcher("register_company.jsp").forward(req, res);
			}
	}
	/*
	 * 公司用户登录
	 */
	public void loginCompany(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String cname = req.getParameter("name");
		String password = req.getParameter("password");
		boolean flag = false;
		try {
			flag = CompanyFy.getFactoryCompany().loginCompany(cname, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			session.setAttribute("cname", cname);
			req.setAttribute("login_success", "欢迎您"+cname+"登陆成功！");
			req.getRequestDispatcher("success.jsp").forward(req, res);
			
		}else {
			req.setAttribute("login_error", "检查您的用户名或者密码是否正确");
			req.getRequestDispatcher("login_company.jsp").forward(req, res);
		}
	}
	/**
	 * 注销
	 * @param req
	 * @param res
	 * @throws Exception 
	 */
	public void logonCompany(HttpServletRequest req,HttpServletResponse res) 
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		if(session.getAttribute("cname")!=null) {
			session.removeAttribute("cname");
			res.sendRedirect("login_company.jsp");
		}
	}
	/**
	 * 通往公司信息修改
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toupdate(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String cname = (String)session.getAttribute("cname");
		CompanyVo vo = null;
		try {
			vo = CompanyFy.getFactoryCompany().queryCompany(cname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("update_cjob", vo);
		req.getRequestDispatcher("update_company.jsp").forward(req, res);
	}
	/*
	 * 公司信息修改
	 */
	public void updateCompany(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		CompanyVo vo = null;
		String cname = req.getParameter("cname");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String manage = req.getParameter("manage");
		String address = req.getParameter("address");
		String resume = req.getParameter("resume");
		vo = new CompanyVo(cname, password, name, email, tel, manage, address, resume);
		boolean flag = false;
		try {
			flag = CompanyFy.getFactoryCompany().updateCompany(vo, cname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			req.setAttribute("update_success", cname+"信息更改成功");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("update_company.jsp").forward(req, res);
		}
	}
	/*
	 * 公司信息查询
	 */
	public void queryCompany(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session  =req.getSession();
		String name = (String)session.getAttribute("cname");
		CompanyVo vo = null;
		try {
			vo = CompanyFy.getFactoryCompany().queryCompany(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(vo!=null) {
			req.setAttribute("query_success",vo);
			req.getRequestDispatcher("query_company.jsp").forward(req, res);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
