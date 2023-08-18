package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.service.FavortieMapService;
import web.vo.FavoriteMap;

@WebServlet("/web/controller/favoriteMapDeleteController")
public class favoriteMapDeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FavortieMapService favortieMapService;
	private FavoriteMap favoriteMap;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		favortieMapService = new FavortieMapService();
		favoriteMap = new FavoriteMap();
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
		
		
		
		boolean deletionSuccessful = favortieMapService.deleteAttraction(favoriteMap.getMemberId(), favoriteMap.getAttractionId());
		
		

	    if (deletionSuccessful) {
	    	
	    	favoriteMap.setMessage("刪除成功");
	    	
	        // 删除成功，向前端发送成功信息
	        resp.getWriter().write(gson.toJson(favoriteMap));
	    } else {
	        // 删除失败，向前端发送错误信息
	    	favoriteMap.setMessage("刪除失敗");
	    	
	        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        resp.getWriter().write(gson.toJson(favoriteMap));
	    }
	}
}
