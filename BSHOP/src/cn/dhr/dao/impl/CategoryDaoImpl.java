package cn.dhr.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.dhr.dao.CategoryDao;
import cn.dhr.domain.Category;
import cn.dhr.utils.DataSourceUtils;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> getAllCategory() throws Exception {
		String sql = "select * from category";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		List<Category> listCate = qr.query(sql, new BeanListHandler<>(Category.class));
		return listCate;
	}

}
