package videoPlay.controller;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		resp.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		resp.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(req.getParameter("videoId"));
		Integer views = vp.TimesWatched(id);
		System.out.println(views);
		resp.setContentType("text/plain");
		resp.getWriter().write(""+views+"");
	}
}
