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
import web.vo.FavoriteMap;
import web.vo.attraction;

@WebServlet("/web/controller/favoriteMapController")
public class favoriteMapController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FavortieMapService favortieMapService;
	private FavoriteMap favoriteMap;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		favortieMapService = new FavortieMapService();
		favoriteMap =new FavoriteMap();
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
		
		favoriteMap = gson.fromJson(req.getReader(), FavoriteMap.class);

		favoriteMap = favortieMapService.getAllAttraction(favoriteMap.getMemberId());
		
		List<attraction> attlist = favoriteMap.getAttractions();
		
		String json = gson.toJson(attlist);
		
		resp.getWriter().write(json);	
		

		
	}
}
