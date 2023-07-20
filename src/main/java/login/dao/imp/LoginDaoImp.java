package login.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import login.dao.LoginDao;

public class LoginDaoImp implements LoginDao {

	private DataSource ds;

	private String login = "select userName FROM User WHERE email=? && password=?";
//	執行sql語法，用於比對login資料是否正確

	public LoginDaoImp() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/javaFramework");
			// 從 JNDI 中查找名為 "java:comp/env/jdbc/javaFramework" 的 DataSource 物件
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public String authenticate(String email, String password) {
		String username = null;
		// 宣告一個用於存放使用者名稱的變數，初始值為 null，對應loginController的if...else
		try (Connection connection = ds.getConnection();
				PreparedStatement pstm = connection.prepareStatement(login);
				) {
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
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
