package com.dhr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dhr.dao.CategoryDao;
import com.dhr.util.DataSourceUtils;
import com.dhr.web.domain.Category;

public class CategoryDaoImpl implements CategoryDao{
	private PreparedStatement prep;
	private Connection conn;
	public CategoryDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	/**
	 * 查询所有分类
	 */
	public List<Category> findAll() throws Exception {
		List<Category> cate = new ArrayList<>();
//		Category category = null;
		String sql = "SELECT * FROM category ORDER BY cid DESC";
//		prep = conn.prepareStatement(sql);
//		ResultSet rs = prep.executeQuery();
//		while(rs.next()) {
//			category = new Category();
//			category.setCid(rs.getString(1));
//			category.setCname(rs.getString(2));
//			cate.add(category);
//		}
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		cate = qr.query(sql, new BeanListHandler<>(Category.class));
		return cate;
	}
	@Override
	/**
	 * 按照id查询分类
	 */
	public Category getById(String cid) throws Exception {
		String sql = "SELECT * FROM category WHERE cid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cid);
		Category category = null;
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			category = new Category();
			category.setCid(rs.getString(1));
			category.setCname(rs.getString(2));
		}
		return category;
	}
	@Override
	/**
	 * 修改分类
	 */
	public boolean categoryUpdate(String cid, String cname) throws Exception {	
		boolean flag = false;
		String sql = "UPDATE category SET cname=? WHERE cid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cname);
		prep.setString(2, cid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	/**
	 * 删除分类
	 */
	public boolean categoryDelete(String cid) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM category WHERE cid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	/**
	 * 新增分类
	 */
	public boolean categoryAdd(Category category) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO category VALUES(?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1, category.getCid());
		prep.setString(2, category.getCname());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
}
