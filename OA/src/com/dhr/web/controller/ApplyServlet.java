package com.dhr.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.StaticStatus;
import com.dhr.domain.Apply;
import com.dhr.domain.ClassType;
import com.dhr.domain.Classes;
import com.dhr.domain.Customer;
import com.dhr.domain.CustomerStatus;
import com.dhr.service.ApplyService;
import com.dhr.service.ConfigService;
import com.dhr.service.CustomerService;
import com.dhr.service.impl.ApplyServiceImpl;
import com.dhr.service.impl.ConfigServiceImpl;
import com.dhr.service.impl.CustomerServiceImpl;
import com.dhr.util.WebUtil;

/**
 * 入学申请处理
 * 
 * @author Mr DU
 *
 */
public class ApplyServlet extends HttpServlet {
	private ConfigService configService = new ConfigServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	private ApplyService applyService = new ApplyServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("showApplyUI".equals(op)) {
			showApplyUI(request, response);
		} else if ("editCustomerUI".equals(op)) {
			editCustomerUI(request, response);
		} else if ("editCustomer".equals(op)) {
			editCustomer(request, response);
		} else if ("genApply".equals(op)) {
			genApply(request, response);
		} else if ("processApplyUI".equals(op)) {
			processApplyUI(request, response);
		}
	}

	/**
	 * 显示当前未关闭的申请。显示自荐信和入学测试的申请和审批信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processApplyUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 生成申请
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void genApply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到当前的登陆用户
		Customer customer = (Customer) request.getSession().getAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG);
		// 检查申请次数是否超过了3次
		int applyCount = applyService.checkApplyCount(customer);
		if (applyCount >= 3) {
			request.setAttribute("message", "您的申请已查过3次，将不能发出申请。请联系：010-110");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// 检查是否存在未关闭的申请
		boolean hasNotClosedApply = applyService.checkIsClosed(customer);
		if (hasNotClosedApply) {
			request.setAttribute("message", "您有未结束的申请，不能重复申请");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		Apply apply = new Apply();
		// 生成一个唯一的编号:yyyyMMdd00000001 20150210 00000001
		apply.setNumber(WebUtil.genApplyNumber());

		apply.setTitle(customer.getName() + "_入学申请");
		apply.setStartDate(new Date());
		apply.setStatus("申请审批中");
		// 设置班级
		String classesId = request.getParameter("classesId");
		Classes classes = configService.findClassesById(classesId);
		// 建立申请和班级、客户的关联关系
		apply.setCustomer(customer);
		apply.setClasses(classes);
		applyService.genApply(apply);
		request.setAttribute("message", "申请成功！接下来请按照提示完成流程");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * 保存修改的信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到当前的登陆用户
		Customer customer = (Customer) request.getSession().getAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG);
		customer.setQq(request.getParameter("qq"));
		// 单独判断邮箱有没有改变，如果发生了改变，激活状态也要改变，需要重新激活
		String email = request.getParameter("email");
		if (!email.equals(customer.getEmail())) {
			// 修改了邮箱
			customer.setEmail(email);
			customer.setActived(false);
		}
		customer.setGender(request.getParameter("gender"));
		customer.setStatus(request.getParameter("status"));
		customer.setClassType(request.getParameter("classType"));
		customer.setAddress(request.getParameter("address"));
		customerService.updateCustomer(customer);
		request.setAttribute("message", "修改资料成功");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * 修改个人信息页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editCustomerUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询所有的课程类型
		List<ClassType> classTypes = configService.findAllClassTypes();
		// 查询所有的客户状态
		List<CustomerStatus> customerStatus = configService.findAllCustomerStatus();
		// 设置到域回显数据
		request.setAttribute("classTypes", classTypes);
		request.setAttribute("customerStatus", customerStatus);
		request.getRequestDispatcher("/apply/editCustomer.jsp").forward(request, response);

	}

	/**
	 * 显示申请页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showApplyUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询当前登陆客户注册时意向课程类型下的班级
		// 获得当前用户session
		Customer customer = (Customer) request.getSession().getAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG);
		// 根据课程类型名称查询这个课程所有的开班信息
		List<Classes> classes = configService.findClassesByClassTypeName(customer.getClassType());
		// 设置回显到域对象
		request.setAttribute("classes", classes);
		request.getRequestDispatcher("/apply/apply.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
