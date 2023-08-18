package admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pictureId;
	
	private Integer videoId;
	@Lob
	private byte[] picture;
	
	public Picture() {
		
	}
	
	public Picture(Integer pictureId, Integer videoId, byte[] picture) {
		super();
		this.pictureId = pictureId;
		this.videoId = videoId;
		this.picture = picture;
	}

	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
