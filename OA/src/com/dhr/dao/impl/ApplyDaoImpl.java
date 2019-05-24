package com.dhr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dhr.dao.ApplyDao;
import com.dhr.domain.Apply;
import com.dhr.domain.Classes;
import com.dhr.domain.Customer;
import com.dhr.exception.DaoException;
import com.dhr.util.C3P0Util;

/**
 * 申请处理业务
 * 
 * @author Mr DU
 *
 */
public class ApplyDaoImpl implements ApplyDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	/**
	 * 保存申请
	 * 
	 * @param apply
	 */
	public void save(Apply apply) {
		try {
			qr.update(
					"insert into applys (number,title,startDate,endDate,closed,successed,status,totalGrade,classesId,customerId) values (?,?,?,?,?,?,?,?,?,?)",
					apply.getNumber(), apply.getTitle(), apply.getStartDate(), apply.getEndDate(), apply.getClosed(),
					apply.getSuccessed(), apply.getStatus(), apply.getTotalGrade(),
					apply.getClasses() == null ? null : apply.getClasses().getId(),
					apply.getCustomer() == null ? null : apply.getCustomer().getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 查询客户申请的所有
	 * 
	 * @param customerId
	 * @return
	 */
	public List<Apply> findByCustomer(Integer customerId) {
		try {
			List<Apply> applys = qr.query("select * from applys where customerId=?",
					new BeanListHandler<Apply>(Apply.class), customerId);
			// 查询关联的客户和班级信息
			for (Apply a : applys) {
				Customer customer = qr.query("select * from customers where id=?",
						new BeanHandler<Customer>(Customer.class), customerId);
				// 把客户设置到属性当中
				a.setCustomer(customer);
				Classes classes = qr.query(
						"select * from classes where id=(select classesId from applys where number=?)",
						new BeanHandler<Classes>(Classes.class), a.getNumber());
				// 把属性设置到客户
				a.setClasses(classes);
			}
			return applys;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 查询未关闭申请的条数
	 * 
	 * @return
	 */
	public int findNotClosedApplyNumber() {
		try {
			Long number = (Long) qr.query(
					"select count(*) from applys where (closed is null or closed=false) and status=?",
					new ScalarHandler(1), "申请审批中");
			return number.intValue();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 查询未关闭的申请
	 * 
	 * @param startIndex
	 * @param size
	 * @return
	 */
	public List<Apply> findNotClosedApply(int startIndex, int size) {
		try {
			List<Apply> applys = qr.query(
					"select * from applys where  (closed is null or closed=false) and status=? limit ?,?",
					new BeanListHandler<Apply>(Apply.class), "申请审批中", startIndex, size);
			// 查询关联的客户和班级信息
			for (Apply a : applys) {
				Customer customer = qr.query(
						"select * from customers where id=(select customerId from applys where number=?)",
						new BeanHandler<Customer>(Customer.class), a.getNumber());
				a.setCustomer(customer);
				Classes classes = qr.query(
						"select * from classes where id=(select classesId from applys where number=?)",
						new BeanHandler<Classes>(Classes.class), a.getNumber());
				a.setClasses(classes);
			}
			return applys;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 根据编号查询申请
	 * 
	 * @param number
	 * @return
	 */
	public Apply findByNumber(String number) {
		try {
			Apply apply = qr.query("select * from applys where  number=?", new BeanHandler<Apply>(Apply.class), number);
			// 查询关联的客户和班级信息
			if (apply != null) {
				Customer customer = qr.query(
						"select * from customers where id=(select customerId from applys where number=?)",
						new BeanHandler<Customer>(Customer.class), apply.getNumber());
				apply.setCustomer(customer);
				Classes classes = qr.query(
						"select * from classes where id=(select classesId from applys where number=?)",
						new BeanHandler<Classes>(Classes.class), apply.getNumber());
				apply.setClasses(classes);
			}
			return apply;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 更新申请信息
	 * 
	 * @param apply
	 */
	public void update(Apply apply) {
		try {
			qr.update(
					"update applys set title=?,startDate=?,endDate=?,closed=?,successed=?,status=?,totalGrade=?,classesId=?,customerId=? where number=?",
					apply.getTitle(), apply.getStartDate(), apply.getEndDate(), apply.getClosed(), apply.getSuccessed(),
					apply.getStatus(), apply.getTotalGrade(),
					apply.getClasses() == null ? null : apply.getClasses().getId(),
					apply.getCustomer() == null ? null : apply.getCustomer().getId(), apply.getNumber());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
