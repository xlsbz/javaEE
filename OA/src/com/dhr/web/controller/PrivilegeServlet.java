package com.dhr.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.domain.Function;
import com.dhr.domain.Role;
import com.dhr.domain.User;
import com.dhr.service.PrivilegeService;
import com.dhr.service.impl.PrivilegeServiceImpl;
import com.dhr.util.WebUtil;

/**
 * 权限管理处理
 * 
 * @author Mr DU
 *
 */
public class PrivilegeServlet extends HttpServlet {
	private PrivilegeService privilegeService = new PrivilegeServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("listFunctions".equals(op)) {
			listFunctions(request, response);
		} else if ("addFunction".equals(op)) {
			addFunction(request, response);
		} else if ("listRoles".equals(op)) {
			listRoles(request, response);
		} else if ("addRole".equals(op)) {
			addRole(request, response);
		} else if ("grantRole".equals(op)) {
			grantRole(request, response);
		} else if ("saveGrantRole".equals(op)) {
			saveGrantRole(request, response);
		} else if ("listUsers".equals(op)) {
			listUsers(request, response);
		} else if ("addUser".equals(op)) {
			addUser(request, response);
		} else if ("grantUser".equals(op)) {
			grantUser(request, response);
		} else if ("saveGrantUser".equals(op)) {
			saveGrantUser(request, response);
		}
	}

	/**
	 * 保存管理员权限
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saveGrantUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String[] roleIds = request.getParameterValues("roleId");
		if (roleIds != null && roleIds.length > 0) {
			privilegeService.grantRole2User(userId, roleIds);
		}
		request.setAttribute("message", "处理成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 查询单个管理员
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void grantUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据id查询用户：查询用户同时把已经分配的角色查询出来
		String userId = request.getParameter("userId");
		// 得到用户
		User user = privilegeService.findUserById(userId);
		// 查询所有的角色列表
		List<Role> roles = privilegeService.findAllRoles();
		// 转向页面去显示
		request.setAttribute("user", user);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manage/grantUser.jsp").forward(request, response);
	}

	/**
	 * 新增管理员
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 封装数据
		User user = WebUtil.fillBean(request, User.class);
		privilegeService.addUser(user);
		request.setAttribute("message", "添加成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 查询所有管理员列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询所有用户设置到域
		List<User> users = privilegeService.findAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/manage/listUsers.jsp").forward(request, response);
	}

	/**
	 * 给角色分配功能
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saveGrantRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取权限ID和要添加的功能
		String roleId = request.getParameter("roleId");
		String[] functionIds = request.getParameterValues("functionId");
		if (functionIds != null && functionIds.length > 0) {
			privilegeService.grantFunction2Role(roleId, functionIds);
		}
		request.setAttribute("message", "处理成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 给角色分配功能 页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void grantRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据id查询角色：查询角色同时把已经分配的功能查询出来
		String roleId = request.getParameter("roleId");
		Role role = privilegeService.findRoleById(roleId);
		// 查询所有的功能列表
		List<Function> functions = privilegeService.findAllFunctions();
		// 转向页面去显示
		request.setAttribute("role", role);
		request.setAttribute("functions", functions);
		request.getRequestDispatcher("/manage/grantRole.jsp").forward(request, response);
	}

	/**
	 * 新增角色
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Role role = WebUtil.fillBean(request, Role.class);
		privilegeService.addRole(role);
		request.setAttribute("message", "添加成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 查询所有角色
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listRoles(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role> roles = privilegeService.findAllRoles();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manage/listRoles.jsp").forward(request, response);
	}

	/**
	 * 新增功能
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addFunction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Function function = WebUtil.fillBean(request, Function.class);
		privilegeService.addFunction(function);
		request.setAttribute("message", "添加成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 查询所有功能
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listFunctions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Function> functions = privilegeService.findAllFunctions();
		request.setAttribute("functions", functions);
		request.getRequestDispatcher("/manage/listFunctions.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
