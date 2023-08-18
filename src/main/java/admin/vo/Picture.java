package admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
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
	
	
	
}
