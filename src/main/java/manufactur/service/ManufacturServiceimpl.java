package manufactur.service; 

import java.util.List;

import manufactur.dao.ManufactursDAOimpl;
import manufactur.vo.Product;
import manufactur.vo.ProductLink;


public class ManufacturServiceimpl implements ManufactursService {
	ManufactursDAOimpl manufactursDAOimpl = new ManufactursDAOimpl();
	
	
	//顯示商品列表
	@Override
	public List<Product> selectAll() {		
		manufactursDAOimpl = new ManufactursDAOimpl();
		List<Product> result = manufactursDAOimpl.selectAll();
		return result;			
	}
	
	
	
	
	//顯示審核結果
		@Override
		public List<ProductLink> selectStatusAll() {		
			manufactursDAOimpl = new ManufactursDAOimpl();
			List<ProductLink> result = manufactursDAOimpl.selectStatusAll();
			return result;
}
		
		@Override
		//insert東西的時候要去判斷有沒有輸入錯誤
		public Product register(Product product) {
			if (product.getProductName() == null) {
				product.setMessage("商品名稱未輸入");
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
			
			product.setMessage("註冊成功");
			product.setSuccessful(true);
			return product;
		}
		
}