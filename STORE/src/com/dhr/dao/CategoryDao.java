package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.Category;

public interface CategoryDao {
	/**
	 * ��ѯ���з���
	 * @return
	 */
	List<Category> findAll() throws Exception;
	/**
	 * ͨ��ID��ȡ
	 * @param cid
	 * @return
	 */
	Category getById(String cid)throws Exception;
	
	/*----------------admin--------------------*/
	/**
	 * ʵ���޸ķ���
	 * @param cid
	 * @param cname
	 * @return
	 * @throws Exception
	 */
	boolean categoryUpdate(String cid, String cname)throws Exception;
	/**
	 * ɾ������
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	boolean categoryDelete(String cid)throws Exception;
	/**
	 * ��ӷ���
	 * @param category
	 * @return
	 * @throws Exception
	 */
	boolean categoryAdd(Category category)throws Exception;
	
}
