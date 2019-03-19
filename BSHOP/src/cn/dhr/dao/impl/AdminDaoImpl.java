package cn.dhr.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.dhr.dao.AdminDao;
import cn.dhr.domain.Admin;
import cn.dhr.utils.DataSourceUtils;

/**
 * 管理员实现层
 * @author Mr DU
 *
 */
public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin loginAdmin(String user) {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "select * from adminuser where adminname = ?";
		Admin admin = null;
		try {
			admin = qr.query(sql,new BeanHandler<>(Admin.class),user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

}
