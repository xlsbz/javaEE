package com.dhr.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.commons.Page;
import com.dhr.domain.Apply;
import com.dhr.service.ApplyService;
import com.dhr.service.impl.ApplyServiceImpl;

/**
 * 后台处理申请有关
 * 
 * @author Mr DU
 *
 */
public class ProcessServlet extends HttpServlet {
	private ApplyService applyService = new ApplyServiceImpl();

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
		if ("listApplys".equals(op)) {
			listApplys(request, response);
		} else if ("passApply".equals(op)) {
			passApply(request, response);
		} else if ("closeApply".equals(op)) {
			closeApply(request, response);
		}
	}

	/**
	 * 更改申请状态
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void passApply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到要修改的申请编号
		String number = request.getParameter("number");
		Apply apply = applyService.findApplyByNumber(number);
		// 修改状态
		apply.setStatus("申请审批通过");
		// 更新申请信息
		applyService.update(apply);
		request.setAttribute("message", "处理成功!");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 把申请关闭，成功改为false
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void closeApply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到要关闭的申请编号
		String number = request.getParameter("number");
		Apply apply = applyService.findApplyByNumber(number);
		apply.setClosed(true);
		apply.setSuccessed(false);
		apply.setStatus("申请已关闭");
		applyService.update(apply);
		request.setAttribute("message", "处理成功!");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}

	/**
	 * 列出待审批的申请：默认列出没有关闭的申请.分页查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listApplys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户要看的页码
		String num = request.getParameter("num");
		// 把没有关闭的申请封装到page
		Page page = applyService.findAllNotClosedApplys(num);
		page.setUri("/manage/ProcessServlet?op=listApplys");
		// 设置page的到域
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manage/listApplys.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
