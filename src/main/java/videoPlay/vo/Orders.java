package videoPlay.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private Integer userId;
	private Double orderTotal;
	private Date orderDate;
	private Integer payFlowType;
	private Integer comId;
	private Integer statusCode;
	private Integer transactionId;
	
	public Orders() {
		
	}
	
	public Orders(Integer orderId, Integer userId, Double orderTotal, Date orderDate, Integer payFlowType, Integer comId,
			Integer statusCode, Integer transactionId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
		this.payFlowType = payFlowType;
		this.comId = comId;
		this.statusCode = statusCode;
		this.transactionId = transactionId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Integer getPayFlowType() {
		return payFlowType;
	}

	public Integer getComId() {
		return comId;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setPayFlowType(Integer payFlowType) {
		this.payFlowType = payFlowType;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
