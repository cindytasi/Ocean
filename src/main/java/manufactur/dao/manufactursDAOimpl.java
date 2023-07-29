package manufactur.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import com.emp.model.EmpVO;

import manufactur.vo.Product;

public class manufactursDAOimpl implements manufactursDAO {

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
		  List<Product> dd  = new manufactursDAOimpl().selectAll();
//		  for(Product pp:dd) {System.out.println(pp);}
		  for(Product pp:dd) {System.out.println(pp.toString());}	
		 
	
		 
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
//				product.setSpecType(rs.getInt("specType"));
//				product.setSpecInfo(rs.getString("specInfo"));
//				product.setSizeType(rs.getString("sizeType"));
				product.setColorType(rs.getString("colorType"));
//				product.setComId(rs.getInt("comId"));			
				product.setAddedTime(rs.getTimestamp("addedTime"));
				//product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
				product.setPrice(rs.getDouble("price"));
				//product.setVideoName(rs.getString("videoName"));
				//product.setProductId(rs.getInt("productImgId"));
				//product.setInStock(rs.getInt("inStock"));
				//product.setGender(rs.getInt("gender"));
				list.add(product);
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
	  String sql = "UPDATE product "
	            + "SET ProductName = ?, SpecType = ?, SizeType = ?, InStock = ?, Gender = ? "
	            + "WHERE ProductId = ?"; // 假設 ProductId 是用於唯一識別 Product 的主鍵
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
			pstmt.setInt(5, product.getGender());
			System.out.println("Executing SQL query: " + pstmt);   //測試有沒有資料
			
			rowCount = pstmt.executeUpdate();
			 System.out.println("Rows updated: " + rowCount);   //測試有沒有資料
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	  return rowCount != 0;
	 }
	
	
	

	
	
	
	
	
	
	
	
//	@Override
//	public int insert(Product product) {
//		final String sql = "insert into MEMBER(USERNAME, PASSWORD, NICKNAME, ROLE_ID) " + "values(?, ?, ?, ?)";
//		try (
//				Connection conn = DriverManager.getConnection(url,user,password);
//			PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, product.getProductName());
//			pstmt.setString(2, product.ColorType());
//			pstmt.setString(3, product.addedTime());
//			pstmt.setInt(4, product.getprice());
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
	
	
	
	
	
	
	
}
