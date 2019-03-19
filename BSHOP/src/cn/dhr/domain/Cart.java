package cn.dhr.domain;
/**
 * 购物车 ---->购物项+总金额
 * @author Mr DU
 *
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Cart {
	private Map<String, CartItem> cartMap = new HashMap<>();
	private Double total = 0.0;//总金额
	private CartItem cartItems;

	public Collection<CartItem> getCartItems(){
		return cartMap.values();
	}
	
	public Map<String, CartItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<String, CartItem> cartMap) {
		this.cartMap = cartMap;
	}

	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * 添加到购物车
	 * @param bid
	 * @param count
	 * @return
	 */
	public void add2Cart(CartItem cartItem) {
		String bid = cartItem.getProduct().getBid();
		if(cartMap.containsKey(bid)) {
			//存在的话就在原来的数量上加上新的数量
			CartItem oldItem = cartMap.get(bid);
			oldItem.setCount(cartItem.getCount()+oldItem.getCount());
		}else {
			//不存在就直接put
			cartMap.put(bid, cartItem);
		}
		//金钱加上
		total += cartItem.getSubTotal();
	}

	/**
	 * 移除购物车
	 * @param bid
	 */
	public void delete2Cart(String bid) {
		//移除它，返回被移除的对象
		CartItem cartItem = cartMap.remove(bid);
		total -= cartItem.getSubTotal();
	}

	/**
	 * 清空购物车
	 */
	public void clear2Cart() {
		cartMap.clear();
		total = 0.0;
	}
	
}
