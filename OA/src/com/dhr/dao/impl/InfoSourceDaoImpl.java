package com.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dhr.dao.InfoSourceDao;
import com.dhr.domain.InfoSource;
import com.dhr.exception.DaoException;
import com.dhr.util.C3P0Util;

/**
 * 处理信息来源数据层
 * 
 * @author Mr DU
 *
 */
public class InfoSourceDaoImpl implements InfoSourceDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 查询所有的信息来源
	 * 
	 * @return
	 */
	public List<InfoSource> findAll() {
		try {
			return qr.query("select * from INFOSOURCES", new BeanListHandler<InfoSource>(InfoSource.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 新增信息来源
	 * 
	 * @param infoSource
	 */
	public void save(InfoSource infoSource) {
		try {
			qr.update("insert into INFOSOURCES (name,description) values (?,?)", infoSource.getName(),
					infoSource.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 查询单个信息来源
	 * 
	 * @param infoSourceId
	 * @return
	 */
	public InfoSource findOne(String infoSourceId) {
		try {
			return qr.query("select * from INFOSOURCES where id=?", new BeanHandler<InfoSource>(InfoSource.class),
					infoSourceId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 修改信息来源数据
	 * 
	 * @param infoSource
	 */
	public void update(InfoSource infoSource) {
		try {
			qr.update("update INFOSOURCES set name=?,description=? where id=?", infoSource.getName(),
					infoSource.getDescription(), infoSource.getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	/**
	 * 批量删除信息来源
	 * 
	 * @param infoSourceId
	 */
	public void delete(String... infoSourceId) {// [1,2,3]
		try {
			Object[][] params = new Object[infoSourceId.length][];// 高维：批量操作的记录条数；低维：每条记录所需的参数
			// [[1],[2],[3]]
			for (int i = 0; i < params.length; i++) {
				params[i] = new Object[] { infoSourceId[i] };
			}
			// 批量执行
			qr.batch("delete from INFOSOURCES where id=?", params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
