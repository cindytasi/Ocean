package videoPlay.vo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;



@Embeddable
public class FavouritesPK implements Serializable{

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
