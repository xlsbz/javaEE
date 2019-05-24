package com.dhr.web.domain;
/**
 * 封装订单表
 * @author Mr DU
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid;//订单编号
	private Date ordertime;//订单时间
	private double total;//订单总金额
	private Integer state;//订单状态
	private String address;//收货人地址
	private String name;//姓名
	private String telephone;//电话
	private User user;//订单:用户  n:1 在n的一方放一个1的一方对象
	private List<OrderItem> items = new ArrayList<>();//订单:订单项  1:n  在1的一方有需要可以放一个n的一方的集合
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public Order(String oid, Date ordertime, double total, Integer state, String address, String name, String telephone,
			User user, List<OrderItem> items) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.state = state;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.user = user;
		this.items = items;
	}
	public Order() {
		super();
	}
	
}
