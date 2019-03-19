package cn.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import cn.dhr.dao.ProductDao;
import cn.dhr.domain.Product;
import cn.dhr.utils.DataSourceUtils;
import cn.dhr.utils.PageBean;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> getBook() throws Exception {
		String sql = "select * from book where isdel=? limit ?,?";
		Random random = new Random();
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		List<Product> products = qr.query(sql, new BeanListHandler<>(Product.class),0,random.nextInt(10),12);
		return products;
	}

	@Override
	public List<Product> findCategory(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		List<Product> list = null;
		if(cid!=null) {
			String sql = "select * from book where isdel=? and cid=? order by cid desc limit ?";
			list = qr.query(sql, new BeanListHandler<>(Product.class),0,cid,7);
		}else {
			String sql = "select * from book where isdel=? limit ?";
			list = qr.query(sql, new BeanListHandler<>(Product.class),0,7);
		}
		return list;
	}

	@Override
	public List<Product> getLikeBook() throws Exception {
		String sql = "select * from book where isdel=? limit ?,?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		Random random = new Random();
		List<Product> lists = qr.query(sql, new BeanListHandler<>(Product.class),0,random.nextInt(20),14);
		return lists;
	}


	@Override
	public List<Product> findPageNumber(PageBean<Product> bean, String cid) {
		String sql = "select * from book where isdel=? and cid=? limit ?,?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		List<Product> lists = null;
		try {
			lists = qr.query(sql, new BeanListHandler<>(Product.class),0,cid,bean.getStartIndex(),bean.getPageData());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public int getAllData(String cid) throws Exception {
		String sql = "select count(*) from book where cid=? and isdel=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		long c = (long) qr.query(sql, new ScalarHandler(),cid,0);
		int count = (int)c;
		return count;
	}

	@Override
	public Product getProductInfo(String bid) throws Exception {
		String sql = "select * from book where bid=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		Product product = qr.query(sql, new BeanHandler<>(Product.class),bid);
		return product;
	}


}
