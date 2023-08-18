package admin.controller.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.service.VideoService;
import admin.service.impl.VideoServiceImpl;
import admin.vo.Video;

@WebServlet("/videoUpdate")
public class videoUpdate extends HttpServlet{

	private VideoService vs;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		vs = new VideoServiceImpl();
		gson = new Gson();
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
		
		// 讀取收到的request資訊
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String reqq = sb.toString();
		Video upVideo = gson.fromJson(reqq, Video.class);
		boolean b = vs.updateVideo(upVideo);
		if(b) {resp.getWriter().write("更新完成");}
		else{resp.getWriter().write("更新失敗");}
		
	}

	

}
