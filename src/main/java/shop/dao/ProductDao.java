package shop.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import shop.vo.Image;
import shop.vo.Product;

public class ProductDao  {

	// 宣告一個datasource並設為靜態變數成為唯一
	private static DataSource dataSource;
	
	// 取得連線池
	static {
		try {
			Context initialContext = new InitialContext();
			Context context = (Context) initialContext.lookupLink("java:comp/env");
			dataSource = (DataSource) context.lookup("jdbc/javaFramework");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	


	// 拿到Mainhome最新商品限12筆所有照片和商品名 (根據不同顏色會得到相應的照片和商品名)
	public List<Product> getNewAll() {
		List<Product> result = new ArrayList<Product>();
		String getNewAll = """
				SELECT productName, colorType, productImgId, price
				FROM ProductInformation
				GROUP BY productName, colorType, productImgId, price
				ORDER BY MAX(addedTime) DESC
				LIMIT 12;
				""";
		String columns[] = {"productId"};
	
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(getNewAll,columns);) {			
			ResultSet rs = ps.executeQuery();
//			ResultSet id = ps.getGeneratedKeys(); //拿到productId的自動編號
			
			while (rs.next()) {
				Product product = new Product();
				// product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
//				product.setSpecType(rs.getInt("specType"));
//				product.setSpecInfo(rs.getString("specInfo"));
//				product.setSizeType(rs.getString("sizeType"));
				product.setColorType(rs.getString("colorType"));
//				product.setComId(rs.getInt("comId"));			
				//product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));
				//product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
				product.setPrice(rs.getDouble("price"));
				//product.setVideoName(rs.getString("videoName"));
				product.setProductImgId(rs.getInt("productImgId"));
				//product.setInStock(rs.getInt("inStock"));
				//product.setGender(rs.getInt("gender"));
				result.add(product);
				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	// 查詢所有商品  依照最新新增順序排列
	public List<Product> getAll() {
		List<Product> result = new ArrayList<Product>();
		String getAll = """
				SELECT productName, colorType, productImgId, price
				FROM ProductInformation
				GROUP BY productName, colorType, productImgId, price
				ORDER BY MAX(addedTime) DESC;
				""";
		
	
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(getAll);) {			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setColorType(rs.getString("colorType"));		
				//product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));
				product.setPrice(rs.getDouble("price"));
				product.setProductImgId(rs.getInt("productImgId"));
				result.add(product);
				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
		
	// 查詢男or女全部商品
	public List<Product> allGender(int gender) {
		List<Product> result = new ArrayList<Product>();
		
		String allGender = """
				SELECT productName, colorType,  productImgId, price from (
				SELECT * from ProductInformation where gender = ?
				) genderInfo GROUP BY productName, colorType,  productImgId, price
				ORDER BY MAX(addedTime) DESC;
			""";
		
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(allGender);) {	
			ps.setInt(1, gender);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));				
				product.setColorType(rs.getString("colorType"));		
				product.setPrice(rs.getDouble("price"));
				product.setProductImgId(rs.getInt("productImgId"));				
				result.add(product);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	// 查詢男or女細部分類(上衣或褲子或鞋子)
	public List<Product> GenderClothes(int gender, int specType ) {
		List<Product> result = new ArrayList<Product>();
		
		// 以性別篩選是上衣or褲or鞋子
		String GenderClothing = """
				select productName, colorType,  productImgId, price from (
				select * from ProductInformation where gender = ? and specType = ?
				) specTypeInfo group by productName, colorType,  productImgId, price
				ORDER BY MAX(addedTime) DESC;
				""";

		
		
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(GenderClothing);) {
			ps.setInt(1, gender);
			ps.setInt(2, specType);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setColorType(rs.getString("colorType"));						
				product.setPrice(rs.getDouble("price"));
				product.setProductImgId(rs.getInt("productImgId"));
				result.add(product);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	// 查詢產品種類(鞋子或飾品或其他)
	public List<Product> typeOfAcc(int specType ) {
		List<Product> result = new ArrayList<Product>();
		
		String typeOfAcc = """
		select productName, colorType,  productImgId, price from (
				SELECT * from ProductInformation where specType = ?
				) specTypeInfo GROUP BY productName, colorType,  productImgId, price
				ORDER BY MAX(addedTime) DESC;
				""";
		
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(typeOfAcc);) {		
			ps.setInt(1, specType);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));				
				product.setColorType(rs.getString("colorType"));				
				product.setPrice(rs.getDouble("price"));
				product.setProductImgId(rs.getInt("productImgId"));
				result.add(product);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}

}
