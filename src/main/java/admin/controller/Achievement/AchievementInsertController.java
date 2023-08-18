package admin.controller.Achievement;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.AchievementService;
import admin.service.impl.AchievementServiceImpl;
import admin.vo.Achievement;

//新增成就

@WebServlet("/AchievementInsertController")
public class AchievementInsertController extends HttpServlet {
	private AchievementService aservice;
	//創建service實體
	public AchievementInsertController() {
		aservice = new AchievementServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		//讀取request內容到StringBuilder
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestBody = sb.toString();
		
		Gson gson = new Gson();
		//使用gson歸類VO的key、value
		Achievement ach = gson.fromJson(requestBody, Achievement.class);
		//呼叫service方法
		String msg = aservice.insert(ach);
		if ("1".equals(msg)) {
			msg = "新增完成";
		} else {
			msg = "新增失敗";
		}
		resp.setContentType("application/json");
		resp.getWriter().write(msg);
	}

}
