package web.vo;

import java.util.List;

public class FavoriteMap {
	
	    private Integer mapId;
		private Integer memberId;
		private Integer attractionId;
		private String lastModifiedDate;
		private List<attraction> attractions;
		private String message;
		
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<attraction> getAttractions() {
			return attractions;
		}

		public void setAttractions(List<attraction> attractions) {
			this.attractions = attractions;
		}


		public Integer getMapId() {
			return mapId;
		}

		public void setMapId(Integer mapId) {
			this.mapId = mapId;
		}

		public Integer getMemberId() {
			return memberId;
		}

		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}

		public Integer getAttractionId() {
			return attractionId;
		}

		public void setAttractionId(Integer attractionId) {
			this.attractionId = attractionId;
		}

		public String getLastModifiedDate() {
			return lastModifiedDate;
		}

		public void setLastModifiedDate(String lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
		}

		@Override
		public String toString() {
			return "FavoriteMap [mapId=" + mapId + ", memberId=" + memberId + ", attractionId=" + attractionId
					+ ", lastModifiedDate=" + lastModifiedDate + ", attractions=" + attractions + "]";
		}
	     
	}

