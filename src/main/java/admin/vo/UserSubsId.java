package admin.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSubsId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userSubsId;			//訂閱單號
	
	private Double orderTotal;			//訂單總金額
	private Date subscriptionDate;		//訂閱日期
	private Integer payFlowType;		//訂單狀態
	private Integer userId;				//userID
	private Integer plans;				//方案
	private Date expirationDate;		//到期日期
	
	public UserSubsId(Integer userSubsId, Double orderTotal, Date subscriptionDate, Integer payFlowType, Integer userId,
			Integer plans, Date expirationDate) {
		super();
		this.userSubsId = userSubsId;
		this.orderTotal = orderTotal;
		this.subscriptionDate = subscriptionDate;
		this.payFlowType = payFlowType;
		this.userId = userId;
		this.plans = plans;
		this.expirationDate = expirationDate;
	}

	public Integer getUserSubsId() {
		return userSubsId;
	}

	public void setUserSubsId(Integer userSubsId) {
		this.userSubsId = userSubsId;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Integer getPayFlowType() {
		return payFlowType;
	}

	public void setPayFlowType(Integer payFlowType) {
		this.payFlowType = payFlowType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPlans() {
		return plans;
	}

	public void setPlans(Integer plans) {
		this.plans = plans;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
