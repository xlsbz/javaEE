package com.dhr.dao;

import java.util.List;

import com.dhr.domain.Function;

/**
 * 系统功能数据层
 * 
 * @author Mr DU
 *
 */
public interface FunctionDao {

	/**
	 * 查询所有功能
	 * 
	 * @return
	 */
	List<Function> findAll();

	/**
	 * 新增功能
	 * 
	 * @param function
	 */
	void save(Function function);

}
