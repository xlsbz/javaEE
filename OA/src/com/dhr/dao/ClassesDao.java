package com.dhr.dao;

import java.util.List;

import com.dhr.domain.Classes;

/**
 * 班级信息数据层
 * 
 * @author Mr DU
 *
 */
public interface ClassesDao {
	/**
	 * 获取总记录条数
	 * 
	 * @return
	 */
	int getTotalRecordsNumber();

	/**
	 * 获取分页记录
	 * 
	 * @param startIndex
	 *            开始记录的索引
	 * @param size
	 *            一次取出的记录条数
	 * @return
	 */
	List<Classes> findPageRecords(int startIndex, int size);

	/**
	 * 根据班级类型ID查询总开班个数
	 * 
	 * @param classTypeId
	 * @return
	 */
	int getTotalRecordsNumber(String classTypeId);

	/**
	 * 分页查询班级班级信息
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @param classTypeId
	 * @return
	 */
	List<Classes> findPageRecords(int startIndex, int pageSize, String classTypeId);

	/**
	 * 保存班级基本信息，如果班级关联的课程类型不为null，保存classTypeId
	 * 
	 * @param classes
	 */
	void save(Classes classes);

	/**
	 * 根据课程类型名称查询开班信息
	 * 
	 * @param classTypeName
	 * @return
	 */
	List<Classes> findClassesByClassTypeName(String classTypeName);

	/**
	 * 根据班级ID查询班级
	 * 
	 * @param classesId
	 * @return
	 */
	Classes findById(String classesId);
}
