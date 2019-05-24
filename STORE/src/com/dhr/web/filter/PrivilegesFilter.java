package com.dhr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.web.domain.User;

/**
 * ����Ȩ�޹�����
 * @author Mr DU
 *
 */
public class PrivilegesFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//1.ǿ������ת��ΪhttpservletRequest
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//2.��ȡsession
		User user = (User)request.getSession().getAttribute("user");
		//3.����
		if(user!=null) {
			chain.doFilter(req, res);
		}else {
			req.setAttribute("msg", "����û�е�¼!");
			req.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
	}

}
