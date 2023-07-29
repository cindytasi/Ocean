package manufactur.dao;

import java.util.List;

import manufactur.vo.Product;

public interface manufactursDAO {
	//最簡單的商品陳列出來的
	List<Product> selectAll();
//最簡單的修改
	boolean update(Product product);

//	int insert(Product product);
}