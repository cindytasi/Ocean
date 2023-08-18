package admin.controller.Manufacturers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.ManufacturersService;
import admin.service.impl.ManufacturersServiceImpl;

//搜尋全部廠商清單

@WebServlet("/manufacturersSelectController")
public class ManufacturersSelectController extends HttpServlet{
	private ManufacturersService ms;
	
	public ManufacturersSelectController() {
		ms = new ManufacturersServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		//查詢全部
		String adList=ms.findAll();
		resp.setContentType("application/json");
		resp.getWriter().write(adList);
	}

}
