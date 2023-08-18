package admin.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer videoId;

	private String videoName;
	private String videoType;
	private Integer videoYear;
	private String videoArea;
	private String videoDirector;
	private String videoActor;
	private Integer videoLength;
	private Integer videoSeason;
	private Integer videoEpisode;
	private Date uploadDate;
	private BigDecimal VideoReview;
	private Integer domainId;
	private String Introduction;
	private Integer views;
	private Integer save;
	// 以下欄位作為上傳及更新使用
	private Integer adminId;
	private String videoPath;
	@Lob
	private byte[] picture;

	public Video() {

	}

	// videoId, videoName, videoType, videoYear, videoArea, videoDirector,
	// videoActor, videoLength, videoSeason, videoEpisode, uploadDate,
	// VideoReview, domainId, Introduction, views, save
	public Video(Integer videoId, String videoName, String videoType, Integer videoYear, String videoArea,
			String videoDirector, String videoActor, Integer videoLength, Integer videoSeason, Integer videoEpisode,
			Date uploadDate, BigDecimal VideoReview, Integer domainId, String Introduction, Integer views,
			Integer save) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoType = videoType;
		this.videoYear = videoYear;
		this.videoArea = videoArea;
		this.videoDirector = videoDirector;
		this.videoActor = videoActor;
		this.videoLength = videoLength;
		this.videoSeason = videoSeason;
		this.videoEpisode = videoEpisode;
		this.uploadDate = uploadDate;
		this.VideoReview = VideoReview;
		this.domainId = domainId;
		this.Introduction = Introduction;
		this.views = views;
		this.save = save;
	}

	public Video(Integer videoId, String videoName, String videoType, Integer videoYear, String videoArea,
			String videoDirector, String videoActor, Integer videoSeason, Integer videoEpisode, Integer domainId,
			String Introduction) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoType = videoType;
		this.videoYear = videoYear;
		this.videoArea = videoArea;
		this.videoDirector = videoDirector;
		this.videoActor = videoActor;
		this.videoSeason = videoSeason;
		this.videoEpisode = videoEpisode;
		this.domainId = domainId;
		this.Introduction = Introduction;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public String getVideoType() {
		return videoType;
	}

	public Integer getVideoYear() {
		return videoYear;
	}

	public String getVideoArea() {
		return videoArea;
	}

	public String getVideoDirector() {
		return videoDirector;
	}

	public String getVideoActor() {
		return videoActor;
	}

	public Integer getVideoLength() {
		return videoLength;
	}

	public Integer getVideoSeason() {
		return videoSeason;
	}

	public Integer getVideoEpisode() {
		return videoEpisode;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public BigDecimal getVideoReview() {
		return VideoReview;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public String getIntroduction() {
		return Introduction;
	}

	public Integer getViews() {
		return views;
	}

	public Integer getSave() {
		return save;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public void setVideoYear(Integer videoYear) {
		this.videoYear = videoYear;
	}

	public void setVideoArea(String videoArea) {
		this.videoArea = videoArea;
	}

	public void setVideoDirector(String videoDirector) {
		this.videoDirector = videoDirector;
	}

	public void setVideoActor(String videoActor) {
		this.videoActor = videoActor;
	}

	public void setVideoLength(Integer videoLength) {
		this.videoLength = videoLength;
	}

	public void setVideoSeason(Integer videoSeason) {
		this.videoSeason = videoSeason;
	}

	public void setVideoEpisode(Integer videoEpisode) {
		this.videoEpisode = videoEpisode;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setVideoReview(BigDecimal videoReview) {
		VideoReview = videoReview;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public void setSave(Integer save) {
		this.save = save;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
