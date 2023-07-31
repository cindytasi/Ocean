package shop.vo;

import java.util.List;

public class ProductDetail {
	private String displayProdName;
	private Integer specType;
	private String specInfo;
	private String colorType;
	private Integer comId;
	private Double price;
	private Integer productImgId;
	
	
	public String getDisplayProdName() {
		return displayProdName;
	}
	public void setDisplayProdName(String displayProdName) {
		this.displayProdName = displayProdName;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}
	
}
