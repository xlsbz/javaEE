package com.dhr.service.impl;

import java.util.List;

import com.dhr.commons.Page;
import com.dhr.dao.ClassTypeDao;
import com.dhr.dao.ClassesDao;
import com.dhr.dao.CustomerStatusDao;
import com.dhr.dao.InfoSourceDao;
import com.dhr.dao.impl.ClassTypeDaoImpl;
import com.dhr.dao.impl.ClassesDaoImpl;
import com.dhr.dao.impl.CustomerStatusDaoImpl;
import com.dhr.dao.impl.InfoSourceDaoImpl;
import com.dhr.domain.ClassType;
import com.dhr.domain.Classes;
import com.dhr.domain.CustomerStatus;
import com.dhr.domain.InfoSource;
import com.dhr.service.ConfigService;

/**
 * 系统管理业务处理
 * 
 * @author Mr DU
 *
 */
public class ConfigServiceImpl implements ConfigService {
	private InfoSourceDao infoSourceDao = new InfoSourceDaoImpl();
	private ClassTypeDao classTypeDao = new ClassTypeDaoImpl();
	private CustomerStatusDao customerStatusDao = new CustomerStatusDaoImpl();
	private ClassesDao classesDao = new ClassesDaoImpl();

	/**
	 * 查询所有信息来源
	 * 
	 * @return
	 */
	public List<InfoSource> findAllInfoSources() {
		return infoSourceDao.findAll();
	}

	/**
	 * 新增信息来源
	 * 
	 * @param infoSource
	 */
	public void addInfoSource(InfoSource infoSource) {
		infoSourceDao.save(infoSource);
	}

	/**
	 * 根据ID查询信息来源
	 * 
	 * @param infoSourceId
	 * @return
	 */
	public InfoSource findInfoSourceById(String infoSourceId) {
		return infoSourceDao.findOne(infoSourceId);
	}

	/**
	 * 修改信息来源
	 * 
	 * @param infoSource
	 */
	public void editInfoSource(InfoSource infoSource) {
		if (infoSource == null)
			throw new IllegalArgumentException("信息来源为空!!!");
		if (infoSource.getId() == null)
			throw new IllegalArgumentException("没有设置ID");
		infoSourceDao.update(infoSource);
	}

	/**
	 * 删除指定信息来源
	 * 
	 * @param infoSourceId
	 */
	public void delInfoSource(String infoSourceId) {
		infoSourceDao.delete(infoSourceId);
	}

	/**
	 * 批量删除信息来源表的数据
	 * 
	 * @param infoSourceIds
	 */
	public void delMultiInfoSource(String[] infoSourceIds) {
		infoSourceDao.delete(infoSourceIds);
	}

	/**
	 * 查询所有班级类型
	 * 
	 * @return
	 */
	public List<ClassType> findAllClassTypes() {
		return classTypeDao.findAll();
	}

	/**
	 * 根据课程类型ID查询这个课程类型
	 * 
	 * @param classTypeId
	 * @return
	 */
	public ClassType findClassTypeById(String classTypeId) {
		return classTypeDao.findOne(classTypeId);
	}

	/**
	 * 新增课程类型
	 * 
	 * @param classType
	 */
	public void addClassType(ClassType classType) {
		classTypeDao.save(classType);
	}

	/**
	 * 查询所有客户状态
	 * 
	 * @return
	 */
	public List<CustomerStatus> findAllCustomerStatus() {
		return customerStatusDao.findAll();
	}

	/**
	 * 根据客户状态ID查询这个客户状态
	 * 
	 * @param customerStatusId
	 * @return
	 */
	public CustomerStatus findCustomerStatusById(String customerStatusId) {
		return customerStatusDao.findOne(customerStatusId);
	}

	/**
	 * 新增客户状态
	 * 
	 * @param customerStatus
	 */
	public void addCustomerStatus(CustomerStatus customerStatus) {
		customerStatusDao.save(customerStatus);
	}

	/**
	 * 分页查询所有开班 信息
	 * 
	 * @param num
	 * @return
	 */
	public Page findClasses(String num) {
		int pageNum = 1;
		if (num != null && !"".equals(num)) {
			pageNum = Integer.parseInt(num);
		}
		// 获取总记录
		int totalRecordsNumber = classesDao.getTotalRecordsNumber();
		// 创建封装page对象
		Page page = new Page(pageNum, totalRecordsNumber);
		// 查询记录
		List<Classes> records = classesDao.findPageRecords(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

	/**
	 * 查询某个分类下的所有开班信息
	 * 
	 * @param num
	 * @param classTypeId
	 * @return
	 */
	public Page findClasses(String num, String classTypeId) {
		int pageNum = 1;
		if (num != null && !"".equals(num)) {
			pageNum = Integer.parseInt(num);
		}
		int totalRecordsNumber = classesDao.getTotalRecordsNumber(classTypeId);
		Page page = new Page(pageNum, totalRecordsNumber);
		// 查询记录
		List<Classes> records = classesDao.findPageRecords(page.getStartIndex(), page.getPageSize(), classTypeId);
		page.setRecords(records);
		return page;
	}

	/**
	 * 添加开班信息
	 * 
	 * @param classes
	 */
	public void addClasses(Classes classes) {
		if (classes == null)
			throw new IllegalArgumentException("参数为空!!!");
		if (classes.getClassType() == null)
			throw new IllegalArgumentException("班级必须指定课程类型");
		classesDao.save(classes);
	}

	/**
	 * 根据课程类型名查询这个课程类型下的所有开班信息
	 * 
	 * @param classTypeName
	 * @return
	 */
	public List<Classes> findClassesByClassTypeName(String classTypeName) {
		return classesDao.findClassesByClassTypeName(classTypeName);
	}

	/**
	 * 根据班级ID查询班级信息
	 * 
	 * @param classesId
	 * @return
	 */
	public Classes findClassesById(String classesId) {
		return classesDao.findById(classesId);
	}

}
