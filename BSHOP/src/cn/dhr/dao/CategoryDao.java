package cn.dhr.dao;

import java.util.List;

import cn.dhr.domain.Category;

public interface CategoryDao {

	/**
	 * 查询所有分类
	 * @return
	 * @throws Exception
	 */
	List<Category> getAllCategory() throws Exception;

}
