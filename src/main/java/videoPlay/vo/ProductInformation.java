package videoPlay.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String productName;
	private String specType;
	private String specInfo;
	private String sizeType;
	private String colorType;
	private Integer comId;
//	addedTime
//	reviewTime
	private Double price;
	private String videoName;
	private Integer productImgId;
//	inStock
	private Integer gender;
	
	public ProductInformation() {
		
	}

	public ProductInformation(Integer productId, String productName, String specType, String specInfo, String sizeType,
			String colorType, Integer comId, Double price, String videoName, Integer productImgId, Integer gender) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.specType = specType;
		this.specInfo = specInfo;
		this.sizeType = sizeType;
		this.colorType = colorType;
		this.comId = comId;
		this.price = price;
		this.videoName = videoName;
		this.productImgId = productImgId;
		this.gender = gender;
	}

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getSpecType() {
		return specType;
	}

	public String getSpecInfo() {
		return specInfo;
	}

	public String getSizeType() {
		return sizeType;
	}

	public String getColorType() {
		return colorType;
	}

	public Integer getComId() {
		return comId;
	}

	public Double getPrice() {
		return price;
	}

	public String getVideoName() {
		return videoName;
	}

	public Integer getProductImgId() {
		return productImgId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSpecType(String specType) {
		this.specType = specType;
	}

	public void setSpecInfo(String specInfo) {
		this.specInfo = specInfo;
	}

	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}

	public void setColorType(String colorType) {
		this.colorType = colorType;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	

}
