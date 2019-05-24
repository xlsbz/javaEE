package com.dhr.web.domain;
/**
 * ��װ������
 * @author Mr DU
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid;//�������
	private Date ordertime;//����ʱ��
	private double total;//�����ܽ��
	private Integer state;//����״̬
	private String address;//�ջ��˵�ַ
	private String name;//����
	private String telephone;//�绰
	private User user;//����:�û�  n:1 ��n��һ����һ��1��һ������
	private List<OrderItem> items = new ArrayList<>();//����:������  1:n  ��1��һ������Ҫ���Է�һ��n��һ���ļ���
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
