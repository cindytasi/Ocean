package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.service.VideoService;
import web.vo.Video;

@WebServlet("/web/controller/insertVideoController")
public class insertVideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VideoService videoService;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		videoService = new VideoService();
		gson = new Gson();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Video video = gson.fromJson(req.getReader(), Video.class);
		
		videoService.insertVideoList(video.getVideoId(), video.getMemberId());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
		
		
		
	}

}
