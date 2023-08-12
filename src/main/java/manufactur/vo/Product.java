package manufactur.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Product extends ProductImg {
	

	private Integer productId;
	private String productName;
	private Integer specType;
	private String specInfo;
	private String sizeType;
	private String colorType;
	private Integer comId;
	private Timestamp addedTime;
	private Timestamp reviewTime;
	private Double price;
	private String videoName;
	private Integer productImgId;
	private Integer inStock;
	private Integer gender;
	private boolean successful;
	private String message;
	
	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Product() {

	}

	public Product(Integer productId, String productName, Integer specType, String specInfo, String sizeType,
			String colorType, Integer comId, Timestamp addedTime, Timestamp reviewTime, Double price, String videoName,
			Integer productImgId, Integer inStock, Integer gender) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.specType = specType;
		this.specInfo = specInfo;
		this.sizeType = sizeType;
		this.colorType = colorType;
		this.comId = comId;
		this.addedTime = addedTime;
		this.reviewTime = reviewTime;
		this.price = price;
		this.videoName = videoName;
		this.productImgId = productImgId;
		this.inStock = inStock;
		this.gender = gender;

	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSpecType() {
		return specType;
	}

	public void setSpecType(Integer specType) {
		this.specType = specType;
	}

	public String getSpecInfo() {
		return specInfo;
	}

	public void setSpecInfo(String specInfo) {
		this.specInfo = specInfo;
	}

	public String getSizeType() {
		return sizeType;
	}

	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}

	public String getColorType() {
		return colorType;
	}

	public void setColorType(String colorType) {
		this.colorType = colorType;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Timestamp getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(Timestamp addedTime) {
		this.addedTime = addedTime;
	}

	public Timestamp getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Timestamp reviewTime) {
		this.reviewTime = reviewTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	public Integer getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}

	public Integer getInStock() {
		return inStock;
	}

	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", specType=" + specType
				+ ", specInfo=" + specInfo + ", sizeType=" + sizeType + ", colorType=" + colorType + ", comId=" + comId
				+ ", addedTime=" + addedTime + ", reviewTime=" + reviewTime + ", price=" + price + ", videoName="
				+ videoName + ", productImgId=" + productImgId + ", inStock=" + inStock + ", gender=" + gender + "]";
	}

}
