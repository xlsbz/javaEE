package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.StudentFy;
import vo.StudentVo;


/**
 * 控制器，用于处理页面发出的请求，传递给模型层
 * @author Mr DU
 * 本控制器没有采用注解方式，所以需要配置xml
 */
public class StudentS extends HttpServlet{
	String url = "";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//设置请求响应字符编码
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		//获取输出响应流
		PrintWriter out = res.getWriter();
		switch(option) {
			case "login_student":
				loginStudent(req, res);
				break;
			case "register_student":
				try {
				registerStudent(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}break;
			case "to_update":
				toUpdate(req,res);
				break;
			case "update_student":
				try {
					updateStudent(req,res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "query_student":
				try {
					queryStudent(req,res);
				} catch (Exception e) {
				e.printStackTrace();
				}
				break;
			case "registerAjax":
				registerAjax(req, res);
				break;
			case "logon":
				logonStudent(req, res);
				break;
		}
	}
	/**
	 * 注册验证控制器
	 * @param req
	 * @param res
	 * @throws IOException 
	 */
	public void registerAjax(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String sname = req.getParameter("sname");
		//AJAX注册验证
		PrintWriter out = res.getWriter();
		StudentVo vo = null;
		try {

			vo = StudentFy.getFactoryStudent().queryStudent(sname);
			if(vo!=null) {
				System.out.println(vo.getSname());
				out.print("false");
			}else {
				out.print("true");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 注册控制器
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws ParseException 
	 * @throws Exception 
	 */
	public void registerStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String sname = req.getParameter("sname");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String sex = req.getParameter("sex");
		Date birthday = dateFormat.parse(req.getParameter("birthday"));
		String school = req.getParameter("school");
		String specialty = req.getParameter("specialty");
		String knowledge = req.getParameter("knowledge");
		String email = req.getParameter("email");
		String resume = req.getParameter("resume");
		StudentVo studentVo = new StudentVo(sname, password, name, age, sex, birthday, school, specialty, knowledge, email, resume);
		boolean result = false;
		try {
			result = StudentFy.getFactoryStudent().insertStudent(studentVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result) {
			req.setAttribute("register_success", sname+"注册成功！");
			//服务端跳转，用request即可
			req.getRequestDispatcher("success.jsp").forward(req, res);
				//res.sendRedirect("login_student.jsp");
		}else {
			req.setAttribute("register_error", "注册失败可能是用户名重复！");
			//req.getRequestDispatcher("register_student.jsp").forward(req, res);
			req.getRequestDispatcher("register_student.jsp").forward(req, res);
		}
	}
	/**
	 * 登录控制器
	 * @param req
	 * @param res
	 */
	public void loginStudent(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		try {
			if(StudentFy.getFactoryStudent().loginStudent(name, password)) {
				session.setAttribute("sname", name);
				res.sendRedirect("index.jsp");		
			}else {
				session.setAttribute("error", "用户名或密码错误");
				res.sendRedirect("login_student.jsp");
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	/**
	 * 注销
	 * @param req
	 * @param res
	 * @throws Exception 
	 */
	public void logonStudent(HttpServletRequest req,HttpServletResponse res) 
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		if(session.getAttribute("sname")!=null) {
			session.removeAttribute("sname");
			res.sendRedirect("login_student.jsp");
		}
	}
	/**
	 * 通往修改个人信息
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws Exception 
	 */
	public void toUpdate(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException {
		StudentVo vo = null;
		HttpSession session = req.getSession();
		String sname = (String)session.getAttribute("sname");
		try {
			vo = StudentFy.getFactoryStudent().queryStudent(sname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("update", vo);
		req.getRequestDispatcher("update_student.jsp").forward(req, res);
	}
	/**
	 * 修改个人信息
	 * @param req
	 * @param res
	 * @throws Exception 
	 */
	public void updateStudent(HttpServletRequest req,HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String sname = req.getParameter("sname");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String sex = req.getParameter("sex");
		Date birthday = dateFormat.parse(req.getParameter("birthday"));
		String school = req.getParameter("school");
		String specialty = req.getParameter("specialty");
		String knowledge = req.getParameter("knowledge");
		String email = req.getParameter("email");
		String resume = req.getParameter("resume");
		StudentVo studentVo = new StudentVo(sname, password, name, age, sex, birthday, school, specialty, knowledge, email, resume);
		boolean result = false;
		result = StudentFy.getFactoryStudent().updateStudent(studentVo, sname);
		if(result) {
			req.setAttribute("update_success", "修改成功！请重写登录");
			session.removeAttribute("sname");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}else {
			req.setAttribute("update_error", "修改失败！");
			req.getRequestDispatcher("update_student.jsp").forward(req, res);
		}
	}
	/**
	 * 查询个人信息
	 * @param req
	 * @param res
	 * @throws Exception 
	 */
	public void queryStudent(HttpServletRequest req,HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Object sessionname = session.getAttribute("sname");
		StudentVo vo = StudentFy.getFactoryStudent().queryStudent(sessionname.toString());
		if(vo!=null) {
			req.setAttribute("query_success", vo);
			req.getRequestDispatcher("query_student.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
	}
	/**
	 * doget
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
