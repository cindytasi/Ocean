package shop.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import shop.dao.ImageDao;
import shop.dao.ProductDao;
import shop.vo.Image;
import shop.vo.ProdSizeStock;
import shop.vo.Product;
import shop.vo.ProductDetail;

public class ProductService {

	private static ProductDao productDao;
	private static ImageDao imageDao;

	static {
		productDao = new ProductDao();
		imageDao = new ImageDao();
	}

	// 主頁Home
	public List<Product> getNewAll() {

		List<Product> result = productDao.getNewAll();
		return result;
	}

	// 分類頁面
	public List<Product> getTopBarData(String type) {

		switch (type) {
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

	
	// 拿主頁商品照片
	public InputStream getImageById(int id , int data) {
		
		Image img = imageDao.getImageById(id);
		
		switch(data) {
		case 1:			
			InputStream img1 = img.getImg1();
			return img1;
		case 2:		
			InputStream img2 = img.getImg2();
			return img2;
		case 3:		
			InputStream img3 = img.getImg3();
			return img3;
		default:
			InputStream img4 = img.getImg4();
			return img4;
		}		

	}



	//拿各別產品細項資料
	public ProductDetail getDetailAll(String productName, String color){
		List<Product> result = productDao.getDetailAll(productName ,color);
		
		String displayProdName = result.get(0).getProductName();
		Integer specType = result.get(0).getSpecType();
		String specInfo = result.get(0).getSpecInfo();
		String colorType = result.get(0).getColorType();;
		Integer comId = result.get(0).getComId();;
		Double price = result.get(0).getPrice();
		Integer productImgId =result.get(0).getProductImgId();;
		
		List<ProdSizeStock> prodSizeStockList = new ArrayList<>();
		for(Product product : result) {
			ProdSizeStock prodSizeStock = new ProdSizeStock();
			prodSizeStock.setProductId(product.getProductId());
			prodSizeStock.setSizeType(product.getSizeType());
			prodSizeStock.setInStock(product.getInStock());
			prodSizeStockList.add(prodSizeStock);
		}
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setDisplayProdName(displayProdName);
		productDetail.setSpecType(specType);
		productDetail.setSpecInfo(specInfo);
		productDetail.setColorType(colorType);
		productDetail.setComId(comId);
		productDetail.setPrice(price);
		productDetail.setProductImgId(productImgId);
		productDetail.setProdSizeStockList(prodSizeStockList);
		
		return productDetail;		
	}

}

	
