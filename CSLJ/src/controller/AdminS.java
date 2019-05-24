package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.AdminFy;
import daoFactory.CompanyJobFy;
import daoFactory.StudentJobFy;
import vo.CjobVo;
import vo.CompanyVo;
import vo.SjobVo;
import vo.StudentVo;

/**
 * AdminS 控制器
 * @author Mr DU
 * 采用配置web.xml解析
 */
public class AdminS extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		switch(option) {
		case "login":
			loginAdmin(req,res);
			break;
		case "logon":
			logonAdmin(req,res);
			break;
		case "findAll_Student":
			findAllStudent(req,res); 
			break;
		case "findAll_Company":
			findAllCompany(req,res);
			break;
		case "findAll_Cjob":
			findAllCjob(req,res);
			break;
		case "findAll_Sjob":
			findAllSjob(req,res);
			break;
		case "to_find_cxq":
			tofindCjob(req, res);
			break;
		case "to_find_sxq":
			tofindSjob(req, res);
			break;
		}
	}
	/*
	 * 登录
	 */
	public void loginAdmin(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean flag = false;
		try {
			flag = AdminFy.getAdminInstance().loginAdmin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag) {
			req.setAttribute("login_success", "登陆成功!");
			session.setAttribute("admin", username);
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}else {
			req.setAttribute("login_error", "登录失败，密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
		
	}
	/*
	 * 注销
	 */
	public void logonAdmin(HttpServletRequest req,HttpServletResponse res) 
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		if(session.getAttribute("admin")!=null) {
			session.removeAttribute("admin");
			req.setAttribute("logon_success", "注销成功");
			req.getRequestDispatcher("success.jsp").forward(req, res);;
		}
	}
	/*
	 * 查询所有学生信息
	 */
	public void findAllStudent(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		List<StudentVo> all = new ArrayList<>();
		try {
			all = AdminFy.getAdminInstance().findAllStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("all_student", all);
		req.getRequestDispatcher("findAll_Student.jsp").forward(req, res);
	}
	/*
	 * 查询公司信息
	 */
	public void findAllCompany(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		List<CompanyVo> all = new ArrayList<>();
		try {
			all = AdminFy.getAdminInstance().findAllCompany();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("all_company", all);
		req.getRequestDispatcher("findAll_Company.jsp").forward(req, res);
	}
	/*
	 * 查看所有求职信
	 */
	public void findAllSjob(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		List<SjobVo> all = new ArrayList<>();
		try {
			all = AdminFy.getAdminInstance().findAllSjob();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("allsjob", all);
		req.getRequestDispatcher("findAll_Sjob.jsp").forward(req, res);
	}
	/*
	 * 查询所有招聘信
	 */
	public void findAllCjob(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<CjobVo> all = new ArrayList<>();
		try {
			all = AdminFy.getAdminInstance().findAllCjob();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("allcjob", all);
		req.getRequestDispatcher("findAll_Cjob.jsp").forward(req, res);
	}
	/**
	 * 通往查看招聘详情
	 */
	public void tofindCjob(HttpServletRequest req, HttpServletResponse res) {
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		CjobVo cjobVo = null;
		try {
			cjobVo = CompanyJobFy.getCompanyJobFy().findJobId(jobid);
			req.setAttribute("find_cjob", cjobVo);
			req.getRequestDispatcher("cjob.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通往查看求职详情
	 */
	public void tofindSjob(HttpServletRequest req, HttpServletResponse res) {
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		SjobVo sjobVo = null;
		try {
			sjobVo =StudentJobFy.getStudentJob().findJobId(jobid);
			req.setAttribute("find_sjob", sjobVo);
			req.getRequestDispatcher("sjob.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 服务器启动加载数据
	 */
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
