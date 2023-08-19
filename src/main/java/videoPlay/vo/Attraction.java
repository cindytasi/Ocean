package videoPlay.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity

public class Attraction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attractionId;
	
	private String attractionName;
//	googleMapLink;
	private String attractionIntroduce;
	private String address;
	private String phoneNumber;
	@Lob
	private byte[] attractionPic;
//	longitude;
//	latitude;

	public Attraction() {

	}

	public Attraction(Integer attractionId, String attractionName, String attractionIntroduce, String address,
			String phoneNumber) {
		super();
		this.attractionId = attractionId;
		this.attractionName = attractionName;
		this.attractionIntroduce = attractionIntroduce;
		this.address = address;
		this.phoneNumber = phoneNumber;
//		this.attractionPic = attractionPic;
	}

	public Attraction(Integer attractionId, byte[] attractionPic) {
		super();
		this.attractionId = attractionId;
		this.attractionPic = attractionPic;
	}

	public Integer getAttractionId() {
		return attractionId;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public String getAttractionIntroduce() {
		return attractionIntroduce;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public byte[] getAttractionPic() {
		return attractionPic;
	}

	public void setAttractionId(Integer attractionId) {
		this.attractionId = attractionId;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	public void setAttractionIntroduce(String attractionIntroduce) {
		this.attractionIntroduce = attractionIntroduce;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAttractionPic(byte[] attractionPic) {
		this.attractionPic = attractionPic;
	}
	

}
