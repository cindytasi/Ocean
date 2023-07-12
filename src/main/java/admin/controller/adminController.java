package admin.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.adminService;
import admin.service.impl.adminServiceImpl;
import admin.vo.adminVo;

@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private adminService adService;

	@Override
	public void init() throws ServletException {
		adService = new adminServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");

		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();

		if ("".equals(requestBody)) {
			
			String adList = adService.findAll();
			
			resp.setContentType("application/json");
			var out = resp.getWriter();
			out.write(adList);
		}else {
			
			doPost(req,resp);
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");

		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();
		adminVo adVo = new adminVo();
		
		Gson gson = new Gson();
		adVo = gson.fromJson(requestBody, adminVo.class);
		
		String adList = adModeSelecter(adVo);
		resp.setContentType("application/json");
		var out = resp.getWriter();
		out.write(adList);
	}

	public String adModeSelecter(adminVo adVo) {
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
