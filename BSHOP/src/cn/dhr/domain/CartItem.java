package cn.dhr.domain;
/**
 * ������
 * @author Mr DU
 *
 */
public class CartItem {
	private Product product;//��Ʒ
	private Integer count;//����
	private Double subTotal;//С��
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
	//С�Ƽ���
	public Double getSubTotal() {
		return count*product.getPrice();
	}
}
