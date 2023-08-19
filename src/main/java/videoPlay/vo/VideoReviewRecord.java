package videoPlay.vo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VideoReviewRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordId;
	
	private Integer videoId;
	private Integer userId;
	private BigDecimal score;
	
	public VideoReviewRecord() {
		
	}

	public VideoReviewRecord(Integer recordId, Integer videoId, Integer userId, BigDecimal score) {
		super();
		this.recordId = recordId;
		this.videoId = videoId;
		this.userId = userId;
		this.score = score;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
	
}
