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
import shop.vo.Product;
import shop.vo.ShopCartVo;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final String shopCartRedisKey = "shopCart";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String selectedSize = request.getParameter("selectedSize");
		String selectedColor = request.getParameter("selectedColor");
		String quantityValue = request.getParameter("quantityValue");
		String prodName = request.getParameter("prodName");
		String productId = request.getParameter("productId");
		String productcomId = request.getParameter("productcomId");
		String inStock = request.getParameter("inStock");
		String price = request.getParameter("price");
		String productImgId = request.getParameter("productImgId");

		BaseAPIResult<Map> result = new BaseAPIResult();

//===================用try-with-resources 可以自動關閉=============
		JedisPool pool = JedisUtil.getJedisPool(); 
		try (Jedis jedis = pool.getResource();){
			
			
				//========先判斷購物車裡有沒有商品=============
						
			String userId = "1"; // 假設userid=1 (設一個假資料)								
			String cart = jedis.get(shopCartRedisKey + ":" + userId);
			Gson gson = new Gson();
			List<ShopCartVo> shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
			//=============購物車為空，則加入產品=============
			if (shopCartVoList == null || "".equals(shopCartVoList) ) {  
				shopCartVoList = new ArrayList<>();
				ShopCartVo shopCartVo = new ShopCartVo();
				shopCartVo.setSelectedSize(selectedSize);
				shopCartVo.setSelectedColor(selectedColor);
				shopCartVo.setQuantityValue(quantityValue);
				shopCartVo.setProdName(prodName);
				shopCartVo.setProductId(productId);
				shopCartVo.setProductcomId(productcomId);
				shopCartVo.setInStock(inStock);
				shopCartVo.setPrice(price);
				shopCartVo.setProductImgId(productImgId);
				shopCartVoList.add(shopCartVo);
				
				jedis.set(shopCartRedisKey + ":" + userId, new Gson().toJson(shopCartVoList));
				
	
			} else {
				//先拿到存入Redis的物件，並將json轉換成List
				gson = new Gson();
				shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
				//=============如果購物車不為空，則判斷是否為同一商品=============		
				
				// 先找到購物車是否有相同的產品
				boolean foundSameProduct = false;
				for (ShopCartVo prod : shopCartVoList) {
				    if (prod.getProductId().equals(productId)) {
				        // 找到相同產品，則對該產品做加總
				        int currentQuantity = Integer.parseInt(prod.getQuantityValue());
				        int newQuantity = currentQuantity + Integer.parseInt(quantityValue);
				        prod.setQuantityValue(String.valueOf(newQuantity));
				        foundSameProduct = true;
				        break;
				    }
				};

				// 如果購物車沒有相同產品，就加入商品
				if (!foundSameProduct) {
				    ShopCartVo shopCartVo = new ShopCartVo();
				    shopCartVo.setSelectedSize(selectedSize);
				    shopCartVo.setSelectedColor(selectedColor);
				    shopCartVo.setQuantityValue(quantityValue);
				    shopCartVo.setProdName(prodName);
				    shopCartVo.setProductId(productId);
				    shopCartVo.setProductcomId(productcomId);
				    shopCartVo.setInStock(inStock);
				    shopCartVo.setPrice(price);
				    shopCartVo.setProductImgId(productImgId);
				    shopCartVoList.add(shopCartVo);
				}

				// 最後將更新後的購物車訊息存入Redis
				jedis.set(shopCartRedisKey + ":" + userId, new Gson().toJson(shopCartVoList));

			};
				
			
			Map map = new HashMap();
			cart = jedis.get(shopCartRedisKey + ":" + userId);
			shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
			
			int cartSize = shopCartVoList.size();
			map.put("shopcartSize", cartSize);	
			result.setData(map);

			
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(ApiConstants.STATUS_FAIL);
		} 

		ResponseUtils.sendJsonResponse(response, new Gson().toJson(result));

	};

};
