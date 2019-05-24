package com.dhr.service.impl;

import java.util.List;

import com.dhr.commons.Page;
import com.dhr.dao.ApplyDao;
import com.dhr.dao.impl.ApplyDaoImpl;
import com.dhr.domain.Apply;
import com.dhr.domain.Customer;
import com.dhr.service.ApplyService;

/**
 * 申请业务处理
 * 
 * @author Mr DU
 *
 */
public class ApplyServiceImpl implements ApplyService {
	private ApplyDao applyDao = new ApplyDaoImpl();

	/**
	 * 生成申请
	 * 
	 * @param apply
	 */
	public void genApply(Apply apply) {
		if (apply == null) {
			throw new RuntimeException("申请不能为空");
		}
		if (apply.getClasses() == null) {
			throw new RuntimeException("申请必须指定班级");
		}
		if (apply.getCustomer() == null) {
			throw new RuntimeException("申请必须指定申请人");
		}
		applyDao.save(apply);
	}

	/**
	 * 检查申请次数
	 * 
	 * @param customer
	 * @return
	 */
	public int checkApplyCount(Customer customer) {
		List<Apply> applys = applyDao.findByCustomer(customer.getId());
		return applys.size();
	}

	/**
	 * 检查申请状态
	 * 
	 * @param customer
	 * @return
	 */
	public boolean checkIsClosed(Customer customer) {
		List<Apply> applys = applyDao.findByCustomer(customer.getId());
		boolean hasUnClosedApply = false;
		for (Apply a : applys) {
			if (a.getClosed() == null || !a.getClosed()) {
				hasUnClosedApply = true;
				break;
			}
		}
		return hasUnClosedApply;
	}

	/**
	 * 分页查询所有没有关闭的申请
	 * 
	 * @param num
	 * @return
	 */
	public Page findAllNotClosedApplys(String num) {
		int pageNum = 1;
		if (num != null) {
			pageNum = Integer.parseInt(num);
		}
		// 查询总记录
		int totalRecordsNumber = applyDao.findNotClosedApplyNumber();
		Page page = new Page(pageNum, totalRecordsNumber);
		// 查询每页数据
		List<Apply> records = applyDao.findNotClosedApply(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

	/**
	 * 根据编号查询申请
	 * 
	 * @param number
	 * @return
	 */
	public Apply findApplyByNumber(String number) {
		return applyDao.findByNumber(number);
	}

	/**
	 * 更新申请信息
	 * 
	 * @param apply
	 */
	public void update(Apply apply) {
		applyDao.update(apply);
	}

}
