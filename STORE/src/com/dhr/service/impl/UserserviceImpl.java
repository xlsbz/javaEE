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
	 * 用户登录业务
	 */
	public User loginUser(String username,String password) throws Exception {
		User user = null;
		user = userDao.loginUser(username,password);
		conn.close();
		return user;
	}
	@Override
	/**
	 * 用户注册业务
	 */
	public boolean registerUser(User user) throws Exception {
		boolean flag = false;
		flag = userDao.registerUser(user);
		conn.close();
		return flag;
	}
	@Override
	/**
	 * ajax验证用户
	 */
	public boolean getUserByName(String username) throws Exception{
		boolean msg = true;
		msg = userDao.registerUserByName(username);
		return msg;
	}
	@Override
	/**
	 * 用户修改密码
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
	 * admin---->分页查询
	 */
	public PageBean<User> findAllUser(int pageNumber, int pageSize) throws Exception {
		//创建PageBean  在业务层把他的数据处理好
		PageBean<User> bean = new PageBean<>(pageNumber, pageSize);
		//每页数据
		List<User> allList = userDao.findAllUser(bean);
		bean.setData(allList);
		int count = 0;
		//总数据   一共多少页=Math.cile(总数据*1.0/每页数据)
		count = userDao.getAllUserCount();
		bean.setTotalRecord(count);
		return bean;
	}

}
