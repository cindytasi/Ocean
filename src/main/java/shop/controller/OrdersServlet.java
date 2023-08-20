package shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import shop.service.OrderService;
import shop.vo.ShopCartVo;
import shop.vo.TransportInfoVo;
import web.vo.UserVo;


@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doPost(req , res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//拿userId
		HttpSession session = req.getSession();
		UserVo userVo = (UserVo) session.getAttribute("userVo");
		String userId = String.valueOf(userVo.getUserId());

		req.setCharacterEncoding("UTF-8");
		String productJson = req.getParameter("productJson");
		String transportInfoJson = req.getParameter("transportInfoJson");
		
		TransportInfoVo transportInfoVo = new Gson().fromJson(transportInfoJson, TransportInfoVo.class);
		List<ShopCartVo> productlist = new Gson().fromJson(productJson, new TypeToken<List<ShopCartVo>>(){}.getType());
		    
		    // 調用 OrderService 並傳遞數據
		    OrderService.createOrders(userId, transportInfoVo, productlist);
		    
		    
		    
		  //導向訂單成立頁面
		req.getRequestDispatcher("/html/order-tracking.html").forward(req, res);    
    }

        
        
}


