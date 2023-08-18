package admin.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
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
	
}
