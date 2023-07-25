package web.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.dao.UserDao;
import web.vo.UserVo;

public class UserDaoImpl implements UserDao {
	private DataSource ds;

	private String login = "select userName FROM User WHERE email=? && password=?";
//	執行sql語法，用於比對login資料是否正確

	public UserDaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/javaFramework");
			// 從 JNDI 中查找名為 "java:comp/env/jdbc/javaFramework" 的 DataSource 物件
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(UserVo userVo) {
		final String sql = "insert into User(userName, address, telephone, email ,password) " + "values( ?, ?, ?, ?, ?)";

		
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userVo.getUserName());
			pstmt.setString(2, userVo.getAddress());
			pstmt.setString(3, userVo.getTelephone());
			pstmt.setString(4, userVo.getEmail());
			pstmt.setString(5, userVo.getPassword());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String selectForLogin(String email, String password) {
		String username = null;
		// 宣告一個用於存放使用者名稱的變數，初始值為 null，對應loginController的if...else
		try (Connection connection = ds.getConnection(); 
			 PreparedStatement pstm = connection.prepareStatement(login);) {
			System.out.println("Dao selectForLogin");
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				// 如果結果集中有資料
				username = rs.getString("userName");
				// 從結果集中取得使用者名稱
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
	}



}
