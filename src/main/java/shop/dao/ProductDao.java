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
	
	//==========sql語法================
	// 查詢home最新商品限12筆
	final private String getNewAll = "SELECT distinct productName, colorType, addedTime, price FROM ProductInformation order by addedTime desc limit 12;";
	// 查詢所有商品
	final private String getAll = "SELECT distinct productName, colorType, addedTime, price FROM ProductInformation order by addedTime desc;";
	// 查詢男or女全部商品
	final private String allGender = "Select distinct productName, specType, colorType, price ,addedTime from ProductInformation where gender = ?;";
	// 以性別篩選是上衣or褲or鞋子
	final private String GenderClothing = "Select distinct productName, specType, colorType, price ,addedTime from ProductInformation where gender = ? and specType = ?;"; 
	// 以商品種類查詢是鞋子or飾品or其他
	final private String typeOfAcc = "SELECT distinct productName, colorType, addedTime, price FROM ProductInformation where specType = ?;";


	// 拿到主頁下方bar的所有照片和商品名 (根據不同顏色會得到相應的照片和商品名)
	public List<Product> getNewAll() {
		List<Product> result = new ArrayList<Product>();
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
				product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));
				//product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
				product.setPrice(rs.getDouble("price"));
				//product.setVideoName(rs.getString("videoName"));
				//product.setProductId(rs.getInt("productImgId"));
				//product.setInStock(rs.getInt("inStock"));
				//product.setGender(rs.getInt("gender"));
				result.add(product);
				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Product> getAll() {
		List<Product> result = new ArrayList<Product>();
		String columns[] = {"productId"};
	
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(getAll,columns);) {			
			ResultSet rs = ps.executeQuery();
//			ResultSet id = ps.getGeneratedKeys(); //拿到productId的自動編號
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setColorType(rs.getString("colorType"));		
				product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));
				product.setPrice(rs.getDouble("price"));
				result.add(product);
				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public List<Product> allGender(int gender) {
		List<Product> result = new ArrayList<Product>();
		
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(allGender);) {	
			ps.setInt(1, gender);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setColorType(rs.getString("colorType"));		
				product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));			
				product.setPrice(rs.getDouble("price"));
				result.add(product);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Product> GenderClothes(int gender, int specType ) {
		List<Product> result = new ArrayList<Product>();
		
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(GenderClothing);) {
			ps.setInt(1, gender);
			ps.setInt(2, specType);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setColorType(rs.getString("colorType"));		
				product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));			
				product.setPrice(rs.getDouble("price"));
				result.add(product);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Product> typeOfAcc(int specType ) {
		List<Product> result = new ArrayList<Product>();
		
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(typeOfAcc);) {		
			ps.setInt(1, specType);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setColorType(rs.getString("colorType"));		
				product.setAddedTime(rs.getObject("addedTime",LocalDateTime.class));			
				product.setPrice(rs.getDouble("price"));
				result.add(product);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return result;
	}

}
