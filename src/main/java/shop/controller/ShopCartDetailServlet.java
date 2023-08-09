package shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import responseutil.ResponseUtils;
import shop.vo.ApiConstants;
import shop.vo.BaseAPIResult;
import shop.vo.ShopCartVo;


@WebServlet("/ShopCartDetailServlet")
public class ShopCartDetailServlet extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		JedisPool pool = JedisUtil.getJedisPool(); 
		try (Jedis jedis = pool.getResource();){
			

						
			String userId = "1"; // 假設userid=1 (設一個假資料)								
			String cart = jedis.get(Constant.shopCartRedisKey + ":" + userId);
			Gson gson = new Gson();
			List<ShopCartVo> shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
			
			

			Set<String> productcomIdSet = new HashSet<String>();
			for(ShopCartVo shopcart : shopCartVoList) {
				productcomIdSet.add(shopcart.getProductcomId());
			}
			
			List<List<ShopCartVo>> result = new ArrayList<>();
			for(String productcomId : productcomIdSet) {
				List<ShopCartVo> shopCartGroupByComIdList = new ArrayList<>();
				for(ShopCartVo shopcart : shopCartVoList) {
					if(shopcart.getProductcomId().equals(productcomId)) {
						shopCartGroupByComIdList.add(shopcart);
					}
				}
				
				result.add(shopCartGroupByComIdList);
			}
			
			req.setAttribute("prod", result);
			req.getRequestDispatcher("/jsp/Cart.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
