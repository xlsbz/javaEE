package cn.dhr.domain;
/**
 * 购物项
 * @author Mr DU
 *
 */
public class CartItem {
	private Product product;//商品
	private Integer count;//数量
	private Double subTotal;//小计
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
	//小计计算
	public Double getSubTotal() {
		return count*product.getPrice();
	}
}
