package cn.dhr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * ·â×°¶©µ¥
 * @author Mr DU
 *
 */
public class Order {
	private String oid;
	private Double total;
	private Date ordertime;
	private Integer state;
	private String address;
	private User user;
	private List<OrderItem> orderItems = new ArrayList<>();//1:n
	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
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
	
}
