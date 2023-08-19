package videoPlay.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productLinkId;
	private Integer productId;
	private Integer linkTimestamp;
	
	public ProductLink() {
		
	}

	public ProductLink(Integer productLinkId, Integer linkTimestamp,Integer productId) {
		super();
		this.productLinkId = productLinkId;
		this.linkTimestamp = linkTimestamp;
		this.productId = productId;
	}

	public Integer getProductLinkId() {
		return productLinkId;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getLinkTimestamp() {
		return linkTimestamp;
	}

	public void setProductLinkId(Integer productLinkId) {
		this.productLinkId = productLinkId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setLinkTimestamp(Integer linkTimestamp) {
		this.linkTimestamp = linkTimestamp;
	}
	
	
}
