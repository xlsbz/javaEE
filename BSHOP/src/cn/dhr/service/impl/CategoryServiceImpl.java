package cn.dhr.service.impl;

import java.util.List;

import cn.dhr.dao.CategoryDao;
import cn.dhr.dao.impl.CategoryDaoImpl;
import cn.dhr.domain.Category;
import cn.dhr.service.CategoryService;
import cn.dhr.utils.JsonUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public String getAllCategory() throws Exception {
		CategoryDao cd = new CategoryDaoImpl();
		List<Category> cateList = cd.getAllCategory();
		String category = JsonUtil.list2json(cateList);
		return category;
	}

}
