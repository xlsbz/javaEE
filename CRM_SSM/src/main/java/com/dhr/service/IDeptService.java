package com.dhr.service;

import java.util.List;

import com.dhr.domain.Dept;

public interface IDeptService {

	/**
	 * 查询所有部门信息
	 * @return 
	 */
	List<Dept> getAllDepts();

}
