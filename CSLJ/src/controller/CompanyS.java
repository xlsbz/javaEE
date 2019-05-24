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
 * ����������˾��Ϣ
 * @author Mr DU
 * ������������ע�ⷽʽ��������������xml
 */
@WebServlet("/company/CompanyS")
public class CompanyS extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String option = req.getParameter("option");//��ȡ�û��ύ����Ϣ�жϲ���
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
	 * ����ע������
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
			req.setAttribute("register_success", "�û�ע��ɹ���");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}else {
			req.setAttribute("register_error", "�û�ע��ʧ�ܣ������Ǹ��û��Ѿ�ע��");
			req.getRequestDispatcher("register_company.jsp").forward(req, res);
			}
	}
	/*
	 * ��˾�û���¼
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
			req.setAttribute("login_success", "��ӭ��"+cname+"��½�ɹ���");
			req.getRequestDispatcher("success.jsp").forward(req, res);
			
		}else {
			req.setAttribute("login_error", "��������û������������Ƿ���ȷ");
			req.getRequestDispatcher("login_company.jsp").forward(req, res);
		}
	}
	/**
	 * ע��
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
	 * ͨ����˾��Ϣ�޸�
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
	 * ��˾��Ϣ�޸�
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
			req.setAttribute("update_success", cname+"��Ϣ���ĳɹ�");
			req.getRequestDispatcher("success.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("update_company.jsp").forward(req, res);
		}
	}
	/*
	 * ��˾��Ϣ��ѯ
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
