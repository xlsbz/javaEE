package com.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dhr.dao.FunctionDao;
import com.dhr.domain.Function;
import com.dhr.exception.DaoException;
import com.dhr.util.C3P0Util;

/**
 * 功能数据层
 * 
 * @author Mr DU
 *
 */
public class FunctionDaoImpl implements FunctionDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 查询所有功能列表
	 * 
	 * @return
	 */
	public List<Function> findAll() {
		try {
			return qr.query("select * from functions", new BeanListHandler<Function>(Function.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 新增功能
	 * 
	 * @param function
	 */
	public void save(Function function) {
		try {
			qr.update("insert into functions (name,uri) values (?,?)", function.getName(), function.getUri());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
