package shop.vo;
import java.util.Date;


public class OrderVO {
	
	private int orderId;     
	private int userId;
	private double orderTotal; //應付金額
	private Date orderDate;
	private int payFlowType;
	private int comId;
	private int statusCode ;
	private int transactionId;
	private String HODateOrderDetailId;
	private String formattedOrderDate; //orderDate轉換為 2023/8/17格式
	
	public String getFormattedOrderDate() {
		return formattedOrderDate;
	}
	public void setFormattedOrderDate(String formattedOrderDate) {
		this.formattedOrderDate = formattedOrderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getHODateOrderDetailId() {
		return HODateOrderDetailId;
	}
	public void setHODateOrderDetailId(String HODateOrderDetailId) {
		this.HODateOrderDetailId = HODateOrderDetailId;
	}
	
	
	
	
	
	

}
