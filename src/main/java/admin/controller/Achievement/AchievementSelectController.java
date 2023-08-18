package admin.controller.Achievement;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AchievementService;
import admin.service.impl.AchievementServiceImpl;

//成就列表

@WebServlet("/AchievementSelectController")
public class AchievementSelectController extends HttpServlet {
	private AchievementService aservice;

	//創建service實體
	public AchievementSelectController() {
		aservice = new AchievementServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		
		//呼叫service查詢全部清單
		String all = aservice.findAll();
		resp.setContentType("application/json");
		resp.getWriter().write(all);
	}

}
