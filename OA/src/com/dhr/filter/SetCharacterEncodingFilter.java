package com.dhr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 解决POST请求中文编码和响应编码过滤器
 * 
 * @author Mr DU
 *
 */
public class SetCharacterEncodingFilter implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 判断用户有没有配置过滤器的参数，如果没有，给定一个默认编码UTF-8
		String encoding = filterConfig.getInitParameter("encoding");
		if (encoding == null)
			encoding = "UTF-8";

		request.setCharacterEncoding(encoding);// POST请求
		response.setCharacterEncoding(encoding);// 建议写上
		response.setContentType("text/html;charset=" + encoding);// 响应输出流使用的编码

		// 放行
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
