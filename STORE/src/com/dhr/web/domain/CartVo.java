package com.dhr.web.domain;

public class CartVo {
	private String uid;//用户id
	private String pid;//商品id
	private int count;//商品数量
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public CartVo() {
		super();
	}
	public CartVo(String uid, String pid,  int count) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.count = count;
	}
	
}
