package com.dhr.web.domain;
/**
 * 购物车
 * @author Mr DU
 *
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> itemMap = new HashMap<>();
	private double total = 0.0;
	//获取所有map数据
	public Collection<CartItem> getCartItems(){
		return itemMap.values();
	}
	public Map<String, CartItem> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<String, CartItem> itemMap) {
		this.itemMap = itemMap;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	/**
	 * 添加到购物车
	 */
	public void add2Cart(CartItem cartItem) {
		String pid = cartItem.getProduct().getPid();
		if(itemMap.containsKey(pid)) {
			CartItem oitem = itemMap.get(pid);
			//如果是同一个商品就在原来的数量上+新添加的数量
			oitem.setCount(oitem.getCount()+cartItem.getCount());
		}else {
			itemMap.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}
	
	public void removeProduct(String pid) {
		CartItem cartItem = itemMap.remove(pid);
		total -= cartItem.getSubtotal();
	}
	public void clearCart() {
		itemMap.clear();
		total = 0.0;
	}
}
