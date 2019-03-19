package cn.dhr.service.impl;

import cn.dhr.dao.UserDao;
import cn.dhr.dao.impl.UserDaoImpl;
import cn.dhr.domain.User;
import cn.dhr.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User getByName(String username) throws Exception {
		UserDao ud = new UserDaoImpl();
		return ud.getByName(username);
	}

	@Override
	public User loginUser(String username, String password) throws Exception {
		UserDao ud = new UserDaoImpl();
		return ud.loginUser(username,password);
	}

	@Override
	public void addUser(User user) throws Exception {
		UserDao ud = new UserDaoImpl();
		ud.addUser(user);
	}

}
