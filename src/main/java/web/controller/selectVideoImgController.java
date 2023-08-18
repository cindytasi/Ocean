package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.VideoService;
import web.vo.Video;

@WebServlet("/web/controller/selectVideoImgController")
public class selectVideoImgController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VideoService videoService;
	
	@Override
	public void init() throws ServletException {
		videoService = new VideoService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setContentType("application/json; charset=utf-8");

        resp.setContentType("image/jpg");
        
        Integer vidid =Integer.parseInt(req.getParameter("videoId"));
        
       Video videos = videoService.searchAllImg(vidid);
        
        resp.getOutputStream().write(videos.getPicture());
        
        resp.getOutputStream().flush();
	}
	
	

}
