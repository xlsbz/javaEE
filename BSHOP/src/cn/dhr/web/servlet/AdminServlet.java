package cn.dhr.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.Admin;
import cn.dhr.service.AdminService;
import cn.dhr.service.impl.AdminServiceImpl;
import cn.dhr.web.baseservlet.BaseSerlvet;
/**
 * ����Ա---��¼
 * @author Mr DU
 *
 */
@WebServlet("/admin")
public class AdminServlet extends BaseSerlvet {
	private static final long serialVersionUID = 1L;
    
	public String loginAdmin(HttpServletRequest req,HttpServletResponse res) {
		//��ȡ�û���������
		String user = req.getParameter("adminName");
		String password = req.getParameter("password");
		//����service
		AdminService as = new AdminServiceImpl();
		Admin admin = as.loginAdmin(user);
		if(admin==null) {
			req.setAttribute("msg", "�û������ڣ�");
		}else {
			if(password.equals(admin.getPassword())) {
				//��½�ɹ�
				req.getSession().setAttribute("admin", admin);
				return "/admin/home.jsp";
			}else {
				req.setAttribute("msg", "�û��������");
				return "/admin/index.jsp";
			}
		}
		return "/admin/index.jsp";
	}
   
}
