package cn.dhr.service;

import java.util.List;

import cn.dhr.domain.Product;
import cn.dhr.utils.PageBean;

public interface ProductService {
	
	/**
	 * 同步显示图书
	 * @return
	 * @throws Exception
	 */
	List<Product> getNewBook()throws Exception;
	
	/**
	 * 异步显示四大分类
	 * @return
	 * @throws Exception
	 */
	String findCategory(String cid)throws Exception;

	/**
	 * 同步显示首页四大分类图书
	 * @return
	 * @throws Exception
	 */
	List<Product> getCategory()throws Exception;
	
	/**
	 * 同步显示首页分享区
	 * @return
	 * @throws Exception
	 */
	List<Product> getLikeBook()throws Exception;

	/**
	 * 分页查看分类商品
	 * @param pageNumber
	 * @param pageTotal
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	PageBean<Product> findPageNumber(int pageNumber, int pageData, String cid)throws Exception;

	/**
	 * 查询商品详情
	 * @param bid
	 * @return
	 * @throws Exception
	 */
	Product getProductInfo(String bid)throws Exception;

}
