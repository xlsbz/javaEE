package cn.dhr.dao;

import java.util.List;

import cn.dhr.domain.Product;
import cn.dhr.utils.PageBean;

public interface ProductDao {

	/**
	 * ͬ����ʾͼ��
	 * @return
	 * @throws Exception
	 */
	List<Product> getBook()throws Exception;

	/**
	 * ��ʾ�Ĵ����
	 * @return
	 * @throws Exception
	 */
	List<Product> findCategory(String cid)throws Exception;
	/**
	 * ��ʾ������
	 * @return
	 * @throws Exception
	 */
	List<Product> getLikeBook()throws Exception;

	/**
	 * ��ҳ��ѯ������Ʒ
	 * @return
	 * @throws Exception
	 */
	List<Product> findPageNumber(PageBean<Product> bean, String cid);
	

	/**
	 * ��ȡ�ܼ�¼
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	int getAllData(String cid)throws Exception;

	/**
	 * ��ѯ��Ʒ����
	 * @param bid
	 * @return
	 * @throws Exception
	 */
	Product getProductInfo(String bid)throws Exception;


}
