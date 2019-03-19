package cn.dhr.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ¹ýÂË±àÂë
 * @author Mr DU
 *
 */
public class EncodingFilter implements Filter{
	private String charset = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest resquest = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		req.setCharacterEncoding(this.charset);
		chain.doFilter(resquest, response);
	}
}
