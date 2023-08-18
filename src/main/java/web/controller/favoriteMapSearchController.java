package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.service.FavortieMapService;
import web.vo.Video;


@WebServlet("/web/controller/favoriteMapSearchController")
public class favoriteMapSearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FavortieMapService favortieMapService;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		favortieMapService = new FavortieMapService();
		gson = new Gson();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
					
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Video video = new Video();
		
		video = gson.fromJson(req.getReader(), Video.class);
		
		List<Video> videos = favortieMapService.searchVideos(video.getVideoName());
		
		String json = gson.toJson(videos);
		resp.getWriter().write(json);
		
	}
	
}
