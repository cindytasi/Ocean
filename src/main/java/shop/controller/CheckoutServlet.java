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
import com.mysql.cj.util.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import responseutil.ResponseUtils;
import shop.vo.ApiConstants;
import shop.vo.BaseAPIResult;
import shop.vo.CheckoutVo;
import shop.vo.Product;
import shop.vo.ShopCartVo;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//先轉換編碼，並拿前端的兩個json(一個是訂單詳情、一個是應付金額等total資料)
		request.setCharacterEncoding("UTF-8");
		String productJson =  request.getParameter("productJson");
		Gson gson = new Gson();
		List<ShopCartVo> productList = gson.fromJson(productJson, new TypeToken<List<ShopCartVo>>() {}.getType());
		
		
		String checkoutJson =  request.getParameter("checkoutJson");
		CheckoutVo checkoutVo = gson.fromJson(checkoutJson, CheckoutVo.class);
		
		request.setAttribute("productJson", productJson);
		request.setAttribute("productList", productList);
		request.setAttribute("checkoutJson", checkoutJson);
		request.setAttribute("checkoutVo", checkoutVo);
		
		request.getRequestDispatcher("/jsp/Checkout.jsp").forward(request, response);
	};

};
