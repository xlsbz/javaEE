package com.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dhr.dao.CustomerStatusDao;
import com.dhr.domain.CustomerStatus;
import com.dhr.exception.DaoException;
import com.dhr.util.C3P0Util;

/**
 * 客户状态数据层
 * 
 * @author Mr DU
 *
 */
public class CustomerStatusDaoImpl implements CustomerStatusDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 查询所有状态
	 * 
	 * @return
	 */
	public List<CustomerStatus> findAll() {
		try {
			return qr.query("select * from CUSTOMERSTATUS", new BeanListHandler<CustomerStatus>(CustomerStatus.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 根据ID查询指定状态
	 * 
	 * @param customerStatusId
	 * @return
	 */
	public CustomerStatus findOne(String customerStatusId) {
		try {
			return qr.query("select * from CUSTOMERSTATUS where id=?",
					new BeanHandler<CustomerStatus>(CustomerStatus.class), customerStatusId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 新增学生状态信息
	 * 
	 * @param customerStatus
	 */
	public void save(CustomerStatus customerStatus) {
		try {
			qr.update("insert into CUSTOMERSTATUS (name,description) values (?,?)", customerStatus.getName(),
					customerStatus.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
