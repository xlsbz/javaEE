package cn.dhr.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.dhr.dao.UserDao;
import cn.dhr.domain.User;
import cn.dhr.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User getByName(String username) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "select * from user where username=?";
		User user = qr.query(sql, new BeanHandler<>(User.class),username);
		return user;
	}

	@Override
	public User loginUser(String username, String password) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "select * from user where username=? and password=?";
		User user = qr.query(sql, new BeanHandler<>(User.class),username,password);
		return user;
	}

	@Override
	public void addUser(User user) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSouerce());
		String sql = "insert into user(uid,username,password,email) values(?,?,?,?)";
		qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getEmail());
	}

}
