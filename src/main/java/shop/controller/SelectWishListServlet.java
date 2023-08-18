package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.WishListService;
import shop.vo.WishList;


@WebServlet("/SelectWishListServlet")
public class SelectWishListServlet extends HttpServlet {
	private static WishListService wishListService;

	static {
		wishListService = new WishListService();
	}
	
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 	String userId = "1"; // 获取用户ID，这里是假设的
	        List<WishList> wishList = wishListService.getWishListByUserId(userId);
	        
	        req.setAttribute("wishList", wishList);
	        req.getRequestDispatcher("/jsp/Wishlist.jsp").forward(req, res);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
