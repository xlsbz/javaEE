package com.dhr.dao;

import java.util.List;

import com.dhr.domain.Apply;

/**
 * 数据接口
 * 
 * @author Mr DU
 *
 */
public interface ApplyDao {

	/**
	 * 保存申请
	 * 
	 * @param apply
	 */
	void save(Apply apply);

	/**
	 * 根据客户的id查询他的所有申请
	 * 
	 * @param id
	 * @return
	 */
	List<Apply> findByCustomer(Integer customerId);

	/**
	 * 查询未关闭的申请的条数
	 * 
	 * @return
	 */
	int findNotClosedApplyNumber();

	/**
	 * 查询未关闭的申请.分页。状态是“申请审批中”
	 * 
	 * @return
	 */
	List<Apply> findNotClosedApply(int startIndex, int size);

	/**
	 * 根据申请编号查询申请,同时把申请对应的客户和班级信息查询出来。状态是“申请审批中”
	 * 
	 * @param number
	 * @return
	 */
	Apply findByNumber(String number);

	/**
	 * 更新
	 * 
	 * @param apply
	 */
	void update(Apply apply);

}
