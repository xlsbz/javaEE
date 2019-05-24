package com.dhr.web.domain;
/**
 * ��װ������
 * @author Mr DU
 *
 */
public class OrderItem {
	private String itemid;//������id
	private Integer count;//����������
	private double subtotal;//С��
	private Product product;//��Ʒ:������ 1:n ��n��һ������1��һ���Ķ���
	private Order order;//����:������  1:n  ��n��һ������1��һ���Ķ���
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
