package com.dhr.service.impl;
import java.util.List;

import com.dhr.conn.Conn;
import com.dhr.dao.CategoryDao;
import com.dhr.dao.impl.CategoryDaoImpl;
import com.dhr.service.CategoryService;
import com.dhr.util.JsonUtil;
import com.dhr.web.domain.Category;
public class CategoryServiceImpl implements CategoryService{
	private Conn conn = null;
	private CategoryDao cateDao = null;
	public CategoryServiceImpl() {
		conn = new Conn();
		cateDao = new CategoryDaoImpl(conn.getConnection());
	}


	@Override
	/**
	 * ��ѯ���з���
	 */
	public String findAll() throws Exception {
		List<Category> list = cateDao.findAll();
		//2.��listת����json�ַ���
		if(list!=null && list.size()>0){
			return JsonUtil.list2json(list);
		}
		return null;
	}

	/*------------------------admin------------------------*/
	@Override
	/**
	 * ��ѯ���з���
	 */
	public List<Category> findAllCate() throws Exception {
		return cateDao.findAll();
	}


	@Override
	/**
	 * ����ID��ѯ����
	 */
	public Category getById(String cid) throws Exception {
		Category category = null;
		category = cateDao.getById(cid);
		conn.close();
		return category;
	}


	@Override
	/**
	 * �޸ķ���
	 */
	public boolean categoryUpdate(String cid, String cname) throws Exception {
		boolean flag = false;
		flag = cateDao.categoryUpdate(cid,cname);
		conn.close();
		return flag;
	}


	@Override
	/**
	 * ɾ������
	 */
	public boolean categoryDelete(String cid) throws Exception {
		boolean flag = false;
		flag = cateDao.categoryDelete(cid);
		conn.close();
		return flag;
	}


	@Override
	/**
	 * ��������
	 */
	public boolean categoryAdd(Category category) throws Exception {
		boolean flag = false;
		flag = cateDao.categoryAdd(category);
		conn.close();
		return flag;
	}

}
