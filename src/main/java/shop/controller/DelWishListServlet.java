package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.WishListService;


@WebServlet("/DelWishListServlet")
public class DelWishListServlet extends HttpServlet {
	
	private static WishListService wishListService;

	static {
		wishListService = new WishListService();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userId = "1";
		String wishlistId = req.getParameter("wishlistId");

		boolean success = wishListService.deleteWishListItem(userId, wishlistId);

		if (success) {
			res.getWriter().write("刪除成功！");
		} else {
			res.getWriter().write("删除失敗！");
		}
	}

	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		this.doGet(req, res);
	}

}
