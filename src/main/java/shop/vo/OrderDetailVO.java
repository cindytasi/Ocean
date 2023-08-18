package shop.vo;

import java.sql.Date;

public class OrderDetailVO {
	private int orderDetailId;
	private int productId;
	private int orderId;
	private int productQuantity; //單個商品數量
	private double productPrice;
	private String productSize;
	private String productColor;
	private String productName;
	private int ItemsQuantity;  //所有商品數量(加總同廠商)
	private int shipping;
	private double Payable;  //商品總金額(不含運費)
	private String shippingTextValue;
	private String fullName;
	private String phone;
	private String address;
	private String email;
	private int userId;
	private double orderTotal;
	private int payFlowType;
	private int comId;
	private String HODateOrderDetailId;
	private Date orderDate;
	private String deliveryMethod;//會顯示中文:宅配
	private String paymentMethod;//會顯示中文:貨到付款 or 線上刷卡
	private double Subtotal;//小計 1個商品單價*購買件數
	
	
	
	public double getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getFormattedOrderDate() {
		return formattedOrderDate;
	}
	public void setFormattedOrderDate(String formattedOrderDate) {
		this.formattedOrderDate = formattedOrderDate;
	}
	private String formattedOrderDate; //orderDate轉換為 2023/8/17格式
	
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getItemsQuantity() {
		return ItemsQuantity;
	}
	public void setItemsQuantity(int itemsQuantity) {
		ItemsQuantity = itemsQuantity;
	}
	public int getShipping() {
		return shipping;
	}
	public void setShipping(int shipping) {
		this.shipping = shipping;
	}
	public double getPayable() {
		return Payable;
	}
	public void setPayable(double payable) {
		Payable = payable;
	}
	public String getShippingTextValue() {
		return shippingTextValue;
	}
	public void setShippingTextValue(String shippingTextValue) {
		this.shippingTextValue = shippingTextValue;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public int getPayFlowType() {
		return payFlowType;
	}
	public void setPayFlowType(int payFlowType) {
		this.payFlowType = payFlowType;
	}
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public String getHODateOrderDetailId() {
		return HODateOrderDetailId;
	}
	public void setHODateOrderDetailId(String HODateOrderDetailId) {
		this.HODateOrderDetailId = HODateOrderDetailId;
	}
	

	
	
	
	
	
	
	
}
