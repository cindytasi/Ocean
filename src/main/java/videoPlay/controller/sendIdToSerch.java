package videoPlay.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;
//
//import admin.vo.Video;
import videoPlay.service.VideoPlayService;
import videoPlay.service.Impl.VideoPlayServiceImpl;

@WebServlet("/sendIdToSerch")
public class sendIdToSerch extends HttpServlet{
	private VideoPlayService vps;
//	private Gson gson;
	@Override
	public void init() throws ServletException {
		vps = new VideoPlayServiceImpl();
//		gson = new Gson();
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
		String id = tmp.substring(1,tmp.length()-1);
//		String videoInfoById = vps.selectVideoById(Integer.valueOf(id));
//		String encoded = URLEncoder.encode(videoInfoById, "UTF-8");
//		req.setAttribute("videoInfoById", videoInfoById);
//		RequestDispatcher rd = req.getRequestDispatcher("/VideoOutput");
//		rd.forward(req, resp);
//		Cookie videoInfo = new Cookie("videoInfoById",URLEncoder.encode(videoInfoById,"UTF-8"));
//		videoInfo.setMaxAge(60*60*24*7);
//		resp.addCookie(videoInfo);

		String redirectURL = req.getContextPath()+"/videoPlay.html?json=";
		System.out.println(redirectURL);
//		resp.getWriter().write(redirectURL+encoded);
	}
}
