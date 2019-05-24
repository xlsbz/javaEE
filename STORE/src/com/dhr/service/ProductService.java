package com.dhr.service;

import java.util.List;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public interface ProductService {
	/**
	 * 查看热门商品
	 * @return
	 */
	List<Product> findHot() throws Exception;
	/**
	 * 查看最新
	 * @return
	 * @throws Exception
	 */
	List<Product> findNew() throws Exception;
	/**
	 * 猜你喜欢
	 * @return
	 */
	List<Product> findLike() throws Exception;
	/**
	 * 为你推选
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
	Product getProductById(String pid)throws Exception;
	/**
	 * 分页查询
	 * @param pageNumber
	 * @param pageSize
	 * @param cid
	 * @return
	 */
	PageBean<Product> findBypage(int pageNumber, int pageSize, String cid)throws Exception;
	/**
	 * 点击搜索
	 * @return
	 */
	List<Product> searchProduct(String search)throws Exception;
	
	
	/*--------------------------admin------------------------*/
	/**
	 * 管理员查看所有上架商品
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageBean<Product> findAllProduct(int pageNumber, int pageSize)throws Exception;
	/**
	 * 管理员查看所有下架商品
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageBean<Product> findAllOutProduct(int pageNumber, int pageSize)throws Exception;
	/**
	 * 修改商品部分信息
	 * @param product
	 * @return
	 * @throws Exception
	 */
	boolean updataProduct(Product product)throws Exception;
	/**
	 * 上架商品
	 * @param product
	 * @throws Exception
	 */
	void save(Product product)throws Exception;

}
