package cn.dhr.web.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dhr.service.CategoryService;
import cn.dhr.service.impl.CategoryServiceImpl;
import cn.dhr.web.baseservlet.BaseSerlvet;

/**
 * 分类处理
 * @author Mr DU
 *
 */
@WebServlet("/category")
public class CategroyServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	/**
	 * 查询分类
	 * @param req
	 * @param res
	 * @return
	 */
	public String getAllCategory(HttpServletRequest req,HttpServletResponse res) {
		try {
			//设置响应编码
			res.setCharacterEncoding("utf-8");
			//1.调用service
			CategoryService cs = new CategoryServiceImpl();
			String cate = cs.getAllCategory();
			res.getWriter().print(cate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
