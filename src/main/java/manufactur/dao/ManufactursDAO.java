package manufactur.dao;

import java.util.List;

import manufactur.vo.Product;
import manufactur.vo.ProductLink;

public interface ManufactursDAO {
	//最簡單的商品陳列出來的
	List<Product> selectAll();
//最簡單的修改
	boolean update(Product product);
	//最簡單的加入
	int insert(Product product);
	//select 審核狀態碼
	List<ProductLink> selectStatusAll();

//	int insert(Product product);
}