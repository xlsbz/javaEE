package com.dhr.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhr.domain.Function;
import com.dhr.domain.Role;
import com.dhr.domain.User;
import com.dhr.service.PrivilegeService;
import com.dhr.service.impl.PrivilegeServiceImpl;

//过滤/manage/*
/**
 * 验证管理员的权限
 * 
 * @author Mr DU
 *
 */
public class PrivilegeFilter implements Filter {
	private PrivilegeService privilegeService = new PrivilegeServiceImpl();

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) resp;
		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}
		// 检查用户的登陆状态
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login/mlogin.jsp");
			return;
		}
		// 根据用户查询所有的角色，根据角色查询有哪些功能可以访问

		Set<Function> functions = new HashSet<Function>();// 当前登陆用户可以访问的功能

		// 查询用户的同时能够查询用户对应的所有角色
		List<Role> roles = privilegeService.findUserById(user.getId() + "").getRoles();
		for (Role r : roles) {
			List<Function> funs = privilegeService.findRoleById(r.getId() + "").getFunctions();// 角色对应的可访问的功能
			functions.addAll(funs);
		}
		// 获取当前用户访问的uri
		String uri = request.getRequestURI();// /OA/manage/PrivilegeServlet
		// 去除项目名
		uri = uri.replace(request.getContextPath(), "");// /manage/PrivilegeServlet
		// 获取请求?后面的参数
		String queryString = request.getQueryString();// op=grantUser&userId=1
		// "/manage/privilegesServlet?op=?&....
		if (queryString != null) {
			uri = uri + "?" + queryString;
		}

		// 与可以访问的功能的uri地址进行比对
		boolean hasPermission = false;// 是否有权限
		// 遍历该用户所属角色的所有功能
		for (Function f : functions) {
			if (uri.startsWith(f.getUri())) {// 分页时请注意
				hasPermission = true;
				break;
			}
		}
		// 不OK：提示没有权限
		if (!hasPermission) {
			response.getWriter().write("对不起，您没有权限");
			return;
		}
		// OK：放行
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
