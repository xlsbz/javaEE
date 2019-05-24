package com.dhr.service.impl;

import java.util.List;

import com.dhr.conn.Conn;
import com.dhr.dao.ProductDao;
import com.dhr.dao.impl.ProductDaoImpl;
import com.dhr.service.ProductService;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public class ProductServiceImpl implements ProductService {
	private Conn conn;
	private ProductDao productDao = null;

	public ProductServiceImpl() {
		conn = new Conn();
		productDao = new ProductDaoImpl(conn.getConnection());
	}

	@Override
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> findHot() throws Exception {
		List<Product> hList = productDao.findHot();
		return hList;
	}

	@Override
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> findNew() throws Exception {
		List<Product> nList = productDao.findNew();
		return nList;
	}

	@Override
	/**
	 * ��ѯϲ����Ʒ
	 */
	public List<Product> findLike() throws Exception {
		List<Product> lList = productDao.findLike();
		conn.close();
		return lList;
	}

	@Override
	/**
	 * ��ѯ��ѡ��Ʒ
	 */
	public List<Product> findChoose() throws Exception {
		List<Product> chooseList = productDao.findChoose();
		conn.close();
		return chooseList;
	}

	@Override
	/**
	 * ID��ѯ��Ʒ
	 */
	public Product getProductById(String pid) throws Exception {
		Product product = null;
		product = productDao.getProductById(pid);
		return product;
	}

	@Override
	/**
	 * ��ҳ��ѯ��Ʒ
	 */
	public PageBean<Product> findBypage(int pageNumber, int pageSize, String cid) throws Exception {
		PageBean<Product> pagebean = new PageBean<>(pageNumber, pageSize);
		List<Product> data = productDao.findByPage(pagebean, cid);
		pagebean.setData(data);
		// �ܼ�¼��
		int totalRecord = productDao.getTotalRecord(cid);
		pagebean.setTotalRecord(totalRecord);
		conn.close();
		return pagebean;
	}

	@Override
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> searchProduct(String search) throws Exception {
		List<Product> searchList = null;
		searchList = productDao.searchProduct(search);
		conn.close();
		return searchList;
	}

	
	/*--------------------admin--------------------------*/
	@Override
	/**
	 * ��ѯ������Ʒ
	 */
	public PageBean<Product> findAllProduct(int pageNumber, int pageSize) throws Exception {
		// �鿴ÿҳ����
		PageBean<Product> pageBean = new PageBean<>(pageNumber, pageSize);
		List<Product> allProduct = productDao.findByPage(pageBean);
		pageBean.setData(allProduct);
		// �鿴������
		int count = 0;
		count = productDao.getTotalRecord();
		pageBean.setTotalRecord(count);
		conn.close();
		return pageBean;
	}

	@Override
	/**
	 * �޸���Ʒ
	 */
	public boolean updataProduct(Product product) throws Exception {
		boolean flag = productDao.updataProduct(product);
		conn.close();
		return flag;
	}

	@Override
	/**
	 * ��ѯ�¼���Ʒ
	 */
	public PageBean<Product> findAllOutProduct(int pageNumber, int pageSize) throws Exception {
		// �鿴ÿҳ����
		PageBean<Product> pageBean = new PageBean<>(pageNumber, pageSize);
		List<Product> allProduct = productDao.findByPageOut(pageBean);
		pageBean.setData(allProduct);
		// �鿴������
		int count = 0;
		count = productDao.getTotalRecordOut();
		pageBean.setTotalRecord(count);
		conn.close();
		return pageBean;
	}

	@Override
	/**
	 * ������Ʒ
	 */
	public void save(Product product) throws Exception {
		productDao.save(product);
		conn.close();
	}

}
