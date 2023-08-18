package manufactur.service;

import java.util.List;

import manufactur.vo.Product;
import manufactur.vo.ProductLink;

public interface ManufactursService {

	//顯示商品列表
	List<Product> selectAll();

	//顯示審核結果
	List<ProductLink> selectStatusAll();

	Product register(Product product);
	

}