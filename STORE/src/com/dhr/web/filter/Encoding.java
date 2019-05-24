package com.dhr.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 同一编码
 * @author Mr DU
 *
 */
public class Encoding implements Filter{
	private String charset;
	@Override
	public void init(FilterConfig Config) throws ServletException {
		this.charset = Config.getInitParameter("charset");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain china)
			throws IOException, ServletException {
		req.setCharacterEncoding(this.charset);
		//放行
		china.doFilter(req, res);
	}
}