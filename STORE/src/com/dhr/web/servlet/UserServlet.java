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
 * �û�ģ��servlet
 * 
 * @author Mr DU��
 *
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * ��ת�û���¼ҳ��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loginUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//ͬ������'Ϊ����ѡ'��Ʒģ��
			ProductService ps = new ProductServiceImpl();
			List<Product> chooseList = ps.findChoose();
			request.setAttribute("cList", chooseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/login.jsp";
	}
	
	/**
	 * ʵ���û���¼
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡsession����
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//��֤�����
		String codevalue = request.getParameter("code");
		String code = (String) session.getAttribute("code");
		if(!codevalue.equalsIgnoreCase(code)) {
			request.setAttribute("msg", "��֤�벻��ȷ!");
			return "/jsp/login.jsp";
		}
		// ����service
		Userservice us = new UserserviceImpl();
		User user = null;
		try {
			user = us.loginUser(username, password);
		} catch (Exception e) {
			request.setAttribute("msg", "�û������������");
			return "/jsp/login.jsp";
		}
		if (user == null) {
			request.setAttribute("msg", "�û������������");
			return "/jsp/login.jsp";
		} else {
			session.setAttribute("userid", user.getUid());
			// ����user
			session.setAttribute("user", user);
			//��¼�ɹ����ͷ���֤�뱣�������
			session.removeAttribute("code");
		}
		// �ж��û��Ƿ�ѡ�˼�ס�û���,�������������,��һ��ȥֱ�ӻ�ȡ
		if (Constant.SAVE_NAME.equals(request.getParameter("savename"))) {
			Cookie cookie = new Cookie("saveName", URLEncoder.encode(username, "utf-8"));
			//����cookie�ı���ʱ���·��
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setPath(request.getContextPath() + "/");
			response.addCookie(cookie);
		}
		response.sendRedirect("index.jsp");
		return null;
	}

	/**
	 * �û��˳�
	 * 
	 * @throws IOException
	 */
	public String logonUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		if (session.getAttribute("cart") != null) {
			// �û��˳�ʱ�ѹ��ﳵ����д��ȥ
			CartServlet cartServlet = new CartServlet();
			cartServlet.saveDB(req, res);
			session.removeAttribute("cart");
			session.removeAttribute("userid");
		}
		res.sendRedirect(req.getContextPath());
		return null;
	}

	/**
	 * ��ת���û�ע��
	 */
	public String registerUI(HttpServletRequest req, HttpServletResponse res) {
		return "jsp/register.jsp";
	}

	/**
	 * �û���¼
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
		// ����service
		Userservice us = new UserserviceImpl();
		boolean flag = false;
		try {
			flag = us.registerUser(user);
		} catch (Exception e) {
			req.setAttribute("msg", "ע��ʧ�ܣ�");
			e.printStackTrace();
		}
		if (!flag) {
			req.setAttribute("msg", "ע��ʧ�ܣ�");
			return "/jsp/msg.jsp";
		}
		req.setAttribute("msg", "ע��ɹ���");
		return "/jsp/msg.jsp";
	}

	/**
	 * ajax�첽��֤�û��Ƿ����
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
	 * ǰ���޸��û�����
	 */
	public String updatePasswordUI(HttpServletRequest req, HttpServletResponse res) {
		return "/jsp/updatePassword.jsp";
	}

	/**
	 * �޸�����
	 * @param req
	 * @param res
	 * @return
	 */
	public String updatePassword(HttpServletRequest req,HttpServletResponse res) {
		res.setCharacterEncoding("gbk");
		try {
			//1.�����û�����
			String uid = req.getParameter("userid");
			String oldPassword = req.getParameter("oldPassword");
			String newPassword = req.getParameter("newPassword");
			//2.����service����
			Userservice us = new UserserviceImpl();
			boolean flag = us.updatePassword(oldPassword,newPassword,uid);
			if(!flag) {
				req.setAttribute("msg", "�û������޸�ʧ��!");
				return "/jsp/msg.jsp";
			}
			// 3.����ת��
			req.setAttribute("msg", "�û������޸ĳɹ�,�����µ�¼");
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "�û������޸�ʧ��!");
		}
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		if (session.getAttribute("cart") != null) {
			// �û��˳�ʱ�ѹ��ﳵ����д��ȥ
			CartServlet cartServlet = new CartServlet();
			cartServlet.saveDB(req, res);
			session.removeAttribute("cart");
			session.removeAttribute("userid");
		}
		return "/jsp/msg.jsp";
	}
}
