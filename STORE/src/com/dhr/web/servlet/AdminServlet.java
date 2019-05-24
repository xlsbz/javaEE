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
 * ����Ա����
 * @author Mr DU
 *
 */
@WebServlet("/admin")
public class AdminServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * ����Ա��¼
	 * @param req
	 * @param res
	 * @return
	 * ����xmlС�����ݿ��Ź���Ա��Ϣ
	 */
	public String loginAdmin(HttpServletRequest req,HttpServletResponse res) {
		//1.��ȡҳ�洫���Ĳ���
		try {
			String adminName = req.getParameter("adminName");
			String password = req.getParameter("password");
			//2.�Ѳ�����xml��Ϣ�Ա�
			boolean flag = XMLUtils.loginAdmin(adminName, password);
			//3.ת��
			if(flag) {
				req.getSession().setAttribute("admin", adminName);
				res.sendRedirect(req.getContextPath()+"/admin/home.jsp");
			}else {
				req.setAttribute("msg", "�û����������!");
				return "/admin/index.jsp";
			}
		} catch (IOException e) {
			req.setAttribute("msg", "�û����������!");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �˳�
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
	 * ��ѯ�����û�
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
				req.setAttribute("msg", "û�в�ѯ���û�!");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "�û���ѯʧ��");
			e.printStackTrace();
		}
		return "/admin/user/list.jsp";
	}
}
