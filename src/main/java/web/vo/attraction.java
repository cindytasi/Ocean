package web.vo;

import java.util.Arrays;

public class attraction {

		//attractionId, attractionName, googleMapLink, attractionIntroduce, address, phoneNumber, attractionPic, longitude, latitude
		private Integer attractionId;
		private String attractionName;
		private String googleMapLink;
		private String attractionIntroduce;
		private String address;
		private String phoneNumber;
		private byte[] attractionPic;
		private Double longitude;
		private Double latitude;
		
		public Integer getAttractionId() {
			return attractionId;
		}
		public void setAttractionId(Integer attractionId) {
			this.attractionId = attractionId;
		}
		public String getAttractionName() {
			return attractionName;
		}
		public void setAttractionName(String attractionName) {
			this.attractionName = attractionName;
		}
		public String getGoogleMapLink() {
			return googleMapLink;
		}
		public void setGoogleMapLink(String googleMapLink) {
			this.googleMapLink = googleMapLink;
		}
		public String getAttractionIntroduce() {
			return attractionIntroduce;
		}
		public void setAttractionIntroduce(String attractionIntroduce) {
			this.attractionIntroduce = attractionIntroduce;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public byte[] getAttractionPic() {
			return attractionPic;
		}
		public void setAttractionPic(byte[] attractionPic) {
			this.attractionPic = attractionPic;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public Double getLatitude() {
			return latitude;
		}
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}
		@Override
		public String toString() {
			return "attraction [attractionId=" + attractionId + ", attractionName=" + attractionName + ", googleMapLink="
					+ googleMapLink + ", attractionIntroduce=" + attractionIntroduce + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + ", attractionPic=" + Arrays.toString(attractionPic) + ", longitude="
					+ longitude + ", latitude=" + latitude + "]";
		}
		
		
	}

