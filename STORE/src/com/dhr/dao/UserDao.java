package com.dhr.dao;

import java.util.List;

import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;

public interface UserDao {
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	User loginUser(String username, String password) throws Exception;
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	boolean registerUser(User user)throws Exception;
	/**
	 * �û�ע����֤
	 * @param username
	 * @return
	 */
	boolean registerUserByName(String username)throws Exception;
	/**
	 * �޸�����
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	boolean updatePassword(String oldPassword, String newPassword,String uid)throws Exception;
	
	
	/*---------------admin-------------------*/
	/**
	 * ��ҳ��ѯ�û�----->admin
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	List<User> findAllUser(PageBean<User> bean)throws Exception;
	/**
	 * �û��ܸ���
	 * @return
	 * @throws Exception
	 */
	int getAllUserCount() throws Exception;

}
