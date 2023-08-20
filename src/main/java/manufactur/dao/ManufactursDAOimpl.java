package manufactur.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



//import com.emp.model.EmpVO;

import manufactur.vo.Product;
import manufactur.vo.ProductImg;
import manufactur.vo.ProductLink;
import manufactur.vo.Video;

public class ManufactursDAOimpl implements ManufactursDAO {

//	@Override
//	public List<Product> selectAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	private static DataSource dataSource;
	private final static String url="jdbc:mysql://localhost:3306/Ocean?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	 private final static String user="root";
	 private final static String password="password";
	 
//	  public static void main(String[] args) {
////		  List<Product> dd  = new ManufactursDAOimpl().selectAll();
////		  for(Product pp:dd) {System.out.println(pp);}
////		  for(Product pp:dd) {System.out.println(pp.toString());}	 //檢測selectall用
//		  final String sql = "insert into ProductInformation(productName, specType,specInfo,sizeType,colorType,comId,addedTime,reviewTime , price,videoName,productImgId,inStock,gender) " + "values(?, ?, ?,?,?,?,?,?,?,?,?,?,?)";		 
//		  ManufactursDAOimpl manufactursDAOimpl =new ManufactursDAOimpl();
//		  Product product =new Product();	
//		 
//		  product.setProductName("海灘專用");
//			product.setSpecType(1);
//			product.setSpecInfo("衣服");
//			product.setSizeType("xl");
//			product.setColorType("BIGGEST");
//			product.setComId(3);
//			product.setAddedTime(Timestamp.valueOf("2023-07-30 14:16:26"));
//			product.setReviewTime(Timestamp.valueOf("2023-07-30 14:16:26"));
//
//			String num ="200";
//	Double numss =Double.parseDouble(num);
//			
//			product.setPrice(numss); 
//			
//			
//			product.setVideoName("monster");
//			product.setProductImgId(8);
//			product.setInStock(12);
//			product.setGender(1);
//			
//
//		  System.out.println( manufactursDAOimpl.insert(product) );
//		  
		  
	
		 
//	}
	  //最普通的select全部    //給已上價商品列表用    
	@Override
	public List<Product> selectAll() {
		final String sql = "select * from ProductInformation where comId = 5";
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
				 product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
			product.setSpecType(rs.getInt("specType"));
				product.setSpecInfo(rs.getString("specInfo"));
			product.setSizeType(rs.getString("sizeType"));
				product.setColorType(rs.getString("colorType"));
				product.setComId(rs.getInt("comId"));			
				product.setAddedTime(rs.getTimestamp("addedTime"));
//				product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
			product.setReviewTime(rs.getTimestamp("reviewTime"));
				product.setPrice(rs.getDouble("price"));
				product.setVideoName(rs.getString("videoName"));
				product.setProductImgId(rs.getInt("productImgId"));
				product.setInStock(rs.getInt("inStock"));
				product.setGender(rs.getInt("gender"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//算select出的總比數
	 @Override
	    public int countTotalProducts() {
	        String sql = "SELECT COUNT(*) FROM ProductInformation";
	        try (
	            Connection conn = DriverManager.getConnection(url,user,password);
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery()
	        ) {
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	//select用分頁顯示
	    @Override
	    public List<Product> getProductsByPage(int offset, int limit) {
	        String sql = "SELECT * FROM ProductInformation LIMIT ? OFFSET ?";
	        List<Product> productList = new ArrayList<>();
	        try (
	            Connection conn = DriverManager.getConnection(url,user,password);
	            PreparedStatement pstmt = conn.prepareStatement(sql)
	        ) {
	            pstmt.setInt(1, limit);
	            pstmt.setInt(2, offset);
	            ResultSet rs = pstmt.executeQuery();
	            List<Product> list = new ArrayList<>();
				while (rs.next()) {
					Product product = new Product();
					// product.setProductId(rs.getInt("productId"));
					product.setProductName(rs.getString("productName"));
				product.setSpecType(rs.getInt("specType"));
//					product.setSpecInfo(rs.getString("specInfo"));
				product.setSizeType(rs.getString("sizeType"));
		//			product.setColorType(rs.getString("colorType"));
//					product.setComId(rs.getInt("comId"));			
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
	
	
	
	
	
	
	//select商品置入的 審核狀態碼   給審核結果用
	@Override
	public List<ProductLink> selectStatusCord() {
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
	
	
	
	
	
	
	
	
	
	//select商品置入  給置入商品那頁找時間戳
		@Override
		public List<ProductLink> selectStatusLinkTimestamp () {
			final String sql = "select * from ProductLink ";
			try (
					//這個drivermanager僅供測試用
					Connection conn = DriverManager.getConnection(url,user,password);
				    PreparedStatement pstmt = conn.prepareStatement(sql);
				    ResultSet rs = pstmt.executeQuery()) {
					
//				Connection conn = getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery()) {
				List<ProductLink> list = new ArrayList<>();
				while (rs.next()) {
					ProductLink productLink = new ProductLink();
					
					productLink.setLinkTimestamp(rs.getInt("linkTimestamp"));
//					productLink.setSpecType(rs.getInt("specType"));
////					
//					productLink.setSizeType(rs.getString("sizeType"));
//		//			
//					productLink.setPrice(rs.getDouble("price"));
//					
//					productLink.setInStock(rs.getInt("inStock"));
					
					list.add(productLink);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	
	
	
	  //select影片     置入影片的那個地方的畫面上面的影片  
		@Override
		public List<Video> selectVideoAll() {
			final String sql = "select * from Video ";
			try (
					//這個drivermanager僅供測試用
					Connection conn = DriverManager.getConnection(url,user,password);
				    PreparedStatement pstmt = conn.prepareStatement(sql);
				    ResultSet rs = pstmt.executeQuery()) {
					

				List<Video> list = new ArrayList<>();
				while (rs.next()) {
					Video video = new Video();
					 video.setVideoId(rs.getInt("vidoeId"));
					video.setVideoName(rs.getString("videotName"));
					video.setVideoLength(rs.getInt("videoLength"));
					video.setVideoPath(rs.getString("videoPath"));


					list.add(video);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
		
		
	
	
	
	
	//update商品列表
	
		
		    // ... 其他方法 ...

		@Override
		public int updatelist(Product product, ProductImg productImg) {
		    try (Connection conn = DriverManager.getConnection(url, user, password);
		         PreparedStatement pstmt = conn.prepareStatement("UPDATE ProductImg SET img1=?, img2=?, img3=?, img4=? WHERE productImgId=?")) {
		        
		        // 更新 ProductImg 表中的圖片數據
		        pstmt.setBytes(1, productImg.getImg1());
		        pstmt.setBytes(2, productImg.getImg2());
		        pstmt.setBytes(3, productImg.getImg3());
		        pstmt.setBytes(4, productImg.getImg4());
//		        pstmt.setInt(5, productImg.getProductImgId());

		        int rowsAffectedImg = pstmt.executeUpdate();

		        if (rowsAffectedImg > 0) {
		            // 更新 ProductInformation 表中的產品信息
		            final String sql = "UPDATE ProductInformation SET comId=?, productName=?, specType=?, specInfo=?, sizeType=?, colorType=?, price=?, videoName=?, inStock=?, gender=?, reviewTime=? WHERE productId=?";
		            PreparedStatement updateStatement = conn.prepareStatement(sql);

//		            updateStatement.setInt(1, product.getComId());
		            updateStatement.setString(2, product.getProductName());
		            updateStatement.setInt(3, product.getSpecType());
		            updateStatement.setString(4, product.getSpecInfo());
		            updateStatement.setString(5, product.getSizeType());
		            updateStatement.setString(6, product.getColorType());
		            updateStatement.setDouble(7, product.getPrice());
		            updateStatement.setString(8, product.getVideoName());
		            updateStatement.setInt(9, product.getInStock());
		            updateStatement.setInt(10, product.getGender());
//		            updateStatement.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
//		            updateStatement.setInt(12, product.getProductId());

		            int rowsAffectedProductInfo = updateStatement.executeUpdate();
		            updateStatement.close();

		            return rowsAffectedProductInfo; // 返回影響的行數
		        } else {
		            return -1; // 返回一個錯誤狀態碼
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return -1; // 返回一個錯誤狀態碼
		    }
		}

		
		
		
		
		//只update文字
		@Override
		public int updateProductInformation(Product product) {
		    try (Connection conn = DriverManager.getConnection(url, user, password);
		         PreparedStatement pstmt = conn.prepareStatement("UPDATE ProductInformation SET productName=?, specType=?, sizeType=?, colorType=?, price=?, videoName=?, inStock=?, gender=? WHERE productId=?")) {

		        pstmt.setString(1, product.getProductName());
		        pstmt.setInt(2, product.getSpecType());
		        pstmt.setString(3, product.getSizeType());
		        pstmt.setString(4, product.getColorType());
		        pstmt.setDouble(5, product.getPrice());
		        pstmt.setString(6, product.getVideoName());
		        pstmt.setInt(7, product.getInStock());
       pstmt.setInt(8, product.getGender());
		        pstmt.setInt(9, product.getProductId());

		        int rowsAffected = pstmt.executeUpdate();
		        return rowsAffected; // 返回影響的行數
		    } catch (Exception e) {
		        e.printStackTrace();
		        return -1; // 返回一個錯誤狀態碼
		    }
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
	
	
	
	
	//給上架商品那頁用
//	@Override    
//	public int insert(Product product) {
//		final String sql = "insert into ProductInformation(productName, specType,specInfo,sizeType,colorType,comId,addedTime,reviewTime , price,videoName,productImgId,inStock,gender) " + "values( ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
//		try (
//				Connection conn = DriverManager.getConnection(url,user,password);
//			PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			 
//			pstmt.setString(1, product.getProductName());
//			pstmt.setInt(2, product.getSpecType());
//			pstmt.setString(3, product.getSpecInfo());
//			pstmt.setString(4, product.getSizeType());
//			pstmt.setString(5, product.getColorType());
//			pstmt.setInt(6, product.getComId());
//			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//			//pstmt.setString(7,  timestamp.toString());
//			pstmt.setTimestamp(7,  product.getAddedTime());			
//			pstmt.setString(8,  timestamp.toString());
//			pstmt.setDouble(9, product.getPrice());
//			pstmt.setString(10, "hekkkk");
//			pstmt.setInt(11, product.getProductImgId());
//			pstmt.setInt(12, product.getInStock());
//			pstmt.setInt(13, product.getGender());
////			pstmt.setBytes(13, product.getImg1());
//			
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
	
	//insert照片
	@Override    
	public int insert(Product product ,ProductImg productImg ) {
//		final String sql = "insert into ProductInformation(productName, specType,specInfo,sizeType,colorType,comId,addedTime,reviewTime , price,videoName,productImgId,inStock,gender) " + "values( ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
//		String getIdSql = "INSERT INTO ProductImg (img1, img2,img3,img4) VALUES (?, ?,?, ?)";
	    
		try (
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ProductImg (img1, img2,img3,img4) VALUES (?, ?,?, ?)", Statement.RETURN_GENERATED_KEYS);) {
			// 首先，從另一個表中獲取自動生成的編號
			    pstmt.setBytes(1, productImg.getImg1());
			    pstmt.setBytes(2, productImg.getImg2());
			    pstmt.setBytes(3, productImg.getImg3());
			    pstmt.setBytes(4, productImg.getImg4());
			    
			    int rowsAffected = pstmt.executeUpdate();

			    long generatedId = 0; // 存储自动生成的编号值

			    if (rowsAffected > 0) {
			        ResultSet generatedKeys = pstmt.getGeneratedKeys();
			        if (generatedKeys.next()) {
			            generatedId = generatedKeys.getLong(1); // 获取自动生成的编号值
			        }
			    }
			 // 然後，將獲取到的編號值插入到當前表中
			    final String sql = "insert into ProductInformation(comId,productName, specType,specInfo,sizeType,colorType, price,videoName,productImgId,inStock,gender,addedTime,reviewTime) " + "values(?, ?,?,?,?,?,?,?,?,?,?,?,?)";		    
			    PreparedStatement insertStatement = conn.prepareStatement(sql);
			
			    
//			    insertStatement.setBytes(1, productImg.getImg1());
//		        insertStatement.setBytes(2, productImg.getImg2());
//		        insertStatement.setBytes(3, productImg.getImg3());
//		        insertStatement.setBytes(4, productImg.getImg4());
			    
			    
			    
			  
			
			    
			    insertStatement.setInt(1, product.getComId());
		        insertStatement.setString(2, product.getProductName());
		        insertStatement.setInt(3, product.getSpecType());
		        if(product.getSpecType() == 1) {
		        	insertStatement.setString(4, "衣服");
		        }else if(product.getSpecType() == 2) {
		        	insertStatement.setString(4, "褲子");
		        }else if(product.getSpecType() == 3) {
		        	insertStatement.setString(4, "鞋子");
		        }else if(product.getSpecType() == 4) {
		        	insertStatement.setString(4, "飾品");
		        }else {
		        	insertStatement.setString(4, "其他");
		        }
		        	
		        insertStatement.setString(5, product.getSizeType());
		        insertStatement.setString(6, product.getColorType());
		        insertStatement.setDouble(7, product.getPrice());
		        insertStatement.setString(8, product.getVideoName());
		        insertStatement.setLong(9, generatedId); // 插入第一個生成的编号值
		        insertStatement.setInt(10, product.getInStock());
		        insertStatement.setInt(11, product.getGender());
		        insertStatement.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
		        insertStatement.setTimestamp(13, new Timestamp(System.currentTimeMillis()));
		        int rowsAffectedProductInfo = insertStatement.executeUpdate();

		        insertStatement.close();

		        return rowsAffectedProductInfo; // 返回影響的行數
		    } catch (Exception e) {
		        e.printStackTrace();
		        return -1; // 返回一個錯誤狀態碼
		    }
	}



//	@Override
//	public List<Product> selectByPage(int pageNumber, int itemsPerPage) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//			    
		    
			
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
	
	
	
	
	
	
	
	
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
////	
//	-------------------------------------改新版--------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
}
