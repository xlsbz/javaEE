package com.dhr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤管理员
 * @author Mr DU
 *
 */
public class PrivilegesFilterAdmin implements Filter{

	@Override
	public  void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null) {
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}else {
			chain.doFilter(req, res);
		}
		
	}
	
}
