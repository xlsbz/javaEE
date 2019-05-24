package com.dhr.service;

import java.util.List;

import com.dhr.web.domain.Category;

public interface CategoryService {
	/**
	 * ��ѯ���з���
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
	 * ͨ��ID��ȡ����
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	Category getById(String cid)throws Exception;
	
	
	/*-------------------admin-------------------*/
	/**
	 * ʵ���޸ķ���
	 * @param cid
	 * @param cname
	 * @return
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
