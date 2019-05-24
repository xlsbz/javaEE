package com.dhr.service;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;

public interface Userservice {
	/**
	 * �û���¼
	 * @return
	 */
	User loginUser(String username,String password) throws Exception;
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	boolean registerUser(User user)throws Exception;
	/**
	 * ע����֤
	 * @param username
	 * @return
	 */
	boolean getUserByName(String username)throws Exception;
	/**
	 * �޸��û�����
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	boolean updatePassword(String oldPassword, String newPassword,String uid)throws Exception;
	
	/*---------------admin-------------------*/
	/**
	 * ��ҳ��ѯ�û�---->admin
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	PageBean<User> findAllUser(int pageNumber, int pageSize)throws Exception;

}
