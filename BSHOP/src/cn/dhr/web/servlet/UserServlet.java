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
 * �û�ģ�������
 * @author Mr DU
 *
 */
@WebServlet("/user")
public class UserServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * ͨ���û���¼
	 * @param res
	 * @param res
	 */
	public String loginUserUI(HttpServletRequest req,HttpServletResponse res) {
		return "/jsp/login.jsp";
	}
	/**
	 * �û���¼
	 * @param req
	 * @param res
	 * @return
	 */
	public String loginUser(HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			//1.��ȡ����
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String code = req.getParameter("code");
			//�ж���֤���Ƿ���ȷ
			HttpSession session = req.getSession();
			String codeServer = (String)session.getAttribute("code");
			if(!code.equalsIgnoreCase(codeServer)) {
				req.setAttribute("msg", "��֤�����");
				return "/jsp/login.jsp";
			}
			User userBean = new User();
			userBean.setUsername(username);
			userBean.setPassword(password);
			UserService us = new UserServiceImpl();
			User user = us.getByName(userBean.getUsername());
			if(user==null) {
				req.setAttribute("msg", "���û������ڣ�");
				return "/jsp/login.jsp";
			}
			user = us.loginUser(userBean.getUsername(),userBean.getPassword());
			if(user!=null) {
				req.getSession().setAttribute("user", user);
				//��½�ɹ�������֤��
				session.removeAttribute(code);
			}else {
				req.setAttribute("msg", "�������");
				return "/jsp/login.jsp";
			}
			//�ж��Ƿ�ѡ�˼�ס�û���
			String savename = req.getParameter("savename");
			if("ok".equals(savename)) {
				Cookie cookie = new Cookie("savename",username);
				cookie.setPath(req.getContextPath()+"/");
				cookie.setMaxAge(Integer.MAX_VALUE);
				res.addCookie(cookie);
			}
			res.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			req.setAttribute("msg", "��½ʧ�ܣ�");
			e.printStackTrace();
			return "/jsp/login.jsp";
		}
		return null;
	}
	
	/**
	 * ע����¼
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
	 * ͨ��ע��
	 * @param req
	 * @param res
	 * @return
	 */
	public String registerUserUI(HttpServletRequest req,HttpServletResponse res) {
		return "/jsp/register.jsp";
	}
	
	/**
	 * ajax�첽��֤�û����Ƿ���ȷ
	 * @param req
	 * @param res
	 * @return
	 */
	public String registerCheck(HttpServletRequest req,HttpServletResponse res) {
		try {
			//������Ӧ����
			res.setCharacterEncoding("utf-8");
			PrintWriter out = res.getWriter();
			String username = req.getParameter("username");
			//1.���ò鿴�û���
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
	 * �û�ע��
	 * @param req
	 * @param res
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String registerUser(HttpServletRequest req,HttpServletResponse res){
		//�ж���֤��
		String code = req.getParameter("code");
		String codeServer = (String)req.getSession().getAttribute("code");
		if(!code.equalsIgnoreCase(codeServer)) {
			req.setAttribute("msg", "��֤�����");
			return "/jsp/register.jsp";
		}
		//1.��װ��ȡ����
		try {
			User user = CommonUtils.toBean(req.getParameterMap(), User.class);
			//�ֶ���װID
			user.setUid(UUIDUtils.getUUIDUtils());
			//2.����service
			UserService us = new UserServiceImpl();
			us.addUser(user);
			req.setAttribute("msg", "��ϲע��ɹ�,��ȥ��½��");
			//������֤��session
			req.getSession().removeAttribute("code");
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			req.setAttribute("msg", "ע��ʧ�ܣ�");
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
	}
}
