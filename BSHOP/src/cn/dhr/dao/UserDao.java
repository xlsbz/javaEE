package cn.dhr.dao;

import cn.dhr.domain.User;

/**
 * �û�dao����
 * @author Mr DU
 *
 */
public interface UserDao {
	/**
	 * �����û�����ѯ�û�
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User getByName(String username)throws Exception;
	
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	User loginUser(String username, String password)throws Exception;

	/**
	 * �û�ע��
	 * @param user
	 * @throws Exception
	 */
	void addUser(User user)throws Exception;
}
