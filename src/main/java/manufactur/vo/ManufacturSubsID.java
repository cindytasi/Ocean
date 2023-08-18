package manufactur.vo;

import java.util.Date;

public class ManufacturSubsID {

	
	
	private Integer comSubsID;
	private Double orderTotal;
	private Date subscriptionDate;
	private Boolean payFloeType;
	private Integer comId;
	
	
	
	
	
	public  ManufacturSubsID() {
	}
	
	
	public ManufacturSubsID(Integer comSubsID, Double orderTotal,Date subscriptionDate,
			Boolean payFloeType,Integer comId) {
		super();
		this.comSubsID = comSubsID;
		this.orderTotal = orderTotal;
		this.subscriptionDate = subscriptionDate;
		this.payFloeType = payFloeType;
		this.comId = comId;
		
	}


	public Integer getComSubsID() {
		return comSubsID;
	}


	public void setComSubsID(Integer comSubsID) {
		this.comSubsID = comSubsID;
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


	public Boolean getPayFloeType() {
		return payFloeType;
	}


	public void setPayFloeType(Boolean payFloeType) {
		this.payFloeType = payFloeType;
	}


	public Integer getComId() {
		return comId;
	}


	public void setComId(Integer comId) {
		this.comId = comId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
