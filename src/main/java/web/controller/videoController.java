package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.service.VideoService;
import web.vo.Video;

@WebServlet("/web/controller/videoController")
public class videoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private VideoService videoService;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		videoService = new VideoService();
		gson = new Gson();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
					
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Video video =gson.fromJson(req.getReader(), Video.class);
		
		List<Video> videos = videoService.getAllMovieVideo(video.getType(),video.getVideoType(),video.getMemberId());
		
		String json = gson.toJson(videos);
		
	    resp.getWriter().write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req,resp);
	}

	
	
}
