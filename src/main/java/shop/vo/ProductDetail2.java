package shop.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDetail2 {
	private String displayProdName;
	private Integer specType;
	private String specInfo;
	private String colorType;
	private Integer comId;
	private Double price;
	private List<ProdIdStock> idStock;
	private Set<String> colorSet;
	private Set<String> sizeSet;
	private Set<Integer> imgIdSet;	
	private List<ProdIdSizeColorImgStock> prodIdSizeColorImgStockList;
	private Integer defaultImgId;
	
	
	
	
	public Integer getDefaultImgId() {
		return defaultImgId;
	}
	public void setDefaultImgId(Integer defaultImgId) {
		this.defaultImgId = defaultImgId;
	}
	public List<ProdIdSizeColorImgStock> getProdIdSizeColorImgStockList() {
		return prodIdSizeColorImgStockList;
	}
	public void setProdIdSizeColorImgStockList(List<ProdIdSizeColorImgStock> prodIdSizeColorImgStockList) {
		this.prodIdSizeColorImgStockList = prodIdSizeColorImgStockList;
	}
	public Set<String> getColorSet() {
		return colorSet;
	}
	public void setColorSet(Set<String> colorSet) {
		this.colorSet = colorSet;
	}
	public Set<String> getSizeSet() {
		return sizeSet;
	}
	public void setSizeSet(Set<String> sizeSet) {
		this.sizeSet = sizeSet;
	}
	public Set<Integer> getImgIdSet() {
		return imgIdSet;
	}
	public void setImgIdSet(Set<Integer> imgIdSet) {
		this.imgIdSet = imgIdSet;
	}
	
	
	
	public List<ProdIdStock> getIdStock() {
		return idStock;
	}
	public void setIdStock(List<ProdIdStock> idStock) {
		this.idStock = idStock;
	}
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
	
	
}
