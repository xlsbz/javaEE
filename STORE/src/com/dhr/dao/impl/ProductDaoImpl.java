package com.dhr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;

import com.dhr.constant.Constant;
import com.dhr.dao.ProductDao;
import com.dhr.util.DataSourceUtils;
import com.dhr.web.domain.Category;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public class ProductDaoImpl implements ProductDao {
	private Connection conn;
	private PreparedStatement prep;

	public ProductDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	/**
	 * 查询热门商品
	 */
	public List<Product> findHot() throws Exception {
		String sql = "SELECT * FROM product WHERE is_hot=? AND pflag=? LIMIT ?";
		List<Product> isHot = new ArrayList<>();
		Product product = null;
		prep = conn.prepareStatement(sql);
		prep.setInt(1, Constant.IS_HOT);
		prep.setInt(2, Constant.IS_FLAG);
		prep.setInt(3, Constant.COUNT);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while (rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));

			isHot.add(product);
		}
		return isHot;
	}

	@Override
	/**
	 * 查询最新商品
	 */
	public List<Product> findNew() throws Exception {
		String sql = "SELECT * FROM product WHERE  pflag=? ORDER BY pdate DESC LIMIT ?";
		List<Product> isNew = new ArrayList<>();
		Product product = null;
		prep = conn.prepareStatement(sql);
		prep.setInt(1, Constant.IS_FLAG);
		prep.setInt(2, Constant.IS_NEW);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while (rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));

			isNew.add(product);
		}
		return isNew;
	}

	@Override
	/**
	 * 查询喜欢商品
	 */
	public List<Product> findLike() throws Exception {
		String sql = "SELECT * FROM product WHERE pflag=? LIMIT ?";
		List<Product> isLike = new ArrayList<>();
		Product product = null;
		prep = conn.prepareStatement(sql);
		prep.setInt(1, Constant.IS_FLAG);
		prep.setInt(2, Constant.IS_LIKE);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while (rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));

			isLike.add(product);
		}
		return isLike;
	}
	

	@Override
	/**
	 * 查询推选商品
	 */
	public List<Product> findChoose() throws Exception {
		String sql = "SELECT * FROM product WHERE pflag=? LIMIT ?,?";
		List<Product> isChoose = new ArrayList<>();
		//产生随机数
		Random random = new Random();
		int start = random.nextInt(30);
		Product product = null;
		prep = conn.prepareStatement(sql);
		prep.setInt(1, Constant.IS_FLAG);
		prep.setInt(2, start);
		prep.setInt(3, 20);
		ResultSet rs = null;
		rs = prep.executeQuery();
		while (rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));
			isChoose.add(product);
		}
		return isChoose;
	}
	
	@Override
	/**
	 * id查询商品
	 */
	public Product getProductById(String pid) throws Exception {
		Product product = null;
		String sql = "SELECT * FROM product WHERE pid=? LIMIT 1";
		prep = conn.prepareStatement(sql);
		prep.setString(1, pid);
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));
		}
		return product;
	}

	
	/*-------------------admin----------------------*/
	@Override
	/**
	 * 分页查询商品
	 */
	public List<Product> findByPage(PageBean<Product> pagebean, String cid) throws Exception {
		List<Product> all = new ArrayList<>();
		Product product = null;
		String sql = "SELECT * FROM product WHERE cid=? and pflag=? ORDER BY pdate DESC LIMIT ?,?";
		prep = conn.prepareStatement(sql);
		prep.setString(1,cid);
		prep.setInt(2, Constant.IS_FLAG);
		prep.setInt(3,pagebean.getStartIndex());
		prep.setInt(4, pagebean.getPageSize());
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));
			all.add(product);
		}
		return all;
	}

	@Override
	public int getTotalRecord(String cid) throws Exception {
		int total=0;
		String sql = "SELECT * FROM product WHERE cid=? and pflag=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cid);
		prep.setInt(2, Constant.IS_FLAG);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			++total;
		}
		return total;
	}

	@Override
	/**
	 * 搜索商品
	 */
	public List<Product> searchProduct(String search) throws Exception {
		List<Product> searchList = new ArrayList<>();
		Product product = null;
		String sql = "SELECT * FROM product WHERE pname LIKE ? or pdesc LIKE ?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, "%"+search+"%");
		prep.setString(2, "%"+search+"%");
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));
			searchList.add(product);
 		}
		return searchList;
	}

	@Override
	/**
	 * 查询上架商品
	 */
	public List<Product> findByPage(PageBean<Product> pageBean) throws Exception {
		List<Product> all = new ArrayList<>();
		Product product = null;
		String sql = "SELECT * FROM product WHERE pflag=? ORDER BY pdate DESC LIMIT ?,?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, Constant.IS_FLAG);
		prep.setInt(2,pageBean.getStartIndex());
		prep.setInt(3, pageBean.getPageSize());
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));
			Category category = new Category();
			category.setCid(rs.getString(10));
			product.setCategory(category);
			all.add(product);
		}
		return all;
	}

	@Override
	public int getTotalRecord() throws Exception {
		int total=0;
		String sql = "SELECT count(*) FROM product where pflag=?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, Constant.IS_FLAG);
		ResultSet rs = prep.executeQuery();
		if(rs.next()) {
			total = rs.getInt(1);
		}
		return total;
	}

	@Override
	/**
	 * 修改商品信息
	 */
	public boolean updataProduct(Product product) throws Exception {
		boolean flag = false;
		String sql = "UPDATE product SET pname=?,market_price=?,shop_price=?,is_hot=?,pflag=?,pdesc=?,cid=? WHERE pid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, product.getPname());
		prep.setDouble(2, product.getMarket_price());
		prep.setDouble(3, product.getShop_price());
		prep.setInt(4, product.getIs_hot());
		prep.setInt(5, product.getPflag());
		prep.setString(6,product.getPdesc());
		prep.setString(7, product.getCategory().getCid());
		prep.setString(8, product.getPid());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	/**
	 * 下架商品
	 */
	public List<Product> findByPageOut(PageBean<Product> pageBean) throws Exception {
		List<Product> all = new ArrayList<>();
		Product product = null;
		String sql = "SELECT * FROM product WHERE pflag=? ORDER BY pdate DESC LIMIT ?,?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1,1);
		prep.setInt(2,pageBean.getStartIndex());
		prep.setInt(3, pageBean.getPageSize());
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setPid(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setMarket_price(rs.getDouble(3));
			product.setShop_price(rs.getDouble(4));
			product.setPimage(rs.getString(5));
			product.setPdate(rs.getDate(6));
			product.setIs_hot(rs.getInt(7));
			product.setPdesc(rs.getString(8));
			product.setPflag(rs.getInt(9));
			Category category = new Category();
			category.setCid(rs.getString(10));
			product.setCategory(category);
			all.add(product);
		}
		return all;
	}

	@Override
	public int getTotalRecordOut() throws Exception {
		int total=0;
		String sql = "SELECT count(*) FROM product WHERE pflag = ?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, 1);
		ResultSet rs = prep.executeQuery();
		if(rs.next()) {
			total = rs.getInt(1);
		}
		return total;
	}

	@Override
	/**
	 * 新增商品
	 */
	public void save(Product product) throws Exception {
		String sql = "INSERT into PRODUCT values(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		qr.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),
				product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag()
				,product.getCategory().getCid());
	}

}
