package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;

public interface ProductDao {
	/**
	 * ��ѯ������Ʒ
	 * @return
	 */
	List<Product> findHot() throws Exception;
	/**
	 * �鿴������Ʒ
	 * @return
	 * @throws Exception
	 */
	List<Product> findNew() throws Exception;
	/**
	 * �鿴ϲ����Ʒ
	 * @return
	 * @throws Exception
	 */
	List<Product> findLike()throws Exception;
	/**
	 * �鿴Ϊ����ѡ
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
	Product getProductById(String pid) throws Exception;
	/**
	 * ��ҳ��ѯ  ���õ�ǰҳ����
	 * @param pagebean
	 * @param cid
	 * @return
	 */
	List<Product> findByPage(PageBean<Product> pagebean, String cid)throws Exception;
	/**
	 * ��ѯ����ĳ�������ܼ�¼
	 * @param cid
	 * @return
	 */
	int getTotalRecord(String cid)throws Exception;
	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	List<Product> searchProduct(String search)throws Exception;
	/**
	 * ��ѯ�����ϼ���Ʒadmin
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	List<Product> findByPage(PageBean<Product> pageBean)throws Exception;
	/**
	 * ��ѯ�����¼���Ʒadmin
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	List<Product> findByPageOut(PageBean<Product> pageBean)throws Exception;
	/**
	 * ������admin
	 * @return
	 * @throws Exception
	 */
	int getTotalRecord()throws Exception;
	/**
	 * �޸���Ʒ������Ϣ
	 * @param product
	 * @return
	 * @throws Exception
	 */
	boolean updataProduct(Product product)throws Exception;
	/**
	 * �¼�������admin
	 * @return
	 * @throws Exception
	 */
	int getTotalRecordOut()throws Exception;
	/**
	 * �ϼ���Ʒ
	 * @param product
	 */
	void save(Product product) throws Exception;


}
