package cn.dhr.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.Admin;
import cn.dhr.service.AdminService;
import cn.dhr.service.impl.AdminServiceImpl;
import cn.dhr.web.baseservlet.BaseSerlvet;
/**
 * 管理员---登录
 * @author Mr DU
 *
 */
@WebServlet("/admin")
public class AdminServlet extends BaseSerlvet {
	private static final long serialVersionUID = 1L;
    
	public String loginAdmin(HttpServletRequest req,HttpServletResponse res) {
		//获取用户名称密码
		String user = req.getParameter("adminName");
		String password = req.getParameter("password");
		//调用service
		AdminService as = new AdminServiceImpl();
		Admin admin = as.loginAdmin(user);
		if(admin==null) {
			req.setAttribute("msg", "用户不存在！");
		}else {
			if(password.equals(admin.getPassword())) {
				//登陆成功
				req.getSession().setAttribute("admin", admin);
				return "/admin/home.jsp";
			}else {
				req.setAttribute("msg", "用户密码错误！");
				return "/admin/index.jsp";
			}
		}
		return "/admin/index.jsp";
	}
   
}
