package shop.vo;

public class CheckoutVo {
	private int totalItems;
	private double totalPrice;
	private int shippingCost;
	private double payableAmount;
	private String itemCountText;
	private String totalAmountText;
	private String shippingCostText;
	private String payableAmountText;
	private String shippingTextValue;
	
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
	}
	public double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getItemCountText() {
		return itemCountText;
	}
	public void setItemCountText(String itemCountText) {
		this.itemCountText = itemCountText;
	}
	public String getTotalAmountText() {
		return totalAmountText;
	}
	public void setTotalAmountText(String totalAmountText) {
		this.totalAmountText = totalAmountText;
	}
	public String getShippingCostText() {
		return shippingCostText;
	}
	public void setShippingCostText(String shippingCostText) {
		this.shippingCostText = shippingCostText;
	}
	public String getPayableAmountText() {
		return payableAmountText;
	}
	public void setPayableAmountText(String payableAmountText) {
		this.payableAmountText = payableAmountText;
	}
	public String getShippingTextValue() {
		return shippingTextValue;
	}
	public void setShippingTextValue(String shippingTextValue) {
		this.shippingTextValue = shippingTextValue;
	}
	
	
	
	
	
}
