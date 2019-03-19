package cn.dhr.service.impl;

import java.util.List;

import cn.dhr.dao.ProductDao;
import cn.dhr.dao.impl.ProductDaoImpl;
import cn.dhr.domain.Product;
import cn.dhr.service.ProductService;
import cn.dhr.utils.JsonUtil;
import cn.dhr.utils.PageBean;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> getNewBook() throws Exception {
		ProductDao pd = new ProductDaoImpl();
		return pd.getBook();
	}

	@Override
	public String findCategory(String cid) throws Exception {
		ProductDao pd = new ProductDaoImpl();
		List<Product> lists =  pd.findCategory(cid);
		//转化为字符串
		String productsValue = JsonUtil.list2json(lists);
		return productsValue;
	}

	@Override
	public List<Product> getCategory() throws Exception {
		ProductDao pd = new ProductDaoImpl();
		String cid=null;
		List<Product> lists =  pd.findCategory(cid);
		return lists;
	}

	@Override
	public List<Product> getLikeBook() throws Exception {
		ProductDao pd = new ProductDaoImpl();
		List<Product> lists = pd.getLikeBook();
		return lists;
	}

	@Override
	public PageBean<Product> findPageNumber(int pageNumber, int pageData, String cid) throws Exception {
		//1.创建pageBean，封装数据
		PageBean<Product> bean = new PageBean<>(pageNumber, pageData);
		//2.调用dao层封装data
		ProductDao pd = new ProductDaoImpl();
		List<Product> lists = pd.findPageNumber(bean,cid);
		bean.setData(lists);
		//3.调用dao获取总记录
		int count = pd.getAllData(cid);
		bean.setPageDataTotal(count);
		return bean;
	}

	@Override
	public Product getProductInfo(String bid) throws Exception {
		ProductDao pd = new ProductDaoImpl();
		return pd.getProductInfo(bid);
	}
	

}
