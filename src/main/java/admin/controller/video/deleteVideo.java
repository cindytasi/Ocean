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

@WebServlet("/deleteVideo")
public class deleteVideo extends HttpServlet{
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
		resp.setContentType("text/plain");
		
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		String requestBody = sb.toString();
		String[] tmp = requestBody.split(":");
		String split = tmp[1].substring(0, tmp[1].length()-1);
		Integer id = Integer.valueOf(split);
		//呼叫service
		boolean b = vs.deleteVideoById(id);
		if(b) {resp.getWriter().write("刪除完成");}
		else {resp.getWriter().write("刪除失敗");}
	}
	
}
