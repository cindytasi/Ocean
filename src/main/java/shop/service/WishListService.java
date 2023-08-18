package shop.service;

import java.util.List;

import shop.dao.WishListDAO;
import shop.vo.WishList;

public class WishListService {
	
	private static WishListDAO wishListDAO;

	static {
		wishListDAO = new WishListDAO();
	}


    public boolean insertWishListItem(String userId, String prodName, String colorType, String price, String productImgId) {
        // 调用 WishListDAO 的插入方法
        return wishListDAO.insertWishListItem(userId, prodName, colorType, price, productImgId);
    }
    
    
    
    public List<WishList> getWishListByUserId(String userId) {
        return wishListDAO.selectWishListByUserId(userId);
    }
    
    
    public boolean deleteWishListItem(String userId, String wishlistId) {
        return wishListDAO.deleteWishListItem(userId, wishlistId);
    }
    
}
