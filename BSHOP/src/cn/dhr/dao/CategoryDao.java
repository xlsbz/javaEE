package cn.dhr.dao;

import java.util.List;

import cn.dhr.domain.Category;

public interface CategoryDao {

	/**
	 * ��ѯ���з���
	 * @return
	 * @throws Exception
	 */
	List<Category> getAllCategory() throws Exception;

}
