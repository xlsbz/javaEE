package cn.dhr.dao;

import java.util.List;

import cn.dhr.domain.Product;
import cn.dhr.utils.PageBean;

public interface ProductDao {

	/**
	 * 同步显示图书
	 * @return
	 * @throws Exception
	 */
	List<Product> getBook()throws Exception;

	/**
	 * 显示四大分类
	 * @return
	 * @throws Exception
	 */
	List<Product> findCategory(String cid)throws Exception;
	/**
	 * 显示分享区
	 * @return
	 * @throws Exception
	 */
	List<Product> getLikeBook()throws Exception;

	/**
	 * 分页查询分类商品
	 * @return
	 * @throws Exception
	 */
	List<Product> findPageNumber(PageBean<Product> bean, String cid);
	

	/**
	 * 获取总记录
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	int getAllData(String cid)throws Exception;

	/**
	 * 查询商品详情
	 * @param bid
	 * @return
	 * @throws Exception
	 */
	Product getProductInfo(String bid)throws Exception;


}
