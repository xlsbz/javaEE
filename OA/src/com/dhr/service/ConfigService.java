package com.dhr.service;

import java.util.List;

import com.dhr.commons.Page;
import com.dhr.domain.ClassType;
import com.dhr.domain.Classes;
import com.dhr.domain.CustomerStatus;
import com.dhr.domain.InfoSource;

/**
 * 系统相关配置
 * 
 * @author Mr DU
 *
 */
public interface ConfigService {
	/**
	 * 查询所有的信息来源
	 * 
	 * @return List<InfoSource>
	 */
	List<InfoSource> findAllInfoSources();

	/**
	 * 添加信息来源
	 * 
	 * @param infoSource
	 */
	void addInfoSource(InfoSource infoSource);

	/**
	 * 根据id查询信息来源
	 * 
	 * @param infoSourceId
	 * @return
	 */
	InfoSource findInfoSourceById(String infoSourceId);

	/**
	 * 保存修改后的信息来源
	 * 
	 * @param infoSource
	 */
	void editInfoSource(InfoSource infoSource);

	/**
	 * 删除信息来源
	 * 
	 * @param infoSourceId
	 */
	void delInfoSource(String infoSourceId);

	/**
	 * 批量删除信息来源
	 * 
	 * @param ids
	 */
	void delMultiInfoSource(String[] infoSourceIds);

	/**
	 * 查询所有的课程类型
	 * 
	 * @return
	 */
	List<ClassType> findAllClassTypes();

	/**
	 * 根据ID查询课程类型
	 * 
	 * @param classTypeId
	 * @return
	 */
	ClassType findClassTypeById(String classTypeId);

	/**
	 * 新增课程类型
	 * 
	 * @param classType
	 */
	void addClassType(ClassType classType);

	/**
	 * 查询所有客户状态
	 * 
	 * @return
	 */
	List<CustomerStatus> findAllCustomerStatus();

	/**
	 * 根据客户状态ID查询客户状态
	 * 
	 * @param customerStatusId
	 * @return
	 */
	CustomerStatus findCustomerStatusById(String customerStatusId);

	/**
	 * 新增学生状态
	 * 
	 * @param customerStatus
	 */
	void addCustomerStatus(CustomerStatus customerStatus);

	/**
	 * 查询所有班级信息 根据用户要看的页码，查询封装了所有分页信息的Page对象
	 * 
	 * @param num
	 *            用户要看的页码，如果为null，默认是看第1页
	 * @return
	 */
	Page findClasses(String num);

	/**
	 * 根据用户要看的页码，和班级类型，查询封装了所有分页信息的Page对象 查询某个班级类型下的所有班级信息
	 * 
	 * @param num
	 * @param classTypeId班级类型的id
	 * @return
	 */
	Page findClasses(String num, String classTypeId);

	/**
	 * 添加开班信息。一个班级必须指定课程类型
	 * 
	 * @param classes
	 */
	void addClasses(Classes classes);

	/**
	 * 根据课程类型名称，查询开班信息
	 * 
	 * @param classType
	 * @return
	 */
	List<Classes> findClassesByClassTypeName(String classType);

	/**
	 * 根据班级id查询班级信息
	 * 
	 * @param classesId
	 * @return
	 */
	Classes findClassesById(String classesId);

}
