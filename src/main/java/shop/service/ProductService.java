package shop.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shop.dao.ImageDao;
import shop.dao.ProductDao;
import shop.vo.Image;
import shop.vo.ProdIdSizeColorImgStock;
import shop.vo.ProdIdStock;
import shop.vo.Product;
import shop.vo.ProductDetail;
import shop.vo.ProductDetail2;

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
	public InputStream getImageById(int id, int data) {

		Image img = imageDao.getImageById(id);

		switch (data) {
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
	
	

	// 拿各別產品細項資料
	public ProductDetail2 getDetailAll(String productName, String color) {
		// 拿到所有同名的物件
		List<Product> result = productDao.getDetailAll(productName);

		// 將重複的物件取出第一個保持唯一
		String displayProdName = result.get(0).getProductName();
		Integer specType = result.get(0).getSpecType();
		String specInfo = result.get(0).getSpecInfo();
		Integer comId = result.get(0).getComId();
		Double price = result.get(0).getPrice();
		

		Set<String> colorSet = new HashSet<>();
		Set<Integer> imgIdSet = new HashSet<>();
		Set<String> sizeSet = new HashSet<>();
		for (Product product : result) {
			colorSet.add(product.getColorType());
			imgIdSet.add(product.getProductImgId());
			sizeSet.add(product.getSizeType());
		}

		List<ProdIdStock> inStock = new ArrayList();
		for (Product product : result) {
			ProdIdStock prodIdStock = new ProdIdStock();
			prodIdStock.setProductId(product.getProductId());
			prodIdStock.setInStock(product.getInStock());
			inStock.add(prodIdStock);
		}

		List<ProdIdSizeColorImgStock> prodIdSizeColorImgStockList = new ArrayList<>();
		Integer defaultImgId = null; //設一個唯一要拿到的imgId
		for (int i = 0; i < result.size(); i++) {
			Product product = result.get(i);
			ProdIdSizeColorImgStock prodIdSizeColorImgStock = new ProdIdSizeColorImgStock();
			prodIdSizeColorImgStock.setProductId(product.getProductId());
			prodIdSizeColorImgStock.setSizeType(product.getSizeType());
			prodIdSizeColorImgStock.setColorType(product.getColorType());
			prodIdSizeColorImgStock.setInStock(product.getInStock());
			prodIdSizeColorImgStock.setProductImgId(product.getProductImgId());
			prodIdSizeColorImgStockList.add(prodIdSizeColorImgStock);
			
			if(defaultImgId == null && color.equals(product.getColorType())) {
				defaultImgId = product.getProductImgId();
			}
		}
		
		ProductDetail2 productDetail = new ProductDetail2();
		productDetail.setDisplayProdName(displayProdName);
		productDetail.setSpecType(specType);
		productDetail.setSpecInfo(specInfo);
		productDetail.setComId(comId);
		productDetail.setPrice(price);
		productDetail.setIdStock(inStock);
		productDetail.setColorSet(colorSet);
		productDetail.setSizeSet(sizeSet);
		productDetail.setImgIdSet(imgIdSet);
		productDetail.setProdIdSizeColorImgStockList(prodIdSizeColorImgStockList);
		productDetail.setDefaultImgId(defaultImgId);
		return productDetail;

	
	}
	
	//拿收尋bar後的關鍵字資料
	public List<Product> selectKeyWord(String msg){
		List<Product> result = productDao.getKeyWord(msg);
		if(result == null) {
			System.out.println("找不到此商品，請重新輸入");
			
			return null;
		}
		return result;		
		
	}

}
