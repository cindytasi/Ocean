package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import shop.vo.OrderVO;
import shop.vo.WishList;

public class WishListDAO {
	

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
	
    public boolean insertWishListItem(String userId, String prodName, String colorType, String price, String productImgId) {
    	
    	
    	if (checkWishListItem(userId, prodName, colorType)) {
            return false; // 要是商品已經存在於資料庫，則不允許加入
        }
    	
        String insertQuery = "INSERT INTO WishList (userId, prodName, price, colorType, productImgId) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertQuery)) {

            ps.setString(1, userId);
            ps.setString(2, prodName);
            ps.setString(3, price);
            ps.setString(4, colorType);
            ps.setString(5, productImgId);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 添加方法检查是否存在相同的愿望清单商品
    public boolean checkWishListItem(String userId, String prodName, String colorType) {
    	
    	List<WishList> result = new ArrayList<WishList>();
        String selectQuery = "SELECT COUNT(*) AS count FROM WishList WHERE userId = ? AND prodName = ? AND colorType = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(selectQuery)) {

            ps.setString(1, userId);
            ps.setString(2, prodName);
            ps.setString(3, colorType);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
    
    public List<WishList> selectWishListByUserId(String userId) {
        List<WishList> wishList = new ArrayList<>();
        String query = "SELECT * FROM WishList WHERE userId = ?";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, Integer.valueOf(userId));
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WishList item = new WishList();
                item.setWishListId(rs.getInt("wishListId"));
                item.setUserId(rs.getInt("userId"));
                item.setProdName(rs.getString("prodName"));
                item.setPrice(rs.getDouble("price"));
                item.setColorType(rs.getString("colorType"));
                item.setProductImgId(rs.getInt("productImgId"));
                wishList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return wishList;
    }
	
    public boolean deleteWishListItem(String userId, String wishListId) {
        String deleteQuery = "DELETE FROM WishList WHERE userId = ? AND wishListId = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteQuery)) {

            ps.setInt(1, Integer.valueOf(userId));
            ps.setInt(2, Integer.valueOf(wishListId));

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
	
	
	
	
	
	
	
	

}
