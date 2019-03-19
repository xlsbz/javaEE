package cn.dhr.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.domain.Product;
import cn.dhr.service.ProductService;
import cn.dhr.service.impl.ProductServiceImpl;
import cn.dhr.web.baseservlet.BaseSerlvet;

/**
 * ��ҳͬ������
 * 
 * @author Mr DU
 *
 */
@WebServlet("/index")
public class IndexServlet extends BaseSerlvet {
	private static final long serialVersionUID = 1L;

	/**
	 * ��ʾͼ��
	 * 
	 * @param req
	 * @return
	 */
	public String getBook(HttpServletRequest req, HttpServletResponse res) {
		// ����service
		try {
			//ͬ�������Ƽ���Ʒ
			ProductService ps = new ProductServiceImpl();
			List<Product> products = ps.getNewBook();
			req.setAttribute("products", products);
			//ͬ�������Ĵ����
			List<Product> cateproducts = ps.getCategory();
			req.setAttribute("cateproducts", cateproducts);
			//ͬ�����ط�������Ʒ
			List<Product> likeproducts = ps.getLikeBook();
			req.setAttribute("likeproducts", likeproducts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/index.jsp";
	}

	
}
