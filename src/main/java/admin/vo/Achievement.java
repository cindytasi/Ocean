package admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Achievement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer achievementId;					//成就id
	private String achievementName;					//成就名稱
	private Integer domainId;						//領域
	private Integer achievementThresholdHours;		//達成條件
	
	public Achievement() {
		
	};
	
	public Achievement(Integer achievementId, String achievementName, Integer domainId,
			Integer achievementThresholdHours) {
		super();
		this.achievementId = achievementId;
		this.achievementName = achievementName;
		this.domainId = domainId;
		this.achievementThresholdHours = achievementThresholdHours;
	}

	public Integer getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}

	public String getAchievementName() {
		return achievementName;
	}

	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public Integer getAchievementThresholdHours() {
		return achievementThresholdHours;
	}

	public void setAchievementThresholdHours(Integer achievementThresholdHours) {
		this.achievementThresholdHours = achievementThresholdHours;
	}
}
