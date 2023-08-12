package manufactur.service;

import java.util.List;

import manufactur.vo.Product;
import manufactur.vo.ProductImg;
import manufactur.vo.ProductLink;
import manufactur.vo.Video;

public interface ManufactursService {

	//顯示商品列表
	List<Product> selectAll();

	//顯示審核結果
	List<ProductLink> selectStatusCord();

//	Product register(Product product);



//
	
	List<Video> selectVideoAll();

	List<ProductLink> selectStatusLinkTimestamp();
//輸入新產品的判斷
//	Product insertNum(Product product);

	Product insertNum(Product product, ProductImg productImg);
}