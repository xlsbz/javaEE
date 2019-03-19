package cn.dhr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.User;

/**
 * Ȩ�޹�����
 * @author Mr DU
 *
 */
public class PrivilegesFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.ǿ��ת��
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//2.��ȡsession
		User user = (User) req.getSession().getAttribute("user");
		if(user==null) {
			req.setAttribute("msg","����û�е�½�����ȵ�¼��");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
		}else {
			//��½�˾ͷ���
			chain.doFilter(req, res);
		}
		
	}

}
