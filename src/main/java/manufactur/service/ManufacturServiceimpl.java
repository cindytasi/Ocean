package manufactur.service; 

import java.util.List;

import manufactur.dao.ManufactursDAOimpl;
import manufactur.vo.Product;
import manufactur.vo.ProductImg;
import manufactur.vo.ProductLink;
import manufactur.vo.Video;


public class ManufacturServiceimpl implements ManufactursService {
	ManufactursDAOimpl manufactursDAOimpl = new ManufactursDAOimpl();
	
	
	//顯示商品列表
	@Override
	public List<Product> selectAll() {		
		manufactursDAOimpl = new ManufactursDAOimpl();
		List<Product> result = manufactursDAOimpl.selectAll();
		return result;			
	}
	//顯示時間戳
	@Override
	public List<ProductLink>  selectStatusLinkTimestamp () {		
		manufactursDAOimpl = new ManufactursDAOimpl();
		List<ProductLink> result = manufactursDAOimpl. selectStatusLinkTimestamp ();
		return result;			
	}
	
	// 顯示要插入的影片
	public List<Video> selectVideoAll() {		
		manufactursDAOimpl = new ManufactursDAOimpl();
		List<Video> result = manufactursDAOimpl.selectVideoAll();
		return result;		
	}
	
	//顯示審核結果
		@Override
		public List<ProductLink> selectStatusCord() {		
			manufactursDAOimpl = new ManufactursDAOimpl();
			List<ProductLink> result = manufactursDAOimpl.selectStatusCord();
			return result;
}
		
		@Override
		//insert東西的時候要去判斷有沒有輸入錯誤
		public Product insertNum(Product product,ProductImg productImg ) {
			
			if (product.getProductName() == null) {
				product.setMessage("商品名稱未輸入");
				product.setSuccessful(false);
				return product;
			}
			if (product.getColorType() == null) {
				product.setMessage("商品顏色未輸入");
				product.setSuccessful(false);
				return product;
			}
			if (product.getVideoName() == null) {
				product.setMessage("影片名稱未輸入");
				product.setSuccessful(false);
				return product;
			}
			if (product.getGender() == null) {
				product.setMessage("性別未輸入");
				product.setSuccessful(false);
				return product;
			}
			
			if (product.getSpecType() == null) {
				product.setMessage("類型未輸入");
				product.setSuccessful(false);
				return product;
			}
			
			if (product.getSizeType() == null) {
				product.setMessage("尺寸未輸入");
				product.setSuccessful(false);
				return product;
			}
			if (product.getInStock() == null) {
				product.setMessage("庫存未輸入");
				product.setSuccessful(false);
				return product;
			}
			
			if (product.getPrice() == null) {
				product.setMessage("價格未輸入");
				product.setSuccessful(false);
				return product;
			}
			
			int num = new ManufactursDAOimpl().insert(product,productImg );
			
			
			if(num > 0) {
				product.setMessage("成功新增");
				product.setSuccessful(true);
				
				return  product;
			}else {
				product.setMessage("新增失敗");
				product.setSuccessful(false);
				
				return  product;
			}
			//之後有空寫
//			if (dao.selectByUsername(product.getProductName()) != null) {
//				product.setMessage("帳號重複");
//				product.setSuccessful(false);
//				return product;
//			}
			
//			product.setRoleId(2);
//			final int resultCount = dao.insert(product);
//			if (resultCount < 1) {
//				product.setMessage("註冊錯誤，請聯絡管理員!");
//				product.setSuccessful(false);
//				return product;
//			}
			
//			product.setMessage("註冊成功");
//			product.setSuccessful(true);
		
	}
		
}