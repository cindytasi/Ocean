package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.service.FavortieMapService;
import web.vo.attraction;

@WebServlet("/web/controller/AttractionImgController")
public class AttractionImgController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FavortieMapService favortieMapService;
	private Gson gson;
	private attraction attraction;
	
	@Override
	public void init() throws ServletException {
		favortieMapService = new FavortieMapService();
		attraction = new attraction();
		gson = new Gson();
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
        
        attraction = gson.fromJson(req.getReader(), attraction.class);
        
        Integer attid =Integer.parseInt(req.getParameter("attractionId"));
        
        attraction attraction = favortieMapService.attractionImg(attid);
        
        resp.getOutputStream().write(attraction.getAttractionPic());
        
        resp.getOutputStream().flush();
	}
	
}
