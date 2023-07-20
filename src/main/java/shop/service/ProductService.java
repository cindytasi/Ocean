package shop.service;

import java.util.List;

import shop.dao.ProductDao;
import shop.vo.Product;


public class ProductService {
	
	ProductDao productDao = new ProductDao();
	
	
	//主頁Home
	public List<Product> getNewAll() {		
		productDao = new ProductDao();
		List<Product> result = productDao.getNewAll();
		return result;			
	}
	
	
	//分類頁面
	public List<Product> getTopBarData(String type){
		productDao = new ProductDao();
		
			switch(type) {
			case "AllProduct":
				List<Product> allResult = productDao.getAll();
				return allResult;				
			case "Women": 
				List<Product> womenResult = productDao.allGender(0);
				return womenResult;
			case "Men": 
				List<Product> menResult = productDao.allGender(1);
				return menResult;
			case "WomenTop": 
				List<Product> womenTopResult = productDao.GenderClothes(0, 1);
				return womenTopResult;
			case "WomenBottom": 
				List<Product> womenBottomResult = productDao.GenderClothes(0, 2);
				return womenBottomResult;
			case "MenTop": 
				List<Product> menTopResult = productDao.GenderClothes(1, 1);
				return menTopResult;
			case "MenBottom": 
				List<Product> menBottomResult = productDao.GenderClothes(1, 2);
				return menBottomResult;	
			case "WomenShoes": 
				List<Product> womenShoesResult = productDao.GenderClothes(0, 3);
				return womenShoesResult;
			case "MenShoes": 
				List<Product> menShoesResult = productDao.GenderClothes(1, 3);
				return menShoesResult;
			case "Shoes": 
				List<Product> shoesResult = productDao.typeOfAcc(3);
				return shoesResult;	
			case "Accessories": 
				List<Product> accessoriesResult = productDao.typeOfAcc(4);
				return accessoriesResult;	
			default: 
				List<Product> othersResult = productDao.typeOfAcc(5);
			return othersResult;	
			}
	
	}

	



}
