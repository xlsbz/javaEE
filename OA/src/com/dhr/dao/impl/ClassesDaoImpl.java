package com.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dhr.dao.ClassesDao;
import com.dhr.domain.Classes;
import com.dhr.exception.DaoException;
import com.dhr.util.C3P0Util;

/**
 * 开班信息数据处理
 * 
 * @author Mr DU
 *
 */
public class ClassesDaoImpl implements ClassesDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 获取总共有多少开班个数
	 * 
	 * @return
	 */
	public int getTotalRecordsNumber() {
		try {
			// ScalarHandler:获取一条记录中的某一列
			Object obj = qr.query("select count(*) from classes", new ScalarHandler(1));
			Long number = (Long) obj;
			return number.intValue();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 分页查询所有开班数据
	 * 
	 * @param startIndex
	 * @param size
	 * @return
	 */
	public List<Classes> findPageRecords(int startIndex, int size) {
		try {
			return qr.query("select * from classes limit ?,?", new BeanListHandler<Classes>(Classes.class), startIndex,
					size);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 查询某个分类下的开班信息
	 * 
	 * @param classTypeId
	 * @return
	 */
	public int getTotalRecordsNumber(String classTypeId) {
		try {
			// ScalarHandler:获取一条记录中的某一列
			Object obj = qr.query("select count(*) from classes where classTypeId=?", new ScalarHandler(1),
					classTypeId);
			Long number = (Long) obj;
			return number.intValue();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 查询某个分类下的开班个数
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @param classTypeId
	 * @return
	 */
	public List<Classes> findPageRecords(int startIndex, int pageSize, String classTypeId) {
		try {
			return qr.query("select * from classes where classTypeId=? limit ?,?",
					new BeanListHandler<Classes>(Classes.class), classTypeId, startIndex, pageSize);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 保存开班信息
	 * 
	 * @param classes
	 */
	public void save(Classes classes) {
		try {
			qr.update(
					"insert into classes (name,startDate,endDate,planNumber,number,actualNumber,status,classTypeId) values (?,?,?,?,?,?,?,?)",
					classes.getName(), classes.getStartDate(), classes.getEndDate(), classes.getPlanNumber(),
					classes.getNumber(), classes.getActualNumber(), classes.getStatus(),
					classes.getClassType() == null ? null : classes.getClassType().getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 根据课程名查询这个课程的开班信息
	 * 
	 * @param classTypeName
	 * @return
	 */
	public List<Classes> findClassesByClassTypeName(String classTypeName) {
		try {
			return qr.query("select * from classes where classTypeId=(select id from classtypes where name=?)",
					new BeanListHandler<Classes>(Classes.class), classTypeName);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 根据ID查询班级信息
	 * 
	 * @param classesId
	 * @return
	 */
	public Classes findById(String classesId) {
		try {
			return qr.query("select * from classes where id=?", new BeanHandler<Classes>(Classes.class), classesId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
