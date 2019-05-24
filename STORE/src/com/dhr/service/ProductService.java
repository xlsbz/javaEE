package com.dhr.service;

import java.util.List;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public interface ProductService {
	/**
	 * �鿴������Ʒ
	 * @return
	 */
	List<Product> findHot() throws Exception;
	/**
	 * �鿴����
	 * @return
	 * @throws Exception
	 */
	List<Product> findNew() throws Exception;
	/**
	 * ����ϲ��
	 * @return
	 */
	List<Product> findLike() throws Exception;
	/**
	 * Ϊ����ѡ
	 * @return
	 * @throws Exception
	 */
	List<Product> findChoose()throws Exception;
	/**
	 * ��ѯ������Ʒ
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	Product getProductById(String pid)throws Exception;
	/**
	 * ��ҳ��ѯ
	 * @param pageNumber
	 * @param pageSize
	 * @param cid
	 * @return
	 */
	PageBean<Product> findBypage(int pageNumber, int pageSize, String cid)throws Exception;
	/**
	 * �������
	 * @return
	 */
	List<Product> searchProduct(String search)throws Exception;
	
	
	/*--------------------------admin------------------------*/
	/**
	 * ����Ա�鿴�����ϼ���Ʒ
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageBean<Product> findAllProduct(int pageNumber, int pageSize)throws Exception;
	/**
	 * ����Ա�鿴�����¼���Ʒ
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageBean<Product> findAllOutProduct(int pageNumber, int pageSize)throws Exception;
	/**
	 * �޸���Ʒ������Ϣ
	 * @param product
	 * @return
	 * @throws Exception
	 */
	boolean updataProduct(Product product)throws Exception;
	/**
	 * �ϼ���Ʒ
	 * @param product
	 * @throws Exception
	 */
	void save(Product product)throws Exception;

}
