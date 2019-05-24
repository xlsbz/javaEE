package com.dhr.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.service.CategoryService;
import com.dhr.service.impl.CategoryServiceImpl;
import com.dhr.util.UUIDUtils;
import com.dhr.web.domain.Category;
import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * �������
 * @author Mr DU
 *
 */
@WebServlet("/admincategory")
public class AdminCategoryServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * ��ѯ���з���
	 * @param req
	 * @param res
	 * @return
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse res) {
		try {
			CategoryService cs = new CategoryServiceImpl();
			List<Category> cateList = cs.findAllCate();
			req.setAttribute("allCategory", cateList);
		} catch (Exception e) {
			req.setAttribute("msg", "��ѯ����ʧ��");
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
	/**
	 * ͨ���޸ĵ�UI
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryUpdateUI(HttpServletRequest req,HttpServletResponse res) {
		try {
			String cid = req.getParameter("cid");
			CategoryService cs = new CategoryServiceImpl();
			Category category = cs.getById(cid);
			req.setAttribute("category", category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/category/edit.jsp";
	}
	/**
	 * �޸ķ�������
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryUpdate(HttpServletRequest req,HttpServletResponse res) {
		//1.��ȡ��ز���
		try {
			String cid = req.getParameter("cid");
			String cname = req.getParameter("cname");
			//2.����service
			CategoryService cs = new CategoryServiceImpl();
			boolean flag = cs.categoryUpdate(cid,cname);
			if(flag) {
				req.setAttribute("msg", "�����޸ĳɹ�!");
				return "/admin/category/list.jsp";
			}else {
				req.setAttribute("msg", "�����޸�ʧ��!");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "�����޸�ʧ��!");
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
	/**
	 * ɾ������
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryDelete(HttpServletRequest req,HttpServletResponse res) {
		try {
			String cid = req.getParameter("cid");
			CategoryService cs = new CategoryServiceImpl();
			boolean flag = cs.categoryDelete(cid);
			if(flag) {
				req.setAttribute("msg", "����ɾ���ɹ�!");
			}else {
				req.setAttribute("msg", "����ɾ��ʧ��!");
			}
		}catch (Exception e) {
				req.setAttribute("msg", "����ɾ��ʧ��!");
				e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
	/**
	 * ͨ����ӷ���
	 * @param req
	 * @param res
	 * @return
	 */
	public String categoryAddUI(HttpServletRequest req,HttpServletResponse res) {
		return "/admin/category/add.jsp";
	}
	
	public String categoryAdd(HttpServletRequest req,HttpServletResponse res) {
		//1.��ȡҳ�����,��װ
		try {
			String cname = req.getParameter("cname");
			String cid = UUIDUtils.getId();
			Category category = new Category();
			category.setCid(cid);
			category.setCname(cname);
			//2.����service
			CategoryService cs = new CategoryServiceImpl();
			boolean flag = cs.categoryAdd(category);
			//3.�ж��Ƿ�ɹ�
			if(flag) {
				req.setAttribute("msg", "������ӳɹ�!");
			}else {
				req.setAttribute("msg", "�������ʧ��!");
			}
		} catch (Exception e) {
			req.setAttribute("msg", "�������ʧ��!");
			e.printStackTrace();
		}
		return "/admin/category/list.jsp";
	}
}
