package com.dhr.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dhr.service.CategoryService;
import com.dhr.service.impl.CategoryServiceImpl;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * ���ദ��
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * ��ѯ���з���
	 * @param req
	 * @param res
	 * @return
	 * @throws IOException 
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("utf-8");
		PrintWriter writer = res.getWriter();
		CategoryService cs = new CategoryServiceImpl();
		String value = "";
		try {
			value = cs.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		writer.println(value);
		return null;
	}
}
