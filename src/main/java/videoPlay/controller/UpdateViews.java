package videoPlay.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import videoPlay.service.VideoPlayService;
import videoPlay.service.Impl.VideoPlayServiceImpl;

@WebServlet("/UpdateViews")
public class UpdateViews extends HttpServlet{

	private VideoPlayService vp;
	@Override
	public void init() throws ServletException {
		vp = new VideoPlayServiceImpl();
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
		//取得ID
		String tmp = sb.toString();
		String[] split = tmp.split(":");
		String id = split[1].substring(0,split[1].length()-1);
		Integer views = vp.TimesWatched(Integer.valueOf(id));
		System.out.println(views);
		resp.setContentType("text/plain");
		resp.getWriter().write(""+views+"");
	}
}
