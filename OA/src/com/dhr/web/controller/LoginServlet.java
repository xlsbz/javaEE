package com.dhr.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.StaticStatus;
import com.dhr.domain.ClassType;
import com.dhr.domain.Customer;
import com.dhr.domain.CustomerStatus;
import com.dhr.domain.InfoSource;
import com.dhr.domain.User;
import com.dhr.service.ConfigService;
import com.dhr.service.CustomerService;
import com.dhr.service.PrivilegeService;
import com.dhr.service.impl.ConfigServiceImpl;
import com.dhr.service.impl.CustomerServiceImpl;
import com.dhr.service.impl.PrivilegeServiceImpl;
import com.dhr.util.SendMail;
import com.dhr.util.WebUtil;

import cn.dsna.util.images.ValidateCode;

/**
 * 管理员操作
 * 
 * @author Mr DU
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigService configService = new ConfigServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	private PrivilegeService privilegeService = new PrivilegeServiceImpl();

	/**
	 * 处理所有请求
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("captcha".equals(op)) {
			captcha(request, response);
		} else if ("registUI".equals(op)) {
			registUI(request, response);
		} else if ("regist".equals(op)) {
			regist(request, response);
		} else if ("login".equals(op)) {
			login(request, response);
		} else if ("validateEmail".equals(op)) {
			validateEmail(request, response);
		} else if ("active".equals(op)) {
			active(request, response);
		} else if ("logout".equals(op)) {
			logout(request, response);
		} else if ("mlogin".equals(op)) {
			mlogin(request, response);
		}
	}

	/**
	 * 后台管理员登陆
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void mlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = privilegeService.login(username, password);
		if (user == null) {
			response.getWriter().write("错误的用户名或密码！1秒后转向登陆页面");
			response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/login/mlogin.jsp");
			return;
		}
		// xierusession
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + "/manage/index.jsp");// 重定向到后台管理的主页
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG);
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * 激活账户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取激活码
		String activeCode = request.getParameter("activeCode");
		// 根据激活码查询客户
		Customer customer = customerService.findCustomerByActiveCode(activeCode);
		if (customer == null) {
			response.getWriter().write("您的激活码无效！1秒后转向主页");
			response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/index.jsp");
			return;
		}
		// 激活账户---修改用户状态
		customer.setActived(true);
		customer.setActiveDate(new Date());
		customerService.updateCustomer(customer);

		// 更新HttpSession中的登陆标记
		request.getSession().setAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG, customer);

		response.getWriter().write("您的账户激活成功！1秒后转向主页");
		response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/index.jsp");

	}

	/**
	 * 发送验证邮件
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void validateEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证用户是否登陆
		Customer customer = (Customer) request.getSession().getAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG);
		if (customer == null) {
			response.getWriter().write("登陆超时！1秒后转向登陆页面");
			response.setHeader("Refresh", "1;URL=" + request.getContextPath());
			return;
		}
		// 生成一个验证码：唯一性
		customer.setActiveCode(UUID.randomUUID().toString());
		// 发送激活邮件：单独启动一个线程
		SendMail sm = new SendMail(customer);
		sm.start();
		// 更新数据库
		customerService.updateCustomer(customer);
		response.getWriter().write("我们已经发送了一封激活邮件到您的" + customer.getEmail() + "中，请及时激活您的账户。不激活将无法进行报名的申请。");
	}

	/**
	 * 客户登陆
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取登陆信息
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		// 获取验证码
		String captcha = request.getParameter("captcha");
		// 判断验证码不正确
		String sCaptcha = (String) request.getSession().getAttribute("code");
		if (!captcha.equalsIgnoreCase(sCaptcha)) {
			response.getWriter().write("验证码有误！1秒后转向登陆页面");
			// 重定向
			response.setHeader("Refresh", "1;URL=" + request.getContextPath());
			return;
		}
		// 验证用户名和密码
		Customer customer = customerService.login(email, phoneNumber);
		if (customer == null) {
			response.getWriter().write("错误的用户名或密码！1秒后转向登陆页面");
			response.setHeader("Refresh", "1;URL=" + request.getContextPath());
			return;
		}
		// 登陆成功,写入session
		request.getSession().setAttribute(StaticStatus.CUSTOMER_LOGIN_FLAG, customer);
		// 提示
		response.getWriter().write("登陆成功！1秒后转向主页");
		response.setHeader("Refresh", "1;URL=" + request.getContextPath() + "/index.jsp");
	}

	/**
	 * 保存用户的注册信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = WebUtil.fillBean(request, Customer.class);
		customerService.regist(customer);
		// 给出提示
		response.getWriter().write("注册成功！1秒后转向登陆页面");
		response.setHeader("Refresh", "1;URL=" + request.getContextPath());
	}

	/**
	 * 显示注册页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void registUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 同步查出信息来源、课程类型、客户状态
		List<ClassType> classTypes = configService.findAllClassTypes();
		List<CustomerStatus> customerStatus = configService.findAllCustomerStatus();
		List<InfoSource> infoSources = configService.findAllInfoSources();
		request.setAttribute("classTypes", classTypes);
		request.setAttribute("customerStatus", customerStatus);
		request.setAttribute("infoSources", infoSources);

		request.getRequestDispatcher("/login/regist.jsp").forward(request, response);
	}

	/**
	 * 生成随机验证码图片；把验证码存放到HttpSession中
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void captcha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 控制不要缓存
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		ValidateCode vc = new ValidateCode(120, 20, 4, 9);
		String code = vc.getCode();
		System.out.println(code);
		// 把验证码存放到HttpSession中
		request.getSession().setAttribute("code", code);
		// 用字节流输出对应的图片
		ImageIO.write(vc.getBuffImg(), "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
