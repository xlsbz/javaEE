package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public interface ProductDao {
	/**
	 * 查询热门商品
	 * @return
	 */
	List<Product> findHot() throws Exception;
	/**
	 * 查看最新商品
	 * @return
	 * @throws Exception
	 */
	List<Product> findNew() throws Exception;
	/**
	 * 查看喜欢商品
	 * @return
	 * @throws Exception
	 */
	List<Product> findLike()throws Exception;
	/**
	 * 查看为你推选
	 * @return
	 * @throws Exception
	 */
	List<Product> findChoose()throws Exception;
	/**
	 * 查询单个商品
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	Product getProductById(String pid) throws Exception;
	/**
	 * 分页查询  设置当前页数据
	 * @param pagebean
	 * @param cid
	 * @return
	 */
	List<Product> findByPage(PageBean<Product> pagebean, String cid)throws Exception;
	/**
	 * 查询设置某个分类总记录
	 * @param cid
	 * @return
	 */
	int getTotalRecord(String cid)throws Exception;
	/**
	 * 点击搜索
	 * @return
	 * @throws Exception
	 */
	List<Product> searchProduct(String search)throws Exception;
	/**
	 * 查询所有上架商品admin
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	List<Product> findByPage(PageBean<Product> pageBean)throws Exception;
	/**
	 * 查询所有下架商品admin
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	List<Product> findByPageOut(PageBean<Product> pageBean)throws Exception;
	/**
	 * 总数据admin
	 * @return
	 * @throws Exception
	 */
	int getTotalRecord()throws Exception;
	/**
	 * 修改商品部分信息
	 * @param product
	 * @return
	 * @throws Exception
	 */
	boolean updataProduct(Product product)throws Exception;
	/**
	 * 下架总数据admin
	 * @return
	 * @throws Exception
	 */
	int getTotalRecordOut()throws Exception;
	/**
	 * 上架商品
	 * @param product
	 */
	void save(Product product) throws Exception;


}
