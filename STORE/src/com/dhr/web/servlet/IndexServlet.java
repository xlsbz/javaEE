package com.dhr.web.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.ProductService;
import com.dhr.service.impl.ProductServiceImpl;
import com.dhr.util.Count;
import com.dhr.web.domain.Product;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * ҳ��չʾ
 * @author Mr DU
 *
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * չʾ��Ʒ
	 */
	public String showShop(HttpServletRequest req,HttpServletResponse res) {
		//ͳ�Ʒ�����
		Count count = new Count();
		count.count(req);
		//productҵ��
		ProductService ps = new ProductServiceImpl();
		//������Ʒ
		List<Product> hotList;
		//������Ʒ
		List<Product> newList;
		//����ϲ��
		List<Product> likeList;
		try {
			hotList = ps.findHot();
			req.setAttribute("hList", hotList);
			newList = ps.findNew();
			req.setAttribute("nList", newList);
			likeList = ps.findLike();
			req.setAttribute("lList", likeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/index.jsp";
	}
}
