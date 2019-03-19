package cn.dhr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.User;

/**
 * 权限过滤器
 * @author Mr DU
 *
 */
public class PrivilegesFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.强制转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//2.获取session
		User user = (User) req.getSession().getAttribute("user");
		if(user==null) {
			req.setAttribute("msg","您还没有登陆，请先登录！");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
		}else {
			//登陆了就放行
			chain.doFilter(req, res);
		}
		
	}

}
