package videoPlay.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class VideoAttraction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer videoAttractionId;
	
	private Integer attractionId;
	private Integer videoId;
	private Integer attReviewStatus;
	private Integer locationTimestamp;
	
	public VideoAttraction() {
		
	}

	public VideoAttraction(Integer videoAttractionId, Integer attractionId, Integer videoId, Integer attReviewStatus,
			Integer locationTimestamp) {
		super();
		this.videoAttractionId = videoAttractionId;
		this.attractionId = attractionId;
		this.videoId = videoId;
		this.attReviewStatus = attReviewStatus;
		this.locationTimestamp = locationTimestamp;
	}

	public Integer getVideoAttractionId() {
		return videoAttractionId;
	}

	public Integer getAttractionId() {
		return attractionId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public Integer getAttReviewStatus() {
		return attReviewStatus;
	}

	public Integer getLocationTimestamp() {
		return locationTimestamp;
	}

	public void setVideoAttractionId(Integer videoAttractionId) {
		this.videoAttractionId = videoAttractionId;
	}

	public void setAttractionId(Integer attractionId) {
		this.attractionId = attractionId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public void setAttReviewStatus(Integer attReviewStatus) {
		this.attReviewStatus = attReviewStatus;
	}

	public void setLocationTimestamp(Integer locationTimestamp) {
		this.locationTimestamp = locationTimestamp;
	}
	
}
