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
	 * 查询热门商品
	 */
	public List<Product> findHot() throws Exception {
		List<Product> hList = productDao.findHot();
		return hList;
	}

	@Override
	/**
	 * 查询最新商品
	 */
	public List<Product> findNew() throws Exception {
		List<Product> nList = productDao.findNew();
		return nList;
	}

	@Override
	/**
	 * 查询喜欢商品
	 */
	public List<Product> findLike() throws Exception {
		List<Product> lList = productDao.findLike();
		conn.close();
		return lList;
	}

	@Override
	/**
	 * 查询推选商品
	 */
	public List<Product> findChoose() throws Exception {
		List<Product> chooseList = productDao.findChoose();
		conn.close();
		return chooseList;
	}

	@Override
	/**
	 * ID查询商品
	 */
	public Product getProductById(String pid) throws Exception {
		Product product = null;
		product = productDao.getProductById(pid);
		return product;
	}

	@Override
	/**
	 * 分页查询商品
	 */
	public PageBean<Product> findBypage(int pageNumber, int pageSize, String cid) throws Exception {
		PageBean<Product> pagebean = new PageBean<>(pageNumber, pageSize);
		List<Product> data = productDao.findByPage(pagebean, cid);
		pagebean.setData(data);
		// 总记录数
		int totalRecord = productDao.getTotalRecord(cid);
		pagebean.setTotalRecord(totalRecord);
		conn.close();
		return pagebean;
	}

	@Override
	/**
	 * 查询搜索商品
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
	 * 查询所有商品
	 */
	public PageBean<Product> findAllProduct(int pageNumber, int pageSize) throws Exception {
		// 查看每页数据
		PageBean<Product> pageBean = new PageBean<>(pageNumber, pageSize);
		List<Product> allProduct = productDao.findByPage(pageBean);
		pageBean.setData(allProduct);
		// 查看总数据
		int count = 0;
		count = productDao.getTotalRecord();
		pageBean.setTotalRecord(count);
		conn.close();
		return pageBean;
	}

	@Override
	/**
	 * 修改商品
	 */
	public boolean updataProduct(Product product) throws Exception {
		boolean flag = productDao.updataProduct(product);
		conn.close();
		return flag;
	}

	@Override
	/**
	 * 查询下架商品
	 */
	public PageBean<Product> findAllOutProduct(int pageNumber, int pageSize) throws Exception {
		// 查看每页数据
		PageBean<Product> pageBean = new PageBean<>(pageNumber, pageSize);
		List<Product> allProduct = productDao.findByPageOut(pageBean);
		pageBean.setData(allProduct);
		// 查看总数据
		int count = 0;
		count = productDao.getTotalRecordOut();
		pageBean.setTotalRecord(count);
		conn.close();
		return pageBean;
	}

	@Override
	/**
	 * 新增商品
	 */
	public void save(Product product) throws Exception {
		productDao.save(product);
		conn.close();
	}

}
