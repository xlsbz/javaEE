package com.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dhr.dao.ClassTypeDao;
import com.dhr.domain.ClassType;
import com.dhr.exception.DaoException;
import com.dhr.util.C3P0Util;

/**
 * 开班类型业务
 * 
 * @author Mr DU
 *
 */
public class ClassTypeDaoImpl implements ClassTypeDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 查询所有班级类型
	 * 
	 * @return
	 */
	public List<ClassType> findAll() {
		try {
			return qr.query("select * from CLASSTYPES", new BeanListHandler<ClassType>(ClassType.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 保存班级类型
	 * 
	 * @param classType
	 */
	public void save(ClassType classType) {
		try {
			qr.update("insert into CLASSTYPES (name,description) values (?,?)", classType.getName(),
					classType.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 根据ID查询班级类型
	 * 
	 * @param classTypeId
	 * @return
	 */
	public ClassType findOne(String classTypeId) {
		try {
			return qr.query("select * from CLASSTYPES where id=?", new BeanHandler<ClassType>(ClassType.class),
					classTypeId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
