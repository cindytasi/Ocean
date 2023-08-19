package videoPlay.vo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity

public class AchievementDuration {
	
	@EmbeddedId
	private AchievementDurationPK apk;
	
	private Integer watchDuration;
	
	public AchievementDuration() {
		
	}

	public AchievementDurationPK getApk() {
		return apk;
	}

	public Integer getWatchDuration() {
		return watchDuration;
	}

	public void setApk(AchievementDurationPK apk) {
		this.apk = apk;
	}

	public void setWatchDuration(Integer watchDuration) {
		this.watchDuration = watchDuration;
	}

	
	
	
}
