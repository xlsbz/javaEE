package com.dhr.web.servlet.baseservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽取的servlet
 * 
 * @author Mr DU
 *
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1.获取方法名称
			String mName = request.getParameter("method");
			//判断传过来的方法
			if(mName==null||mName.trim().length()==0) {
				mName="error";
			}
			// 2.获取方法对象
			Method method = this.getClass().getDeclaredMethod(mName, HttpServletRequest.class, HttpServletResponse.class);
			// 3.执行方法
			String path = (String) method.invoke(this, request, response);
			// 4.判断是否为空
			if (path != null) {
				request.getRequestDispatcher(path).forward(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
	/**
	 * 穿空参数
	 * @throws IOException 
	 */
	public void error(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter writer = res.getWriter();
		writer.println("您没有传参数，不要调皮！");
	}

}
