package manufactur.dao;

import java.util.List;

import manufactur.vo.Product;
import manufactur.vo.ProductImg;
import manufactur.vo.ProductLink;
import manufactur.vo.Video;

public interface ManufactursDAO {
	//最簡單的商品陳列出來的
	List<Product> selectAll();
//最簡單的修改
	boolean update(Product product);
	//最簡單的加入
//	int insert(Product product);
	//select 審核狀態碼
	List<ProductLink> selectStatusCord();
	
	List<Video> selectVideoAll();
	
	
	
	//找置入時間戳
	List<ProductLink> selectStatusLinkTimestamp();
	int insert(Product product, ProductImg productImg);
	
	
	

//	int insert(Product product);
}