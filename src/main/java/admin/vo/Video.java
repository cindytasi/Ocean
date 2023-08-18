package admin.vo;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
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
	//以下欄位作為上傳及更新使用
	private Integer adminId;
	private String videoPath;
	@Lob
	private byte[] picture;
	
	public Video() {
		
	}
	
	
	//videoId, videoName, videoType, videoYear, videoArea, videoDirector, 
	//videoActor, videoLength, videoSeason, videoEpisode, uploadDate, 
	//VideoReview, domainId, Introduction, views, save
	public Video(Integer videoId, String videoName, String videoType, Integer videoYear, String videoArea,
		String videoDirector, String videoActor, Integer videoLength, Integer videoSeason, Integer videoEpisode,
		Date uploadDate, BigDecimal VideoReview, Integer domainId, String Introduction, Integer views, Integer save) {
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
			String videoDirector, String videoActor, Integer videoSeason, Integer videoEpisode,Integer domainId, String Introduction) {
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


	
}
