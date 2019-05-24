package com.dhr.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dhr.dao.UserDao;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;;
public class UserDaoImpl implements UserDao{
	private Connection conn;
	private PreparedStatement prep = null;
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	/**
	 * 用户登录
	 */
	public User loginUser(String username, String password) throws SQLException {
		User user = null;
		String sql = "SELECT * FROM user WHERE username=? and password=? limit 1";
		prep = conn.prepareStatement(sql);
		prep.setString(1, username);
		prep.setString(2, password);
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setUid(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setName(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setTelephone(rs.getString(6));
			user.setBirthday(rs.getString(7));
			user.setSex(rs.getString(8));
			user.setState(rs.getString(9));
			user.setCode(rs.getString(10));
		}
		return user;
	}
	@Override
	/**
	 * 用户注册
	 */
	public boolean registerUser(User user) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO user(uid,username,password,name,email,telephone,birthday,sex)VALUES(?,?,?,?,?,?,?,?)";
		prep = conn.prepareStatement(sql);
		prep.setString(1, user.getUid());
		prep.setString(2, user.getUsername());
		prep.setString(3, user.getPassword());
		prep.setString(4, user.getName());
		prep.setString(5, user.getEmail());
		prep.setString(6, user.getTelephone());
		prep.setString(7, user.getBirthday());
		prep.setString(8, user.getSex());
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	@Override
	/**
	 * 注册验证
	 */
	public boolean registerUserByName(String username) throws Exception {
		boolean msg = true;
		String sql = "SELECT * FROM user WHERE username=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, username);
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			msg = false;
		}
		return msg;
	}
	@Override
	/**
	 * 用户修改密码
	 */
	public boolean updatePassword(String oldPassword, String newPassword,String uid) throws Exception {
		boolean flag = false;
		String sql = "UPDATE user SET password=? WHERE password=? and uid=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, newPassword);
		prep.setString(2, oldPassword);
		prep.setString(3, uid);
		if(prep.executeUpdate()>0) {
			flag = true;
		}
		return flag;
	}
	
	/*---------------admin-------------------*/
	@Override
	/**
	 * 分页查询所以用户----->admin
	 */
	public List<User> findAllUser(PageBean<User> bean) throws Exception {
		List<User> userList = new ArrayList<>();
		User user = null;
		String sql = "SELECT * FROM user limit ?,?";
		prep = conn.prepareStatement(sql);
		prep.setInt(1, bean.getStartIndex());
		prep.setInt(2, bean.getPageSize());
		ResultSet rs = null;
		rs = prep.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setUid(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setName(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setTelephone(rs.getString(6));
			user.setBirthday(rs.getString(7));
			user.setSex(rs.getString(8));
			userList.add(user);
		}
		return userList;
	}
	@Override
	/**
	 * 获取总记录
	 */
	public int getAllUserCount() throws Exception {
		int count=0;
		String sql = "SELECT COUNT(*) FROM user";
		prep = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = prep.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

}
