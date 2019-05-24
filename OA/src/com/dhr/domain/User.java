package com.dhr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员
 * 
 * @author Mr DU
 *
 */
public class User implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private String nickname;// 昵称

	private List<Role> roles = new ArrayList<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
