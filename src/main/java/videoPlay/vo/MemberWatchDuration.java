package videoPlay.vo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity

public class MemberWatchDuration {
	
	@EmbeddedId
	private MemberWatchDurationPK id;
	
	private Integer watchTimePoint;
	
	public MemberWatchDuration() {
		
	}

	public MemberWatchDurationPK getId() {
		return id;
	}

	public Integer getWatchTimePoint() {
		return watchTimePoint;
	}

	public void setId(MemberWatchDurationPK id) {
		this.id = id;
	}

	public void setWatchTimePoint(Integer watchTimePoint) {
		this.watchTimePoint = watchTimePoint;
	}
	
	
	
}
