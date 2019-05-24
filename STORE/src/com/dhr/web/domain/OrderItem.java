package com.dhr.web.domain;
/**
 * 封装订单项
 * @author Mr DU
 *
 */
public class OrderItem {
	private String itemid;//订单项id
	private Integer count;//订单项数量
	private double subtotal;//小计
	private Product product;//商品:订单项 1:n 在n的一方放入1的一方的对象
	private Order order;//订单:订单项  1:n  在n的一方放入1的一方的对象
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderItem(String itemid, Integer count, double subtotal, Product product, Order order) {
		super();
		this.itemid = itemid;
		this.count = count;
		this.subtotal = subtotal;
		this.product = product;
		this.order = order;
	}
	public OrderItem() {
		super();
	}
	
}
