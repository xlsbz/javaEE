package cn.dhr.dao;

import cn.dhr.domain.Admin;

/**
 * ����Ա���ݲ�
 * @author Mr DU
 *
 */
public interface AdminDao {

	/**
	 * �û���¼
	 * @param user
	 */
	Admin loginAdmin(String user);

}
