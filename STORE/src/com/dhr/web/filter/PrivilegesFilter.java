package com.dhr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.web.domain.User;

/**
 * 访问权限过滤器
 * @author Mr DU
 *
 */
public class PrivilegesFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//1.强制类型转换为httpservletRequest
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//2.获取session
		User user = (User)request.getSession().getAttribute("user");
		//3.放行
		if(user!=null) {
			chain.doFilter(req, res);
		}else {
			req.setAttribute("msg", "您还没有登录!");
			req.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
	}

}
