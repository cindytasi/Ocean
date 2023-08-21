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
	
	private Double Payable;
	private String shippingTextValue;
	private String fullName;
	private String phone;
	private String address;
	private String email;
	private String productSize;
	private String productColor;
	private String productName;
	private Integer ItemsQuantity;
	private Integer shipping;
	private String deliveryMethod;
	private String paymentMethod;
	private Double Subtotal;
	
	public OrderDetail() {
		
	}
	
	
	
	public OrderDetail(Integer orderDetailId, Integer productId, Integer orderId, Integer productQuantity,
			Double productPrice, Integer orderDetailCode, Double payable, String shippingTextValue, String fullName,
			String phone, String address, String email, String productSize, String productColor, String productName,
			Integer itemsQuantity, Integer shipping, String deliveryMethod, String paymentMethod, Double subtotal) {
		super();
		this.orderDetailId = orderDetailId;
		this.productId = productId;
		this.orderId = orderId;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.orderDetailCode = orderDetailCode;
		this.Payable = payable;
		this.shippingTextValue = shippingTextValue;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.productSize = productSize;
		this.productColor = productColor;
		this.productName = productName;
		this.ItemsQuantity = itemsQuantity;
		this.shipping = shipping;
		this.deliveryMethod = deliveryMethod;
		this.paymentMethod = paymentMethod;
		this.Subtotal = subtotal;
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

	public Double getPayable() {
		return Payable;
	}

	public String getShippingTextValue() {
		return shippingTextValue;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getProductSize() {
		return productSize;
	}

	public String getProductColor() {
		return productColor;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getItemsQuantity() {
		return ItemsQuantity;
	}

	public Integer getShipping() {
		return shipping;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public Double getSubtotal() {
		return Subtotal;
	}

	public void setPayable(Double payable) {
		Payable = payable;
	}

	public void setShippingTextValue(String shippingTextValue) {
		this.shippingTextValue = shippingTextValue;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setItemsQuantity(Integer itemsQuantity) {
		ItemsQuantity = itemsQuantity;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setSubtotal(Double subtotal) {
		Subtotal = subtotal;
	}
	
	
}
