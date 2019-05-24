package com.dhr.service;

import java.util.List;

import com.dhr.web.domain.Category;

public interface CategoryService {
	/**
	 * 查询所有分类
	 * @return
	 */
	String findAll() throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Category> findAllCate()throws Exception;
	/**
	 * 通过ID获取分类
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	Category getById(String cid)throws Exception;
	
	
	/*-------------------admin-------------------*/
	/**
	 * 实现修改分类
	 * @param cid
	 * @param cname
	 * @return
	 */
	boolean categoryUpdate(String cid, String cname)throws Exception;
	/**
	 * 删除分类
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	boolean categoryDelete(String cid)throws Exception;
	/**
	 * 添加分类
	 * @param category
	 * @return
	 * @throws Exception
	 */
	boolean categoryAdd(Category category)throws Exception;

}
