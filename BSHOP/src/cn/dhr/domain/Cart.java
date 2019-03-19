package cn.dhr.domain;
/**
 * ���ﳵ ---->������+�ܽ��
 * @author Mr DU
 *
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Cart {
	private Map<String, CartItem> cartMap = new HashMap<>();
	private Double total = 0.0;//�ܽ��
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
	 * ��ӵ����ﳵ
	 * @param bid
	 * @param count
	 * @return
	 */
	public void add2Cart(CartItem cartItem) {
		String bid = cartItem.getProduct().getBid();
		if(cartMap.containsKey(bid)) {
			//���ڵĻ�����ԭ���������ϼ����µ�����
			CartItem oldItem = cartMap.get(bid);
			oldItem.setCount(cartItem.getCount()+oldItem.getCount());
		}else {
			//�����ھ�ֱ��put
			cartMap.put(bid, cartItem);
		}
		//��Ǯ����
		total += cartItem.getSubTotal();
	}

	/**
	 * �Ƴ����ﳵ
	 * @param bid
	 */
	public void delete2Cart(String bid) {
		//�Ƴ��������ر��Ƴ��Ķ���
		CartItem cartItem = cartMap.remove(bid);
		total -= cartItem.getSubTotal();
	}

	/**
	 * ��չ��ﳵ
	 */
	public void clear2Cart() {
		cartMap.clear();
		total = 0.0;
	}
	
}
