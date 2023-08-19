package videoPlay.vo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

public class MemberWatchDurationPK implements Serializable{
	private Integer videoId;
	private Integer memberId;
	public Integer getVideoId() {
		return videoId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	
	
}
