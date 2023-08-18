
package manufactur.vo;
//
//import java.time.LocalDateTime;
//
//public class  Video {
//	private Integer videoId;
//	private Integer videoName;
//	private Integer videoType;
//	private LocalDateTime videoYear;
//	private Integer vidoeArea;
//	private Integer approvalStatus;
//	
//	public   Video() {
//		
//	}
//
//	
//	public  Video(Integer productLinkId, Integer productId,Integer videoId,
//			LocalDateTime linkTimestamp,Integer lastModifiedDate,Integer approvalStatus) {
//		super();
//		this.productLinkId = productLinkId;
//		this.productId = productId;
//		this.videoId = videoId;
//		this.linkTimestamp = linkTimestamp;
//		this.lastModifiedDate = lastModifiedDate;
//		this.approvalStatus = approvalStatus;
//	


import java.util.Arrays;

public class Video {

  String videoName;
  String videoType;
  Integer videoYear;
  String videoArea;
  String videoDirector;
  String videoActor;
  Integer videoLength;
  Integer videoSeason;
  Integer videoEpisode;
  String videoPath;
  Integer adminId;
  String uploadDate;
  String VideoReview;
  Integer domainId;
  String homeTopStatus;
  String Introduction;
  Integer videoId;
  Integer views;
  Integer save;
  byte[] picture;
  String type;
  Integer videoStartYear;
  Integer videoEndYear;
  
  
  public Integer getVideoStartYear() {
   return videoStartYear;
  }

  public void setVideoStartYear(Integer videoStartYear) {
   this.videoStartYear = videoStartYear;
  }

  public Integer getVideoEndYear() {
   return videoEndYear;
  }

  public void setVideoEndYear(Integer videoendYear) {
   this.videoEndYear = videoendYear;
  }

  public String getType() {
   return type;
  }

  public void setType(String type) {
   this.type = type;
  }

  public byte[] getPicture() {
   return picture;
  }

  public void setPicture(byte[] picture) {
   this.picture = picture;
  }

  public Integer getViews() {
   return views;
  }

  public void setViews(Integer views) {
   this.views = views;
  }

  public Integer getSave() {
   return save;
  }

  public void setSave(Integer save) {
   this.save = save;
  }

  public Integer getVideoId() {
   return videoId;
  }

  public void setVideoId(Integer videoId) {
   this.videoId = videoId;
  }

  public String getVideoName() {
   return videoName;
  }

  public void setVideoName(String videoName) {
   this.videoName = videoName;
  }

  public String getVideoType() {
   return videoType;
  }

  public void setVideoType(String videoType) {
   this.videoType = videoType;
  }

  public Integer getVideoYear() {
   return videoYear;
  }

  public void setVideoYear(Integer videoYear) {
   this.videoYear = videoYear;
  }

  public String getVideoArea() {
   return videoArea;
  }

  public void setVideoArea(String videoArea) {
   this.videoArea = videoArea;
  }

  public String getVideoDirector() {
   return videoDirector;
  }

  public void setVideoDirector(String videoDirector) {
   this.videoDirector = videoDirector;
  }

  public String getVideoActor() {
   return videoActor;
  }

  public void setVideoActor(String videoActor) {
   this.videoActor = videoActor;
  }

  public Integer getVideoLength() {
   return videoLength;
  }

  public void setVideoLength(Integer videoLength) {
   this.videoLength = videoLength;
  }

  public Integer getVideoSeason() {
   return videoSeason;
  }

  public void setVideoSeason(Integer videoSeason) {
   this.videoSeason = videoSeason;
  }

  public Integer getVideoEpisode() {
   return videoEpisode;
  }

  public void setVideoEpisode(Integer videoEpisode) {
   this.videoEpisode = videoEpisode;
  }

  public String getVideoPath() {
   return videoPath;
  }

  public void setVideoPath(String videoPath) {
   this.videoPath = videoPath;
  }

  public Integer getAdminId() {
   return adminId;
  }

  public void setAdminId(Integer adminId) {
   this.adminId = adminId;
  }

  public String getUploadDate() {
   return uploadDate;
  }

  public void setUploadDate(String uploadDate) {
   this.uploadDate = uploadDate;
  }

  public String getVideoReview() {
   return VideoReview;
  }

  public void setVideoReview(String videoReview) {
   VideoReview = videoReview;
  }

  public Integer getDomainId() {
   return domainId;
  }

  public void setDomainId(Integer domainId) {
   this.domainId = domainId;
  }

  public String getHomeTopStatus() {
   return homeTopStatus;
  }

  public void setHomeTopStatus(String homeTopStatus) {
   this.homeTopStatus = homeTopStatus;
  }

  public String getIntroduction() {
   return Introduction;
  }

  public void setIntroduction(String introduction) {
   Introduction = introduction;
  }

  @Override
  public String toString() {
   return "Video [videoName=" + videoName + ", videoType=" + videoType + ", videoYear=" + videoYear
     + ", videoArea=" + videoArea + ", videoDirector=" + videoDirector + ", videoActor=" + videoActor
     + ", videoLength=" + videoLength + ", videoSeason=" + videoSeason + ", videoEpisode=" + videoEpisode
     + ", videoPath=" + videoPath + ", adminId=" + adminId + ", uploadDate=" + uploadDate + ", VideoReview="
     + VideoReview + ", domainId=" + domainId + ", homeTopStatus=" + homeTopStatus + ", Introduction="
     + Introduction + ", videoId=" + videoId + ", views=" + views + ", save=" + save + ", picture="
     + Arrays.toString(picture) + "]";
  }
 }


