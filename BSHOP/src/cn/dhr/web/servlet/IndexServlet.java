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
 * 首页同步加载
 * 
 * @author Mr DU
 *
 */
@WebServlet("/index")
public class IndexServlet extends BaseSerlvet {
	private static final long serialVersionUID = 1L;

	/**
	 * 显示图书
	 * 
	 * @param req
	 * @return
	 */
	public String getBook(HttpServletRequest req, HttpServletResponse res) {
		// 调用service
		try {
			//同步加载推荐商品
			ProductService ps = new ProductServiceImpl();
			List<Product> products = ps.getNewBook();
			req.setAttribute("products", products);
			//同步加载四大分类
			List<Product> cateproducts = ps.getCategory();
			req.setAttribute("cateproducts", cateproducts);
			//同步加载分享区商品
			List<Product> likeproducts = ps.getLikeBook();
			req.setAttribute("likeproducts", likeproducts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/index.jsp";
	}

	
}
