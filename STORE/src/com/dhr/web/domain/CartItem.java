package com.dhr.web.domain;
/**
 * ¹ºÎïÏî
 * @author Mr DU
 *
 */
public class CartItem {
	private Product product;
	private Integer count;
	@SuppressWarnings("unused")
	private double subtotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public double getSubtotal() {
		return product.getShop_price()*count;
	}
//	public void setSubtotal(double subtotal) {
//		this.subtotal = subtotal;
//	}
	public CartItem(Product product, Integer count) {
		super();
		this.product = product;
		this.count = count;
	}
	
}
