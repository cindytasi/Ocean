package manufactur.vo;

import java.util.List;

public class ProductPageResponse {
    private int totalProducts;
    private List<Product> productList;

    public ProductPageResponse(int totalProducts, List<Product> productList) {
        this.totalProducts = totalProducts;
        this.productList = productList;
    }

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


}
