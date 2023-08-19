package videoPlay.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderDetailId;
	
	private Integer productId;
	private Integer orderId;
	private Integer productQuantity;
	private Double productPrice;
	private Integer orderDetailCode;
	private Double orderTotal;
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(Integer orderDetailId,Integer productId, Integer orderId, Integer productQuantity, Double productPrice,
			Integer orderDetailCode, Double orderTotal) {
		super();
		this.orderDetailId = orderDetailId;
		this.productId = productId;
		this.orderId = orderId;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.orderDetailCode = orderDetailCode;
		this.orderTotal = orderTotal;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public Integer getOrderDetailCode() {
		return orderDetailCode;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public void setOrderDetailCode(Integer orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
}
