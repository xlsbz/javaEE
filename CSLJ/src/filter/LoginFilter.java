package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ¹ýÂËµÇÂ¼
 * @author Mr DU
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest)req;
//		HttpSession session = request.getSession();
//		if(session.getAttribute("sname")!=null) {
//			chain.doFilter(req, res);
//		}else {
//			request.getRequestDispatcher("login_student.jsp").forward(req, res);
//		}
	}
}
