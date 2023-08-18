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

//修改成就

@WebServlet("/AchievementUpdateController")
public class AchievementUpdateController extends HttpServlet {
	private AchievementService aservice;

	//創建service實體
	public AchievementUpdateController() {
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
		
		Achievement ach = new Achievement();
		Gson gson = new Gson();
		//使用gson歸類VO的鍵值
		ach = gson.fromJson(requestBody, Achievement.class);
		//呼叫service的update方法
		String msg = aservice.update(ach);

		resp.setContentType("application/json");
		

		if (!"0".equals(msg)) {

			resp.getWriter().write("更新完成!");
		} else {
			resp.getWriter().write("更新失敗!");
		}
	}

}
