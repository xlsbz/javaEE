package cn.dhr.web.baseservlet;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ȡ������servlet
 * @author Mr DU
 *
 */
@WebServlet("/BaseSerlvet")
public class BaseSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	/**
	 * ����:
	 * 1.ÿһ��servlet���̳��������  
	 * 2.��ȡ���󷽷�
	 * 3.����õ����ʵ��
	 * 4.ִ����ķ���
	 * 5.����ǿղ���������Ӧ����Ӧ
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
	 * �ղ���
	 * @throws IOException 
	 */
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("��û�д���!");
	}
}
