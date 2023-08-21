package videoPlay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.vo.Video;
import videoPlay.service.VideoPlayService;
import videoPlay.service.Impl.VideoPlayServiceImpl;

@WebServlet("/videoInfo")
public class videoInfo extends HttpServlet{

	private VideoPlayService service;
	private Gson gson;

	@Override
	public void init() throws ServletException {
		service = new VideoPlayServiceImpl();
		gson = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		Integer id = Integer.parseInt(req.getParameter("videoId"));
		
		Video video = service.selectVideoById(id);
		String videoInfo = gson.toJson(video);
		
		resp.setContentType("application/json");
		resp.getWriter().write(videoInfo);
	}
	
}
