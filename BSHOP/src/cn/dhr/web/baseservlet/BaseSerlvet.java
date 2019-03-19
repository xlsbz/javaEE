package cn.dhr.web.baseservlet;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 抽取公共的servlet
 * @author Mr DU
 *
 */
@WebServlet("/BaseSerlvet")
public class BaseSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	/**
	 * 分析:
	 * 1.每一个servlet都继承这个基类  
	 * 2.获取请求方法
	 * 3.反射得到类的实例
	 * 4.执行类的方法
	 * 5.如果是空参数给出相应的响应
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mName = request.getParameter("method");
		if(mName==null) {
			index(request, response);
		}
		try {
			Method method = this.getClass().getDeclaredMethod(mName,HttpServletRequest.class,HttpServletResponse.class);
			String path = (String) method.invoke(this, request,response);
			if(path!=null) {
				request.getRequestDispatcher(path).forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 空参数
	 * @throws IOException 
	 */
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("您没有传参!");
	}
}
