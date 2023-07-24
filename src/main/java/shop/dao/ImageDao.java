package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import shop.vo.Image;
import shop.vo.Product;

public class ImageDao {

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

	public Image getImageById(int id) {

		String getImageById = "SELECT img1 FROM ProductImg where productImgId = ?;";

		Image img = null;
		

		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(getImageById);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();


			if (rs.next()) {
				img = new Image();
				img.setImg1(rs.getBinaryStream("img1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return img;
	}

}
