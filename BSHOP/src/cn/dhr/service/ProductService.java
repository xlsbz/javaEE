package cn.dhr.service;

import java.util.List;

import cn.dhr.domain.Product;
import cn.dhr.utils.PageBean;

public interface ProductService {
	
	/**
	 * ͬ����ʾͼ��
	 * @return
	 * @throws Exception
	 */
	List<Product> getNewBook()throws Exception;
	
	/**
	 * �첽��ʾ�Ĵ����
	 * @return
	 * @throws Exception
	 */
	String findCategory(String cid)throws Exception;

	/**
	 * ͬ����ʾ��ҳ�Ĵ����ͼ��
	 * @return
	 * @throws Exception
	 */
	List<Product> getCategory()throws Exception;
	
	/**
	 * ͬ����ʾ��ҳ������
	 * @return
	 * @throws Exception
	 */
	List<Product> getLikeBook()throws Exception;

	/**
	 * ��ҳ�鿴������Ʒ
	 * @param pageNumber
	 * @param pageTotal
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	PageBean<Product> findPageNumber(int pageNumber, int pageData, String cid)throws Exception;

	/**
	 * ��ѯ��Ʒ����
	 * @param bid
	 * @return
	 * @throws Exception
	 */
	Product getProductInfo(String bid)throws Exception;

}
