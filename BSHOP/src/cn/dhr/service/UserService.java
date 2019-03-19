package cn.dhr.service;

import cn.dhr.domain.User;

public interface UserService {
	
	/**
	 * �鿴�û��Ƿ����
	 * @param username
	 * @return
	 */
	User getByName(String username) throws Exception;
	
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
