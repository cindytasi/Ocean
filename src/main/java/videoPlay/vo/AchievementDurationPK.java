package videoPlay.vo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

public class AchievementDurationPK implements Serializable{
	private Integer userId;
	private Integer domainId;
	public Integer getUserId() {
		return userId;
	}
	public Integer getDomainId() {
		return domainId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}
	
	
	
}
