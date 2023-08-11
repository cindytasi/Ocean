package shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import common.Constant;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import shop.service.ProductService;
import shop.vo.ProdIdSizeColorImgStock;
import shop.vo.Product;
import shop.vo.ProductDetail2;
import shop.vo.ShopCartVo;


@WebServlet("/ShopDetailServlet")
public class ShopDetailServlet extends HttpServlet {
	private ProductService productService;
	
	public void init() {
    	productService = new ProductService();
    }  
     
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String color = req.getParameter("color");
		
		ProductDetail2 result = productService.getDetailAll(productName, color);

		Gson gson = new Gson();
		String mappingJson = gson.toJson(result.getProdIdSizeColorImgStockList());
		
		
		//讓下方的四個商品隨機出現
		List<Product> allProductList = productService.getNewAll();
		Random randomizer = new Random();
		Set<Integer> randomNumSet = new HashSet<>();
		while(randomNumSet.size() < 4) {
			int num = randomizer.nextInt(allProductList.size());
			randomNumSet.add(num);
		}
		
		List<Product> randomProductList = new ArrayList<>();
		for(Integer index : randomNumSet) {
			randomProductList.add(allProductList.get(index));
		}
		
		
		req.setAttribute("randomProductList", randomProductList); //存入random的四個商品
		req.setAttribute("detail", result);
		req.setAttribute("defaultColorType", color);
		req.setAttribute("mappingJson", mappingJson);
		req.getRequestDispatcher("/jsp/ShopDetail.jsp").forward(req, res);
		
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		this.doGet(req, res);
	}

}
