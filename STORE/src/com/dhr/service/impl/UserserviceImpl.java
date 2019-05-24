package com.dhr.service.impl;

import java.util.List;

import com.dhr.conn.Conn;
import com.dhr.dao.UserDao;
import com.dhr.dao.impl.UserDaoImpl;
import com.dhr.service.Userservice;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;

public class UserserviceImpl implements Userservice{
	private Conn conn = null;
	UserDao userDao = null;
	public  UserserviceImpl() {
		conn= new Conn();
		userDao =  new UserDaoImpl(conn.getConnection());
	}
	@Override
	/**
	 * �û���¼ҵ��
	 */
	public User loginUser(String username,String password) throws Exception {
		User user = null;
		user = userDao.loginUser(username,password);
		conn.close();
		return user;
	}
	@Override
	/**
	 * �û�ע��ҵ��
	 */
	public boolean registerUser(User user) throws Exception {
		boolean flag = false;
		flag = userDao.registerUser(user);
		conn.close();
		return flag;
	}
	@Override
	/**
	 * ajax��֤�û�
	 */
	public boolean getUserByName(String username) throws Exception{
		boolean msg = true;
		msg = userDao.registerUserByName(username);
		return msg;
	}
	@Override
	/**
	 * �û��޸�����
	 */
	public boolean updatePassword(String oldPassword, String newPassword,String uid) throws Exception {
		boolean flag = false;
		flag = userDao.updatePassword(oldPassword,newPassword,uid);
		conn.close();
		return flag;
	}
	
	
	/*--------------------------admin------------------------------*/
	@Override
	/**
	 * admin---->��ҳ��ѯ
	 */
	public PageBean<User> findAllUser(int pageNumber, int pageSize) throws Exception {
		//����PageBean  ��ҵ�����������ݴ����
		PageBean<User> bean = new PageBean<>(pageNumber, pageSize);
		//ÿҳ����
		List<User> allList = userDao.findAllUser(bean);
		bean.setData(allList);
		int count = 0;
		//������   һ������ҳ=Math.cile(������*1.0/ÿҳ����)
		count = userDao.getAllUserCount();
		bean.setTotalRecord(count);
		return bean;
	}

}
