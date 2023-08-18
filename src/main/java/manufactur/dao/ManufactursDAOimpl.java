package manufactur.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//import com.emp.model.EmpVO;

import manufactur.vo.Product;
import manufactur.vo.ProductLink;

public class ManufactursDAOimpl implements ManufactursDAO {

//	@Override
//	public List<Product> selectAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	private static DataSource dataSource;
	private final static String url="jdbc:mysql://localhost:3306/Ocean?serverTimezone=Asia/Taipei";
	 private final static String user="root";
	 private final static String password="password";
	 
	  public static void main(String[] args) {
//		  List<Product> dd  = new ManufactursDAOimpl().selectAll();
//		  for(Product pp:dd) {System.out.println(pp);}
//		  for(Product pp:dd) {System.out.println(pp.toString());}	 //檢測selectall用
		  final String sql = "insert into ProductInformation(ProductId,productName, specType,specInfo,sizeType,colorType,comId,addedTime,reviewTime , price,videoName,productImgId,inStock,gender) " + "values(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";		 
		  ManufactursDAOimpl manufactursDAOimpl =new ManufactursDAOimpl();
		  Product product =new Product();	
		  product.setProductId(2);
		  product.setProductName("kelly");
			product.setSpecType(1);
			product.setSpecInfo("BIGGEST");
			product.setSizeType("xl");
			product.setColorType("BIGGEST");
			product.setComId(3);
			product.setAddedTime(Timestamp.valueOf("2023-07-30 14:16:26"));
			product.setReviewTime(Timestamp.valueOf("2023-07-30 14:16:26"));

			String num ="200";
	Double numss =Double.parseDouble(num);
			
			product.setPrice(numss); 
			
			
			product.setVideoName("monster");
			product.setProductId(1);
			product.setInStock(12);
			product.setGender(1);
			

		  System.out.println( manufactursDAOimpl.insert(product) );
		  
		  
	
		 
	}
	  //最普通的select全部      
	@Override
	public List<Product> selectAll() {
		final String sql = "select * from ProductInformation ";
		try (
				//這個drivermanager僅供測試用
				Connection conn = DriverManager.getConnection(url,user,password);
			    PreparedStatement pstmt = conn.prepareStatement(sql);
			    ResultSet rs = pstmt.executeQuery()) {
				
//			Connection conn = getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery()) {
			List<Product> list = new ArrayList<>();
			while (rs.next()) {
				Product product = new Product();
				// product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
			product.setSpecType(rs.getInt("specType"));
//				product.setSpecInfo(rs.getString("specInfo"));
			product.setSizeType(rs.getString("sizeType"));
	//			product.setColorType(rs.getString("colorType"));
//				product.setComId(rs.getInt("comId"));			
	//			product.setAddedTime(rs.getTimestamp("addedTime"));
				//product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
				product.setPrice(rs.getDouble("price"));
				//product.setVideoName(rs.getString("videoName"));
				//product.setProductId(rs.getInt("productImgId"));
				product.setInStock(rs.getInt("inStock"));
				//product.setGender(rs.getInt("gender"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//select 審核狀態碼
	@Override
	public List<ProductLink> selectStatusAll() {
		final String sql = "select * from ProductLink ";
		try (
				//這個drivermanager僅供測試用
				Connection conn = DriverManager.getConnection(url,user,password);
			    PreparedStatement pstmt = conn.prepareStatement(sql);
			    ResultSet rs = pstmt.executeQuery()) {
				
//			Connection conn = getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery()) {
			List<ProductLink> list = new ArrayList<>();
			while (rs.next()) {
				ProductLink productLink = new ProductLink();
				
				productLink.setApprovalStatus(rs.getInt("approvalStatus"));
//				productLink.setSpecType(rs.getInt("specType"));
////				
//				productLink.setSizeType(rs.getString("sizeType"));
//	//			
//				productLink.setPrice(rs.getDouble("price"));
//				
//				productLink.setInStock(rs.getInt("inStock"));
				
				list.add(productLink);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//最普通的update
	@Override
	 public boolean update(Product product) {
	  int rowCount = 0;
	  String sql = "UPDATE ProductInformation "
	            + "SET productName = ?, specType = ?, sizeType = ?, inStock = ?, price = ? "
	            + "WHERE productId = ?"; // 假設 ProductId 是用於唯一識別 Product 的主鍵
	  try (
//	  Connection connection = dataSource.getConnection();
//	    PreparedStatement ps = connection.prepareStatement(sql)
			  Connection conn = DriverManager.getConnection(url,user,password);
			    PreparedStatement pstmt = conn.prepareStatement(sql);
			    ResultSet rs = pstmt.executeQuery()
			  
			  
			  ) {
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getSpecType());
			pstmt.setString(3, product.getSizeType());
			pstmt.setInt(4, product.getInStock());
			pstmt.setDouble(5, product.getPrice());
			System.out.println("Executing SQL query: " + pstmt);   //測試有沒有資料
			
			rowCount = pstmt.executeUpdate();
			 System.out.println("Rows updated: " + rowCount);   //測試有沒有資料
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	  return rowCount != 0;
	 }
	
	
	

	
//	@Override
//	public List<Product> selectAll() {
//		final String sql = "select * from ProductInformation ";
//		try (
//				//這個drivermanager僅供測試用
//				Connection conn = DriverManager.getConnection(url,user,password);
//			    PreparedStatement pstmt = conn.prepareStatement(sql);
//			    ResultSet rs = pstmt.executeQuery()) {
//				
////			Connection conn = getConnection();
////			PreparedStatement pstmt = conn.prepareStatement(sql);
////			ResultSet rs = pstmt.executeQuery()) {
//			List<Product> list = new ArrayList<>();
//			while (rs.next()) {
//				Product product = new Product();
//				// product.setProductId(rs.getInt("productId"));
//				product.setProductName(rs.getString("productName"));
////				product.setSpecType(rs.getInt("specType"));
////				product.setSpecInfo(rs.getString("specInfo"));
////				product.setSizeType(rs.getString("sizeType"));
//				product.setColorType(rs.getString("colorType"));
////				product.setComId(rs.getInt("comId"));			
//				product.setAddedTime(rs.getTimestamp("addedTime"));
//				//product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
//				product.setPrice(rs.getDouble("price"));
//				//product.setVideoName(rs.getString("videoName"));
//				//product.setProductId(rs.getInt("productImgId"));
//				//product.setInStock(rs.getInt("inStock"));
//				//product.setGender(rs.getInt("gender"));
//				list.add(product);
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public int insert(Product product) {
		final String sql = "insert into ProductInformation(ProductId,productName, specType,specInfo,sizeType,colorType,comId,addedTime,reviewTime , price,videoName,productImgId,inStock,gender) " + "values(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
		try (
				Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getSpecType());
			pstmt.setString(4, product.getSpecInfo());
			pstmt.setString(5, product.getSizeType());
			pstmt.setString(6, product.getColorType());
			pstmt.setInt(7, product.getComId());
			pstmt.setTimestamp(8, product.getAddedTime());
			pstmt.setTimestamp(9, product.getReviewTime());
			pstmt.setDouble(10, product.getPrice());
			pstmt.setString(11, product.getVideoName());
			pstmt.setInt(12, product.getProductId());
			pstmt.setInt(13, product.getInStock());
			pstmt.setInt(14, product.getGender());
			
		
			
			
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
//	@Override
//	public int insert(Member member) {
//		final String sql = "insert into MEMBER(USERNAME, PASSWORD, NICKNAME, ROLE_ID) " + "values(?, ?, ?, ?)";
//		try (
//			Connection conn = getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, member.getUsername());
//			pstmt.setString(2, member.getPassword());
//			pstmt.setString(3, member.getNickname());
//			pstmt.setInt(4, member.getRoleId());
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
//	
	
	
	
}
