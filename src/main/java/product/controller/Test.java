package product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {
	public static void main(String[] args) {

//		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//				Statement stmt = conn.createStatement()) {
//
//			// 取得 User 表的記錄數量，並回傳給for確認需執行次數
//			String sqlCount = "SELECT COUNT(*) FROM User";
////			請將FROM 表單名稱，“表單名稱”修改為需要做修改的表單
//			
//			int recordCount = 0;
//
//			try (ResultSet rs = stmt.executeQuery(sqlCount)) {
//				if (rs.next()) {
//					recordCount = rs.getInt(1);
//					System.out.println("Number of records in table :" + recordCount);
//				}
//			}
//
//			for (int i = 1; i <= recordCount; i++) {
//
//				String sql1 = "UPDATE User SET profilePicture = ? WHERE userid = " + i;
////				UPDATE 表單名稱，“表單名稱”修改為需要做修改的表單，
////				SET 欄位名稱，“欄位名稱”請放入要加入圖片的欄位名稱，
////				userid需改為欲修改表單自動生成ID欄位名稱
//				
//				String path = "/Users/J_s_Kai/Desktop/image/" + i + ".jpg";
////				請確認圖片副檔名為“.jpg"，並可將圖片檔名設為整數，讓程式自動執行
////				請確認上傳圖片的路徑，並將path路徑改為你上傳檔案的路徑
//				
//				try (PreparedStatement ps = conn.prepareStatement(sql1);) {
//					
//					File file = new File(path);
//					FileInputStream fis = null;
//					try {
//						fis = new FileInputStream(file);
//					} catch (FileNotFoundException e) {
//
//						e.printStackTrace();
//					}
//					ps.setBlob(1, fis);
//					int rowCount = ps.executeUpdate();
//					System.out.println(rowCount + " row(s) updated!!" + i);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

	}

}
