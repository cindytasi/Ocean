package manufactur.dao;


import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import manufactur.vo.Product;
//
//import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Emp3;//這句是為了要多方位查詢

public class Manufacturs2DAOimpl implements Manufacturs2DAO {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB3");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
//			final String sql = 
			"insert into ProductInformation(productName, specType,specInfo,sizeType,colorType,comId,addedTime,reviewTime , price,videoName,productImgId,inStock,gender) " + "values( ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
//		"INSERT INTO emp3 (ename,job,hiredate,sal,comm,upFiles,deptno) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
//	final String sql =
			"select * from ProductInformation ";
//		"SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp3 order by empno";
//	private static final String GET_ONE_STMT = 
//		"SELECT empno,ename,job,hiredate,sal,comm,upFiles,deptno FROM emp3 where empno = ?";
//	private static final String DELETE = 
//		"DELETE FROM emp3 where empno = ?";
	
//新增商品

@Override
public void insert(Product product) {

	Connection con = null;
	PreparedStatement pstmt = null;

	try {

		con = ds.getConnection();
		pstmt = con.prepareStatement(INSERT_STMT);

		 
		pstmt.setString(1, product.getProductName());
		pstmt.setInt(2, product.getSpecType());
		pstmt.setString(3, product.getSpecInfo());
		pstmt.setString(4, product.getSizeType());
		pstmt.setString(5, product.getColorType());
		pstmt.setInt(6, product.getComId());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//pstmt.setString(7,  timestamp.toString());
		pstmt.setTimestamp(7,  product.getAddedTime());			
		pstmt.setString(8,  timestamp.toString());
		pstmt.setDouble(9, product.getPrice());
		pstmt.setString(10, "hekkkk");
		pstmt.setInt(11, product.getProductImgId());
		pstmt.setInt(12, product.getInStock());
		pstmt.setInt(13, product.getGender());

		pstmt.executeUpdate();

		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

}

//刪除已上架的東西

//@Override
//public void delete(Integer empno) {
//
//	Connection con = null;
//	PreparedStatement pstmt = null;
//
//	try {
//
//		con = ds.getConnection();
//		pstmt = con.prepareStatement(DELETE);
//
//		pstmt.setInt(1, empno);
//
//		pstmt.executeUpdate();
//
//		// Handle any driver errors
//	} catch (SQLException se) {
//		throw new RuntimeException("A database error occured. "
//				+ se.getMessage());
//		// Clean up JDBC resources
//	} finally {
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (con != null) {
//			try {
//				con.close();
//			} catch (Exception e) {
//				e.printStackTrace(System.err);
//			}
//		}
//	}
//
//}
//顯示已上架的商品
@Override
public List<Product> getAll2() {
	List<Product> list = new ArrayList<Product>();
	Product product = null;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		con = ds.getConnection();
		pstmt = con.prepareStatement(GET_ALL_STMT);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			// empVO 也稱為 Domain objects
			Product product2 = new Product();
			// product.setProductId(rs.getInt("productId"));
			product2.setProductName(rs.getString("productName"));
		product2.setSpecType(rs.getInt("specType"));
//			product.setSpecInfo(rs.getString("specInfo"));
		product2.setSizeType(rs.getString("sizeType"));
//			product.setColorType(rs.getString("colorType"));
//			product.setComId(rs.getInt("comId"));			
//			product.setAddedTime(rs.getTimestamp("addedTime"));
			//product.setReviewTime(rs.getObject("reviewTime",LocalDateTime.class));
			product2.setPrice(rs.getDouble("price"));
			//product.setVideoName(rs.getString("videoName"));
			//product.setProductId(rs.getInt("productImgId"));
			product2.setInStock(rs.getInt("inStock"));
			//product.setGender(rs.getInt("gender"));
			list.add(product2);
		}

		// Handle any driver errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. "
				+ se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	return list;
}
////顯示已上架的商品以名稱搜

//@Override
//public List<EmpVO> getAll(Map<String, String[]> map) {
//	List<EmpVO> list = new ArrayList<EmpVO>();
//	EmpVO empVO = null;
//
//	Connection con = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	try {
//		
//		con = ds.getConnection();
//		String finalSQL = "select * from emp3 "
//	          + jdbcUtil_CompositeQuery_Emp3.get_WhereCondition(map)
//	          + "order by empno";
//		pstmt = con.prepareStatement(finalSQL);
//		System.out.println("●●finalSQL(by DAO) = "+finalSQL);
//		rs = pstmt.executeQuery();
//
//		while (rs.next()) {
//			empVO = new EmpVO();
//			empVO.setEmpno(rs.getInt("empno"));
//			empVO.setEname(rs.getString("ename"));
//			empVO.setJob(rs.getString("job"));
//			empVO.setHiredate(rs.getDate("hiredate"));
//			empVO.setSal(rs.getDouble("sal"));
//			empVO.setComm(rs.getDouble("comm"));
//			empVO.setDeptno(rs.getInt("deptno"));
//			list.add(empVO); // Store the row in the List
//		}
//
//		// Handle any SQL errors
//	} catch (SQLException se) {
//		throw new RuntimeException("A database error occured. "
//				+ se.getMessage());
//	} finally {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (con != null) {
//			try {
//				con.close();
//			} catch (Exception e) {
//				e.printStackTrace(System.err);
//			}
//		}
//	}
//	return list;
//}
}