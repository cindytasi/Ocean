package manufactur.dao;

import java.util.List;

import manufactur.vo.Product;

public interface Manufacturs2DAO {

	void insert(Product product);

	

	List<Product> getAll2();

}
