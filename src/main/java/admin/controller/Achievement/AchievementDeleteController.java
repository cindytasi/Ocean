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


//刪除成就

@WebServlet("/AchievementDeleteController")
public class AchievementDeleteController extends HttpServlet {
	
	
	private AchievementService aservice;
	//創建service實體
	public AchievementDeleteController() {
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
		//使用split分一半
		String[] requestBody = sb.toString().split(":");
		//取得ID
		String id = requestBody[1].substring(1, requestBody[1].length()-2);
		String resmsg = aservice.delete(Integer.parseInt(id));

		resp.setContentType("application/json");
		
		if (!"0".equals(resmsg)) {
			resp.getWriter().write("刪除完成!");
		} else {
			resp.getWriter().write("刪除失敗!");
		}

	}

}
