package cn.dhr.web.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.Product;
import cn.dhr.service.ProductService;
import cn.dhr.service.impl.ProductServiceImpl;
import cn.dhr.utils.PageBean;
import cn.dhr.web.baseservlet.BaseSerlvet;
/**
 * ��Ʒ������
 * @author Mr DU
 *
 */
@WebServlet("/product")
public class ProductServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	/*
	 * �첽������Ʒ
	 * @param req
	 * @param res
	 * @return
	 */
	public String findCategory(HttpServletRequest req,HttpServletResponse res) {
		 /* �Ĵ����*/
		try {
			//��Ӧ����
			req.setCharacterEncoding("utf-8");
			ProductService ps = new ProductServiceImpl();
			String cid = req.getParameter("cid");
			String products = ps.findCategory(cid);
			res.getWriter().print(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ҳ��ʾ������Ʒ
	 * @return
	 */
	public String findPageNumber(HttpServletRequest req,HttpServletResponse res) {
		try {
			//1.��ȡ�ڼ�ҳ��ʼ��ÿҳ����������,��Ʒ����
		
			int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			String cid = req.getParameter("cid");
			int pageData =2;
			//2.����pageBean
			PageBean<Product> pageBean = null;
			//3.����service
			ProductService ps = new ProductServiceImpl();
			pageBean = ps.findPageNumber(pageNumber,pageData,cid);
			req.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/book_list.jsp";
	}
	
	/**
	 * ��Ʒ����չʾ
	 * @param req
	 * @param res
	 * @return
	 */
	public String productInfo(HttpServletRequest req,HttpServletResponse res) {
		try {
			//1.��ȡ��ƷID
			String bid = req.getParameter("bid");
			//2.����service
			ProductService ps = new ProductServiceImpl();
			Product product = ps.getProductInfo(bid);
			//3.��װ����ת��
			req.setAttribute("product", product);
		} catch (Exception e) {
			req.setAttribute("msg", "��Ʒ�����ȡʧ�ܣ�");
			e.printStackTrace();
			return "/jsp/msg.jsp";
		}
		return "/jsp/book_info.jsp";
	}
}
