package shop.vo;

public class ProdSizeStock {
	private Integer productId;
	private String sizeType;
	private Integer inStock;
	
	public ProdSizeStock() {
	}
	
	public ProdSizeStock(Integer productId, String sizeType, Integer inStock) {
		super();
		this.productId = productId;
		this.sizeType = sizeType;
		this.inStock = inStock;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getSizeType() {
		return sizeType;
	}
	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}
	public Integer getInStock() {
		return inStock;
	}
	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}
}
