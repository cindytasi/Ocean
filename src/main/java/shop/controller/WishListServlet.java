package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import shop.service.SelectOrdersService;
import shop.service.WishListService;
import web.vo.UserVo;


@WebServlet("/WishListServlet")
public class WishListServlet extends HttpServlet {
	private static WishListService wishListService;

	static {
		wishListService = new WishListService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//拿userId
		HttpSession session = req.getSession();
		UserVo userVo= (UserVo)session.getAttribute("userVo");	
		String userId = String.valueOf(userVo.getUserId());
		
		String colorType= req.getParameter("colorType");
		String prodName= req.getParameter("prodName");
		String price= req.getParameter("price");
		String productImgId= req.getParameter("productImgId");
		boolean success = wishListService.insertWishListItem(userId, prodName, colorType, price, productImgId);
		
		
	    JSONObject jsonResponse = new JSONObject(); // 创建一个 JSON 对象
		Gson gson = new Gson();
	
	    if (success) {
	        jsonResponse.put("status", "success");
	        jsonResponse.put("message", "商品已加入願望清單！");
	    } else {
	        jsonResponse.put("status", "error");
	        jsonResponse.put("message", "願望清單已經有此商品囉~");
	    }

	    res.setContentType("application/json");
	    res.setCharacterEncoding("UTF-8");
	    res.getWriter().write(jsonResponse.toString()); // 将 JSON 对象写入响应
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		this.doGet(req, res);
	}

}
