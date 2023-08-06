package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import common.Constant;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import shop.vo.ShopCartVo;

@WebFilter(urlPatterns = { "/ShopCartDetailServlet","/ShopDetailServlet" ,"/MainShopServlet","/ShopServlet"})
public class RedisFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		JedisPool pool = JedisUtil.getJedisPool(); 
		try (Jedis jedis = pool.getResource();){
//			HttpServletRequest req = (HttpServletRequest) request;
//			HttpSession session = req.getSession();
//			Object userIdObj = session.getAttribute("userId"); // 取得 userId 属性，返回的是 Object 类型
			// 判斷 userIdObj 是否為 null，如果不為 null，則轉型成 String
//			String userId = null;
//			if (userIdObj != null) {
//			    userId = userIdObj.toString(); // 將 userIdObj 轉型成 String
//			} else {
//				request.getRequestDispatcher("/LogServlet").forward(request, response);
//				return ;
//			}
			String userId = "1";	
			String cart = jedis.get(Constant.shopCartRedisKey + ":" + userId);
			Gson gson = new Gson();
			List<ShopCartVo> shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
			int cartSize = shopCartVoList.size();
			request.setAttribute("cartSize", cartSize);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
