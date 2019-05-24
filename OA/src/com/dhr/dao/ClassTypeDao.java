package com.dhr.dao;

import java.util.List;

import com.dhr.domain.ClassType;

/**
 * 班级类型数据层
 * 
 * @author Mr DU
 *
 */
public interface ClassTypeDao {

	/**
	 * 查询所有班级类型
	 * 
	 * @return
	 */
	List<ClassType> findAll();

	/**
	 * 增加班级类别信息
	 * 
	 * @param classType
	 */
	void save(ClassType classType);

	/**
	 * 根据ID查询班级类别信息
	 * 
	 * @param classTypeId
	 * @return
	 */
	ClassType findOne(String classTypeId);

}
