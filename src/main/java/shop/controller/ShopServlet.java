package shop.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import shop.service.ProductService;
import shop.vo.Product;
import shop.vo.ShopCartVo;
import web.vo.UserVo;


@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final String shopCartRedisKey = "shopCart";
	private ProductService productService;
	
    public void init() {
    	productService = new ProductService();
    }   
	
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//===============讓購物車上的數字統一===============

		JedisPool pool = JedisUtil.getJedisPool(); 
		try (Jedis jedis = pool.getResource();){
			HttpSession session = req.getSession();
			UserVo userVo = (UserVo) session.getAttribute("userVo");
			String userId = String.valueOf(userVo.getUserId());
			String cart = jedis.get(shopCartRedisKey + ":" + userId);
			Gson gson = new Gson();
			List<ShopCartVo> shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>() {
			}.getType());
			int cartSize = shopCartVoList.size();
			req.setAttribute("cartSize", cartSize);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		
		
		String type = (String)req.getParameter("type");	
		List<Product> list = productService.getTopBarData(type);
		req.setAttribute("product", list);	
		req.getRequestDispatcher("/jsp/Shop.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}

}
