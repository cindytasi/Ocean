package admin.controller.video;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.VideoService;
import admin.service.impl.VideoServiceImpl;

@WebServlet("/videoSerch")
public class videoSerch extends HttpServlet{
	private VideoService vs;
	
	@Override
	public void init() throws ServletException {
		vs = new VideoServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		//查詢單筆
		String requestBody = sb.toString();
		String[] tmp = requestBody.split(":");
		requestBody = tmp[1].substring(1,tmp[1].length()-2);
		String ress = vs.serchVideo(requestBody);
		
		resp.getWriter().write(ress);
	}

	
}
