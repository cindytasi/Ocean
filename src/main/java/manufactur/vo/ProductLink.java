package manufactur.vo;

import java.time.LocalDateTime;

public class ProductLink {
	private Integer productLinkId;
	private Integer productId;
	private Integer videoId;
	private Integer linkTimestamp;
	private LocalDateTime lastModifiedDate;
	private Integer approvalStatus;
	
	public  ProductLink() {
	}
	
	public ProductLink(Integer productLinkId, Integer productId,Integer videoId,
			Integer linkTimestamp,LocalDateTime lastModifiedDate,Integer approvalStatus) {
		super();
		this.productLinkId = productLinkId;
		this.productId = productId;
		this.videoId = videoId;
		this.linkTimestamp = linkTimestamp;
		this.lastModifiedDate = lastModifiedDate;
		this.approvalStatus = approvalStatus;
		
	
		
		
		
	}

	public Integer getProductLinkId() {
		return productLinkId;
	}

	public void setProductLinkId(Integer productLinkId) {
		this.productLinkId = productLinkId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getLinkTimestamp() {
		return linkTimestamp;
	}

	public void setLinkTimestamp(Integer linkTimestamp) {
		this.linkTimestamp = linkTimestamp;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
}
