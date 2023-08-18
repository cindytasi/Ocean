package admin.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.AdminService;
import admin.service.impl.AdminServiceImpl;
import admin.vo.AdminVo;

//管理員共用controller

@WebServlet("/adminController")
public class AdminController extends HttpServlet {
	private AdminService adService;

	// 創建service實體
	@Override
	public void init() throws ServletException {
		adService = new AdminServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		//查詢全部清單
		String adList = adService.findAll();

		resp.setContentType("application/json");
		var out = resp.getWriter();
		out.write(adList);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		
		//讀取收到的request資訊
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();
		AdminVo adVo = new AdminVo();
		//使用gson歸類VO的鍵值
		Gson gson = new Gson();
		adVo = gson.fromJson(requestBody, AdminVo.class);
		//依據方法類型來執行service方法
		String adList = adModeSelecter(adVo);
		resp.setContentType("application/json");
		resp.getWriter().write(adList);
	}

	//確認方法類型並執行service方法
	public String adModeSelecter(AdminVo adVo) {
		switch (adVo.getAdMode()) {
		case "insert":
			return adService.insert(adVo);

		case "update":
			return adService.update(adVo);

		case "delete":
			return adService.delete(adVo);

		default:
			return adService.findAll();
		}
	}

}
