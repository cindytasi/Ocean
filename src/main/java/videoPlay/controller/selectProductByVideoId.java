package videoPlay.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import videoPlay.service.VideoPlayService;
import videoPlay.service.Impl.VideoPlayServiceImpl;

@WebServlet("/selectProductByVideoId")
public class selectProductByVideoId extends HttpServlet{
	private VideoPlayService vps;

	@Override
	public void init() throws ServletException {
		vps = new VideoPlayServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		Integer id = Integer.parseInt(req.getParameter("videoId"));
		
		String productInfo = vps.selectProductByVideoId(id);
		
		resp.setContentType("application/json");
		resp.getWriter().write(productInfo);
	}

}
