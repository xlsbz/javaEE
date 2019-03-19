package cn.dhr.domain;
/**
 * 用户模型
 * @author Mr DU
 *
 */
public class User {
	/**
	 * CREATE TABLE `user` (
	  `uid` VARCHAR(32) NOT NULL,
	  `username` VARCHAR(50) NOT NULL,
	  `password` VARCHAR(50) NOT NULL,
	  `email` VARCHAR(50) NOT NULL,
	  `state` TINYINT(1) DEFAULT NULL,
	  `code` VARCHAR(64) DEFAULT NULL,
	  PRIMARY KEY (`uid`),
	  UNIQUE KEY `username` (`username`)
	) ENGINE=INNODB DEFAULT CHARSET=utf8;
	 */
	private String uid;
	private String username;
	private String password;
	private String email;
	private Integer state;
	private String code;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
