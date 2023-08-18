package shop.vo;

public class WishList {
	
	private int wishListId;
	private int userId;
	private String prodName;
	private double price;
	private String colorType;
	private int productImgId;
	
	
	public int getWishListId() {
		return wishListId;
	}
	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColorType() {
		return colorType;
	}
	public void setColorType(String colorType) {
		this.colorType = colorType;
	}
	public int getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(int productImgId) {
		this.productImgId = productImgId;
	}
	
	
	
	
	

}
