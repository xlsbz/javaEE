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
 * �����������ڴ���ҳ�淢�������󣬴��ݸ�ģ�Ͳ�
 * @author Mr DU
 * ��������û�в���ע�ⷽʽ��������Ҫ����xml
 */
public class StudentS extends HttpServlet{
	String url = "";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//����������Ӧ�ַ�����
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");
		//��ȡ�����Ӧ��
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
	 * ע����֤������
	 * @param req
	 * @param res
	 * @throws IOException 
	 */
	public void registerAjax(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String sname = req.getParameter("sname");
		//AJAXע����֤
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
	 * ע�������
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
			req.setAttribute("register_success", sname+"ע��ɹ���");
			//�������ת����request����
			req.getRequestDispatcher("success.jsp").forward(req, res);
				//res.sendRedirect("login_student.jsp");
		}else {
			req.setAttribute("register_error", "ע��ʧ�ܿ������û����ظ���");
			//req.getRequestDispatcher("register_student.jsp").forward(req, res);
			req.getRequestDispatcher("register_student.jsp").forward(req, res);
		}
	}
	/**
	 * ��¼������
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
				session.setAttribute("error", "�û������������");
				res.sendRedirect("login_student.jsp");
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	/**
	 * ע��
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
	 * ͨ���޸ĸ�����Ϣ
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
	 * �޸ĸ�����Ϣ
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
			req.setAttribute("update_success", "�޸ĳɹ�������д��¼");
			session.removeAttribute("sname");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}else {
			req.setAttribute("update_error", "�޸�ʧ�ܣ�");
			req.getRequestDispatcher("update_student.jsp").forward(req, res);
		}
	}
	/**
	 * ��ѯ������Ϣ
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
