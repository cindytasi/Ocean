package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import common.Constant;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.util.JedisUtil;
import shop.vo.ShopCartVo;
import web.vo.UserVo;

@WebFilter(urlPatterns = { "/ShopCartDetailServlet","/ShopDetailServlet" ,"/MainShopServlet","/ShopServlet","/SelectBarServlet",
		"/DelAddRedisServlet","/CheckoutServlet","/SelectWishListServlet","/DelWishListServlet"})
public class RedisFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		JedisPool pool = JedisUtil.getJedisPool(); 
		try (Jedis jedis = pool.getResource();){
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession();
			UserVo userVo = (UserVo)session.getAttribute("userVo"); // 取得 userId 属性，返回的是 Object 类型，但因為Kai給的是Vo，我要轉型成Vo的類型才能取得他的值
			// 判斷 userVo 是否為 null，如果不為 null，則轉型成 String
			String userId = null;//預設要傳入的userId
			if (userVo != null) {
				userId = String.valueOf(userVo.getUserId()); // 將 userVo 轉型成 String
			} else {
				res.sendRedirect(req.getContextPath()+"/login/login.html");//用到重定向，讓原本要導入的頁面導到指定的url裡(login頁面)
				//request.getRequestDispatcher("/LogServlet").forward(request, response);這裡不能這樣寫這樣不會跳轉
				return ;
			}	
			String cart = jedis.get(Constant.shopCartRedisKey + ":" + userId);
			int cartSize = 0;
			if(cart == null) {
				List<ShopCartVo> newList = new ArrayList<ShopCartVo>();
				jedis.set(Constant.shopCartRedisKey  + ":" + userId, new Gson().toJson(newList));
			}else {
				Gson gson = new Gson();
				List<ShopCartVo> shopCartVoList = gson.fromJson(cart, new TypeToken<List<ShopCartVo>>(){}.getType());
				cartSize = shopCartVoList.size();
			}
			request.setAttribute("cartSize", cartSize);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
