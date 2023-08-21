package videoPlay.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import admin.vo.Video;
import videoPlay.dao.VideoPlayDao;
import videoPlay.dao.Impl.VideoPlayDaoImpl;
import videoPlay.service.VideoPlayService;
import videoPlay.service.Impl.VideoPlayServiceImpl;

@WebServlet("/VideoOutput")
public class VideoOutput extends HttpServlet{
	private VideoPlayService service;

	@Override
	public void init() throws ServletException {
		service = new VideoPlayServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		Integer id = Integer.parseInt(req.getParameter("videoId"));

		String videoName  = service.selectVideoById(id).getVideoName();
		
		System.out.println(videoName);
		resp.setContentType("video/mp4");
		FileInputStream fio = new FileInputStream(String.format(System.getProperty("catalina.base")+"\\webapps\\videos\\"+videoName+"\\"+videoName+".mp4"));

		resp.getOutputStream().write(fio.readAllBytes());
		
	}

	
}
