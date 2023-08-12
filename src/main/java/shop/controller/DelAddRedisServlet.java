package shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import responseutil.ResponseUtils;
import shop.vo.ApiConstants;
import shop.vo.BaseAPIResult;
import shop.vo.ShopCartVo;


@WebServlet("/DelAddRedisServlet")
public class DelAddRedisServlet extends HttpServlet {
	private static final String shopCartRedisKey = "shopCart";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		
		String productId = request.getParameter("productId");
		String productcomId = request.getParameter("productcomId");
		int inStock = Integer.valueOf(request.getParameter("inStock"));
		String productImgId = request.getParameter("productImgId");
		String prodName = request.getParameter("prodName");
		String selectedColor = request.getParameter("selectedColor");
		String selectedSize = request.getParameter("selectedSize");
		int updateQuantityValue = Integer.valueOf(request.getParameter("quantityValue"));
		double price = Double.valueOf(request.getParameter("price"));
		String type = request.getParameter("type");  //拿到前端來的type
		BaseAPIResult<Map> result = new BaseAPIResult();
		Map map = new HashMap();//用來裝要response的result
		//===================用try-with-resources 可以自動關閉=============
				JedisPool pool = JedisUtil.getJedisPool(); 
				try (Jedis jedis = pool.getResource();){
	
					String userId = "1"; // 假設userid=1 (設一個假資料)								
					String cart = jedis.get(shopCartRedisKey + ":" + userId);
					String cartkey = shopCartRedisKey + ":" + userId;//拿到redis 該userId購物車的key
					Gson gson = new Gson();					
					List<ShopCartVo> shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
					
					//用前端傳來的type判斷 add/minus/delete/Alldelete										
					if("add".equals(type)) {
						for (ShopCartVo prod : shopCartVoList) {
						    if (prod.getProductId().equals(productId)) {
						        // 找到相同產品，則對該產品做加總
	
						        prod.setQuantityValue(updateQuantityValue); 
						        break;
						    }
						};
						jedis.set(shopCartRedisKey + ":" + userId, new Gson().toJson(shopCartVoList));
						
						
					}else if("minus".equals(type)) {
						for (ShopCartVo prod : shopCartVoList) {
						    if (prod.getProductId().equals(productId)) {
						        // 找到相同產品，則對該產品做加總
						        prod.setQuantityValue(updateQuantityValue);
						        break;
						    }
						};
						jedis.set(shopCartRedisKey + ":" + userId, new Gson().toJson(shopCartVoList));
						
						
					}else if("delete".equals(type)) {
						
						  // 遍歷 List，找到並刪除指定的物件
				        Iterator<ShopCartVo> iterator = shopCartVoList.iterator();
				        while (iterator.hasNext()) {
				        	ShopCartVo prod = iterator.next();
				            if (prod.getProductId().equals(productId)) {
				                iterator.remove();
				            }
				        }
				        // 將更新後的 List 轉換為 JSON 字串
				        String updatedJsonString = gson.toJson(shopCartVoList);
				        // 將更新後的 JSON 字串存回 Redis
				        jedis.set(cartkey, updatedJsonString);
								
						
					}else if("Alldelete".equals(type)) {
						
						jedis.del(cartkey);						
						map.put("type", type);	
						result.setData(map);
						return;
					};
					
										
					cart = jedis.get(shopCartRedisKey + ":" + userId);//重新獲取購物車數據										
					map.put("type", type);	//ajax回應需要type和status數據，但我status預設是1，所以不用加入
					result.setData(map);

	
				} catch (Exception e) {
					e.printStackTrace();
					result.setStatus(ApiConstants.STATUS_FAIL);
				} 

				ResponseUtils.sendJsonResponse(response, new Gson().toJson(result));

			};




}
