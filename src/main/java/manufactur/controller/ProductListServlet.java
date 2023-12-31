package manufactur.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import manufactur.dao.ManufactursDAO;
import manufactur.dao.ManufactursDAOimpl;
import manufactur.service.ManufacturServiceimpl;
import manufactur.service.ManufacturService;
import manufactur.vo.Product;
import manufactur.vo.ProductLink;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {

	private ManufactursDAO dao;
	private ManufacturService manufacturService;

	// 在這個 init 方法中，通常會在 Servlet 被初始化時調用。Servlet 容器會在第一次請求到達該 Servlet 時自動調用 init
	// 方法，以便初始化一些必要的物件和資源，這樣該 Servlet 就可以正確地處理後續的請求。
	public void init() {
		manufacturService = new ManufacturServiceimpl();
		dao = new ManufactursDAOimpl();
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset=UTF-8");
		System.out.println("ddd");// 測試console
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		   } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		   }

		Gson gson = new Gson();
//		Product product = gson.fromJson(req.getReader(), Product.class);

		List<Product> list = dao.selectAll();
//		System.out.println(list);
		
		String product = gson.toJson(list);
		

		res.getWriter().write(product);//: 這行程式碼將 JSON 格式的字串 product 寫入到 HTTP 回應中，並返回給客戶端。這樣，客戶端就會收到 JSON 格式的資料。

		// return ResponseEntity.ok(user);

//        String res = "{\"successful\": true, \"message\": \"OK\"}";   如果你在前面的程式碼中設定 res 為 "{\"successful\": true, \"message\": \"OK\"}"，那麼客戶端就會接收到這個 JSON 格式的回應，並可以解析這個 JSON 來獲取相關的資訊。
//        resp.getWriter().write(res);   用於將字串寫入 HTTP 響應的正文中，將該字串作為回應返回給客戶端。這是在 Servlet 中常見的一種回應方式，通常用於返回 JSON 資料或其他類型的字串資料。
//        

//		 res.setContentType("application/json");
//		    res.setCharacterEncoding("utf-8");
//		    res.getWriter().write("success");
	
	
	
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
